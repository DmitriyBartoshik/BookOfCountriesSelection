package com.brothersoft.bookofcountry.presentation.screens.selection;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.brothersoft.bookofcountry.R;
import com.brothersoft.bookofcountry.presentation.screens.country.group.CountryGroupActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class RegionListActivity extends AppCompatActivity implements View.OnClickListener {
    private Button africa;
    private Button americas;
    private Button asia;
    private Button europe;
    private Button oceania;
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_region_list);
        addBanner();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        backButtonInit();
        buttonInit();
        listenerInit();
    }

    public void buttonInit() {
        africa = (Button) findViewById(R.id.region_africa);
        americas = (Button) findViewById(R.id.region_americas);
        asia = (Button) findViewById(R.id.region_asia);
        europe = (Button) findViewById(R.id.region_europe);
        oceania = (Button) findViewById(R.id.region_oceania);
    }

    public void listenerInit() {
        africa.setOnClickListener(this);
        americas.setOnClickListener(this);
        asia.setOnClickListener(this);
        europe.setOnClickListener(this);
        oceania.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String region = ((Button) v).getText().toString();
        Intent intent = CountryGroupActivity.getIntent(this,
                "region", region, region);
        startActivity(intent);
    }

    public void backButtonInit() {
        FrameLayout backImage=(FrameLayout) findViewById(R.id.back_button_layout) ;
        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void addBanner() {
        MobileAds.initialize(this,
                "ca-app-pub-7982947060816171~2298098731");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}
