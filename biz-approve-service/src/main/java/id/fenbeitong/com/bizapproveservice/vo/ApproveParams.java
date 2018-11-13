package id.fenbeitong.com.bizapproveservice.vo;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.node.ObjectNode;
import id.fenbeitong.com.openapicommons.vo.CommonParams;

/**
 * ApproveParams
 * <p>TODO
 *
 * @author Created by ivan on 下午7:37 18-11-13.
 * @version 1.0
 **/
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ApproveParams extends CommonParams<ApproveParams> {
    private ObjectNode data;

    public ObjectNode getData() {
        return data;
    }

    public void setData(ObjectNode data) {
        this.data = data;
    }

    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static class Apply {
        private int type;
        private int flowType;
        private String thirdId;
        private String thirdRemark;
        private int budget;

        public Apply() {
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
    }

    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static class tripList {
        private int type;
        private String startCityId;
        private String startTime;
        private String arrivalCityId;
        private String endTime;
        private int estimatedAmout;

        public tripList() {
        }

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

        public int getEstimatedAmout() {
            return estimatedAmout;
        }

        public void setEstimatedAmout(int estimatedAmout) {
            this.estimatedAmout = estimatedAmout;
        }
    }
}
