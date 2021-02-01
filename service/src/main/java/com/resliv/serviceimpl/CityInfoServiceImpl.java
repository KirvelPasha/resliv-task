package com.resliv.serviceimpl;

import com.resliv.converter.CityInfoConverter;
import com.resliv.dto.CityInfoDto;
import com.resliv.entity.CityInfo;
import com.resliv.repository.CityInfoRepository;
import com.resliv.service.CityInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityInfoServiceImpl implements CityInfoService {
    private final CityInfoRepository cityInfoRepository;
    private final CityInfoConverter cityInfoConverter;

    @Autowired
    public CityInfoServiceImpl(CityInfoRepository cityInfoRepository, CityInfoConverter cityInfoConverter) {
        this.cityInfoRepository = cityInfoRepository;
        this.cityInfoConverter = cityInfoConverter;

    }


    @Override
    public List<CityInfo> getCityInfoByCityName(String cityName) {
        return cityInfoRepository.getCityInfoByCityName(cityName);
    }

    @Override
    public void deleteById(Integer id) {
        cityInfoRepository.deleteById(id);
    }

    @Override
    public CityInfo save(CityInfoDto cityInfoDto) {
        CityInfo cityInfo = cityInfoConverter.converter(cityInfoDto);
        return cityInfoRepository.save(cityInfo);
    }

}
