package com.brothersoft.bookofcountries.presentation.screens.country.single.items.currency;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.brothersoft.bookofcountries.presentation.base.recycler.BaseItemViewHolder;
import com.brothersoft.bookofcountries.presentation.base.recycler.BaseRecyclerViewAdapter;
import com.brothersoft.bookofcountries.presentation.screens.country.single.items.currency.CurrencyItemViewHolder;
import com.brothersoft.bookofcountries.presentation.screens.country.single.items.currency.CurrencyItemViewModel;
import com.brothersoft.domain.entity.country.Currency;

public class CurrencyListAdapter  extends BaseRecyclerViewAdapter<Currency, CurrencyItemViewModel> {
    @NonNull
    @Override
    public BaseItemViewHolder<Currency, CurrencyItemViewModel, ?> onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return  CurrencyItemViewHolder.create(viewGroup, new CurrencyItemViewModel());
    }
}
