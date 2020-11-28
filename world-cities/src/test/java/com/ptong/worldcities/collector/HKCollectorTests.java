package com.ptong.worldcities.collector;

import java.io.IOException;
import java.util.List;

import com.ptong.worldcities.collector.region.HKCollector;
import com.ptong.worldcities.model.City;
import com.ptong.worldcities.utils.FileUtils;
import com.ptong.worldcities.utils.JsonUtils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HKCollectorTests {

    public static final String COUNTRY_CODE = HKCollector.COUNTRY_CODE;

    private static final String CITY_JSON_FILE_PATH = FileUtils.getResourcesFolder(COUNTRY_CODE) + "cities.json";

    @Test
    public void shouldParseCityHtml() throws IOException, InterruptedException {
        HKCollector collector = new HKCollector();
        List<City> cities = collector.parseCityHtml("");
        FileUtils.writeToFile(CITY_JSON_FILE_PATH, JsonUtils.getJsonFromObject(cities));
        Assertions.assertTrue(cities.size() == 1);
    }
}