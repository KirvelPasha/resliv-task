package com.resliv.controller;

import com.resliv.dto.CityDto;
import com.resliv.entity.City;
import com.resliv.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cities")
public class CityController {
    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping()
    public ResponseEntity<City> save(@RequestBody CityDto cityDto) {
        return new ResponseEntity<>(cityService.save(cityDto), HttpStatus.CREATED);
    }

    @DeleteMapping()
    ResponseEntity<Void> deleteById(@RequestParam("id") Integer id) {
        cityService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
