package com.brothersoft.bookofcountry.injection;


import com.brothersoft.bookofcountry.presentation.screens.country.capital.CapitalViewModel;
import com.brothersoft.bookofcountry.presentation.screens.country.group.CountryGroupViewModel;
import com.brothersoft.bookofcountry.presentation.screens.country.list.CountryListViewModel;
import com.brothersoft.bookofcountry.presentation.screens.country.single.CountryViewModel;
import com.brothersoft.bookofcountry.presentation.screens.selection.CurrencyListActivity;
import com.brothersoft.bookofcountry.presentation.screens.selection.LanguageListActivity;
import com.brothersoft.bookofcountry.presentation.screens.selection.RegionalBlockActivity;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = AppModule.class)
@Singleton
public interface AppComponent {
    void runInject(CountryListViewModel listViewModel);
    void runInject(CountryViewModel countryViewModel);
    void runInject(CountryGroupViewModel countryGroupViewModel);
    void runInject(CapitalViewModel capitalViewModel);
    void runInject(LanguageListActivity languageListActivity);
    void runInject(CurrencyListActivity languageListActivity);
    void runInject(RegionalBlockActivity regionalBlockListActivity);


}
