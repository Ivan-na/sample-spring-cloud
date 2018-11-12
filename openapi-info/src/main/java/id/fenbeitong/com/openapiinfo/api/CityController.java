package id.fenbeitong.com.openapiinfo.api;

import id.fenbeitong.com.openapicommons.api.CommonController;
import id.fenbeitong.com.openapicommons.dto.ResponseData;
import id.fenbeitong.com.openapicommons.utils.JSONUtils;
import id.fenbeitong.com.openapiinfo.entity.CityAirport;
import id.fenbeitong.com.openapiinfo.vo.CityCodeParams;
import id.fenbeitong.com.openapiinfo.vo.CityStationParams;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CityController
 * <p>TODO
 *
 * @author Created by ivan on 下午5:01 18-11-12.
 * @version 1.0
 **/
@RestController
@RequestMapping("/open/api/common")
@Api("COMMON-CITY")
public class CityController extends CommonController<CityController> {

    @ApiOperation(value = "Check Env tag", notes = "env tag")
    @PostMapping("/cityCode")
    public ResponseData getCithCodeList(@RequestBody CityCodeParams cityCodeParams) {
        LOGGER.info(JSONUtils.toJson(cityCodeParams));
        String jsonResult = "{\"request_id\": \"xUolOnJHWhIO4YP8MozO\",\"code\": 0,\"msg\": \"成功\",\"data\": {\"cities\": [{\"id\": \"1715\",\"name\": \"南宁市\",\"pinyin\": \"nan ning shi\",\"description\": \"南宁市\",\"station_list\": [{\"name\": \"吴圩国际机场\",\"code\": \"NNG\"}]}, {\"id\": \"2644\",\"name\": \"固原市\",\"pinyin\": \"gu yuan shi\",\"description\": \"固原市\",\"station_list\": [{\"name\": \"六盘山机场\",\"code\": \"GYU\"}]}, {\"id\": \"2121\",\"name\": \"海口市\",\"pinyin\": \"hai kou shi\",\"description\": \"海口市\",\"station_list\": [{\"name\": \"美兰国际机场\",\"code\": \"HAK\"}]}}";
        CityAirport ca = new CityAirport();
        ca = JSONUtils.toBean(ca.getClass(), jsonResult);
        LOGGER.info(JSONUtils.toJson(ca));
        return ResponseData.ok(ca);
    }

    public ResponseData getCityStationList(CityStationParams cityStationParams) {
        return ResponseData.fail();
    }


}
