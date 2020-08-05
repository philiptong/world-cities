package com.ptong.worldcities.collector;

import java.io.IOException;
import java.util.List;

import com.ptong.worldcities.collector.region.MACRegionCollector;
import com.ptong.worldcities.model.District;
import com.ptong.worldcities.utils.FileUtils;
import com.ptong.worldcities.utils.JsonUtils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MACRegionCollectorTests {

    private static final String COUNTRY_CODE = "mac";

    private static final String DISTRICT_JSON_FILE_PATH = FileUtils.getResourcesFolder(COUNTRY_CODE) + "districts_json";

    @Test
    public void shouldParseDistrictHtml() throws IOException, InterruptedException {
        MACRegionCollector collector = new MACRegionCollector();
        List<District> districts = collector.parseDistrictHtml("");
        FileUtils.writeToFile(DISTRICT_JSON_FILE_PATH, JsonUtils.getJsonFromObject(districts));
        Assertions.assertTrue(districts.size() == 1);
    }
}