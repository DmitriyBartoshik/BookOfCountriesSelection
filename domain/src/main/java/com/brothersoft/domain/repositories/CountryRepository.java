package com.brothersoft.domain.repositories;

import com.brothersoft.domain.entity.DomainModel;
import com.brothersoft.domain.entity.country.Country;
import com.brothersoft.domain.entity.country.CurrencyList;
import com.brothersoft.domain.entity.country.Language;
import com.brothersoft.domain.entity.country.LanguageList;
import com.brothersoft.domain.entity.country.RegionalBlockList;


import java.util.List;

import io.reactivex.Observable;

public interface CountryRepository {

    Observable<List<Country>> getAllCountries();

    Observable<List<Country>> getCountryGroupList(String field, String fieldValue);

    Observable<Country> getCountry(String alpha3Code);

    Observable<List<LanguageList>> getLanguages(String field);

    Observable<List<CurrencyList>> getCurrencies(String field);
    Observable<List<RegionalBlockList>> getRegionalBlocks(String field);
}
