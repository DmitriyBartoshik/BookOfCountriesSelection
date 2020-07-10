package com.brothersoft.bookofcountry.presentation.screens.country.list;

import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;


import com.brothersoft.bookofcountry.R;
import com.brothersoft.bookofcountry.databinding.ActivityCountryListBinding;
import com.brothersoft.bookofcountry.presentation.base.BaseMvvmActivity;
import com.brothersoft.domain.entity.country.Country;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.List;

public class CountryListActivity extends BaseMvvmActivity<CountryListViewModel,
        ActivityCountryListBinding, CountryListRouter> {
    public List<Country> allCountries = new ArrayList<>();

    private AdView mAdView;

    @Override
    protected CountryListViewModel provideViewModel() {
        return ViewModelProviders.of(this).get(CountryListViewModel.class);
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_country_list;
    }

    @Override
    protected CountryListRouter provideRouter() {
        return new CountryListRouter(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addBanner();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        viewModel.getCountryList();
        settingsAdapter();


        backButtonInit();
//        binding.countryList.setLayoutManager(new LinearLayoutManager(this));
//        binding.countryList.setAdapter(viewModel.adapter);
//        binding.countryList.setHasFixedSize(true);

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

    public void backButtonInit() {
//        ImageView backImage = (ImageView) findViewById(R.id.backImage);
        FrameLayout backImage=(FrameLayout) findViewById(R.id.back_button_layout) ;
        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void settingsAdapter() {
        binding.countryList.setLayoutManager(new LinearLayoutManager(this));
        binding.countryList.setAdapter(viewModel.adapter);
        binding.countryList.setHasFixedSize(true);
    }

    public void addBanner() {
        MobileAds.initialize(this,
                "ca-app-pub-7982947060816171~2298098731");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}

