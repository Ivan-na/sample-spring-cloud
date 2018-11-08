package id.fenbeitong.com.openapicommons.constants;


/**
 * ResponseCode
 * <p>Response - Code -Enum
 *
 * @author Created by ivan on 上午11:33 18-11-8.
 * @version 1.0
 **/
public enum ResponseCode {
    /**
     * 正确
     **/
    SUCCESS_CODE(200),
    /**
     * 参数错误
     **/
    PARAM_ERROR_CODE(400),
    /**
     * 限制调用
     **/
    LIMIT_ERROR_CODE(401),
    /**
     * token 过期
     **/
    TOKEN_TIMEOUT_CODE(402),
    /**
     * 禁止访问
     **/
    NO_AUTH_CODE(403),
    /**
     * 资源没找到
     **/
    NOT_FOUND(404),
    /**
     * 服务器错误
     **/
    SERVER_ERROR_CODE(500),
    /**
     * 服务降级中
     **/
    DOWNGRADE(406);

    /**
     * ENUM Structure
     */
    private int code;

    ResponseCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
