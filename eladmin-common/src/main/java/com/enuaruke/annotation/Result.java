package com.enuaruke.annotation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author: 05
 * @date: 2022-09-27 16:44
 */
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("成功标志")
    private boolean success = true;
    @ApiModelProperty("返回处理消息")
    private String message = "操作成功！";
    @ApiModelProperty("返回代码")
    private Integer code = 0;
    @ApiModelProperty("返回数据对象")
    private T result;
    @ApiModelProperty("时间戳")
    private long timestamp = System.currentTimeMillis();
    @JsonIgnore
    private String onlTable;

    public Result() {
    }

    public Result<T> success(String message) {
        this.message = message;
        this.code = CommonConstant.SC_OK_200;
        this.success = true;
        return this;
    }

    public static Result<Object> ok() {
        Result<Object> r = new Result();
        r.setSuccess(true);
        r.setCode(CommonConstant.SC_OK_200);
        r.setMessage("成功");
        return r;
    }

    public static Result<Object> ok(String msg) {
        Result<Object> r = new Result();
        r.setSuccess(true);
        r.setCode(CommonConstant.SC_OK_200);
        r.setMessage(msg);
        return r;
    }

    public static Result<Object> ok(Object data) {
        Result<Object> r = new Result();
        r.setSuccess(true);
        r.setCode(CommonConstant.SC_OK_200);
        r.setResult(data);
        return r;
    }

    public static <T> Result<T> OK() {
        Result<T> r = new Result();
        r.setSuccess(true);
        r.setCode(CommonConstant.SC_OK_200);
        r.setMessage("成功");
        return r;
    }

    public static <T> Result<T> OK(T data) {
        Result<T> r = new Result();
        r.setSuccess(true);
        r.setCode(CommonConstant.SC_OK_200);
        r.setResult(data);
        return r;
    }

    public static <T> Result<T> OK(String msg, T data) {
        Result<T> r = new Result();
        r.setSuccess(true);
        r.setCode(CommonConstant.SC_OK_200);
        r.setMessage(msg);
        r.setResult(data);
        return r;
    }

    public static <T> Result<T> error(String msg, T data) {
        Result<T> r = new Result();
        r.setSuccess(false);
        r.setCode(CommonConstant.SC_INTERNAL_SERVER_ERROR_500);
        r.setMessage(msg);
        r.setResult(data);
        return r;
    }

    public static Result<Object> error(String msg) {
        return error(CommonConstant.SC_INTERNAL_SERVER_ERROR_500, msg);
    }

    public static Result<Object> error(int code, String msg) {
        Result<Object> r = new Result();
        r.setCode(code);
        r.setMessage(msg);
        r.setSuccess(false);
        return r;
    }

    public Result<T> error500(String message) {
        this.message = message;
        this.code = CommonConstant.SC_INTERNAL_SERVER_ERROR_500;
        this.success = false;
        return this;
    }

    public static Result<Object> noauth(String msg) {
        return error(CommonConstant.SC_JEECG_NO_AUTHZ, msg);
    }

    public boolean isSuccess() {
        return this.success;
    }

    public String getMessage() {
        return this.message;
    }

    public Integer getCode() {
        return this.code;
    }

    public T getResult() {
        return this.result;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String getOnlTable() {
        return this.onlTable;
    }

    public void setSuccess(final boolean success) {
        this.success = success;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public void setCode(final Integer code) {
        this.code = code;
    }

    public void setResult(final T result) {
        this.result = result;
    }

    public void setTimestamp(final long timestamp) {
        this.timestamp = timestamp;
    }

    @JsonIgnore
    public void setOnlTable(final String onlTable) {
        this.onlTable = onlTable;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Result)) {
            return false;
        } else {
            Result<?> other = (Result)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.isSuccess() != other.isSuccess()) {
                return false;
            } else if (this.getTimestamp() != other.getTimestamp()) {
                return false;
            } else {
                label64: {
                    Object this$code = this.getCode();
                    Object other$code = other.getCode();
                    if (this$code == null) {
                        if (other$code == null) {
                            break label64;
                        }
                    } else if (this$code.equals(other$code)) {
                        break label64;
                    }

                    return false;
                }

                label57: {
                    Object this$message = this.getMessage();
                    Object other$message = other.getMessage();
                    if (this$message == null) {
                        if (other$message == null) {
                            break label57;
                        }
                    } else if (this$message.equals(other$message)) {
                        break label57;
                    }

                    return false;
                }

                Object this$result = this.getResult();
                Object other$result = other.getResult();
                if (this$result == null) {
                    if (other$result != null) {
                        return false;
                    }
                } else if (!this$result.equals(other$result)) {
                    return false;
                }

                Object this$onlTable = this.getOnlTable();
                Object other$onlTable = other.getOnlTable();
                if (this$onlTable == null) {
                    if (other$onlTable != null) {
                        return false;
                    }
                } else if (!this$onlTable.equals(other$onlTable)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Result;
    }

    public int hashCode() {
        int result = 1;
        result = result * 59 + (this.isSuccess() ? 79 : 97);
        long $timestamp = this.getTimestamp();
        result = result * 59 + (int)($timestamp >>> 32 ^ $timestamp);
        Object $code = this.getCode();
        result = result * 59 + ($code == null ? 43 : $code.hashCode());
        Object $message = this.getMessage();
        result = result * 59 + ($message == null ? 43 : $message.hashCode());
        Object $result = this.getResult();
        result = result * 59 + ($result == null ? 43 : $result.hashCode());
        Object $onlTable = this.getOnlTable();
        result = result * 59 + ($onlTable == null ? 43 : $onlTable.hashCode());
        return result;
    }

    public String toString() {
        return "Result(success=" + this.isSuccess() + ", message=" + this.getMessage() + ", code=" + this.getCode() + ", result=" + this.getResult() + ", timestamp=" + this.getTimestamp() + ", onlTable=" + this.getOnlTable() + ")";
    }
}
