package com.brothersoft.bookofcountries.injection;


import com.brothersoft.bookofcountries.presentation.screens.country.capital.CapitalViewModel;
import com.brothersoft.bookofcountries.presentation.screens.country.group.CountryGroupViewModel;
import com.brothersoft.bookofcountries.presentation.screens.country.list.CountryListViewModel;
import com.brothersoft.bookofcountries.presentation.screens.country.single.CountryViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = AppModule.class)
@Singleton
public interface AppComponent {
    void runInject(CountryListViewModel listViewModel);
    void runInject(CountryViewModel countryViewModel);
    void runInject(CountryGroupViewModel countryGroupViewModel);
    void runInject(CapitalViewModel capitalViewModel);
}
