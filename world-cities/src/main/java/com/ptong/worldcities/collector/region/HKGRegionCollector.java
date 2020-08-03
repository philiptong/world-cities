package com.ptong.worldcities.collector.region;

import java.util.LinkedList;
import java.util.List;

import com.ptong.worldcities.collector.RegionCollector;
import com.ptong.worldcities.model.District;
import com.ptong.worldcities.model.Region;

public class HKGRegionCollector extends RegionCollector {

    private static final String COUNTRY_CODE = "HKG";

    @Override
    public String downloadDistrictHtml() {
        return "";
    }

    @Override
    public String downloadRegionHtml() {
        return "";
    }

    @Override
    public List<District> parseDistrictHtml(String html) {
        List<District> cities = new LinkedList<>();
        District city = new District();
        city.setName("Hong Kong");
        city.setCountryCode(COUNTRY_CODE);
        city.setRegionCode(COUNTRY_CODE);
        cities.add(city);
        return cities;
    }

    @Override
    public List<Region> parseRegionHtml(String html) {
        List<Region> regions = new LinkedList<>();
        Region region = new Region();
        region.setName("Hong Kong");
        region.setCountryCode(COUNTRY_CODE);
        region.setIsoCode(COUNTRY_CODE);
        regions.add(region);
        return regions;
    }

}