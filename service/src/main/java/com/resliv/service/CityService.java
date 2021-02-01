package com.resliv.service;

import com.resliv.dto.CityDto;
import com.resliv.entity.City;

public interface CityService {
    City getCityByName(String name);

    City save(CityDto cityDto);

    void deleteById(Integer id);
}
