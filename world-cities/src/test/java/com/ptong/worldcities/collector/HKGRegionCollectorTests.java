package com.ptong.worldcities.collector;

import java.io.IOException;
import java.util.List;

import com.ptong.worldcities.collector.region.HKGRegionCollector;
import com.ptong.worldcities.model.District;
import com.ptong.worldcities.utils.FileUtils;
import com.ptong.worldcities.utils.JsonUtils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HKGRegionCollectorTests {

    private final String DISTRICT_JSON_FILE_PATH = FileUtils.getTestResourcesFolder() + "/hkg/districts_json";

    @Test
    public void shouldParseDistrictHtml() throws IOException, InterruptedException {
        HKGRegionCollector collector = new HKGRegionCollector();
        List<District> districts = collector.parseDistrictHtml("");
        FileUtils.writeToFile(DISTRICT_JSON_FILE_PATH, JsonUtils.getJsonFromObject(districts));
        Assertions.assertTrue(districts.size() == 1);
    }
}