package com.ptong.worldcities.collector;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.ptong.worldcities.model.Country;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class CountryCollector extends HttpDownloader {

    private static final String COUNTRIES_RESOURCE_URI = "https://en.wikipedia.org/wiki/ISO_3166-1";

    public String downloadHtml() throws IOException, InterruptedException {
        return this.get(COUNTRIES_RESOURCE_URI);
    }

    public List<Country> parseHtml(String html) {
        Document doc = Jsoup.parse(html);
        List<Country> countries = new LinkedList<>();
        Elements rows = doc.select("table").get(1).select("tbody > tr");
        rows.forEach(row -> {
            Elements tds = row.select("td");
            if (tds.size() > 0) {
                Country country = new Country();
                country.setName(tds.get(0).text());
                country.setAlpha2Code(tds.get(1).text());
                country.setAlpha3Code(tds.get(2).text());
                country.setNumericCode(tds.get(3).text());
                countries.add(country);
            }
        });
        return countries;
    }
}