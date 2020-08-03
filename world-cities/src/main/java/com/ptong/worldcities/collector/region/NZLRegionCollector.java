package com.ptong.worldcities.collector.region;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.ptong.worldcities.collector.RegionCollector;
import com.ptong.worldcities.model.District;
import com.ptong.worldcities.model.Region;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class NZLRegionCollector extends RegionCollector {

    private static final String COUNTRY_CODE = "NZL";
    private static final String REGIONS_RESOURCE_URI = "https://en.wikipedia.org/wiki/ISO_3166-2:NZ";

    @Override
    public String downloadDistrictHtml() {
        try {
            return this.get(REGIONS_RESOURCE_URI);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "";
        }
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
    public List<District> parseDistrictHtml(String html) {
        Document doc = Jsoup.parse(html);
        List<District> districts = new LinkedList<>();
        Elements rows = doc.select("table").get(0).select("tbody > tr");
        rows.forEach(row -> {
            Elements tds = row.select("td");
            if (tds.size() > 0) {
                String name = tds.get(1).text().trim().equals("") ? tds.get(2).text() : tds.get(1).text();
                District district = new District();
                district.setName(name);
                district.setCountryCode(COUNTRY_CODE);
                district.setRegionCode(tds.get(0).text());
                districts.add(district);
            }
        });
        return districts;
    }

    @Override
    public List<Region> parseRegionHtml(String html) {
        Document doc = Jsoup.parse(html);
        List<Region> regions = new LinkedList<>();
        Elements rows = doc.select("table").get(0).select("tbody > tr");
        rows.forEach(row -> {
            Elements tds = row.select("td");
            if (tds.size() > 0) {
                String name = tds.get(1).text().trim().equals("") ? tds.get(2).text() : tds.get(1).text();
                Region region = new Region();
                region.setName(name);
                region.setCountryCode(COUNTRY_CODE);
                region.setIsoCode(tds.get(0).text());
                regions.add(region);
            }
        });
        return regions;
    }
}