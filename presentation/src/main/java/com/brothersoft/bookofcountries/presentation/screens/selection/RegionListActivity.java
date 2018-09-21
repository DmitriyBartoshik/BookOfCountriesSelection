package com.brothersoft.bookofcountries.presentation.screens.selection;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.brothersoft.bookofcountries.R;
import com.brothersoft.bookofcountries.presentation.screens.country.group.CountryGroupActivity;

public class RegionListActivity extends AppCompatActivity implements View.OnClickListener {
    private Button africa;
    private Button americas;
    private Button asia;
    private Button europe;
    private Button oceania;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_region_list);
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
                "region", region);
        startActivity(intent);
    }
}
