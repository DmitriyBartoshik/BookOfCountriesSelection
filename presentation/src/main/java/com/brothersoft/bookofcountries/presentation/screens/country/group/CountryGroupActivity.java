package com.brothersoft.bookofcountries.presentation.screens.country.group;


import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.brothersoft.bookofcountries.R;
import com.brothersoft.bookofcountries.databinding.ActivityCountryGroupBinding;
import com.brothersoft.bookofcountries.presentation.base.BaseMvvmActivity;

import static com.brothersoft.bookofcountries.presentation.utils.Extras.EXTRA_COUNTRY_FIELD;
import static com.brothersoft.bookofcountries.presentation.utils.Extras.EXTRA_COUNTRY_FIELD_VALUES;

public class CountryGroupActivity extends BaseMvvmActivity<CountryGroupViewModel,
        ActivityCountryGroupBinding, CountryGroupRouter> {

    public static Intent getIntent(Activity activity, String countryField, String countryFieldValues) {
        Intent intent = new Intent(activity, CountryGroupActivity.class);
        intent.putExtra(EXTRA_COUNTRY_FIELD, countryField);
        intent.putExtra(EXTRA_COUNTRY_FIELD_VALUES, countryFieldValues);

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
        String field = getIntent().getExtras().getString(EXTRA_COUNTRY_FIELD);
        String fieldValue = getIntent().getExtras().getString(EXTRA_COUNTRY_FIELD_VALUES);
        viewModel.getCountryGroupList(field, fieldValue);
        settingsAdapter();
    }

    public void settingsAdapter() {
        binding.countryList.setLayoutManager(new LinearLayoutManager(this));
        binding.countryList.setAdapter(viewModel.adapter);
        binding.countryList.setHasFixedSize(true);
    }
}

