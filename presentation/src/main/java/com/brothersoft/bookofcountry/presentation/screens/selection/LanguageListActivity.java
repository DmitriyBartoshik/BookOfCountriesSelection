package com.brothersoft.bookofcountry.presentation.screens.selection;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.brothersoft.bookofcountry.R;
import com.brothersoft.bookofcountry.app.App;
import com.brothersoft.bookofcountry.presentation.screens.country.group.CountryGroupActivity;
import com.brothersoft.bookofcountry.presentation.screens.selection.adapter.FieldTypeAdapter;
import com.brothersoft.bookofcountry.presentation.screens.selection.adapter.OnItemClickListener;
import com.brothersoft.domain.entity.country.Language;
import com.brothersoft.domain.entity.country.LanguageList;
import com.brothersoft.domain.usecases.country.GetLanguagesUseCase;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
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
    ProgressBar progressBar;
    private AdView mAdView;

    @Inject
    GetLanguagesUseCase languagesUseCase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_group_list);
        addBanner();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        runInject();
        backButtonInit();
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
                        progressBar.setVisibility(View.INVISIBLE);
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
        recyclerView.setAdapter(adapter);
        adapter.setOnClickListener(this);
    }

    @Override
    public void onItemClick(int position) {
        String languageCode = languages.get(position)[1];
        String languageName = languages.get(position)[0];

        Intent intent = CountryGroupActivity.getIntent(this,
                "lang", languageCode, languageName);
        startActivity(intent);
    }

    public void setText() {
        TextView textView = (TextView) findViewById(R.id.toolbar_text);
        textView.setText("Languages");
    }

    public void backButtonInit() {
        FrameLayout backImage=(FrameLayout) findViewById(R.id.back_button_layout) ;
        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void addBanner() {
        MobileAds.initialize(this,
                "ca-app-pub-7982947060816171~2298098731");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}
