package com.ptong.worldcities.collector;

import java.io.IOException;
import java.util.List;

import com.ptong.worldcities.model.City;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ChinaCitiesCollectorTests {

    private final String RESOURCE_URL = "http://www.mca.gov.cn///article/sj/xzqh/2020/2020/2020072805001.html";

    @Test
    public void shouldDownloadHtml() throws IOException, InterruptedException {
        ChinaCitiesCollector collector = new ChinaCitiesCollector();
        String html = collector.downloadHtml(this.RESOURCE_URL);
        System.out.println(html);
        Assertions.assertTrue(html.length() > 0);
    }

    @Test
    public void shouldParseHtml() throws IOException, InterruptedException {
        ChinaCitiesCollector collector = new ChinaCitiesCollector();
        String html = collector.downloadHtml(this.RESOURCE_URL);
        List<City> cities = collector.parseHtml(html);
        System.out.println(cities);
        Assertions.assertTrue(cities.size() > 0);
    }

}