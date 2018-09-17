package com.brothersoft.data.entity.responses.weather;

import com.brothersoft.data.entity.responses.DataModel;

import java.util.List;

public class CapitalWeatherResponse implements DataModel {
    private CoordinateResponse coord;
    private List<WeatherDescriptionResponse> weather;
    private String base;
    private WeatherDataResponse main;
    private int visibility;
    private WindResponse wind;
    private CloudResponse clouds;
    private long dt;
    private SunDataResponse sys;
    private int id;
    private String name;
    private int cod;

    public CoordinateResponse getCoord() {
        return coord;
    }

    public List<WeatherDescriptionResponse> getWeather() {
        return weather;
    }

    public String getBase() {
        return base;
    }

    public WeatherDataResponse getMain() {
        return main;
    }

    public int getVisibility() {
        return visibility;
    }

    public WindResponse getWind() {
        return wind;
    }

    public CloudResponse getClouds() {
        return clouds;
    }

    public long getDt() {
        return dt;
    }

    public SunDataResponse getSys() {
        return sys;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCod() {
        return cod;
    }
}
