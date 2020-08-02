package com.ptong.worldcities.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Country implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String isoCode2;
    private String isoCode3;
}