package id.fenbeitong.com.bizapproveservice.constants;

import org.springframework.beans.factory.annotation.Value;

/**
 * ApproveAURL
 * <p>TODO
 *
 * @author Created by ivan on 下午6:12 18-11-13.
 * @version 1.0
 **/
public class ApproveURL {
    @Value("host.saas.center")
    public static final String SAAS_HL = "";

    @Value("host.hyperloop")
    public static final String HOST_HL = "";

    //审批单列表
    public static final String URL_GET_APPROVE_LIST = SAAS_HL + "/apply/third/start_apply_list?%s";

    //创建审批单
    public static final String URL_POST_APPROVE_CREATE = SAAS_HL + "/apply/third/create";

    //撤销审批单
    public static final String URL_POST_APPROVE_CANCEL = SAAS_HL + "/apply/third/revoke";

    //审批单详情
    public static final String URL_GET_APPROVE_DETAIL = SAAS_HL + "/apply/v2/detail?%s";

    //审批单校验（根据传入审批单ID和行程ID进行日期符合校验）
    public static final String URL_GET_APPROVE_VALID_DETAIL = SAAS_HL + "/apply/third/apply_trip_info?%s";

    //获取可用审批单
    public static final String URL_POST_APPROVE_AVAILABLE = HOST_HL + "/v1/api/web/apply/available";

    //查询第三方审批单详情信息
    public static final String URL_GET_THIRD_APPROVE_DETAIL = SAAS_HL + "/apply/third/apply_order_detail?%s";

    /**
     * 审批单列表
     *
     * @return
     */
    public static String getApproveListUrl(String param) {

        return String.format(URL_GET_APPROVE_LIST, param);
    }

    /**
     * 创建审批单
     *
     * @return
     */
    public static String postApproveCreateUrl() {

        return URL_POST_APPROVE_CREATE;
    }

    /**
     * 撤销审批单
     *
     * @return
     */
    public static String postApproveCancelUrl() {
        return URL_POST_APPROVE_CANCEL;
    }

    /**
     * 审批单详情
     *
     * @return
     */
    public static String getApproveDetailUrl(String param) {

        return String.format(URL_GET_APPROVE_DETAIL, param);
    }

    /**
     * 审批单详情校验
     *
     * @param param
     * @return
     */
    public static String getApproveValidDetailUrl(String param) {

        return String.format(URL_GET_APPROVE_VALID_DETAIL, param);
    }

    /**
     * 获取可用审批单
     *
     * @return
     */
    public static String postApproveAvailableUrl() {

        return URL_POST_APPROVE_AVAILABLE;
    }

    /**
     * 查询第三方审批单详情信息
     *
     * @param param
     * @return
     */
    public static String getThirdApproveDetailUrl(String param) {

        return String.format(URL_GET_THIRD_APPROVE_DETAIL, param);
    }

}
