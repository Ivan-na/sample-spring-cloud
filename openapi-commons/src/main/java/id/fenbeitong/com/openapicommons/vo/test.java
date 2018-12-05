package id.fenbeitong.com.openapicommons.vo;

import java.util.List;

/**
 * test
 * <p> TODO
 *
 * @version 1.0
 * Created by ivan on 18-11-15 - 下午5:24.
 **/
public class test {

    /**
     * apply : {"type":1,"flow_type":4,"budget":1,"third_id":"59dc7fe62798635263b8414a","third_remark":"approve-openapi-test2"}
     * trip_list : [{"type":7,"start_city_id":"2000002","start_time":"2017-12-13","arrival_city_id":"1000001","end_time":"2017-12-13","estimated_amount":1}]
     */

    private ApplyBean apply;
    private List<TripListBean> tripList;

    public ApplyBean getApply() {
        return apply;
    }

    public void setApply(ApplyBean apply) {
        this.apply = apply;
    }

    public List<TripListBean> getTripList() {
        return tripList;
    }

    public void setTripList(List<TripListBean> tripList) {
        this.tripList = tripList;
    }

    public static class ApplyBean {
        /**
         * type : 1
         * flow_type : 4
         * budget : 1
         * third_id : 59dc7fe62798635263b8414a
         * third_remark : approve-openapi-test2
         */

        private int type;
        private int flowType;
        private int budget;
        private String thirdId;
        private String thirdRemark;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getFlowType() {
            return flowType;
        }

        public void setFlowType(int flowType) {
            this.flowType = flowType;
        }

        public int getBudget() {
            return budget;
        }

        public void setBudget(int budget) {
            this.budget = budget;
        }

        public String getThirdId() {
            return thirdId;
        }

        public void setThirdId(String thirdId) {
            this.thirdId = thirdId;
        }

        public String getThirdRemark() {
            return thirdRemark;
        }

        public void setThirdRemark(String thirdRemark) {
            this.thirdRemark = thirdRemark;
        }
    }

    public static class TripListBean {
        /**
         * type : 7
         * start_city_id : 2000002
         * start_time : 2017-12-13
         * arrival_city_id : 1000001
         * end_time : 2017-12-13
         * estimated_amount : 1
         */

        private int type;
        private String startCityId;
        private String startTime;
        private String arrivalCityId;
        private String endTime;
        private int estimatedAmount;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getStartCityId() {
            return startCityId;
        }

        public void setStartCityId(String startCityId) {
            this.startCityId = startCityId;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getArrivalCityId() {
            return arrivalCityId;
        }

        public void setArrivalCityId(String arrivalCityId) {
            this.arrivalCityId = arrivalCityId;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public int getEstimatedAmount() {
            return estimatedAmount;
        }

        public void setEstimatedAmount(int estimatedAmount) {
            this.estimatedAmount = estimatedAmount;
        }
    }
}
