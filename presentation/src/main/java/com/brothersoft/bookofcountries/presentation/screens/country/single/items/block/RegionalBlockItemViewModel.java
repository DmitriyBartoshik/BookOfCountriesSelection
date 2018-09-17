package com.brothersoft.bookofcountries.presentation.screens.country.single.items.block;

import android.databinding.ObservableField;

import com.brothersoft.bookofcountries.presentation.base.recycler.BaseItemViewModel;
import com.brothersoft.domain.entity.country.RegionalBlock;

public class RegionalBlockItemViewModel extends BaseItemViewModel<RegionalBlock> {

    public ObservableField<String> regionalBlockName = new ObservableField<>("");

    public RegionalBlock regionalBlock;
    public int position = 0;

    @Override
    public void setItem(RegionalBlock regionalBlock, int position) {
        this.regionalBlockName.set(regionalBlock.getName());
    }
}
