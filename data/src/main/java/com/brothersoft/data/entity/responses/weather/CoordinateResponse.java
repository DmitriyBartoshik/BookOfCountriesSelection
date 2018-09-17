package com.brothersoft.data.entity.responses.weather;

import com.brothersoft.data.entity.responses.DataModel;

public class CoordinateResponse implements DataModel {
    private double lon;
    private double lat;

    public double getLon() {
        return lon;
    }

    public double getLat() {
        return lat;
    }
}
