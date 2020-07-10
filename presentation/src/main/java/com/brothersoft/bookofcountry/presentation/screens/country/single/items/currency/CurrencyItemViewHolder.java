package com.brothersoft.bookofcountry.presentation.screens.country.single.items.currency;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.brothersoft.bookofcountry.databinding.ItemCurrencyBinding;
import com.brothersoft.bookofcountry.presentation.base.recycler.BaseItemViewHolder;
import com.brothersoft.domain.entity.country.Currency;


public class CurrencyItemViewHolder  extends BaseItemViewHolder<Currency, CurrencyItemViewModel, ItemCurrencyBinding> {
    public static CurrencyItemViewHolder currencyItemViewHolder;

    public CurrencyItemViewHolder(CurrencyItemViewModel viewModel, ItemCurrencyBinding binding) {
        super(viewModel, binding);
    }
    public static  CurrencyItemViewHolder create(ViewGroup parent,  CurrencyItemViewModel viewModel) {
        ItemCurrencyBinding binding = ItemCurrencyBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
        return new  CurrencyItemViewHolder(viewModel, binding);
    }

    @Override
    public  CurrencyItemViewModel getViewModel() {
        return super.getViewModel();
    }

    public static  CurrencyItemViewHolder getViewHolder() {
        return currencyItemViewHolder;
    }
}
