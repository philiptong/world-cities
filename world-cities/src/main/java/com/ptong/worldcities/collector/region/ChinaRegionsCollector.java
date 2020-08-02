package com.ptong.worldcities.collector.region;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.ptong.worldcities.collector.RegionCollector;
import com.ptong.worldcities.model.Region;
import com.ptong.worldcities.model.City;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ChinaRegionsCollector extends RegionCollector {

    public String downloadHtml(String uri) throws IOException, InterruptedException {
        return this.get(uri);
    }

    @Override
    public List<City> parseCityHtml(String html) {
        Document doc = Jsoup.parse(html);
        Elements tds = doc.select("td");
        List<City> cities = new LinkedList<>();
        tds.forEach(td -> {
            String content = td.text();
            if (content.matches(".*[市]$")) {
                City city = new City();
                city.setName(content);
                cities.add(city);
            }
        });
        return cities;
    }

    @Override
    public List<Region> parseRegionHtml(String html) {
        // TODO Auto-generated method stub
        return null;
    }
}