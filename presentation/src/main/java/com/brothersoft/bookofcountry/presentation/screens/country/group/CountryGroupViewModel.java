package com.brothersoft.bookofcountry.presentation.screens.country.group;

import com.brothersoft.bookofcountry.app.App;
import com.brothersoft.bookofcountry.presentation.base.BaseViewModel;
import com.brothersoft.bookofcountry.presentation.base.recycler.ClickedItemModel;
import com.brothersoft.bookofcountry.presentation.screens.country.list.items.country.CountryListAdapter;
import com.brothersoft.domain.entity.DomainModel;
import com.brothersoft.domain.entity.country.Country;
import com.brothersoft.domain.usecases.country.GetCountryGroupUseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class CountryGroupViewModel extends BaseViewModel<CountryGroupRouter, DomainModel> {
    public String field;
    public String fieldValue;

    public CountryListAdapter adapter = new CountryListAdapter();
    @Inject
    public GetCountryGroupUseCase countryGroupUseCase;

    @Override
    protected void runInject() {
        App.getAppComponent().runInject(this);
    }

    public CountryGroupViewModel() {
        adapterClickObserver();
    }


    public void getCountryGroupList(String field, String fieldValue, String fieldName) {
        showProgressBar();
        setField(field, fieldName);
        countryGroupUseCase.getCountryGroupList(field, fieldValue).subscribe(new Observer<List<Country>>() {
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

    public void setField(String field, String fieldValue) {
        if (field.equals("lang"))
            field = "language";
        if (field.equals("regionalbloc"))
            field = "regional bloc";

        this.field = field;
        this.fieldValue = fieldValue;

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
