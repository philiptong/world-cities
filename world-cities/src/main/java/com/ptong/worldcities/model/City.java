package com.ptong.worldcities.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class City implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private double lat;
    private double lng;
    private String countryName;
    private String alpha2Code;
    private String alpha3Code;
    private String adminName;

}