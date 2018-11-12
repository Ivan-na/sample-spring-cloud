package id.fenbeitong.com.openapiinfo.vo;

import id.fenbeitong.com.openapicommons.vo.CommonParams;

/**
 * CityStationParams
 * <p>TODO
 *
 * @author Created by ivan on 下午6:00 18-11-12.
 * @version 1.0
 **/
public class CityStationParams extends CommonParams<CityStationParams> {
    private CityCodeParams.Data data;

    public CityCodeParams.Data getData() {
        return data;
    }

    public void setData(CityCodeParams.Data data) {
        this.data = data;
    }

    class Data {
        private String type;
        private String cityKey;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}


