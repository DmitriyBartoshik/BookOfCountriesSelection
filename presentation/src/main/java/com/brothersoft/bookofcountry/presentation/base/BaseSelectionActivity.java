package com.brothersoft.bookofcountry.presentation.base;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseSelectionActivity extends AppCompatActivity {
    public BaseSelectionActivity() {
        runInject();

    }
    public abstract void runInject();
}
