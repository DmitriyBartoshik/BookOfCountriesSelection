package com.brothersoft.bookofcountry.presentation.screens.country.list;

import com.brothersoft.bookofcountry.presentation.base.BaseRouter;
import com.brothersoft.bookofcountry.presentation.screens.country.single.CountryActivity;

public class CountryListRouter extends BaseRouter<CountryListActivity> {
    public CountryListRouter(CountryListActivity activity) {
        super(activity);
    }


    public void goToCountryDetails(String name) {
        activity.startActivity(CountryActivity.getIntent(activity, name));
    }

}
