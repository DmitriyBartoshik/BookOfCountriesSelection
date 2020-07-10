package com.brothersoft.bookofcountry.presentation.screens.country.list;

import com.brothersoft.bookofcountry.app.App;
import com.brothersoft.bookofcountry.presentation.base.BaseViewModel;
import com.brothersoft.bookofcountry.presentation.base.recycler.ClickedItemModel;
import com.brothersoft.bookofcountry.presentation.screens.country.list.items.country.CountryListAdapter;
import com.brothersoft.domain.entity.DomainModel;
import com.brothersoft.domain.entity.country.Country;
import com.brothersoft.domain.usecases.country.GetListCountryUseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class CountryListViewModel extends BaseViewModel<CountryListRouter, DomainModel> {

    public CountryListAdapter adapter = new CountryListAdapter();

    @Inject
    public GetListCountryUseCase listCountryUseCase;

    @Override
    protected void runInject() {
        App.getAppComponent().runInject(this);
    }

   public CountryListViewModel() {

        adapterClickObserver();
    }

    public void getCountryList() {
        showProgressBar();
        listCountryUseCase.getCountries().subscribe(new Observer<List<Country>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<Country> countries) {
                adapter.setItems(countries);
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

    public void adapterClickObserver() {
        adapter.observeItemClick().subscribe(new Observer<ClickedItemModel>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(ClickedItemModel clickedItemModel) {
                if (clickedItemModel.getEntity() instanceof Country) {
                    String alpha3Code = ((Country) clickedItemModel.getEntity()).getAlpha3Code();
                    router.goToCountryDetails(alpha3Code);
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
}
