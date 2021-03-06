package com.ptong.worldcities.collector;

import java.util.List;

import com.ptong.worldcities.model.Region;
import com.ptong.worldcities.model.City;

public interface ResourceCollector {

    String downloadCityHtml();

    String downloadRegionHtml();

    List<City> parseCityHtml(String html);

    List<Region> parseRegionHtml(String html);
}