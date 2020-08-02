package com.ptong.worldcities.collector;

import java.io.IOException;
import java.util.List;

import com.ptong.worldcities.collector.region.ChinaRegionsCollector;
import com.ptong.worldcities.config.Constants;
import com.ptong.worldcities.model.City;
import com.ptong.worldcities.utils.FileUtils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ChinaRegionsCollectorTests {

    private final String CITY_RESOURCE_URI = Constants.CHINA_CITIES_RESOURCE_URI;
    private final String CITY_HTML_FILE_PATH = FileUtils.getTestResourcesFolder() + "/china/china_cities_html";

    @Test
    public void shouldDownloadCityHtml() throws IOException, InterruptedException {
        ChinaRegionsCollector collector = new ChinaRegionsCollector();
        String html = collector.downloadHtml(this.CITY_RESOURCE_URI);
        System.out.println(html);
        FileUtils.writeToFile(CITY_HTML_FILE_PATH, html);
        Assertions.assertTrue(html.length() > 0);
    }

    @Test
    public void shouldParseCityHtml() throws IOException, InterruptedException {
        ChinaRegionsCollector collector = new ChinaRegionsCollector();
        String html = FileUtils.readFile(CITY_HTML_FILE_PATH);
        List<City> cities = collector.parseCityHtml(html);
        System.out.println(cities);
        Assertions.assertTrue(cities.size() == 684);
    }

}