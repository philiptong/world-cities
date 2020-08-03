package com.ptong.worldcities.model;

import java.io.Serializable;

import lombok.Data;

/**
 * Second/Third level administrative division, county, city or town
 */
@Data
public class District implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private double lat;
    private double lng;
    private String countryCode;
    private String regionCode;

}