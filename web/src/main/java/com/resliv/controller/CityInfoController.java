package com.resliv.controller;

import com.resliv.dto.CityInfoDto;
import com.resliv.entity.CityInfo;
import com.resliv.service.CityInfoService;
import com.resliv.wrapper.CityInfoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cityinfos")
public class CityInfoController {

    private final CityInfoService cityInfoService;

    @Autowired
    public CityInfoController(CityInfoService cityInfoService) {
        this.cityInfoService = cityInfoService;
    }

    @GetMapping()
    public ResponseEntity<CityInfoList> getCountyByName(@RequestParam("cityName") String cityName) {
        CityInfoList cityInfoList = new CityInfoList(cityInfoService.getCityInfoByCityName(cityName));
        return new ResponseEntity<>(cityInfoList, HttpStatus.OK);
    }


    @PostMapping()
    public ResponseEntity<CityInfo> save(@RequestBody CityInfoDto cityInfoDto) {
        return new ResponseEntity<>(cityInfoService.save(cityInfoDto), HttpStatus.CREATED);
    }

    @DeleteMapping()
    ResponseEntity<Void> deleteById(@RequestParam("id") Integer id) {
        cityInfoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}

