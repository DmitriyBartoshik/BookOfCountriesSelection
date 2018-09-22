package com.brothersoft.bookofcountries.presentation.screens.selection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.brothersoft.bookofcountries.R;
import com.brothersoft.bookofcountries.app.App;
import com.brothersoft.bookofcountries.presentation.screens.country.group.CountryGroupActivity;
import com.brothersoft.bookofcountries.presentation.screens.selection.adapter.FieldTypeAdapter;
import com.brothersoft.bookofcountries.presentation.screens.selection.adapter.OnItemClickListener;
import com.brothersoft.domain.entity.country.Currency;
import com.brothersoft.domain.entity.country.CurrencyList;
import com.brothersoft.domain.usecases.country.GetCurrenciesUseCase;
import com.brothersoft.domain.usecases.country.GetLanguagesUseCase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class CurrencyListActivity extends AppCompatActivity implements OnItemClickListener {
    private List<String[]> currencies = new ArrayList<>();
    private RecyclerView recyclerView;
    private FieldTypeAdapter adapter;

    @Inject
    GetCurrenciesUseCase currenciesUseCase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_list);
        runInject();
        getCurrencyList();
    }

    public void getCurrencyList() {
        currenciesUseCase.getCurrencies("currencies")
                .subscribe(new Observer<List<CurrencyList>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<CurrencyList> currencyLists) {
                        getCurrenciesName(currencyLists);
                        setCurrencyRecycler();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("AAA", "Error1!!!!!!!!!!!!!!!!!!");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void runInject() {
        App.getAppComponent().runInject(this);
    }

    public void getCurrenciesName(List<CurrencyList> currencyList) {
        Set<String[]> languagesSet = new HashSet();
        for (CurrencyList currencies : currencyList) {
            for (Currency currency : currencies.getCurrencies()) {
                String[] currencyInfo = {currency.getName(), currency.getCode()};
                languagesSet.add(currencyInfo);
            }
        }
        this.currencies.addAll(languagesSet);
    }

    public void setCurrencyRecycler() {
        recyclerView = findViewById(R.id.currencyList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new FieldTypeAdapter(this, this.currencies);
        adapter.setOnClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int position) {
        String currency = currencies.get(position)[1];
        Intent intent = CountryGroupActivity.getIntent(this,
                "currency", currency);
        startActivity(intent);
    }
}