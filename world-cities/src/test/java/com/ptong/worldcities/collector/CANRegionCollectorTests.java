package com.ptong.worldcities.collector;

import java.io.IOException;
import java.util.List;

import com.ptong.worldcities.collector.region.NZLRegionCollector;
import com.ptong.worldcities.model.District;
import com.ptong.worldcities.model.Region;
import com.ptong.worldcities.utils.FileUtils;
import com.ptong.worldcities.utils.JsonUtils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CANRegionCollectorTests {

    private final String REGION_HTML_FILE_PATH = FileUtils.getTestResourcesFolder() + "/can/regions_html";
    private final String DISTRICT_JSON_FILE_PATH = FileUtils.getTestResourcesFolder() + "/can/districts_json";
    private final String REGION_JSON_FILE_PATH = FileUtils.getTestResourcesFolder() + "/can/regions_json";

    @Test
    public void shouldParseDistrictHtml() throws IOException, InterruptedException {
        NZLRegionCollector collector = new NZLRegionCollector();
        String html = FileUtils.readFile(REGION_HTML_FILE_PATH);
        List<District> districts = collector.parseDistrictHtml(html);
        FileUtils.writeToFile(DISTRICT_JSON_FILE_PATH, JsonUtils.getJsonFromObject(districts));
        Assertions.assertTrue(districts.size() == 13);
    }

    @Test
    public void shouldDownloadRegionHtml() throws IOException, InterruptedException {
        NZLRegionCollector collector = new NZLRegionCollector();
        String html = collector.downloadRegionHtml();
        FileUtils.writeToFile(REGION_HTML_FILE_PATH, html);
        Assertions.assertTrue(html.length() > 0);
    }

    @Test
    public void shouldParseRegionHtml() throws IOException, InterruptedException {
        NZLRegionCollector collector = new NZLRegionCollector();
        String html = FileUtils.readFile(REGION_HTML_FILE_PATH);
        List<Region> regions = collector.parseRegionHtml(html);
        FileUtils.writeToFile(REGION_JSON_FILE_PATH, JsonUtils.getJsonFromObject(regions));
        Assertions.assertTrue(regions.size() == 13);
    }

}