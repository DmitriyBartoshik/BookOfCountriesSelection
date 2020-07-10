package com.brothersoft.bookofcountry.presentation.screens.country.group;

import com.brothersoft.bookofcountry.presentation.base.BaseRouter;
import com.brothersoft.bookofcountry.presentation.screens.country.single.CountryActivity;

public class CountryGroupRouter extends BaseRouter<CountryGroupActivity> {
    public CountryGroupRouter(CountryGroupActivity activity) {
        super(activity);
    }

    public void goToCountryDetails(String name) {
        activity.startActivity(CountryActivity.getIntent(activity, name));
    }
}
