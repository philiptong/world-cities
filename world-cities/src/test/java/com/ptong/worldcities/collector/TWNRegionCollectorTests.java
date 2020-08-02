package com.ptong.worldcities.collector;

import java.io.IOException;
import java.util.List;

import com.ptong.worldcities.collector.region.TWNRegionCollector;
import com.ptong.worldcities.config.Constants;
import com.ptong.worldcities.model.City;
import com.ptong.worldcities.model.Region;
import com.ptong.worldcities.utils.FileUtils;
import com.ptong.worldcities.utils.JsonUtils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TWNRegionCollectorTests {

    private final String REGION_RESOURCE_URI = Constants.TWN_REGIONS_RESOURCE_URI;
    private final String REGION_HTML_FILE_PATH = FileUtils.getTestResourcesFolder() + "/twn/regions_html";
    private final String REGION_JSON_FILE_PATH = FileUtils.getTestResourcesFolder() + "/twn/regions_json";
    private final String CITY_JSON_FILE_PATH = FileUtils.getTestResourcesFolder() + "/twn/cities_json";

    @Test
    public void shouldParseCityHtml() throws IOException, InterruptedException {
        TWNRegionCollector collector = new TWNRegionCollector();
        String html = FileUtils.readFile(REGION_HTML_FILE_PATH);
        List<City> cities = collector.parseCityHtml(html);
        FileUtils.writeToFile(CITY_JSON_FILE_PATH, JsonUtils.getJsonFromObject(cities));
        Assertions.assertTrue(cities.size() == 339);
    }

    @Test
    public void shouldDownloadRegionHtml() throws IOException, InterruptedException {
        TWNRegionCollector collector = new TWNRegionCollector();
        String html = collector.downloadHtml(this.REGION_RESOURCE_URI);
        FileUtils.writeToFile(REGION_HTML_FILE_PATH, html);
        Assertions.assertTrue(html.length() > 0);
    }

    @Test
    public void shouldParseRegionHtml() throws IOException, InterruptedException {
        TWNRegionCollector collector = new TWNRegionCollector();
        String html = FileUtils.readFile(REGION_HTML_FILE_PATH);
        List<Region> regions = collector.parseRegionHtml(html);
        FileUtils.writeToFile(REGION_JSON_FILE_PATH, JsonUtils.getJsonFromObject(regions));
        Assertions.assertTrue(regions.size() > 0);
    }
}