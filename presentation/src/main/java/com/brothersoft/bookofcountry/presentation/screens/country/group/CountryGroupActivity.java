package com.brothersoft.bookofcountry.presentation.screens.country.group;


import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.brothersoft.bookofcountry.R;
import com.brothersoft.bookofcountry.databinding.ActivityCountryGroupBinding;
import com.brothersoft.bookofcountry.presentation.base.BaseMvvmActivity;
import com.brothersoft.domain.entity.country.Country;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.List;

import static com.brothersoft.bookofcountry.presentation.utils.Extras.EXTRA_COUNTRY_FIELD;
import static com.brothersoft.bookofcountry.presentation.utils.Extras.EXTRA_COUNTRY_FIELD_CODE;
import static com.brothersoft.bookofcountry.presentation.utils.Extras.EXTRA_COUNTRY_FIELD_NAME;

public class CountryGroupActivity extends BaseMvvmActivity<CountryGroupViewModel,
        ActivityCountryGroupBinding, CountryGroupRouter> {
    private AdView mAdView;

    public List<Country> allCountries = new ArrayList<>();

    public static Intent getIntent(Activity activity, String countryField, String countryFieldCode, String countryFieldName) {
        Intent intent = new Intent(activity, CountryGroupActivity.class);
        intent.putExtra(EXTRA_COUNTRY_FIELD, countryField);
        intent.putExtra(EXTRA_COUNTRY_FIELD_CODE, countryFieldCode);
        intent.putExtra(EXTRA_COUNTRY_FIELD_NAME, countryFieldName);

        return intent;
    }

    @Override
    protected CountryGroupViewModel provideViewModel() {
        return ViewModelProviders.of(this).get(CountryGroupViewModel.class);
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_country_group;
    }

    @Override
    protected CountryGroupRouter provideRouter() {
        return new CountryGroupRouter(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addBanner();
        String field = getIntent().getExtras().getString(EXTRA_COUNTRY_FIELD);
        String fieldCode = getIntent().getExtras().getString(EXTRA_COUNTRY_FIELD_CODE);
        String fieldName = getIntent().getExtras().getString(EXTRA_COUNTRY_FIELD_NAME);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        viewModel.getCountryGroupList(field, fieldCode, fieldName);
        settingsAdapter();
        backButtonInit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.application_menu, menu);
        MenuItem search = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(search);
        search(searchView);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private void search(SearchView searchView) {

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String search) {
                initialListCountry();
                filterCountryList(search);
                return true;
            }
        });
    }

    public void initialListCountry() {
        if (allCountries.size() == 0) {
            allCountries = viewModel.adapter.getItems();
        }
    }

    public void filterCountryList(String search) {
        if (search.isEmpty()) {
            viewModel.adapter.setItems(allCountries);
        } else {
            List<Country> filteredCountryList = new ArrayList<>();
            for (Country country : allCountries) {
                if (country.getName().toLowerCase().contains(search) || country.getCapital().toLowerCase().contains(search)) {
                    filteredCountryList.add(country);
                }
            }
            viewModel.adapter.setItems(filteredCountryList);
        }
    }

    public void settingsAdapter() {
        binding.countryList.setLayoutManager(new LinearLayoutManager(this));
        binding.countryList.setAdapter(viewModel.adapter);
        binding.countryList.setHasFixedSize(true);
    }

    public void backButtonInit() {
        ImageView backImage = (ImageView) findViewById(R.id.backImage);
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

