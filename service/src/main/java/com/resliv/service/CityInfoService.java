package com.resliv.service;

import com.resliv.dto.CityInfoDto;
import com.resliv.entity.CityInfo;

import java.util.List;


public interface CityInfoService {
    List<CityInfo> getCityInfoByCityName(String cityName);

    void deleteById(Integer id);

    CityInfo save(CityInfoDto cityInfoDto);
}
