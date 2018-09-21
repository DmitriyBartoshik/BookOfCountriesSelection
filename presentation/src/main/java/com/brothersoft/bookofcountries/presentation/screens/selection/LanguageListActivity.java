package com.brothersoft.bookofcountries.presentation.screens.selection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.brothersoft.bookofcountries.R;
import com.brothersoft.bookofcountries.app.App;
import com.brothersoft.bookofcountries.presentation.base.BaseActivity;
import com.brothersoft.bookofcountries.presentation.base.BaseSelectionActivity;
import com.brothersoft.bookofcountries.presentation.screens.country.group.CountryGroupActivity;
import com.brothersoft.bookofcountries.presentation.screens.selection.adapter.FieldTypeAdapter;
import com.brothersoft.bookofcountries.presentation.screens.selection.adapter.OnItemClickListener;
import com.brothersoft.domain.entity.DomainModel;
import com.brothersoft.domain.entity.country.Language;
import com.brothersoft.domain.entity.country.LanguageList;
import com.brothersoft.domain.usecases.country.GetAllFieldByTypeUseCase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class LanguageListActivity extends AppCompatActivity implements OnItemClickListener {
    private List<String[]> languages = new ArrayList<>();
    private RecyclerView recyclerView;
    private FieldTypeAdapter adapter;
    @Inject
    GetAllFieldByTypeUseCase allFieldByTypeUseCase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_list);
        runInject();
        getListLanguage();
    }

    public void runInject() {
        App.getAppComponent().runInject(this);
    }


    public void getListLanguage() {
        allFieldByTypeUseCase.getAllFieldByType("languages")
                .subscribe(new Observer<List<LanguageList>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(List<LanguageList> languagesList) {
                        getLanguagesName(languagesList);
                        setLanguageRecycler();
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    public void getLanguagesName(List<LanguageList> listLanguages) {
        HashSet<String []> languagesSet=new HashSet();
        for (LanguageList languages : listLanguages) {
            for (Language language : languages.getLanguages()){
                String[] languageInfo={language.getName(),language.getIso639_1()};
                languagesSet.add(languageInfo);
            }
        }
        this.languages.addAll(languagesSet);
    }

    public void setLanguageRecycler() {
        recyclerView = findViewById(R.id.languageList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new FieldTypeAdapter(this, this.languages);
        adapter.setOnClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int position) {
     String language= languages.get(position)[1];
        Intent intent = CountryGroupActivity.getIntent(this,
                "lang", language);
        startActivity(intent);
    }
}
