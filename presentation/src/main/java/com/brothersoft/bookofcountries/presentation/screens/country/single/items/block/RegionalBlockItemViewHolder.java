package com.brothersoft.bookofcountries.presentation.screens.country.single.items.block;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.brothersoft.bookofcountries.databinding.ItemRegionalBlockBinding;
import com.brothersoft.bookofcountries.presentation.base.recycler.BaseItemViewHolder;
import com.brothersoft.domain.entity.country.RegionalBlock;

public class RegionalBlockItemViewHolder extends BaseItemViewHolder<RegionalBlock, RegionalBlockItemViewModel, ItemRegionalBlockBinding> {
    public static RegionalBlockItemViewHolder regionalBlockItemViewHolder;

    public RegionalBlockItemViewHolder(RegionalBlockItemViewModel viewModel, ItemRegionalBlockBinding binding) {
        super(viewModel, binding);
    }

    public static RegionalBlockItemViewHolder create(ViewGroup parent, RegionalBlockItemViewModel viewModel) {
        ItemRegionalBlockBinding binding = ItemRegionalBlockBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
        return new RegionalBlockItemViewHolder(viewModel, binding);
    }

    @Override
    public RegionalBlockItemViewModel getViewModel() {
        return super.getViewModel();
    }

    public static RegionalBlockItemViewHolder getViewHolder() {
        return regionalBlockItemViewHolder;
    }
}
