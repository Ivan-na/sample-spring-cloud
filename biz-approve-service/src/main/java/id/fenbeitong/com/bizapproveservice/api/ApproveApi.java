package id.fenbeitong.com.bizapproveservice.api;

import id.fenbeitong.com.bizapproveservice.entity.Approve;
import id.fenbeitong.com.bizapproveservice.vo.ApproveParams;
import id.fenbeitong.com.openapicommons.entity.BizCommonEntity;
import id.fenbeitong.com.openapicommons.utils.JSONUtils;
import id.fenbeitong.com.openapicommons.vo.BizCommonParams;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ApproveApi
 * <p>TODO
 *
 * @author Created by ivan on 下午7:38 18-11-13.
 * @version 1.0
 **/
@RestController
@RequestMapping("/biz/approve")
@Api("BIZ-APPROVE")
public class ApproveApi {

    @ApiOperation(value = "Check Env tag", notes = "env tag")
    @PostMapping("/create")
    public BizCommonEntity<Approve> createApprove(@RequestBody BizCommonParams<ApproveParams> bizCommonParams) {
        String jsonParma = bizCommonParams.toJsonWithLowerCase(ApproveParams.class);
        // CALL SERVICE
        String jsonResult = "{\"request_id\": \"xUolOnJHWhIO4YP8MozO\",\"code\": 0,\"msg\": \"success\",\"data\": {\"id\": \"58baa2866819481560f013ac\"}}";
        BizCommonEntity<Approve> bizCommonEntity = BizCommonEntity.fromJson(jsonResult, Approve.class);
        return bizCommonEntity;
    }

    public static void main(String[] args) {
        String jsonResult = "{\"request_id\": \"xUolOnJHWhIO4YP8MozO\",\"code\": 0,\"msg\": \"success\",\"data\": {\"id\": \"58baa2866819481560f013ac\"}}";
        BizCommonEntity<Approve> bizCommonEntity = BizCommonEntity.fromJson(jsonResult, Approve.class);
        Approve app = bizCommonEntity.getData();
        System.out.println(app.getId());
    }
}
