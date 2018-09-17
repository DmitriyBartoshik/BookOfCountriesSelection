package com.brothersoft.bookofcountries.presentation.screens.country.single;

import com.brothersoft.bookofcountries.presentation.base.BaseRouter;
import com.brothersoft.bookofcountries.presentation.screens.country.capital.CapitalActivity;
import com.brothersoft.bookofcountries.presentation.screens.country.group.CountryGroupActivity;

public class CountryRouter extends BaseRouter<CountryActivity> {
    public CountryRouter(CountryActivity activity) {
        super(activity);
    }


    public void goToCountryGroupList(String countryField, String countryFieldValue) {
        activity.startActivity(CountryGroupActivity.getIntent(activity, countryField, countryFieldValue));
    }

    public void goToCapital(String capital) {
        activity.startActivity(CapitalActivity.getIntent(activity, capital));
    }
}
