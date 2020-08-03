package com.ptong.worldcities.collector;

import java.util.List;

import com.ptong.worldcities.model.Region;
import com.ptong.worldcities.model.District;

public interface ResourceCollector {

    String downloadDistrictHtml();

    String downloadRegionHtml();

    List<District> parseDistrictHtml(String html);

    List<Region> parseRegionHtml(String html);
}