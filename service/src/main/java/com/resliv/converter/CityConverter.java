package com.resliv.converter;

import com.resliv.dto.CityDto;
import com.resliv.entity.City;
import org.springframework.stereotype.Component;

@Component
public class CityConverter {

    public City converter(CityDto cityDto) {
        City city = new City();
        city.setName(cityDto.getName());

        return city;
    }

    public CityDto converter(City city) {
        CityDto cityDto = new CityDto();
        cityDto.setName(city.getName());

        return cityDto;
    }
}
