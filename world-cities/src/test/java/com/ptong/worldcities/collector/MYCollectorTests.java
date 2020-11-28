package com.ptong.worldcities.collector;

import java.io.IOException;
import java.util.List;

import com.ptong.worldcities.collector.region.MYCollector;
import com.ptong.worldcities.model.Region;
import com.ptong.worldcities.utils.FileUtils;
import com.ptong.worldcities.utils.JsonUtils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MYCollectorTests {

    public static final String COUNTRY_CODE = MYCollector.COUNTRY_CODE;

    private static final String REGION_HTML_FILE_PATH = FileUtils.getResourcesFolder(COUNTRY_CODE) + "regions.html";
    private static final String REGION_JSON_FILE_PATH = FileUtils.getResourcesFolder(COUNTRY_CODE) + "regions.json";

    @Test
    public void shouldDownloadRegionHtml() throws IOException, InterruptedException {
        MYCollector collector = new MYCollector();
        String html = collector.downloadRegionHtml();
        FileUtils.writeToFile(REGION_HTML_FILE_PATH, html);
        Assertions.assertTrue(html.length() > 0);
    }

    @Test
    public void shouldParseRegionHtml() throws IOException, InterruptedException {
        MYCollector collector = new MYCollector();
        String html = FileUtils.readFile(REGION_HTML_FILE_PATH);
        List<Region> regions = collector.parseRegionHtml(html);
        FileUtils.writeToFile(REGION_JSON_FILE_PATH, JsonUtils.getJsonFromObject(regions));
        Assertions.assertTrue(regions.size() == 16);
    }

}