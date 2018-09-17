package com.brothersoft.domain.entity.weather;

import com.brothersoft.domain.entity.DomainModel;

import java.util.Date;
import java.util.List;

public class CapitalWeather implements DomainModel {
    private Coordinate coord;
    private List<WeatherDescription> weather;
    private String base;
    private WeatherData main;
    private int visibility;
    private Wind wind;
    private Cloud clouds;
    private long dt;
    private SunData sys;
    private int id;
    private String name;
    private int cod;

    public Coordinate getCoord() {
        return coord;
    }

    public List<WeatherDescription> getWeather() {
        return weather;
    }

    public String getBase() {
        return base;
    }

    public WeatherData getMain() {
        return main;
    }

    public int getVisibility() {
        return visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public Cloud getClouds() {
        return clouds;
    }

    public long getDt() {
        return dt;
    }

    public SunData getSys() {
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

    public void setCoord(Coordinate coord) {
        this.coord = coord;
    }

    public void setWeather(List<WeatherDescription> weather) {
        this.weather = weather;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public void setMain(WeatherData main) {
        this.main = main;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public void setClouds(Cloud clouds) {
        this.clouds = clouds;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public void setSys(SunData sys) {
        this.sys = sys;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
}

