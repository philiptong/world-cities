package com.ptong.worldcities.model;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * Political entity in ISO 3166-1
 */
@Data
public class Country implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String alpha2Code;
    private String alpha3Code;
    private String numericCode;
    private List<AdminDivision> adminDivisions;
}