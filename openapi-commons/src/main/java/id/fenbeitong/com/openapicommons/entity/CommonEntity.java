package id.fenbeitong.com.openapicommons.entity;

/**
 * CommonEntity
 * <p>General Entity, used for globe properties etc.
 *
 * @author Created by ivan on 上午11:35 18-11-8.
 * @version 1.0
 **/
public abstract class CommonEntity<T> implements java.io.Serializable {
    private String requestId;
    private String code;
    private String msg;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
