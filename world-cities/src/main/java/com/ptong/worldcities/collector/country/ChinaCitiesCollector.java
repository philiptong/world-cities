package com.ptong.worldcities.collector.country;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.ptong.worldcities.collector.CityCollector;
import com.ptong.worldcities.model.City;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ChinaCitiesCollector extends CityCollector {

    public String downloadHtml(String uri) throws IOException, InterruptedException {
        return this.get(uri);
    }

    @Override
    public List<City> parseHtml(String html) {
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
}