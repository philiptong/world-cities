package com.ptong.worldcities.collector;

import java.util.List;

import com.ptong.worldcities.model.City;

public interface ResourceParser {

    List<City> parseHtml(String html);

}