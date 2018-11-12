package id.fenbeitong.com.openapiinfo.vo;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import id.fenbeitong.com.openapicommons.vo.CommonParams;

/**
 * CityCodeParams
 * <p>TODO
 *
 * @author Created by ivan on 下午5:59 18-11-12.
 * @version 1.0
 **/
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CityCodeParams extends CommonParams<CityCodeParams> {
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    static class Data {
        private String type;

        public Data() {
        }

        public Data(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}


