package com.brothersoft.data.entity.responses.country;

import com.brothersoft.data.entity.responses.DataModel;
import java.util.List;

public class CountryResponse implements DataModel {
    private String name;
    private List<String> topLevelDomain;
    private String alpha2Code;
    private String alpha3Code;
    private List<String> callingCodes;
    private String capital;
    private List<String> altSpellings;
    private String region;
    private String subregion;
    private int population;
    private List<Double> latlng;
    private String demonym;
    private double area;
    private double gini;
    private List<String> timezones;
    private List<String> borders;
    private String nativeName;
    private int numericCode;
    private List<CurrencyResponse> currencies;
    private List<LanguageResponse> languages;
    private TranslationResponse translations;
    private String flag;
    private List<RegionalBlockResponse> regionalBlocs;
    private String cioc;

    public String getName() {
        return name;
    }

    public List<String> getTopLevelDomain() {
        return topLevelDomain;
    }


    public String getAlpha2Code() {
        return alpha2Code;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public List<String> getCallingCodes() {
        return callingCodes;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public List<String> getAltSpellings() {
        return altSpellings;
    }

    public String getRegion() {
        return region;
    }

    public String getSubregion() {
        return subregion;
    }

    public int getPopulation() {
        return population;
    }

    public List<Double> getLatlng() {
        return latlng;
    }

    public String getDemonym() {
        return demonym;
    }

    public double getArea() {
        return area;
    }

    public double getGini() {
        return gini;
    }

    public List<String> getTimezones() {
        return timezones;
    }

    public List<String> getBorders() {
        return borders;
    }

    public String getNativeName() {
        return nativeName;
    }

    public int getNumericCode() {
        return numericCode;
    }

    public List<CurrencyResponse> getCurrencies() {
        return currencies;
    }

    public List<LanguageResponse> getLanguages() {
        return languages;
    }


    public TranslationResponse getTranslations() {
        return translations;
    }


    public String getFlag() {
        return flag;
    }



    public List<RegionalBlockResponse> getRegionalBlocs() {
        return regionalBlocs;
    }


    public String getCioc() {
        return cioc;
    }
}
