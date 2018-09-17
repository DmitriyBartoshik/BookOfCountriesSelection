package com.brothersoft.bookofcountries.presentation.screens.country.list.items.country;

import android.databinding.ObservableField;

import com.brothersoft.bookofcountries.presentation.base.recycler.BaseItemViewModel;
import com.brothersoft.domain.entity.country.Country;

public class CountryItemViewModel extends BaseItemViewModel<Country> {
    public ObservableField<String> name = new ObservableField<>("");
    public ObservableField<String> capital = new ObservableField<>("");
    public ObservableField<String> region = new ObservableField<>("");
    public ObservableField<String> flag = new ObservableField<>("");

    public Country country;
    public int position = 0;

    @Override
    public void setItem(Country country, int position) {
        this.name.set(country.getName());
        this.capital.set(country.getCapital());
        this.region.set(country.getRegion());
        this.flag.set(country.getFlag());
    }
}
