package com.brothersoft.bookofcountry.presentation.screens.country.single;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import com.brothersoft.bookofcountry.app.App;
import com.brothersoft.bookofcountry.presentation.base.BaseViewModel;
import com.brothersoft.bookofcountry.presentation.base.recycler.ClickedItemModel;
import com.brothersoft.bookofcountry.presentation.screens.country.single.items.block.RegionalBlockListAdapter;
import com.brothersoft.bookofcountry.presentation.screens.country.single.items.currency.CurrencyListAdapter;
import com.brothersoft.bookofcountry.presentation.screens.country.single.items.language.LanguageListAdapter;
import com.brothersoft.domain.entity.DomainModel;
import com.brothersoft.domain.entity.country.Country;
import com.brothersoft.domain.entity.country.Currency;
import com.brothersoft.domain.entity.country.Language;
import com.brothersoft.domain.entity.country.RegionalBlock;
import com.brothersoft.domain.usecases.country.GetCountryUseCase;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class CountryViewModel extends BaseViewModel<CountryRouter, DomainModel> {
    public ObservableField<String> name = new ObservableField<String>();
    public ObservableField<String> capital = new ObservableField<String>();
    public ObservableField<String> region = new ObservableField<String>();
    public ObservableField<String> flag = new ObservableField<>("");
    public ObservableField<String> population = new ObservableField<String>();
    public ObservableField<String> area = new ObservableField<String>();
    public ObservableField<String> gini = new ObservableField<String>();
    public ObservableField<String> callingCode = new ObservableField<String>();
    public ObservableField<String> domain = new ObservableField<String>();
    public ObservableField<String> alpha2Code = new ObservableField<String>();
    public ObservableField<String> alpha3Code = new ObservableField<String>();
    public ObservableField<String> timeZone = new ObservableField<String>();

    public ObservableBoolean blocContainer = new ObservableBoolean(true);
    public ObservableBoolean giniContainer = new ObservableBoolean(true);

    public double capitalLat;
    public double capitalLng;

    public LanguageListAdapter languageListAdapter = new LanguageListAdapter();
    public CurrencyListAdapter currencyListAdapter = new CurrencyListAdapter();
    public RegionalBlockListAdapter regionalBlockListAdapter = new RegionalBlockListAdapter();

    @Inject
    public GetCountryUseCase countryUseCase;

    @Override
    protected void runInject() {
        App.getAppComponent().runInject(this);
    }

    public CountryViewModel() {
        languageClickObserver();
        currencyClickObserver();
        regionalBlockClickObserver();
    }

    public void getCountry(String name) {
        showProgressBar();
        countryUseCase.getCountry(name).subscribe(new Observer<Country>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Country country) {
                languageListAdapter.setItems(country.getLanguages());
                currencyListAdapter.setItems(country.getCurrencies());
                if (country.getRegionalBlocs().isEmpty()) hideRegionalBloc();
                else
                    regionalBlockListAdapter.setItems(country.getRegionalBlocs());
                setCountryField(country);
                hideProgressBar();
            }

            @Override
            public void onError(Throwable e) {
                router.showError(e);
            }

            @Override
            public void onComplete() {

            }
        });
    }

    public void languageClickObserver() {
        languageListAdapter.observeItemClick().subscribe(new Observer<ClickedItemModel>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ClickedItemModel clickedItemModel) {
                if (clickedItemModel.getEntity() instanceof Language) {
                    String languageCode = ((Language) clickedItemModel.getEntity()).getIso639_1();
                    String languageName = ((Language) clickedItemModel.getEntity()).getName();
                    router.goToCountryGroupList("lang", languageCode, languageName);
                }
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    public void currencyClickObserver() {
        currencyListAdapter.observeItemClick().subscribe(new Observer<ClickedItemModel>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ClickedItemModel clickedItemModel) {
                if (clickedItemModel.getEntity() instanceof Currency) {
                    String currencyCode = ((Currency) clickedItemModel.getEntity()).getCode();
                    String currencyName = ((Currency) clickedItemModel.getEntity()).getName();
                    router.goToCountryGroupList("currency", currencyCode, currencyName);
                }
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    public void regionalBlockClickObserver() {
        regionalBlockListAdapter.observeItemClick().subscribe(new Observer<ClickedItemModel>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ClickedItemModel clickedItemModel) {
                if (clickedItemModel.getEntity() instanceof RegionalBlock) {
                    String regionalBlocCode = ((RegionalBlock) clickedItemModel.getEntity()).getAcronym();
                    String regionalBlocName = ((RegionalBlock) clickedItemModel.getEntity()).getName();
                    router.goToCountryGroupList("regionalbloc", regionalBlocCode, regionalBlocName);
                }
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    public void setCountryField(Country country) {
        this.name.set(country.getName());
        this.capital.set(country.getCapital());
        this.region.set(country.getRegion());
        this.flag.set(country.getFlag());
        this.population.set(String.valueOf(country.getPopulation()));
        this.area.set(String.valueOf(country.getArea()));
        if (country.getGini() == 0.0)
            hideGini();
        else
            this.gini.set(String.valueOf(country.getGini()));
        this.callingCode.set("+" + country.getCallingCodes().get(0));
        this.domain.set(country.getTopLevelDomain().get(0));
        this.alpha2Code.set(country.getAlpha2Code());
        this.alpha3Code.set(country.getAlpha3Code());
        this.timeZone.set(country.getTimezones().get(0));

        this.capitalLat = country.getLatlng().get(0);
        this.capitalLng = country.getLatlng().get(1);

    }

    public void goToRegionsCountries() {
        String focusRegion = region.get();
        router.goToCountryGroupList("region", focusRegion, focusRegion);
    }

    public void goToCapital() {
//        String cap = capital.get();
//        router.goToCapital(cap);
    }

    public void goToMap() {
        router.goToMap(name.get(), capitalLat, capitalLng);
    }

    public void hideGini() {
        giniContainer.set(false);
    }

    public void hideRegionalBloc() {
        blocContainer.set(false);
    }
}
