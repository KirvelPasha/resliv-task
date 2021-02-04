package com.resliv.service;

import com.resliv.dto.CityDto;
import com.resliv.entity.City;

import java.util.List;

public interface CityService {
    List<City> getAll();

    City getCityByName(String name);

    City save(CityDto cityDto);

    void deleteById(Integer id);

    City getCityById(Integer id);

    City update(CityDto cityDto);
}
