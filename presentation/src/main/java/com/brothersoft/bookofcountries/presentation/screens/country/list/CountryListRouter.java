package com.brothersoft.bookofcountries.presentation.screens.country.list;

import android.util.Log;

import com.brothersoft.bookofcountries.presentation.base.BaseRouter;
import com.brothersoft.bookofcountries.presentation.screens.country.single.CountryActivity;

public class CountryListRouter extends BaseRouter<CountryListActivity> {
    public CountryListRouter(CountryListActivity activity) {
        super(activity);
    }


    public void goToCountryDetails(String name) {
        activity.startActivity(CountryActivity.getIntent(activity, name));
    }

}
