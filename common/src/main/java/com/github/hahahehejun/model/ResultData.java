package com.github.hahahehejun.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author lfw
 * @Description
 * @date 2020/11/27 17:19
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "响应信息", description = "返回响应信息")
public class ResultData<T> implements Serializable {

    private static final long serialVersionUID = -1517272643101952846L;

    /**
     * 接口返回编码，不同的业务模块需自己定义
     */
    @ApiModelProperty(value = "响应状态码")
    private Integer code;
    /**
     * 接口返回消息，供前端参考
     */
    @ApiModelProperty(value = "描述信息")
    private String message;
    /**
     * 接口返回数据
     */
    @ApiModelProperty(value = "返回对象")
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResultData(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResultData(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultData() {
    }

    /**
     * 接口调用成功返回的结果
     *
     * @param data 数据
     */
    public static <T> ResultData<T> data(T data) {
        return result(ResultCode.SUCCESS, data, "");
    }

    /**
     * 接口调用成功返回的结果（无数据，自定义消息）
     *
     * @param message 消息
     */
    public static <T> ResultData<T> message(String message) {
        return result(ResultCode.SUCCESS, null, message);
    }

    /**
     * 接口调用成功返回的结果
     */
    public static <T> ResultData<T> result() {
        return new ResultData<>(ResultCode.SUCCESS, "SUCCESS");
    }

    /**
     * 接口调用成功返回的结果
     *
     * @param data    返回数据
     */
    public static <T> ResultData<T> result(T data) {
        return new ResultData<>(ResultCode.SUCCESS, "SUCCESS", data);
    }

    /**
     * 接口调用成功返回的结果
     *
     * @param data    返回数据
     * @param message 返回消息
     */
    public static <T> ResultData<T> result(Integer code, T data, String message) {
        return new ResultData<>(code, message, data);
    }

    /**
     * 返回异常
     *
     * @param code    异常编码
     * @param message 异常信息
     */
    public static <T> ResultData<T> error(Integer code, String message) {
        return result(code, null, message);
    }

    @Override
    public String toString() {
        return "ResultData{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * 用户请登录
     *
     * @return
     */
    public static <T> ResultData<T> notLogin() {
        return ResultData.error(ResultCode.ERROR_NOT_LOGIN, "请先登录");
    }

    /**
     * 异地登陆
     *
     * @param <T>
     * @return
     */
    public static <T> ResultData<T> differentLogin() {
        return ResultData.error(ResultCode.ERROR_FORCED_OFFLINE, "发现您有异地登陆的情况，建议修改密码并重新登陆");
    }
}
