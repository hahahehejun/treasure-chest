package com.github.hahahehejun.config;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Optional;

/**
 * @author lfw
 * @Description
 * @date 2020/11/27 17:05
 */
public abstract class AbstractSwaggerConfiguration {

    protected Docket createRestApi(String groupName, String... basePackage) {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(basePackage(basePackage))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .groupName(groupName);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title())
                .description(description())
                .termsOfServiceUrl(serverUrl())
                .version(version())
                .build();
    }

    protected String title() {
        return "demo";
    }

    protected String description() {
        return "项目描述";
    }

    protected String serverUrl() {
        return "https://";
    }

    private Predicate<RequestHandler> basePackage(final String... basePackage) {
        return input -> declaringClass(input).map(handlerPackage(basePackage)::apply).orElse(true);
    }

    private Function<Class<?>, Boolean> handlerPackage(final String... basePackage) {
        return input -> {
            // 循环判断匹配
            for (String strPackage : basePackage) {
                assert input != null;
                boolean isMatch = input.getPackage().getName().startsWith(strPackage);
                if (isMatch) {
                    return true;
                }
            }
            return false;
        };
    }

    private Optional<Class<?>> declaringClass(RequestHandler input) {
        return Optional.ofNullable(input.declaringClass());
    }

    /**
     * 项目版本号
     *
     * @return 项目版本号
     */
    protected abstract String version();

}