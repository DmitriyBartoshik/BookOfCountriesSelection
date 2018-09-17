package com.brothersoft.bookofcountries.presentation.screens.country.single.items.block;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.brothersoft.bookofcountries.presentation.base.recycler.BaseItemViewHolder;
import com.brothersoft.bookofcountries.presentation.base.recycler.BaseRecyclerViewAdapter;
import com.brothersoft.bookofcountries.presentation.screens.country.single.items.block.RegionalBlockItemViewHolder;
import com.brothersoft.bookofcountries.presentation.screens.country.single.items.block.RegionalBlockItemViewModel;
import com.brothersoft.domain.entity.country.RegionalBlock;

public class RegionalBlockListAdapter extends BaseRecyclerViewAdapter<RegionalBlock, RegionalBlockItemViewModel> {
    @NonNull
    @Override
    public BaseItemViewHolder<RegionalBlock, RegionalBlockItemViewModel, ?> onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return  RegionalBlockItemViewHolder.create(viewGroup, new RegionalBlockItemViewModel());
    }
}
