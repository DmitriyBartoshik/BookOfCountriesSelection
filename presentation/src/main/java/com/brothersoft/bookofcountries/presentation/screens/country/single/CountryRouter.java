package com.brothersoft.bookofcountries.presentation.screens.country.single;

import android.content.Intent;

import com.brothersoft.bookofcountries.presentation.base.BaseRouter;
import com.brothersoft.bookofcountries.presentation.screens.country.capital.CapitalActivity;
import com.brothersoft.bookofcountries.presentation.screens.country.group.CountryGroupActivity;
import com.brothersoft.bookofcountries.presentation.screens.country.map.MapsActivity;

public class CountryRouter extends BaseRouter<CountryActivity> {
    public CountryRouter(CountryActivity activity) {
        super(activity);
    }


    public void goToCountryGroupList(String countryField, String countryFieldCode, String countryFieldName) {
        activity.startActivity(CountryGroupActivity
                .getIntent(activity, countryField, countryFieldCode, countryFieldName));
    }

    public void goToCapital(String capital) {
        activity.startActivity(CapitalActivity.getIntent(activity, capital));
    }

    public void goToMap(String countryName, double lat, double lng) {
        activity.startActivity(MapsActivity.getIntent(activity, countryName, lat, lng));
    }
}
