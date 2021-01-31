package com.resliv.converter;

import com.resliv.dto.CountryDto;
import com.resliv.entity.Country;
import org.springframework.stereotype.Component;

@Component
public class CountryConverter {

    public Country converter(CountryDto countryDto) {
        Country country = new Country();
        country.setName(countryDto.getName());
        country.setInfo(countryDto.getInfo());

        return country;
    }

    public CountryDto converter(Country country) {
        CountryDto countryDto = new CountryDto();
        countryDto.setName(country.getName());
        countryDto.setInfo(country.getInfo());

        return countryDto;
    }
}
