package com.resliv.dto;

public class CityInfoDto {
    private Integer id;
    private String info;
    private String cityName;

    public CityInfoDto(Integer id, String info, String cityName) {
        this.id = id;
        this.info = info;
        this.cityName = cityName;
    }

    public CityInfoDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
