package com.brothersoft.bookofcountries.presentation.screens.country.single.items.language;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.brothersoft.bookofcountries.databinding.ItemLanguageBinding;
import com.brothersoft.bookofcountries.presentation.base.recycler.BaseItemViewHolder;
import com.brothersoft.domain.entity.country.Language;

public class LanguageItemViewHolder  extends BaseItemViewHolder<Language, LanguageItemViewModel, ItemLanguageBinding> {
    public static LanguageItemViewHolder languageItemViewHolder;

    public LanguageItemViewHolder(LanguageItemViewModel viewModel, ItemLanguageBinding binding) {
        super(viewModel, binding);
    }
    public static LanguageItemViewHolder create(ViewGroup parent, LanguageItemViewModel viewModel) {
        ItemLanguageBinding binding = ItemLanguageBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
        return new LanguageItemViewHolder(viewModel, binding);
    }

    @Override
    public LanguageItemViewModel getViewModel() {
        return super.getViewModel();
    }

    public static LanguageItemViewHolder getViewHolder() {
        return languageItemViewHolder;
    }
}
