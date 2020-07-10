package com.brothersoft.bookofcountry.presentation.screens.country.single;

import com.brothersoft.bookofcountry.presentation.base.BaseRouter;
import com.brothersoft.bookofcountry.presentation.screens.country.capital.CapitalActivity;
import com.brothersoft.bookofcountry.presentation.screens.country.group.CountryGroupActivity;
import com.brothersoft.bookofcountry.presentation.screens.country.map.MapsActivity;

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
