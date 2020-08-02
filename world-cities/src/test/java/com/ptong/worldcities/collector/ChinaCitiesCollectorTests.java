package com.ptong.worldcities.collector;

import java.io.IOException;
import java.util.List;

import com.ptong.worldcities.config.Constants;
import com.ptong.worldcities.model.City;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ChinaCitiesCollectorTests {

    private final String RESOURCE_URI = Constants.CHINA_CITIES_RESOURCE_URI;

    @Test
    public void shouldDownloadHtml() throws IOException, InterruptedException {
        ChinaCitiesCollector collector = new ChinaCitiesCollector();
        String html = collector.downloadHtml(this.RESOURCE_URI);
        System.out.println(html);
        Assertions.assertTrue(html.length() > 0);
    }

    @Test
    public void shouldParseHtml() throws IOException, InterruptedException {
        ChinaCitiesCollector collector = new ChinaCitiesCollector();
        String html = collector.downloadHtml(this.RESOURCE_URI);
        List<City> cities = collector.parseHtml(html);
        System.out.println(cities);
        Assertions.assertTrue(cities.size() > 0);
    }

}