package com.brothersoft.bookofcountry.presentation.screens.country.single.items.language;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.brothersoft.bookofcountry.presentation.base.recycler.BaseItemViewHolder;
import com.brothersoft.bookofcountry.presentation.base.recycler.BaseRecyclerViewAdapter;
import com.brothersoft.domain.entity.country.Language;

public class LanguageListAdapter extends BaseRecyclerViewAdapter<Language, LanguageItemViewModel> {
    @NonNull
    @Override
    public BaseItemViewHolder<Language, LanguageItemViewModel, ?> onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return  LanguageItemViewHolder.create(viewGroup, new LanguageItemViewModel());
    }
}
