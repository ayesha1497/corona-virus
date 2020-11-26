package com.corona.virus.coronavirus.model;

public class CoronaVirus {

    private String county;

    private String state;

    private String country;

    private Integer totalConfirmedCases;

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getTotalConfirmedCases() {
        return totalConfirmedCases;
    }

    public void setTotalConfirmedCases(Integer totalConfirmedCases) {
        this.totalConfirmedCases = totalConfirmedCases;
    }
}
