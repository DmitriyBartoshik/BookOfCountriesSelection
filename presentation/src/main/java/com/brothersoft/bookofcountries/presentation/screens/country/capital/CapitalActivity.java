package com.brothersoft.bookofcountries.presentation.screens.country.capital;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.brothersoft.bookofcountries.R;
import com.brothersoft.bookofcountries.databinding.ActivityCapitalBinding;
import com.brothersoft.bookofcountries.presentation.base.BaseMvvmActivity;

import static com.brothersoft.bookofcountries.presentation.utils.Extras.EXTRA_COUNTRY_CAPITAL_NAME;

public class CapitalActivity extends BaseMvvmActivity<CapitalViewModel,
        ActivityCapitalBinding, CapitalRouter> {

    public static Intent getIntent(Activity activity, String capital) {
        Intent intent = new Intent(activity, CapitalActivity.class);
        intent.putExtra(EXTRA_COUNTRY_CAPITAL_NAME, capital);
        return intent;
    }

    @Override
    protected CapitalViewModel provideViewModel() {
        return ViewModelProviders.of(this).get(CapitalViewModel.class);
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_capital;
    }

    @Override
    protected CapitalRouter provideRouter() {
        return new CapitalRouter(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String capital = getIntent().getExtras().getString(EXTRA_COUNTRY_CAPITAL_NAME);
        if (capital != null) {
            viewModel.getCapitalWeather(capital);
        }
    }
}
