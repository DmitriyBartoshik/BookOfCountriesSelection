package com.brothersoft.bookofcountry.presentation.screens.selection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.brothersoft.bookofcountry.R;
import com.brothersoft.bookofcountry.app.App;
import com.brothersoft.bookofcountry.presentation.screens.country.group.CountryGroupActivity;
import com.brothersoft.bookofcountry.presentation.screens.selection.adapter.FieldTypeAdapter;
import com.brothersoft.bookofcountry.presentation.screens.selection.adapter.OnItemClickListener;
import com.brothersoft.domain.entity.country.RegionalBlock;
import com.brothersoft.domain.entity.country.RegionalBlockList;
import com.brothersoft.domain.usecases.country.GetBlocksUseCase;
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

public class RegionalBlockActivity extends AppCompatActivity implements OnItemClickListener {
    private List<String[]> blocks = new ArrayList<>();
    private RecyclerView recyclerView;
    private FieldTypeAdapter adapter;
    ProgressBar progressBar;
    private AdView mAdView;

    @Inject
    GetBlocksUseCase blocksUseCase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_group_list);
        addBanner();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        backButtonInit();
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        runInject();
        setText();
        getRegionalBlockList();
    }

    public void runInject() {
        App.getAppComponent().runInject(this);
    }

    public void getRegionalBlockList() {
        blocksUseCase.getRegionalBlocs("regionalBlocs")
                .subscribe(new Observer<List<RegionalBlockList>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<RegionalBlockList> regionalBlockList) {
                        getRegionalBlocksName(regionalBlockList);
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

    public void getRegionalBlocksName(List<RegionalBlockList> regionalBlockList) {
        Set<RegionalBlock> blocksSet = new TreeSet();
        for (RegionalBlockList blocks : regionalBlockList) {
            for (RegionalBlock regionalBlock : blocks.getRegionalBlocs()) {
                if (regionalBlock.getName() != null) {
                    blocksSet.add(regionalBlock);
                }

            }
        }
        for (RegionalBlock regionalBlock : blocksSet) {
            String[] blockInfo = {regionalBlock.getName(), regionalBlock.getAcronym()};
            this.blocks.add(blockInfo);
        }
    }

    public void setLanguageRecycler() {
        recyclerView = findViewById(R.id.group_List);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new FieldTypeAdapter(this, this.blocks);
        adapter.setOnClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int position) {
        String blocCode = blocks.get(position)[1];
        String blocName = blocks.get(position)[0];

        Intent intent = CountryGroupActivity.getIntent(this,
                "regionalbloc", blocCode, blocName);
        startActivity(intent);
    }

    public void setText() {
        TextView textView = (TextView) findViewById(R.id.toolbar_text);
        textView.setText("Regional blocs");
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

