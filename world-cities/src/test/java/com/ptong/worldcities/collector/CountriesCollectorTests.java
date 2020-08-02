package com.ptong.worldcities.collector;

import java.io.IOException;
import java.util.List;

import com.ptong.worldcities.config.Constants;
import com.ptong.worldcities.model.Country;
import com.ptong.worldcities.utils.FileUtils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountriesCollectorTests {

    private final String RESOURCE_URI = Constants.COUNTRIES_RESOURCE_URI;
    private final String HTML_FILE_PATH = FileUtils.getTestResourcesFolder() + "/countries_html";

    @Test
    public void shouldDownloadHtml() throws IOException, InterruptedException {
        CountriesCollector collector = new CountriesCollector();
        String html = collector.downloadHtml(this.RESOURCE_URI);
        System.out.println(html);
        FileUtils.writeToFile(HTML_FILE_PATH, html);
        Assertions.assertTrue(html.length() > 0);
    }

    @Test
    public void shouldParseHtml() throws IOException, InterruptedException {
        CountriesCollector collector = new CountriesCollector();
        String html = FileUtils.readFile(HTML_FILE_PATH);
        List<Country> countries = collector.parseHtml(html);
        System.out.println(countries);
        Assertions.assertTrue(countries.size() > 0);
    }
}