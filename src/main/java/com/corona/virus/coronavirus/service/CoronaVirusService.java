package com.corona.virus.coronavirus.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class CoronaVirusService {

    private static String coronaVirusDataUrl = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_US.csv";

    @PostConstruct
    public String getCoronaVirusInformation() {
        String coronaVirusInformation;
        final HttpClient httpClient = HttpClient.newHttpClient();
        final HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(coronaVirusDataUrl)).build();
        try {
            coronaVirusInformation = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString()).body();
        } catch (final IOException e) {
            throw new RuntimeException("Error when retrieving corono virus information" + e.getMessage());
        } catch (final InterruptedException e) {
            throw new RuntimeException("Error when retrieving corono virus information" + e.getMessage());
        }
        System.out.println(coronaVirusInformation);
        return coronaVirusInformation;
    }
}
