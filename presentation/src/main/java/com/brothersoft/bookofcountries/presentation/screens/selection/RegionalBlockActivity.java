package com.brothersoft.bookofcountries.presentation.screens.selection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.brothersoft.bookofcountries.R;
import com.brothersoft.bookofcountries.app.App;
import com.brothersoft.bookofcountries.presentation.screens.country.group.CountryGroupActivity;
import com.brothersoft.bookofcountries.presentation.screens.selection.adapter.FieldTypeAdapter;
import com.brothersoft.bookofcountries.presentation.screens.selection.adapter.OnItemClickListener;
import com.brothersoft.domain.entity.country.Language;
import com.brothersoft.domain.entity.country.LanguageList;
import com.brothersoft.domain.entity.country.RegionalBlock;
import com.brothersoft.domain.entity.country.RegionalBlockList;
import com.brothersoft.domain.usecases.country.GetBlocksUseCase;
import com.brothersoft.domain.usecases.country.GetLanguagesUseCase;

import java.util.ArrayList;
import java.util.HashSet;
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

    @Inject
    GetBlocksUseCase blocksUseCase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_group_list);
        progressBar=(ProgressBar)findViewById(R.id.progress_bar) ;
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
        TextView textView = (TextView) findViewById(R.id.text_header_group_type_list);
        textView.setText("Regional blocs");
    }
}

