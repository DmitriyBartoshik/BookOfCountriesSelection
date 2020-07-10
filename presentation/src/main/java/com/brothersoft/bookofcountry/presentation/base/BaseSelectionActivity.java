package com.brothersoft.bookofcountry.presentation.base;

import android.support.v7.app.AppCompatActivity;

public abstract class BaseSelectionActivity extends AppCompatActivity {
    public BaseSelectionActivity() {
        runInject();

    }
    public abstract void runInject();
}
