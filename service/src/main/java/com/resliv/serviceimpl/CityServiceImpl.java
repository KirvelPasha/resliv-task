package com.resliv.serviceimpl;

import com.resliv.converter.CityConverter;
import com.resliv.dto.CityDto;
import com.resliv.entity.City;
import com.resliv.repository.CityRepository;
import com.resliv.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;
    private final CityConverter cityConverter;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository, CityConverter cityConverter) {
        this.cityRepository = cityRepository;
        this.cityConverter = cityConverter;
    }

    @Override
    public List<City> getAll() {
        return cityRepository.findAll();
    }

    @Override
    public City getCityByName(String name) {
        Optional<City> city = Optional.ofNullable(cityRepository.getCityByName(name));
        if (!city.isPresent()) {
            throw new IllegalArgumentException("Sorry we don't have city with name: " + name);
        }
        return city.get();
    }

    @Override
    public City save(CityDto cityDto) {
        if (cityRepository.getCityByName(cityDto.getName()) != null) {
            throw new IllegalArgumentException("Sorry but city with name: " + cityDto.getName() + "already existed");
        }
        City city = cityConverter.converter(cityDto);
        return cityRepository.save(city);
    }

    @Override
    public void deleteById(Integer id) {
        cityRepository.deleteById(id);
    }

    @Override
    public City getCityById(Integer id) {
        Optional<City> city = cityRepository.findById(id);
        if (!city.isPresent()) {
            throw new IllegalArgumentException("Sorry we don't have city with id:" + id);
        }
        return city.get();
    }

    @Override
    public City update(CityDto cityDto) {
        City city = getCityById(cityDto.getId());
        city.setName(cityDto.getName());
        return cityRepository.save(city);
    }
}
