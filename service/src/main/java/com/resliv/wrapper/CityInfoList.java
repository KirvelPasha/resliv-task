package com.resliv.wrapper;

import com.resliv.entity.CityInfo;

import java.util.List;

public class CityInfoList {
    private List<CityInfo> cityInfoList;

    public CityInfoList(List<CityInfo> cityInfoList) {
        this.cityInfoList = cityInfoList;
    }

    public List<CityInfo> getCityInfoList() {
        return cityInfoList;
    }

    public void setCityInfoList(List<CityInfo> cityInfoList) {
        this.cityInfoList = cityInfoList;
    }
}
