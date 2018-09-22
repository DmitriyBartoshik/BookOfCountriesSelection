package com.brothersoft.domain.usecases.country;

import com.brothersoft.domain.entity.DomainModel;
import com.brothersoft.domain.entity.country.Country;
import com.brothersoft.domain.entity.country.Language;
import com.brothersoft.domain.entity.country.LanguageList;
import com.brothersoft.domain.executors.PostExecutionThread;
import com.brothersoft.domain.repositories.CountryRepository;
import com.brothersoft.domain.usecases.BaseUseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetLanguagesUseCase extends BaseUseCase {
    private CountryRepository countryRepository;

    @Inject
    public GetLanguagesUseCase(CountryRepository countryRepository,
                               PostExecutionThread postExecutionThread) {
        super(postExecutionThread);
        this.countryRepository=countryRepository;

    }
    public Observable<List<LanguageList>> getLanguages(String field) {
        return countryRepository
                .getLanguages(field)
                .subscribeOn(executionThread)
                .observeOn(postExecutionThread);
    }
}

