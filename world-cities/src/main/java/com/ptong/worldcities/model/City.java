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
    private String isoCode2;
    private String isoCode3;
    private String adminName;

}