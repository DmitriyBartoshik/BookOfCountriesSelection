package com.brothersoft.data.net.weather;

import com.brothersoft.data.entity.responses.weather.CapitalWeatherResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherRestApi {
    @GET("weather")
    Observable<CapitalWeatherResponse> getCapitalWeather(@Query("q") String q, @Query("appid")String appid);
}
