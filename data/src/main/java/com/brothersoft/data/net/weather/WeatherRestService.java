package com.brothersoft.data.net.weather;

import com.brothersoft.data.entity.responses.HttpError;
import com.brothersoft.data.entity.responses.weather.CapitalWeatherResponse;
import com.brothersoft.data.net.ErrorParserTransformer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Singleton
public class WeatherRestService {
    private WeatherRestApi weatherRestApi;
    private Gson gson;
    private static final String WEATHER_REQUEST_URL = "http://api.openweathermap.org/data/2.5/";
    private static final String WEATHER_API_KEY="ff8afdc61e30c5131edcce5186b5850e";
    private ErrorParserTransformer errorParserTransformer;

    @Inject
    public WeatherRestService() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient
                .Builder()
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build();

        gson = new GsonBuilder()
                .create();

        this.weatherRestApi = new Retrofit
                .Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(WEATHER_REQUEST_URL)
                .client(okHttpClient)
                .build()
                .create(WeatherRestApi.class);

        errorParserTransformer = new ErrorParserTransformer(gson);
    }

    public Observable<CapitalWeatherResponse> getCapitalWeather(String capital) {
        return weatherRestApi.getCapitalWeather(capital,WEATHER_API_KEY)
                 .compose(errorParserTransformer.<CapitalWeatherResponse, HttpError>parseHttpError());

    }


}


