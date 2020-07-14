package com.brothersoft.bookofcountry.presentation.screens.country.single.items.currency;

import androidx.databinding.ObservableField;

import com.brothersoft.bookofcountry.presentation.base.recycler.BaseItemViewModel;
import com.brothersoft.domain.entity.country.Currency;

public class CurrencyItemViewModel extends BaseItemViewModel<Currency> {
    public ObservableField<String> currencyCode = new ObservableField<>("");

    public Currency currency;
    public int position = 0;

    @Override
    public void setItem(Currency currency, int position) {
        this.currencyCode.set(currency.getName());
    }
}
