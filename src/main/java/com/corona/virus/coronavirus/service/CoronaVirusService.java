package com.corona.virus.coronavirus.service;

import com.corona.virus.coronavirus.model.CoronaVirus;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class CoronaVirusService {

    private static String coronaVirusDataUrl = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";

    private List<CoronaVirus> allCoronaVirusInformation = new ArrayList<>();

    @PostConstruct
    @Scheduled(cron = "* * 1 * * *")
    public String getCoronaVirusInformation() {
        List<CoronaVirus> newCoronaVirusInformation = new ArrayList<>();
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
        StringReader coronaVirusInformationStringReader = new StringReader(coronaVirusInformation);
        Iterable<CSVRecord> records;
        try {
            records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(coronaVirusInformationStringReader);
        } catch (IOException e) {
            throw new RuntimeException("Error when parsing csv for corono virus information" + e.getMessage());
        }
        for (CSVRecord record : records) {
            final CoronaVirus coronaVirus = new CoronaVirus();
            coronaVirus.setState(record.get("Province/State"));
            coronaVirus.setCountry(record.get("Country/Region"));
            coronaVirus.setTotalConfirmedCases(Integer.parseInt(record.get(record.size() - 1)));
            newCoronaVirusInformation.add(coronaVirus);
        }
        this.allCoronaVirusInformation = newCoronaVirusInformation;
        System.out.println(allCoronaVirusInformation.size());
        return coronaVirusInformation;
    }
}
