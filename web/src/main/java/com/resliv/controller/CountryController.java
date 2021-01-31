package com.resliv.controller;

import com.resliv.dto.CountryDto;
import com.resliv.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/countries")
public class CountryController {
    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public ResponseEntity<CountryDto> getCountyByName(@PathVariable String name) {
        return new ResponseEntity<>(countryService.getCountryByName(name), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<CountryDto> save(@RequestBody CountryDto countryDto) {
        return new ResponseEntity<>(countryService.save(countryDto), HttpStatus.CREATED);
    }

}
