package com.ptong.worldcities.model;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * Principle administrative division for Countries, ISO 3166-2
 */
@Data
public class Region implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String isoCode;
    private String countryCode;
    private List<City> cities;

}