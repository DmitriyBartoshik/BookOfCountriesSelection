package com.brothersoft.domain.repositories;

import com.brothersoft.domain.entity.weather.CapitalWeather;

import io.reactivex.Observable;

public interface WeatherRepository {
    Observable<CapitalWeather> getCapitalWeather(String capital);
}
