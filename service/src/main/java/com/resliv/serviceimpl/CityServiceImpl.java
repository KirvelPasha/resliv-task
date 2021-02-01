package com.resliv.serviceimpl;

import com.resliv.converter.CityConverter;
import com.resliv.dto.CityDto;
import com.resliv.entity.City;
import com.resliv.repository.CountryRepository;
import com.resliv.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {
    private final CountryRepository countryRepository;
    private final CityConverter cityConverter;

    @Autowired
    public CityServiceImpl(CountryRepository countryRepository, CityConverter cityConverter) {
        this.countryRepository = countryRepository;
        this.cityConverter = cityConverter;
    }

    @Override
    public City getCityByName(String name) {
        return countryRepository.getCityByName(name);
    }

    @Override
    public City save(CityDto cityDto) {
        City city = cityConverter.converter(cityDto);
        return countryRepository.save(city);
    }

    @Override
    public void deleteById(Integer id) {
        countryRepository.deleteById(id);
    }
}
