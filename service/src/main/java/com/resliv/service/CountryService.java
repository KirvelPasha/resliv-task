package com.resliv.service;

import com.resliv.dto.CountryDto;
import com.resliv.entity.Country;

public interface CountryService {
    CountryDto getCountryByName(String name);

    CountryDto save(CountryDto countryDto);
}
