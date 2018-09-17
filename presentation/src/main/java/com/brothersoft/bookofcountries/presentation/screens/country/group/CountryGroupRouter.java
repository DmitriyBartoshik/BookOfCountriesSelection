package com.brothersoft.bookofcountries.presentation.screens.country.group;

import com.brothersoft.bookofcountries.presentation.base.BaseRouter;
import com.brothersoft.bookofcountries.presentation.screens.country.single.CountryActivity;

public class CountryGroupRouter extends BaseRouter<CountryGroupActivity> {
    public CountryGroupRouter(CountryGroupActivity activity) {
        super(activity);
    }

    public void goToCountryDetails(String name) {
        activity.startActivity(CountryActivity.getIntent(activity, name));
    }
}
