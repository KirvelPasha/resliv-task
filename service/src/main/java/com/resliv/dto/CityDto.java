package com.resliv.dto;

public class CityDto {
    private String name;

    public CityDto(String name, String info) {
        this.name = name;
    }

    public CityDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
