package com.ptong.worldcities.collector;

import java.util.List;

import com.ptong.worldcities.model.Region;
import com.ptong.worldcities.model.City;

public interface ResourceParser {

    List<City> parseCityHtml(String html);

    List<Region> parseRegionHtml(String html);
}