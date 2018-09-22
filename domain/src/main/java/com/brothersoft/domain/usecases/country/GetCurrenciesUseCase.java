package com.brothersoft.domain.usecases.country;

import com.brothersoft.domain.entity.country.CurrencyList;
import com.brothersoft.domain.entity.country.LanguageList;
import com.brothersoft.domain.executors.ExecutionThread;
import com.brothersoft.domain.executors.PostExecutionThread;
import com.brothersoft.domain.repositories.CountryRepository;
import com.brothersoft.domain.usecases.BaseUseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

public class GetCurrenciesUseCase extends BaseUseCase {
    private CountryRepository countryRepository;

    @Inject
    public GetCurrenciesUseCase(CountryRepository countryRepository,
                               PostExecutionThread postExecutionThread) {
        super(postExecutionThread);
        this.countryRepository=countryRepository;

    }
    public Observable<List<CurrencyList>> getCurrencies(String field) {
        return countryRepository
                .getCurrencies(field)
                .subscribeOn(executionThread)
                .observeOn(postExecutionThread);
    }
}
