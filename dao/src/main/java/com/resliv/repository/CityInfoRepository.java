package com.resliv.repository;

import com.resliv.entity.CityInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityInfoRepository extends JpaRepository<CityInfo, Integer> {
    List<CityInfo> getCityInfoByCityName(String cityName);
}
