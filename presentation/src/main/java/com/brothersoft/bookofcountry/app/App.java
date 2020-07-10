package com.brothersoft.bookofcountry.app;

import android.app.Application;

import com.brothersoft.bookofcountry.injection.AppComponent;
import com.brothersoft.bookofcountry.injection.AppModule;
import com.brothersoft.bookofcountry.injection.DaggerAppComponent;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

public class App extends Application {
    private static AppComponent appComponent;

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());

        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
    }
}
