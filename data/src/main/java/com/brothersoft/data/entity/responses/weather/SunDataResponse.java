package com.brothersoft.data.entity.responses.weather;

import com.brothersoft.data.entity.responses.DataModel;

public class SunDataResponse implements DataModel {
    private int type;
    private int id;
    private double message;
    private String country;
    private long sunrise;
    private long sunset;

    public int getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public double getMessage() {
        return message;
    }

    public String getCountry() {
        return country;
    }

    public long getSunrise() {
        return sunrise;
    }

    public long getSunset() {
        return sunset;
    }
}
