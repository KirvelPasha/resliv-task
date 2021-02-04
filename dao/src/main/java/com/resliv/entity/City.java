package com.resliv.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "CITY")
public class City extends BaseEntity {
    private String name;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CityInfo> cityInfos;

    public City(Integer id, String name, List<CityInfo> cityInfos) {
        super(id);
        this.name = name;
        this.cityInfos = cityInfos;
    }

    public City() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CityInfo> getCityInfos() {
        return cityInfos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        City city = (City) o;
        return Objects.equals(name, city.name) &&
                Objects.equals(cityInfos, city.cityInfos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, cityInfos);
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                '}';
    }
}
