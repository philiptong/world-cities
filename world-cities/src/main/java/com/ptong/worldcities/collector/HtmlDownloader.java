package com.ptong.worldcities.collector;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public abstract class HtmlDownloader {

    private final HttpClient client;

    protected HtmlDownloader() {
        this.client = HttpClient.newHttpClient();
    }

    protected String get(final String uri) throws IOException, InterruptedException {
        final HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();
        final HttpResponse<String> response = this.client.send(request, BodyHandlers.ofString());
        return response.body();
    }

}