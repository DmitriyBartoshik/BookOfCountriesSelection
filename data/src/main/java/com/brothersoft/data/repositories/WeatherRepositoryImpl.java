package com.brothersoft.data.repositories;

import com.brothersoft.data.entity.responses.weather.CapitalWeatherResponse;
import com.brothersoft.data.entity.responses.weather.CloudResponse;
import com.brothersoft.data.entity.responses.weather.CoordinateResponse;
import com.brothersoft.data.entity.responses.weather.SunDataResponse;
import com.brothersoft.data.entity.responses.weather.WeatherDataResponse;
import com.brothersoft.data.entity.responses.weather.WeatherDescriptionResponse;
import com.brothersoft.data.entity.responses.weather.WindResponse;
import com.brothersoft.data.net.weather.WeatherRestService;
import com.brothersoft.domain.entity.weather.CapitalWeather;
import com.brothersoft.domain.entity.weather.Cloud;
import com.brothersoft.domain.entity.weather.Coordinate;
import com.brothersoft.domain.entity.weather.SunData;
import com.brothersoft.domain.entity.weather.WeatherData;
import com.brothersoft.domain.entity.weather.WeatherDescription;
import com.brothersoft.domain.entity.weather.Wind;
import com.brothersoft.domain.repositories.WeatherRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class WeatherRepositoryImpl implements WeatherRepository {
    private WeatherRestService weatherRestService;

    @Inject
    public WeatherRepositoryImpl(WeatherRestService weatherRestService) {
        this.weatherRestService = weatherRestService;
    }

    @Override
    public Observable<CapitalWeather> getCapitalWeather(String capital) {
        return weatherRestService.getCapitalWeather(capital)
                .map(new Function<CapitalWeatherResponse, CapitalWeather>() {
                    @Override
                    public CapitalWeather apply(CapitalWeatherResponse capitalWeatherResponse) throws Exception {
                        CapitalWeather weather = getCapitalWeather(capitalWeatherResponse);
                        return weather;
                    }
                });
    }

    public CapitalWeather getCapitalWeather(CapitalWeatherResponse weatherResponse) {
        CapitalWeather weather = new CapitalWeather();
        weather.setCoord(getCoordinate(weatherResponse.getCoord()));
        weather.setWeather(getWeatherDescription(weatherResponse.getWeather()));
        weather.setBase(weatherResponse.getBase());
        weather.setMain(getWeatherData(weatherResponse.getMain()));
        weather.setVisibility(weatherResponse.getVisibility());
        weather.setWind(getWind(weatherResponse.getWind()));
        weather.setClouds(getCloud(weatherResponse.getClouds()));
        weather.setDt(weatherResponse.getDt());
        weather.setSys(getSunData(weatherResponse.getSys()));
        weather.setId(weatherResponse.getId());
        weather.setName(weatherResponse.getName());
        weather.setCod(weatherResponse.getCod());
        return weather;
    }

    public Coordinate getCoordinate(CoordinateResponse coordinateResponse) {
        Coordinate coordinate = new Coordinate();
        coordinate.setLat(coordinateResponse.getLat());
        coordinate.setLon(coordinateResponse.getLon());
        return coordinate;
    }

    public List<WeatherDescription> getWeatherDescription(List<WeatherDescriptionResponse> weatherDescriptionResponses) {
        List<WeatherDescription> weatherDescriptions = new ArrayList<>();
        for (WeatherDescriptionResponse weatherDescriptionResponse : weatherDescriptionResponses) {
            WeatherDescription weatherDescription = new WeatherDescription();
            weatherDescription.setDescription(weatherDescriptionResponse.getDescription());
            weatherDescription.setIcon(weatherDescriptionResponse.getIcon());
            weatherDescription.setId(weatherDescriptionResponse.getId());
            weatherDescription.setMain(weatherDescriptionResponse.getMain());
            weatherDescriptions.add(weatherDescription);
        }
        return weatherDescriptions;
    }

    public WeatherData getWeatherData(WeatherDataResponse weatherDataResponse) {
        WeatherData weatherData = new WeatherData();
        weatherData.setGrnd_level(weatherDataResponse.getGrnd_level());
        weatherData.setHumidity(weatherDataResponse.getHumidity());
        weatherData.setPressure(weatherDataResponse.getPressure());
        weatherData.setSea_level(weatherDataResponse.getSea_level());
        weatherData.setTemp(weatherDataResponse.getTemp());
        weatherData.setTemp_max(weatherDataResponse.getTemp_max());
        weatherData.setTemp_min(weatherDataResponse.getTemp_min());
        return weatherData;
    }

    public Wind getWind(WindResponse windResponse) {
        Wind wind = new Wind();
        wind.setDeg(windResponse.getDeg());
        wind.setGust(windResponse.getGust());
        wind.setSpeed(windResponse.getSpeed());
        return wind;
    }

    public Cloud getCloud(CloudResponse cloudResponse) {
        Cloud cloud = new Cloud();
        cloud.setAll(cloudResponse.getAll());
        return cloud;
    }

    public SunData getSunData(SunDataResponse sunDataResponse) {
        SunData sunData = new SunData();
        sunData.setCountry(sunDataResponse.getCountry());
        sunData.setId(sunDataResponse.getId());
        sunData.setMessage(sunDataResponse.getMessage());
        sunData.setSunrise(sunDataResponse.getSunrise());
        sunData.setSunset(sunDataResponse.getSunset());
        sunData.setType(sunDataResponse.getType());
        return sunData;
    }
}
