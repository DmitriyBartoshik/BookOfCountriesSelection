package com.brothersoft.bookofcountries.presentation.screens.selection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.brothersoft.bookofcountries.R;
import com.brothersoft.bookofcountries.app.App;
import com.brothersoft.bookofcountries.presentation.screens.country.group.CountryGroupActivity;
import com.brothersoft.bookofcountries.presentation.screens.selection.adapter.FieldTypeAdapter;
import com.brothersoft.bookofcountries.presentation.screens.selection.adapter.OnItemClickListener;
import com.brothersoft.domain.entity.country.Language;
import com.brothersoft.domain.entity.country.LanguageList;
import com.brothersoft.domain.usecases.country.GetLanguagesUseCase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class LanguageListActivity extends AppCompatActivity implements OnItemClickListener {
    private List<String[]> languages = new ArrayList<>();
    private RecyclerView recyclerView;
    private FieldTypeAdapter adapter;
    @Inject
    GetLanguagesUseCase languagesUseCase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_group_list);
        runInject();
        setText();
        getLanguageList();
    }

    public void runInject() {
        App.getAppComponent().runInject(this);
    }


    public void getLanguageList() {
        languagesUseCase.getLanguages("languages")
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
        Set<Language> languagesSet = new TreeSet();
        for (LanguageList languages : listLanguages) {
            for (Language language : languages.getLanguages()) {
                if (language.getName() != null) {
                    languagesSet.add(language);
                }
            }
        }
        for (Language language : languagesSet) {
            String[] languageInfo = {language.getName(), language.getIso639_1()};
            this.languages.add(languageInfo);
        }
    }

    public void setLanguageRecycler() {
        recyclerView = findViewById(R.id.group_List);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new FieldTypeAdapter(this, this.languages);
        adapter.setOnClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int position) {
        String language = languages.get(position)[1];
        Intent intent = CountryGroupActivity.getIntent(this,
                "lang", language);
        startActivity(intent);
    }
    public void setText(){
        TextView textView=(TextView)findViewById(R.id.text_header_group_type_list);
        textView.setText("Languages");
    }
}
