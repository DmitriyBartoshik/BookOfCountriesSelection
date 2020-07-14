package com.brothersoft.bookofcountry.presentation.screens.country.list.items.country;

import androidx.annotation.NonNull;
import android.view.ViewGroup;

import com.brothersoft.bookofcountry.presentation.base.recycler.BaseItemViewHolder;
import com.brothersoft.bookofcountry.presentation.base.recycler.BaseRecyclerViewAdapter;
import com.brothersoft.domain.entity.country.Country;


public class CountryListAdapter extends BaseRecyclerViewAdapter<Country, CountryItemViewModel> {
    @NonNull
    @Override
    public BaseItemViewHolder<Country, CountryItemViewModel, ?> onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        return CountryItemViewHolder.create(parent, new CountryItemViewModel());
    }
}