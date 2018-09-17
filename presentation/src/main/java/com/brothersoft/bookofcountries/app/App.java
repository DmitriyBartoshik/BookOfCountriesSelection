package com.brothersoft.bookofcountries.app;

import android.app.Application;

import com.brothersoft.bookofcountries.injection.AppComponent;
import com.brothersoft.bookofcountries.injection.AppModule;
import com.brothersoft.bookofcountries.injection.DaggerAppComponent;

public class App extends Application {
    private static AppComponent appComponent;

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
    }
}
