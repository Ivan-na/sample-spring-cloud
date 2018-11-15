package id.fenbeitong.com.openapiapproveservice.fallback;

import id.fenbeitong.com.openapiapproveservice.entity.Approve;
import id.fenbeitong.com.openapiapproveservice.feign.BizApproveClient;
import id.fenbeitong.com.openapiapproveservice.vo.ApproveParams;
import id.fenbeitong.com.openapicommons.entity.BizCommonEntity;
import id.fenbeitong.com.openapicommons.vo.BizCommonParams;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * BizApproveClientFallback
 * <p> TODO
 *
 * @version 1.0
 * Created by ivan on 18-11-15 - 下午3:17.
 **/
@Component
public class BizApproveClientFallback implements BizApproveClient {
    @Override
    public BizCommonEntity<Approve> createApprove(@RequestBody BizCommonParams<ApproveParams> bizCommonParams) {
        BizCommonEntity<Approve> response = new BizCommonEntity<Approve>();
        response.setCode("500");
        response.setMsg("Biz Service temp down");
        return response;
    }
}
