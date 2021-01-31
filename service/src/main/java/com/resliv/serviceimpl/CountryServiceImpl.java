package com.resliv.serviceimpl;

import com.resliv.converter.CountryConverter;
import com.resliv.dto.CountryDto;
import com.resliv.entity.Country;
import com.resliv.repository.CountryRepository;
import com.resliv.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;
    private final CountryConverter countryConverter;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository, CountryConverter countryConverter) {
        this.countryRepository = countryRepository;
        this.countryConverter = countryConverter;
    }

    @Override
    public CountryDto getCountryByName(String name) {
        return  countryConverter.converter(countryRepository.getCountryByName(name));
    }

    @Override
    public CountryDto save(CountryDto countryDto) {
        Country country = countryConverter.converter(countryDto);
        return countryConverter.converter(countryRepository.save(country));
    }
}
