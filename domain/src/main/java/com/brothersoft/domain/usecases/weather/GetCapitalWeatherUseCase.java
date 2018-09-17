package com.brothersoft.domain.usecases.weather;

import com.brothersoft.domain.entity.weather.CapitalWeather;
import com.brothersoft.domain.executors.PostExecutionThread;
import com.brothersoft.domain.repositories.WeatherRepository;
import com.brothersoft.domain.usecases.BaseUseCase;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetCapitalWeatherUseCase extends BaseUseCase {
    private WeatherRepository weatherRepository;
    @Inject
    public GetCapitalWeatherUseCase(WeatherRepository weatherRepository,
                             PostExecutionThread postExecutionThread) {
        super(postExecutionThread);
        this.weatherRepository = weatherRepository;
    }

    public Observable<CapitalWeather> getCapitalWeather(String capital) {
        return weatherRepository
                .getCapitalWeather(capital)
                .subscribeOn(executionThread)
                .observeOn(postExecutionThread);
    }
}
