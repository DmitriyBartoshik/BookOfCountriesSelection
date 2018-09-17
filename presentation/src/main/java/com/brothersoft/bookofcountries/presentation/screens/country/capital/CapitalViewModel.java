package com.brothersoft.bookofcountries.presentation.screens.country.capital;

import android.databinding.ObservableField;
import android.util.Log;

import com.brothersoft.bookofcountries.app.App;
import com.brothersoft.bookofcountries.presentation.base.BaseViewModel;
import com.brothersoft.domain.entity.weather.CapitalWeather;
import com.brothersoft.domain.usecases.weather.GetCapitalWeatherUseCase;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class CapitalViewModel extends BaseViewModel<CapitalRouter> {
    public ObservableField<String> weatherImageUrl = new ObservableField<>();
    public ObservableField<String> capital = new ObservableField<>();
    public ObservableField<String> country = new ObservableField<>();
    public ObservableField<String> clouds = new ObservableField<>();
    public ObservableField<String> temp = new ObservableField<>();
    public ObservableField<String> windSpeed = new ObservableField<>();
    public ObservableField<String> pressure = new ObservableField<>();
    public ObservableField<String> humidity = new ObservableField<>();
    public ObservableField<String> sunrise = new ObservableField<>();
    public ObservableField<String> sunset = new ObservableField<>();


    @Inject
    public GetCapitalWeatherUseCase capitalWeatherUseCase;

    @Override
    protected void runInject() {
        {
            App.getAppComponent().runInject(this);
        }
    }

    public CapitalViewModel() {
    }

    public void getCapitalWeather(String capital) {
        capitalWeatherUseCase
                .getCapitalWeather(capital)
                .subscribe(new Observer<CapitalWeather>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CapitalWeather capitalWeather) {
                        setCapitalField(capitalWeather);
                    }

                    @Override
                    public void onError(Throwable e) {
                        router.showError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void setCapitalField(CapitalWeather capitalWeather) {
        String icon = capitalWeather.getWeather().get(0).getIcon();
        String iconUrl = "http://openweathermap.org/img/w/" + icon + ".png";
        weatherImageUrl.set(iconUrl);
        capital.set(capitalWeather.getName());
        country.set(capitalWeather.getSys().getCountry());
        clouds.set(capitalWeather.getWeather().get(0).getDescription());
        temp.set(String.valueOf((int) capitalWeather.getMain().getTemp() - 273) + " \u2103");
        windSpeed.set(String.valueOf(capitalWeather.getWind().getSpeed()));
        pressure.set(String.valueOf(capitalWeather.getMain().getPressure()));
        humidity.set(String.valueOf(capitalWeather.getMain().getHumidity()));
        long a = capitalWeather.getSys().getSunrise();

        Date date = new Date(capitalWeather.getSys().getSunrise());
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH;mm");
        sunrise.set(dateFormat.format(date));

        date = new Date(capitalWeather.getSys().getSunset());
        dateFormat = new SimpleDateFormat("HH:mm");
        sunset.set(dateFormat.format(date));
    }
}
