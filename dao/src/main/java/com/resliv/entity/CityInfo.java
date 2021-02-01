package com.resliv.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "CITY_INFO")
public class CityInfo extends BaseEntity {
    private String info;

    @ManyToOne
    @JoinColumn(name = "cityId")
    private City city;

    public CityInfo(Integer id, String info, City city) {
        super(id);
        this.info = info;
        this.city = city;
    }

    public CityInfo() {
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CityInfo cityInfo = (CityInfo) o;
        return Objects.equals(info, cityInfo.info) &&
                Objects.equals(city, cityInfo.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), info, city);
    }

    @Override
    public String toString() {
        return "CityInfo{" +
                "info='" + info + '\'' +
                ", city=" + city +
                '}';
    }
}
