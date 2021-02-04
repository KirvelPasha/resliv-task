package com.resliv.serviceimpl;

import com.resliv.converter.CityInfoConverter;
import com.resliv.dto.CityInfoDto;
import com.resliv.entity.CityInfo;
import com.resliv.repository.CityInfoRepository;
import com.resliv.service.CityInfoService;
import com.resliv.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityInfoServiceImpl implements CityInfoService {
    private final CityInfoRepository cityInfoRepository;
    private final CityInfoConverter cityInfoConverter;
    private final CityService cityService;

    @Autowired
    public CityInfoServiceImpl(CityInfoRepository cityInfoRepository, CityInfoConverter cityInfoConverter, CityService cityService) {
        this.cityInfoRepository = cityInfoRepository;
        this.cityInfoConverter = cityInfoConverter;

        this.cityService = cityService;
    }


    @Override
    public List<CityInfo> getCityInfoByCityName(String cityName) {
        return cityService.getCityByName(cityName).getCityInfos();
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

    @Override
    public CityInfo getCityInfoById(Integer id) {
        Optional<CityInfo> cityInfo = cityInfoRepository.findById(id);
        if (!cityInfo.isPresent()) {
            throw new IllegalArgumentException("Sorry we don't have city info with id: " + id);
        }
        return cityInfo.get();
    }

    @Override
    public CityInfo update(CityInfoDto cityInfoDto) {
        CityInfo cityInfo = getCityInfoById(cityInfoDto.getId());
        cityInfo.setInfo(cityInfoDto.getInfo());
        return cityInfoRepository.save(cityInfo);
    }

}
