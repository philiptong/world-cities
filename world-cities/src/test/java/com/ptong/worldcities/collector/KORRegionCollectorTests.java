package com.ptong.worldcities.collector;

import java.io.IOException;
import java.util.List;

import com.ptong.worldcities.collector.region.KORRegionCollector;
import com.ptong.worldcities.model.District;
import com.ptong.worldcities.model.Region;
import com.ptong.worldcities.utils.FileUtils;
import com.ptong.worldcities.utils.JsonUtils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KORRegionCollectorTests {

    private final String REGION_HTML_FILE_PATH = FileUtils.getTestResourcesFolder() + "/kor/regions_html";
    private final String DISTRICT_JSON_FILE_PATH = FileUtils.getTestResourcesFolder() + "/kor/districts_json";
    private final String REGION_JSON_FILE_PATH = FileUtils.getTestResourcesFolder() + "/kor/regions_json";

    @Test
    public void shouldParseDistrictHtml() throws IOException, InterruptedException {
        KORRegionCollector collector = new KORRegionCollector();
        String html = FileUtils.readFile(REGION_HTML_FILE_PATH);
        List<District> districts = collector.parseDistrictHtml(html);
        FileUtils.writeToFile(DISTRICT_JSON_FILE_PATH, JsonUtils.getJsonFromObject(districts));
        Assertions.assertTrue(districts.size() == 17);
    }

    @Test
    public void shouldDownloadRegionHtml() throws IOException, InterruptedException {
        KORRegionCollector collector = new KORRegionCollector();
        String html = collector.downloadRegionHtml();
        FileUtils.writeToFile(REGION_HTML_FILE_PATH, html);
        Assertions.assertTrue(html.length() > 0);
    }

    @Test
    public void shouldParseRegionHtml() throws IOException, InterruptedException {
        KORRegionCollector collector = new KORRegionCollector();
        String html = FileUtils.readFile(REGION_HTML_FILE_PATH);
        List<Region> regions = collector.parseRegionHtml(html);
        FileUtils.writeToFile(REGION_JSON_FILE_PATH, JsonUtils.getJsonFromObject(regions));
        Assertions.assertTrue(regions.size() == 17);
    }

}