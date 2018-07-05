package model.bean;

import java.io.Serializable;

/**
 * Created by msl on 2016/7/6.
 */
public class HttpResult<T> implements Serializable{

    private Integer code;
    private String message;
    private boolean ok;
    private T result;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "HttpResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", ok=" + ok +
                ", result=" + result +
                '}';
    }
}
