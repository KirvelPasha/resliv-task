package com.resliv.converter;

import com.resliv.dto.CityInfoDto;
import com.resliv.entity.CityInfo;
import com.resliv.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CityInfoConverter {
    private final CityService cityService;

    @Autowired
    public CityInfoConverter(CityService cityService) {
        this.cityService = cityService;
    }

    public CityInfo converter(CityInfoDto cityInfoDto) {
        CityInfo cityInfo = new CityInfo();
        cityInfo.setInfo(cityInfoDto.getInfo());
        cityInfo.setCity(cityService.getCityByName(cityInfoDto.getName()));
        return cityInfo;
    }

    public CityInfoDto converter(CityInfo cityInfo) {
        CityInfoDto cityInfoDto = new CityInfoDto();
        cityInfoDto.setInfo(cityInfo.getInfo());
        return cityInfoDto;
    }
}
