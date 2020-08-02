package com.ptong.worldcities.model;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class AdminDivision implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String isoCode;
    private String countryName;
    private List<City> cities;

}