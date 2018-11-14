package id.fenbeitong.com.openapiapproveservice.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.fenbeitong.com.openapiapproveservice.entity.Approve;
import id.fenbeitong.com.openapiapproveservice.vo.ApproveParams;
import id.fenbeitong.com.openapicommons.api.CommonController;
import id.fenbeitong.com.openapicommons.dto.ResponseData;
import id.fenbeitong.com.openapicommons.entity.BizCommonEntity;
import id.fenbeitong.com.openapicommons.vo.BizCommonParams;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * ApproveController
 * <p>
 * TODO
 *
 * @version 1.0 Created by ivan on 18-11-14 - 下午5:41.
 **/
@RestController
@RequestMapping("/open/api/approve")
@Api("APPROVE")
public class ApproveController extends CommonController<ApproveController> {

	@ApiOperation(value = "Check Env tag", notes = "env tag")
    @PostMapping("/create")
    public ResponseData createApprove(@RequestBody BizCommonParams<ApproveParams> bizCommonParams) {
		
		LOGGER.info(bizCommonParams.getData().getTripList().get(0).getArrivalCityId());
        String jsonP = "{\"access_token\":\"5747fbc10f0e60e0709d8d722\",\"timestamp\":124124325,\"sign\":\"oihfnlyeofdh98\",\"employee_id\":\"59b74c1323445f2d54dd07922\",\"employee_type\":1,\"data\":{\"apply\":{\"type\":1,\"flow_type\":4, \"budget\":1,\"third_id\":\"59dc7fe62798635263b8414a\",\"third_remark\":\"approve-openapi-test2\"},\"trip_list\":[{\"type\":7,  \"start_city_id\":\"2000002\",\"start_time\":\"2017-12-13\",\"arrival_city_id\":\"1000001\",\"end_time\":\"2017-12-13\",\"estimated_amount\":1}]}}";
        bizCommonParams = BizCommonParams.fromJsonWithLowerCase(jsonP, ApproveParams.class);	  
        // call biz service
        LOGGER.info(bizCommonParams.getData().getTripList().get(0).getArrivalCityId());
        BizCommonEntity<Approve> response = new BizCommonEntity<Approve>();
        return ResponseData.ok(response);
    }
}
