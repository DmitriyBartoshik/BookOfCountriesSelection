package com.brothersoft.domain.usecases.country;

import com.brothersoft.domain.entity.country.Country;
import com.brothersoft.domain.executors.PostExecutionThread;
import com.brothersoft.domain.repositories.CountryRepository;
import com.brothersoft.domain.usecases.BaseUseCase;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetCountryUseCase extends BaseUseCase {
    private CountryRepository countryRepository;

    @Inject
    public GetCountryUseCase(CountryRepository countryRepository,
                             PostExecutionThread postExecutionThread) {
        super(postExecutionThread);
        this.countryRepository = countryRepository;
    }

    public Observable<Country> getCountry(String alpha3Code) {
        return countryRepository
                .getCountry(alpha3Code)
                .subscribeOn(executionThread)
                .observeOn(postExecutionThread);
    }
}
