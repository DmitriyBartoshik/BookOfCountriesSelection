package com.brothersoft.data.entity.responses.weather;

import com.brothersoft.data.entity.responses.DataModel;

public class WindResponse implements DataModel {
    private double speed;
    private double deg;
    private double gust;

    public double getSpeed() {
        return speed;
    }

    public double getDeg() {
        return deg;
    }

    public double getGust() {
        return gust;
    }
}
