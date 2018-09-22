package com.brothersoft.data.net.country;

import com.brothersoft.data.entity.responses.country.CountryResponse;
import com.brothersoft.domain.entity.DomainModel;
import com.brothersoft.domain.entity.country.CurrencyList;
import com.brothersoft.domain.entity.country.Language;
import com.brothersoft.domain.entity.country.LanguageList;
import com.brothersoft.domain.entity.country.RegionalBlockList;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RestApi {

    @GET("all")
    Observable<List<CountryResponse>> getAllCountries();

    @GET("{field}/{fieldValue}")
    Observable<List<CountryResponse>> getCountryGroupList(@Path("field") String field, @Path("fieldValue") String fieldValue);

    @GET("alpha/{alpha3Code}")
    Observable<CountryResponse> getCountry(@Path("alpha3Code") String name);

    @GET("all")
    Observable<List<LanguageList>> getLanguages(@Query("fields") String fields);

    @GET("all")
    Observable<List<CurrencyList>> getCurrencies(@Query("fields") String fields);

    @GET("all")
    Observable<List<RegionalBlockList>> getRegionalBlocks(@Query("fields") String fields);
}
