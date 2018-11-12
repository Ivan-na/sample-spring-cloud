package id.fenbeitong.com.openapiinfo.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import id.fenbeitong.com.openapicommons.entity.CommonEntity;

import java.util.List;

/**
 * CityAirport
 * <p>TODO
 *
 * @author Created by ivan on 下午8:02 18-11-12.
 * @version 1.0
 **/
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CityAirport extends CommonEntity<CityAirport> {
    private List<City> cities;

    public CityAirport() {
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    static class City {
        private String id;
        private String name;
        private String pinyin;
        private String description;
        private List<Airport> stationList;

        public City() {
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPinyin() {
            return pinyin;
        }

        public void setPinyin(String pinyin) {
            this.pinyin = pinyin;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public List<Airport> getStationList() {
            return stationList;
        }

        public void setStationList(List<Airport> stationList) {
            this.stationList = stationList;
        }
    }

    static class Airport {
        private String name;
        private String code;

        public Airport() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }
}
