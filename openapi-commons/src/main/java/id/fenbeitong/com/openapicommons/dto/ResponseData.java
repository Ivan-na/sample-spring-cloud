package id.fenbeitong.com.openapicommons.dto;


/**
 * ResponseData
 * <p>General Response Holder Object, API should use it for response
 *
 * @author Created by ivan on 上午11:34 18-11-8.
 * @version 1.0
 **/
public class ResponseData {

    private int responseCode = 200;
    private String responseMessage = "";
    private Object responseData;

    // Constructors
    private ResponseData() {
    }

    private ResponseData(Object responseData) {
        this.responseData = responseData;
    }

    private ResponseData(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    private ResponseData(int responseCode, String responseMessage) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }

    // Response Schema
    public static ResponseData ok(Object responseData) {
        return new ResponseData(responseData);
    }

    public static ResponseData fail() {
        return new ResponseData();
    }

    public static ResponseData fail(String responseMessage) {
        return new ResponseData(responseMessage);
    }

    public static ResponseData fail(int responseCode, String responseMessage) {
        return new ResponseData(responseCode, responseMessage);
    }

    // Getter & Setter
    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public Object getResponseData() {
        return responseData;
    }

    public void setResponseData(Object responseData) {
        this.responseData = responseData;
    }
}
