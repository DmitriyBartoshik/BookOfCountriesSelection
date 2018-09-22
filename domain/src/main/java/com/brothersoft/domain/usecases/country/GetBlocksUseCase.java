package com.brothersoft.domain.usecases.country;

import com.brothersoft.domain.entity.country.CurrencyList;
import com.brothersoft.domain.entity.country.RegionalBlockList;
import com.brothersoft.domain.executors.PostExecutionThread;
import com.brothersoft.domain.repositories.CountryRepository;
import com.brothersoft.domain.usecases.BaseUseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetBlocksUseCase extends BaseUseCase {
    private CountryRepository countryRepository;

    @Inject
    public GetBlocksUseCase(CountryRepository countryRepository,
                            PostExecutionThread postExecutionThread) {
        super(postExecutionThread);
        this.countryRepository = countryRepository;

    }

    public Observable<List<RegionalBlockList>> getRegionalBlocs(String field) {
        return countryRepository
                .getRegionalBlocks(field)
                .subscribeOn(executionThread)
                .observeOn(postExecutionThread);
    }
}
