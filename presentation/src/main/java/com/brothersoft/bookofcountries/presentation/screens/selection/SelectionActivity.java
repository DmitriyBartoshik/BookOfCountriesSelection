package com.brothersoft.bookofcountries.presentation.screens.selection;

import android.content.Intent;
import android.databinding.generated.callback.OnClickListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.brothersoft.bookofcountries.R;
import com.brothersoft.bookofcountries.presentation.screens.country.list.CountryListActivity;

public class SelectionActivity extends AppCompatActivity {
    private Button fullList;
    private Button region;
    private Button language;
    private Button currency;
    private Button block;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
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
}
