package com.ptong.worldcities.collector;

import java.io.IOException;
import java.util.List;

import com.ptong.worldcities.collector.region.CNCollector;
import com.ptong.worldcities.model.City;
import com.ptong.worldcities.model.Region;
import com.ptong.worldcities.utils.FileUtils;
import com.ptong.worldcities.utils.JsonUtils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CNCollectorTests {

    public static final String COUNTRY_CODE = CNCollector.COUNTRY_CODE;

    private static final String CITY_HTML_FILE_PATH = FileUtils.getResourcesFolder(COUNTRY_CODE) + "cities.html";
    private static final String REGION_HTML_FILE_PATH = FileUtils.getResourcesFolder(COUNTRY_CODE) + "regions.html";
    private static final String CITY_JSON_FILE_PATH = FileUtils.getResourcesFolder(COUNTRY_CODE) + "cities.json";
    private static final String REGION_JSON_FILE_PATH = FileUtils.getResourcesFolder(COUNTRY_CODE) + "regions.json";

    @Test
    public void shouldDownloadCityHtml() throws IOException, InterruptedException {
        CNCollector collector = new CNCollector();
        String html = collector.downloadCityHtml();
        FileUtils.writeToFile(CITY_HTML_FILE_PATH, html);
        Assertions.assertTrue(html.length() > 0);
    }

    @Test
    public void shouldParseCityHtml() throws IOException, InterruptedException {
        CNCollector collector = new CNCollector();
        String html = FileUtils.readFile(CITY_HTML_FILE_PATH);
        List<City> cities = collector.parseCityHtml(html);
        FileUtils.writeToFile(CITY_JSON_FILE_PATH, JsonUtils.getJsonFromObject(cities));
        Assertions.assertTrue(cities.size() == 339);
    }

    @Test
    public void shouldDownloadRegionHtml() throws IOException, InterruptedException {
        CNCollector collector = new CNCollector();
        String html = collector.downloadRegionHtml();
        FileUtils.writeToFile(REGION_HTML_FILE_PATH, html);
        Assertions.assertTrue(html.length() > 0);
    }

    @Test
    public void shouldParseRegionHtml() throws IOException, InterruptedException {
        CNCollector collector = new CNCollector();
        String html = FileUtils.readFile(REGION_HTML_FILE_PATH);
        List<Region> regions = collector.parseRegionHtml(html);
        FileUtils.writeToFile(REGION_JSON_FILE_PATH, JsonUtils.getJsonFromObject(regions));
        Assertions.assertTrue(regions.size() == 34);
    }

}