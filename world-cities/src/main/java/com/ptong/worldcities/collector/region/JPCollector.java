package com.ptong.worldcities.collector.region;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.ptong.worldcities.collector.RegionCollector;
import com.ptong.worldcities.model.City;
import com.ptong.worldcities.model.Region;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class JPCollector extends RegionCollector {

    public static final String COUNTRY_CODE = "JP";
    private static final String REGIONS_RESOURCE_URI = "https://en.wikipedia.org/wiki/ISO_3166-2:JP";

    @Override
    public String downloadCityHtml() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String downloadRegionHtml() {
        try {
            return this.get(REGIONS_RESOURCE_URI);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    public List<City> parseCityHtml(String html) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Region> parseRegionHtml(String html) {
        Document doc = Jsoup.parse(html);
        List<Region> regions = new LinkedList<>();
        Elements rows = doc.select("table").get(0).select("tbody > tr");
        rows.forEach(row -> {
            Elements tds = row.select("td");
            if (tds.size() > 0) {
                Region region = new Region();
                region.setName(tds.get(1).text());
                region.setCountryCode(COUNTRY_CODE);
                region.setIsoCode(tds.get(0).text());
                regions.add(region);
            }
        });
        return regions;
    }

}