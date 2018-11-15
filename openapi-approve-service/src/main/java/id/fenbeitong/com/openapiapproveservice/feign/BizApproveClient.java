package id.fenbeitong.com.openapiapproveservice.feign;

import id.fenbeitong.com.openapiapproveservice.entity.Approve;
import id.fenbeitong.com.openapiapproveservice.fallback.BizApproveClientFallback;
import id.fenbeitong.com.openapiapproveservice.vo.ApproveParams;
import id.fenbeitong.com.openapicommons.entity.BizCommonEntity;
import id.fenbeitong.com.openapicommons.vo.BizCommonParams;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * BizApproveClient
 * <p>TODO
 *
 * @author Created by ivan on 下午2:39 18-11-15.
 * @version 1.0
 **/
@FeignClient(name = "BIZ-APPROVE", fallback = BizApproveClientFallback.class)
public interface BizApproveClient {
    @PostMapping("/create")
    public BizCommonEntity<Approve> createApprove(@RequestBody BizCommonParams<ApproveParams> bizCommonParams);
}
