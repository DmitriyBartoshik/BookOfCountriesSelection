package com.brothersoft.domain.usecases.country;

import com.brothersoft.domain.entity.country.Country;
import com.brothersoft.domain.executors.PostExecutionThread;
import com.brothersoft.domain.repositories.CountryRepository;
import com.brothersoft.domain.usecases.BaseUseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetListCountryUseCase extends BaseUseCase {
    private CountryRepository countryRepository;

    @Inject
    public GetListCountryUseCase(CountryRepository countryRepository,
                              PostExecutionThread postExecutionThread) {
        super(postExecutionThread);
        this. countryRepository = countryRepository;
    }

    public Observable<List<Country>> getCountries() {
        return  countryRepository
                .getAllCountries()
                .subscribeOn(executionThread)
                .observeOn(postExecutionThread);
    }
}
