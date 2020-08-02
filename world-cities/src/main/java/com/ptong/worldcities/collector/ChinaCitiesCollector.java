package com.ptong.worldcities.collector;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.ptong.worldcities.model.City;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ChinaCitiesCollector extends HttpDownloader implements ResourceParser {

    public ChinaCitiesCollector() {
        super();
    }

    public String downloadHtml(String uri) {
        String html = "";
        try {
            html = this.get(uri);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return html;
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