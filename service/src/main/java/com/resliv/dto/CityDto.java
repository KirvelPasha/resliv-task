package com.resliv.dto;

public class CityDto {
    private Integer id;
    private String name;

    public CityDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public CityDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
