package yzs.commonlibrary.data.net;

/**
 * by Andy.Wu on 2016/7/4.
 * 对应接口出参的bean
 */
public class HttpResult<T> {
    private String code;
    private String message;
    private T data;

    public HttpResult(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
