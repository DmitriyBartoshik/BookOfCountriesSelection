package com.brothersoft.bookofcountries.presentation.screens.country.single;


import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.brothersoft.bookofcountries.R;
import com.brothersoft.bookofcountries.databinding.ActivityCountryBinding;
import com.brothersoft.bookofcountries.presentation.base.BaseMvvmActivity;

import static com.brothersoft.bookofcountries.presentation.utils.Extras.EXTRA_COUNTRY_ALPHA3CODE;


public class CountryActivity extends BaseMvvmActivity<CountryViewModel,
        ActivityCountryBinding, CountryRouter> {

    public static Intent getIntent(Activity activity, String name) {
        Intent intent = new Intent(activity, CountryActivity.class);
        intent.putExtra(EXTRA_COUNTRY_ALPHA3CODE, name);
        return intent;
    }

    @Override
    protected CountryViewModel provideViewModel() {
        return ViewModelProviders.of(this).get(CountryViewModel.class);
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_country;
    }

    @Override
    protected CountryRouter provideRouter() {
        return new CountryRouter(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String alpha3Code = getIntent().getExtras().getString(EXTRA_COUNTRY_ALPHA3CODE);
        if (alpha3Code != null) {
            viewModel.getCountry(alpha3Code);
        }
        setRecyclerViews();
    }
    public void setRecyclerViews(){
        binding.countryLanguages.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        binding.countryLanguages.setAdapter(viewModel.languageListAdapter);

        binding.countryCurrencies.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        binding.countryCurrencies.setAdapter(viewModel.currencyListAdapter);

        binding.countryBlocks.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        binding.countryBlocks.setAdapter(viewModel.regionalBlockListAdapter);
    }
}

