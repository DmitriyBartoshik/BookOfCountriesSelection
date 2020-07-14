package com.brothersoft.bookofcountry.presentation.screens.selection;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.brothersoft.bookofcountry.R;
import com.brothersoft.bookofcountry.presentation.screens.country.list.CountryListActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class SelectionActivity extends AppCompatActivity {
    private Button fullList;
    private Button region;
    private Button language;
    private Button currency;
    private Button block;

    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        addBanner();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        buttonInit();
        setButtonOnclickListener();
    }

    public void buttonInit() {
        fullList = (Button) findViewById(R.id.full_list_button);
        region = (Button) findViewById(R.id.region_button);
        language = (Button) findViewById(R.id.language_button);
        currency = (Button) findViewById(R.id.currency_button);
        block = (Button) findViewById(R.id.regional_block_button);
    }

    public void setButtonOnclickListener() {
        fullList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CountryListActivity.class);
                startActivity(intent);
            }
        });
        region.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegionListActivity.class);
                startActivity(intent);
            }
        });
        language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LanguageListActivity.class);
                startActivity(intent);
            }
        });
        currency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CurrencyListActivity.class);
                startActivity(intent);
            }
        });
        block.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegionalBlockActivity.class);
                startActivity(intent);
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
