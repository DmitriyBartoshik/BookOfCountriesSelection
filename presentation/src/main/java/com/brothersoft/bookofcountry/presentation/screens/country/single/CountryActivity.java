package com.brothersoft.bookofcountry.presentation.screens.country.single;


import android.app.Activity;
import androidx.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.brothersoft.bookofcountry.R;
import com.brothersoft.bookofcountry.databinding.ActivityCountryBinding;
import com.brothersoft.bookofcountry.presentation.base.BaseMvvmActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import static com.brothersoft.bookofcountry.presentation.utils.Extras.EXTRA_COUNTRY_ALPHA3CODE;


public class CountryActivity extends BaseMvvmActivity<CountryViewModel,
        ActivityCountryBinding, CountryRouter> {
    private AdView mAdView;

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
        addBanner();
        String alpha3Code = getIntent().getExtras().getString(EXTRA_COUNTRY_ALPHA3CODE);
        if (alpha3Code != null) {
            viewModel.getCountry(alpha3Code);
        }
        setRecyclerViews();
    }

    public void setRecyclerViews() {
        binding.countryLanguages.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        binding.countryLanguages.setAdapter(viewModel.languageListAdapter);

        binding.countryCurrencies.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        binding.countryCurrencies.setAdapter(viewModel.currencyListAdapter);

        binding.countryBlocks.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        binding.countryBlocks.setAdapter(viewModel.regionalBlockListAdapter);
    }

    public void addBanner() {
        MobileAds.initialize(this,
                "ca-app-pub-7982947060816171~2298098731");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}

