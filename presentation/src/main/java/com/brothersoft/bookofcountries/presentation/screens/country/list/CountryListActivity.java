package com.brothersoft.bookofcountries.presentation.screens.country.list;

import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.brothersoft.bookofcountries.R;
import com.brothersoft.bookofcountries.databinding.ActivityCountryListBinding;
import com.brothersoft.bookofcountries.presentation.base.BaseMvvmActivity;
import com.brothersoft.domain.entity.country.Country;

import java.util.ArrayList;
import java.util.List;

public class CountryListActivity extends BaseMvvmActivity<CountryListViewModel,
        ActivityCountryListBinding, CountryListRouter> {
    public List<Country> allCountries = new ArrayList<>();

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
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        binding.countryList.setLayoutManager(new LinearLayoutManager(this));
        binding.countryList.setAdapter(viewModel.adapter);
        binding.countryList.setHasFixedSize(true);
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
}

