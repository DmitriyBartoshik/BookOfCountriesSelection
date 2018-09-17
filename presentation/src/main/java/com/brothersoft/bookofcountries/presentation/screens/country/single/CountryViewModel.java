package com.brothersoft.bookofcountries.presentation.screens.country.single;

import android.databinding.ObservableField;

import com.brothersoft.bookofcountries.app.App;
import com.brothersoft.bookofcountries.presentation.base.BaseViewModel;
import com.brothersoft.bookofcountries.presentation.base.recycler.ClickedItemModel;
import com.brothersoft.bookofcountries.presentation.screens.country.single.items.block.RegionalBlockListAdapter;
import com.brothersoft.bookofcountries.presentation.screens.country.single.items.currency.CurrencyListAdapter;
import com.brothersoft.bookofcountries.presentation.screens.country.single.items.language.LanguageListAdapter;
import com.brothersoft.domain.entity.country.Country;
import com.brothersoft.domain.entity.country.Currency;
import com.brothersoft.domain.entity.country.Language;
import com.brothersoft.domain.entity.country.RegionalBlock;
import com.brothersoft.domain.usecases.country.GetCountryUseCase;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class CountryViewModel extends BaseViewModel<CountryRouter> {
    public ObservableField<String> name = new ObservableField<String>();
    public ObservableField<String> capital = new ObservableField<String>();
    public ObservableField<String> region = new ObservableField<String>();
    public ObservableField<String> flag = new ObservableField<>("");
    public ObservableField<String> population = new ObservableField<String>();
    public ObservableField<String> area = new ObservableField<String>();
    public ObservableField<String> callingCode = new ObservableField<String>();
    public ObservableField<String> domain = new ObservableField<String>();
    public ObservableField<String> alpha2Code = new ObservableField<String>();
    public ObservableField<String> alpha3Code = new ObservableField<String>();
    public ObservableField<String> timeZone = new ObservableField<String>();

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
        countryUseCase.getCountry(name).subscribe(new Observer<Country>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Country country) {
                languageListAdapter.setItems(country.getLanguages());
                currencyListAdapter.setItems(country.getCurrencies());
                regionalBlockListAdapter.setItems(country.getRegionalBlocs());
                setCountryField(country);
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
                    String language = ((Language) clickedItemModel.getEntity()).getIso639_1();
                    router.goToCountryGroupList("lang", language);
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
                    String currency = ((Currency) clickedItemModel.getEntity()).getCode();
                    router.goToCountryGroupList("currency", currency);
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
                    String regionalBlock = ((RegionalBlock) clickedItemModel.getEntity()).getAcronym();
                    router.goToCountryGroupList("regionalbloc", regionalBlock);
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
        this.callingCode.set("+" + country.getCallingCodes().get(0));
        this.domain.set(country.getTopLevelDomain().get(0));
        this.alpha2Code.set(country.getAlpha2Code());
        this.alpha3Code.set(country.getAlpha3Code());
        this.timeZone.set(country.getTimezones().get(0));
    }

    public void goToRegionsCountries() {
        String focusRegion = region.get();
        router.goToCountryGroupList("region", focusRegion);
    }

    public void goToCapital() {
        String cap = capital.get();
        router.goToCapital(cap);
    }
}
