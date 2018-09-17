package com.brothersoft.data.entity.responses.weather;

import com.brothersoft.data.entity.responses.DataModel;

public class WeatherDescriptionResponse implements DataModel {
    private int id;
    private String main;
    private String description;
    private String icon;

    public int getId() {
        return id;
    }

    public String getMain() {
        return main;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }
}
