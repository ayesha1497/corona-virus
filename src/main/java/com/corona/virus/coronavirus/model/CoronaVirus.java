package com.corona.virus.coronavirus.model;

public class CoronaVirus {

    private String state;

    private String country;

    private Integer totalConfirmedCases;

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
