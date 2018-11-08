package id.fenbeitong.com.openapijwt.vo;

/**
 * AuthParams
 * <p>user auth params
 *
 * @author Created by ivan on 下午2:40 18-11-8.
 * @version 1.0
 **/
public class AuthParams {
    // access key
    private String accessKey;
    // customer id
    private String customerId;

    // Construct
    private AuthParams() {
    }

    public AuthParams(String accessKey, String customerId) {
        this.accessKey = accessKey;
        this.customerId = customerId;
    }

    // Getter/Setter
    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
