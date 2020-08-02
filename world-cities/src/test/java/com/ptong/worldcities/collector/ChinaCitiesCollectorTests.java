package com.ptong.worldcities.collector;

import java.io.IOException;
import java.util.List;

import com.ptong.worldcities.collector.country.ChinaCitiesCollector;
import com.ptong.worldcities.config.Constants;
import com.ptong.worldcities.model.City;
import com.ptong.worldcities.utils.FileUtils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ChinaCitiesCollectorTests {

    private final String RESOURCE_URI = Constants.CHINA_CITIES_RESOURCE_URI;
    private final String HTML_FILE_PATH = FileUtils.getTestResourcesFolder() + "/china/china_cities_html";

    @Test
    public void shouldDownloadHtml() throws IOException, InterruptedException {
        ChinaCitiesCollector collector = new ChinaCitiesCollector();
        String html = collector.downloadHtml(this.RESOURCE_URI);
        System.out.println(html);
        FileUtils.writeToFile(HTML_FILE_PATH, html);
        Assertions.assertTrue(html.length() > 0);
    }

    @Test
    public void shouldParseHtml() throws IOException, InterruptedException {
        ChinaCitiesCollector collector = new ChinaCitiesCollector();
        String html = FileUtils.readFile(HTML_FILE_PATH);
        List<City> cities = collector.parseCityHtml(html);
        System.out.println(cities);
        Assertions.assertTrue(cities.size() == 684);
    }

}