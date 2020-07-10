package com.brothersoft.bookofcountry.presentation.screens.country.single.items.language;

import android.databinding.ObservableField;

import com.brothersoft.bookofcountry.presentation.base.recycler.BaseItemViewModel;
import com.brothersoft.domain.entity.country.Language;

public class LanguageItemViewModel extends BaseItemViewModel<Language> {
    public ObservableField<String> languageName = new ObservableField<>("");

    public Language language;
    public int position = 0;

    @Override
    public void setItem(Language language, int position) {
        this.languageName.set(language.getName());
    }
}
