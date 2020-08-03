package com.ptong.worldcities.collector.region;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.ptong.worldcities.collector.RegionCollector;
import com.ptong.worldcities.model.Region;
import com.ptong.worldcities.model.District;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class CHNRegionCollector extends RegionCollector {

    private static final String COUNTRY_CODE = "CHN";
    private static final String REGIONS_RESOURCE_URI = "https://zh.wikipedia.org/wiki/ISO_3166-2:CN";
    private static final String DISTRICTS_RESOURCE_URI = "http://www.mca.gov.cn///article/sj/xzqh/2020/2020/2020072805001.html";

    @Override
    public List<District> parseDistrictHtml(String html) {
        Document doc = Jsoup.parse(html);
        Elements trs = doc.select("tr[height=19]");
        List<District> districts = new LinkedList<>();
        trs.forEach(tr -> {
            Elements tds = tr.select("td");
            String code = tds.get(1).text();
            String name = tds.get(2).text();
            if (code.endsWith("00") && !name.contains("省") && !name.contains("自治区")) {
                District district = new District();
                district.setName(name);
                district.setCountryCode(COUNTRY_CODE);
                districts.add(district);
            }
        });
        return districts;
    }

    @Override
    public List<Region> parseRegionHtml(String html) {
        Document doc = Jsoup.parse(html);
        List<Region> regions = new LinkedList<>();
        Elements rows = doc.select("table").get(1).select("tbody > tr");
        rows.forEach(row -> {
            Elements tds = row.select("td");
            if (tds.size() > 0) {
                Region region = new Region();
                region.setName(tds.get(2).text());
                region.setCountryCode(COUNTRY_CODE);
                region.setIsoCode(tds.get(0).text());
                regions.add(region);
            }
        });
        return regions;
    }

    @Override
    public String downloadDistrictHtml() {
        try {
            return this.get(DISTRICTS_RESOURCE_URI);
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
}