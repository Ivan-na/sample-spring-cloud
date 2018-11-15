package id.fenbeitong.com.openapijwt.api;

import id.fenbeitong.com.openapicommons.api.CommonController;
import id.fenbeitong.com.openapicommons.constants.ResponseCode;
import id.fenbeitong.com.openapicommons.dto.ResponseData;
import id.fenbeitong.com.openapicommons.utils.JWTUtils;
import id.fenbeitong.com.openapijwt.entity.User;
import id.fenbeitong.com.openapijwt.service.AuthService;
import id.fenbeitong.com.openapijwt.vo.AuthParams;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 * JWTController
 * <p>get JWT token for a valid user
 *
 * @author Created by ivan on 上午11:51 18-11-8.
 * @version 1.0
 **/
@RestController
@Api("JWT")
@RefreshScope
public class JWTController extends CommonController<JWTController> {
    // Atuh Service
    private AuthService authService;

    @Value("${env.tag}")
    private String envTag = "123";

    @Autowired
    public JWTController(AuthService authService) {
        this.authService = authService;
    }

    @ApiOperation(value = "Check Env tag", notes = "env tag")
    @GetMapping("/msg")
    public ResponseData checkEnvTag() {
        if (StringUtils.isNotBlank(envTag)) {
            return ResponseData.ok(envTag);
        } else {
            return ResponseData.fail("not Load");
        }
    }

    /**
     * @param authParams : valid user info params
     * @return id.fenbeitong.com.openapicommons.dto.ResponseData
     * @author Created by ivan on 上午11:52 18-11-8.
     * <p>Get Token By Post Request
     **/
    @ApiOperation(value = "User Post Request for a JWT Token", notes = "Token with Post")
    @PostMapping("/token")
    public ResponseData requestTokenByPost(@RequestBody AuthParams authParams) {
        if (StringUtils.isBlank(authParams.getCustomerId()) || StringUtils.isBlank(authParams.getAccessKey())) {
            return ResponseData.fail(ResponseCode.PARAM_ERROR_CODE.getCode(), "PARAM Error : CustomerId or AccessKey is Empty");
        } else {
            User user = authService.authUser(authParams);
            if (null == user) {
                return ResponseData.fail(ResponseCode.NO_AUTH_CODE.getCode(), "Auth Failed : not a qualified user");
            } else {
                JWTUtils jwt = JWTUtils.getInstance();
                return ResponseData.ok(jwt.getToken(user.getId().toString()));
            }

        }
    }
}
