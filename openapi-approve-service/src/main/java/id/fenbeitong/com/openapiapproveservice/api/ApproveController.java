package id.fenbeitong.com.openapiapproveservice.api;

import id.fenbeitong.com.openapiapproveservice.entity.Approve;
import id.fenbeitong.com.openapiapproveservice.feign.BizApproveClient;
import id.fenbeitong.com.openapiapproveservice.vo.ApproveParams;
import id.fenbeitong.com.openapicommons.api.CommonController;
import id.fenbeitong.com.openapicommons.dto.ResponseData;
import id.fenbeitong.com.openapicommons.entity.BizCommonEntity;
import id.fenbeitong.com.openapicommons.utils.JSONUtils;
import id.fenbeitong.com.openapicommons.vo.BizCommonParams;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ApproveController
 * <p>
 * TODO
 *
 * @version 1.0 Created by ivan on 18-11-14 - 下午5:41.
 **/
@RestController
@Api("OPEN API APPROVE")
public class ApproveController extends CommonController<ApproveController> {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private BizApproveClient bizApproveClient;


    @ApiOperation(value = "Create Approve", notes = "Create Approve")
    @PostMapping("/create")
    public ResponseData createApprove(@RequestBody BizCommonParams<ApproveParams> bizCommonParams) {

        BizCommonEntity<Approve> response = bizApproveClient.createApprove(bizCommonParams);
        LOGGER.info(JSONUtils.toJson(response));
        if ("0".equals(response.getCode())) {
            return ResponseData.ok(response);
        } else {
            return ResponseData.fail(Integer.parseInt(response.getCode()), response.getMsg());
        }
    }
}
