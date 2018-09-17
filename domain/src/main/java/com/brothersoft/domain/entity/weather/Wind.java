package com.brothersoft.domain.entity.weather;

import com.brothersoft.domain.entity.DomainModel;

public class Wind implements DomainModel {
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

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setDeg(double deg) {
        this.deg = deg;
    }

    public void setGust(double gust) {
        this.gust = gust;
    }
}
