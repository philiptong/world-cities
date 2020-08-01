package com.ptong.worldcities.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class City implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
}