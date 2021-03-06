package com.ptong.worldcities.collector;

import java.io.IOException;
import java.util.List;

import com.ptong.worldcities.model.Country;
import com.ptong.worldcities.utils.FileUtils;
import com.ptong.worldcities.utils.JsonUtils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountryCollectorTests {

    private static final String HTML_FILE_PATH = FileUtils.getResourcesFolder() + "/countries.html";
    private static final String JSON_FILE_PATH = FileUtils.getResourcesFolder() + "/countries.json";

    @Test
    public void shouldDownloadHtml() throws IOException, InterruptedException {
        CountryCollector collector = new CountryCollector();
        String html = collector.downloadHtml();
        FileUtils.writeToFile(HTML_FILE_PATH, html);
        Assertions.assertTrue(html.length() > 0);
    }

    @Test
    public void shouldParseHtml() throws IOException, InterruptedException {
        CountryCollector collector = new CountryCollector();
        String html = FileUtils.readFile(HTML_FILE_PATH);
        List<Country> countries = collector.parseHtml(html);
        FileUtils.writeToFile(JSON_FILE_PATH, JsonUtils.getJsonFromObject(countries));
        Assertions.assertTrue(countries.size() == 249);
    }
}