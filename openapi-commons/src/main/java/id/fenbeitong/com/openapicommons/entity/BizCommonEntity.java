package id.fenbeitong.com.openapicommons.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * CommonEntity
 * <p>General Entity, used for globe properties etc.
 *
 * @author Created by ivan on 上午11:35 18-11-8.
 * @version 1.0
 **/
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class BizCommonEntity<T> implements java.io.Serializable {
    private String requestId;
    private String code;
    private String msg;
    private ObjectNode data;

    public ObjectNode getData() {
        return data;
    }

    public void setData(ObjectNode data) {
        this.data = data;
    }

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
