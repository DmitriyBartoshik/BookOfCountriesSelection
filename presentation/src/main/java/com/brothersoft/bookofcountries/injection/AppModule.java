package com.brothersoft.bookofcountries.injection;

import android.content.Context;

import com.brothersoft.bookofcountries.executor.UIThread;
import com.brothersoft.data.net.country.RestService;
import com.brothersoft.data.net.weather.WeatherRestService;
import com.brothersoft.data.repositories.CountryRepositoryImpl;
import com.brothersoft.data.repositories.WeatherRepositoryImpl;
import com.brothersoft.domain.executors.PostExecutionThread;
import com.brothersoft.domain.repositories.CountryRepository;
import com.brothersoft.domain.repositories.WeatherRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return context;
    }

    @Provides
    public static CountryRepository provideCountryRepository(CountryRepositoryImpl countryRepository) {
        return new CountryRepositoryImpl(new RestService());
    }

    @Provides
    public static WeatherRepository provideWeatherRepository(WeatherRepositoryImpl weatherRepository) {
        return new WeatherRepositoryImpl(new WeatherRestService());
    }

    @Singleton
    @Provides
    public static PostExecutionThread provideUIThread(UIThread uiThread) {
        return uiThread;
    }
}
