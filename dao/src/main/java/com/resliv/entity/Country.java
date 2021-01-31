package com.resliv.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "COUNTRY")
public class Country extends BaseEntity {
    private String name;
    private String info;

    public Country(Integer id, String name, String info) {
        super(id);
        this.name = name;
        this.info = info;
    }

    public Country() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
