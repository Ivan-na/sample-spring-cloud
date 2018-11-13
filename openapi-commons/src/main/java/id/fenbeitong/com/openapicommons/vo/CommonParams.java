package id.fenbeitong.com.openapicommons.vo;

import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * CommonParams
 * <p>TODO
 *
 * @author Created by ivan on 下午5:13 18-11-12.
 * @version 1.0
 **/
public class CommonParams<T> implements java.io.Serializable {
    private String accessToken;
    private String sign;
    private Long timestamp;
    private String employeeId;
    private String employeeType;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

}
