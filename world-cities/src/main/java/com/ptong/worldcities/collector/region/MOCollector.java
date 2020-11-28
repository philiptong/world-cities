package com.ptong.worldcities.collector.region;

import java.util.LinkedList;
import java.util.List;

import com.ptong.worldcities.collector.RegionCollector;
import com.ptong.worldcities.model.City;
import com.ptong.worldcities.model.Region;

public class MOCollector extends RegionCollector {

    public static final String COUNTRY_CODE= "MO";

    @Override
    public String downloadCityHtml() {
        return "";
    }

    @Override
    public String downloadRegionHtml() {
        return "";
    }

    @Override
    public List<City> parseCityHtml(String html) {
        List<City> cities = new LinkedList<>();
        City city = new City();
        city.setName("Macao");
        city.setCountryCode(COUNTRY_CODE);
        city.setRegionCode(COUNTRY_CODE);
        cities.add(city);
        return cities;
    }

    @Override
    public List<Region> parseRegionHtml(String html) {
        List<Region> regions = new LinkedList<>();
        Region region = new Region();
        region.setName("Macao");
        region.setCountryCode(COUNTRY_CODE);
        region.setIsoCode(COUNTRY_CODE);
        regions.add(region);
        return regions;
    }

}