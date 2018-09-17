package com.brothersoft.domain.entity.weather;

import com.brothersoft.domain.entity.DomainModel;

public class Coordinate implements DomainModel {
private double lon;
private double lat;

    public double getLon() {
        return lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }
}
