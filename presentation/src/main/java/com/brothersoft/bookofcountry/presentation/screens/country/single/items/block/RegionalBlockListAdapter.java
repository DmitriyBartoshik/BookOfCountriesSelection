package com.brothersoft.bookofcountry.presentation.screens.country.single.items.block;

import androidx.annotation.NonNull;
import android.view.ViewGroup;

import com.brothersoft.bookofcountry.presentation.base.recycler.BaseItemViewHolder;
import com.brothersoft.bookofcountry.presentation.base.recycler.BaseRecyclerViewAdapter;
import com.brothersoft.domain.entity.country.RegionalBlock;

public class RegionalBlockListAdapter extends BaseRecyclerViewAdapter<RegionalBlock, RegionalBlockItemViewModel> {
    @NonNull
    @Override
    public BaseItemViewHolder<RegionalBlock, RegionalBlockItemViewModel, ?> onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return  RegionalBlockItemViewHolder.create(viewGroup, new RegionalBlockItemViewModel());
    }
}
