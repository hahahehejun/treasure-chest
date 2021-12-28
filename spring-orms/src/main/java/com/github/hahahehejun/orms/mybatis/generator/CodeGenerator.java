package com.github.hahahehejun.orms.mybatis.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @author lfw
 * @Description
 * @date 2020/10/30 13:41
 */
public class CodeGenerator {

    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        FastAutoGenerator.create("jdbc:clickhouse://127.0.0.1:8123/default", null, null)
                .globalConfig(builder -> {
                    builder.author("wu") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(projectPath + "/spring-orms/src/main/java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.github.hahahehejun.orms") // 设置父包名
                            .moduleName("mybatis") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml,projectPath + "/spring-orms/src/main/resources/mapper/")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("user") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

}
