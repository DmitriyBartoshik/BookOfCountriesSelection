package com.brothersoft.data.repositories;

import com.brothersoft.data.entity.responses.country.CountryResponse;
import com.brothersoft.data.entity.responses.country.CurrencyResponse;
import com.brothersoft.data.entity.responses.country.LanguageResponse;
import com.brothersoft.data.entity.responses.country.RegionalBlockResponse;
import com.brothersoft.data.entity.responses.country.TranslationResponse;
import com.brothersoft.data.net.country.RestService;
import com.brothersoft.domain.entity.country.Country;
import com.brothersoft.domain.entity.country.Currency;
import com.brothersoft.domain.entity.country.Language;
import com.brothersoft.domain.entity.country.RegionalBlock;
import com.brothersoft.domain.entity.country.Translation;
import com.brothersoft.domain.repositories.CountryRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class CountryRepositoryImpl implements CountryRepository {

    private RestService restService;

    @Inject
    public CountryRepositoryImpl(RestService restService) {
        this.restService = restService;
    }


    @Override
    public Observable<List<Country>> getAllCountries() {
        return restService.getAllCountries()
                .map(new Function<List<CountryResponse>, List<Country>>() {
                    @Override
                    public List<Country> apply(List<CountryResponse> countryResponses) throws Exception {
                        List<Country> countries = new ArrayList<>();
                        for (CountryResponse countryResponse : countryResponses) {
                            Country country = getCountry(countryResponse);
                            countries.add(country);
                        }
                        return countries;
                    }
                });
    }

    @Override
    public Observable<List<Country>> getCountryGroupList(String field, String fieldValue) {
        return restService.getCountryGroupList(field, fieldValue)
                .map(new Function<List<CountryResponse>, List<Country>>() {
                    @Override
                    public List<Country> apply(List<CountryResponse> countryResponses) throws Exception {
                        List<Country> countries = new ArrayList<>();
                        for (CountryResponse countryResponse : countryResponses) {
                            Country country = getCountry(countryResponse);
                            countries.add(country);
                        }
                        return countries;
                    }
                });
    }

    @Override
    public Observable<Country> getCountry(String alpha3Code) {

        return restService.getCountry(alpha3Code)
                .map(new Function<CountryResponse, Country>() {
                    @Override
                    public Country apply(CountryResponse countryResponse) throws Exception {
                        Country country=getCountry(countryResponse);
                        return country;
                    }
                });
    }

    public Country getCountry(CountryResponse countryResponse) {
        Country country = new Country();
        country.setName(countryResponse.getName());
        country.setTopLevelDomain(countryResponse.getTopLevelDomain());
        country.setAlpha2Code(countryResponse.getAlpha2Code());
        country.setAlpha3Code(countryResponse.getAlpha3Code());
        country.setCallingCodes(countryResponse.getCallingCodes());
        country.setCapital(countryResponse.getCapital());
        country.setAltSpellings(countryResponse.getAltSpellings());
        country.setRegion(countryResponse.getRegion());
        country.setSubregion(countryResponse.getSubregion());
        country.setPopulation(countryResponse.getPopulation());
        country.setLatlng(countryResponse.getLatlng());
        country.setDemonym(countryResponse.getDemonym());
        country.setArea(countryResponse.getArea());
        country.setGini(countryResponse.getGini());
        country.setTimezones(countryResponse.getTimezones());
        country.setBorders(countryResponse.getBorders());
        country.setNativeName(countryResponse.getNativeName());
        country.setNumericCode(countryResponse.getNumericCode());
        country.setFlag(countryResponse.getFlag());
        country.setCioc(countryResponse.getCioc());
        country.setCurrencies(getCurrencyList(countryResponse.getCurrencies()));
        country.setLanguages(getLanguageList(countryResponse.getLanguages()));
        country.setTranslations(getTranslationList(countryResponse.getTranslations()));
        country.setRegionalBlocs(getRegionalBlockList(countryResponse.getRegionalBlocs()));
        return country;
    }

    public List<Currency> getCurrencyList(List<CurrencyResponse> currencyResponses) {
        List<Currency> currencies = new ArrayList<>();
        for (CurrencyResponse currencyResponse : currencyResponses) {
            Currency currency = new Currency();
            currency.setCode(currencyResponse.getCode());
            currency.setName(currencyResponse.getName());
            currency.setSymbol(currencyResponse.getSymbol());
            currencies.add(currency);
        }
        return currencies;
    }

    public List<Language> getLanguageList(List<LanguageResponse> languageResponses) {
        List<Language> languages = new ArrayList<>();
        for (LanguageResponse languageResponse : languageResponses) {
            Language language = new Language();
            language.setIso639_1(languageResponse.getIso639_1());
            language.setIso639_2(languageResponse.getIso639_2());
            language.setName(languageResponse.getName());
            language.setNativeName(languageResponse.getNativeName());
            languages.add(language);
        }
        return languages;
    }

    public Translation getTranslationList(TranslationResponse translationResponses) {
        Translation translation = new Translation();
        translation.setDe(translationResponses.getDe());
        translation.setEs(translationResponses.getEs());
        translation.setFr(translationResponses.getFr());
        translation.setJa(translationResponses.getJa());
        translation.setIt(translationResponses.getIt());
        translation.setBr(translationResponses.getBr());
        translation.setPt(translationResponses.getPt());
        return translation;
    }

    public List<RegionalBlock> getRegionalBlockList(List<RegionalBlockResponse> regionalBlockResponses) {
        List<RegionalBlock> regionalBlocks = new ArrayList<>();
        for (RegionalBlockResponse regionalBlockResponse : regionalBlockResponses) {
            RegionalBlock regionalBlock = new RegionalBlock();
            regionalBlock.setAcronym(regionalBlockResponse.getAcronym());
            regionalBlock.setName(regionalBlockResponse.getName());
            regionalBlock.setOtherAcronyms(regionalBlockResponse.getOtherAcronyms());
            regionalBlock.setOtherNames(regionalBlockResponse.getOtherNames());
            regionalBlocks.add(regionalBlock);
        }
        return regionalBlocks;
    }
}
