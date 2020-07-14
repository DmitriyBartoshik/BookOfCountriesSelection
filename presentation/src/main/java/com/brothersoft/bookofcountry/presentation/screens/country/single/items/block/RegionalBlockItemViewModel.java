package com.brothersoft.bookofcountry.presentation.screens.country.single.items.block;

import androidx.databinding.ObservableField;

import com.brothersoft.bookofcountry.presentation.base.recycler.BaseItemViewModel;
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
