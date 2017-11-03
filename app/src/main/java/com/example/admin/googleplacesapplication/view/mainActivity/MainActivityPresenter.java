package com.example.admin.googleplacesapplication.view.mainActivity;

import com.example.admin.googleplacesapplication.data.RetrofitHelper;
import com.google.android.gms.location.places.GeoDataClient;
import com.google.android.gms.location.places.Places;

import javax.inject.Inject;

/**
 * Created by Admin on 11/2/2017.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter {

    MainActivityContract.View view;
    RetrofitHelper retrofitHelper;

    @Inject
    public MainActivityPresenter(RetrofitHelper retrofitHelper) {
        this.retrofitHelper = retrofitHelper;
    }

    @Override
    public void addView(MainActivityContract.View View) {
        this.view = view;
    }

    @Override
    public void removeView() {
        this.view = null;
    }

    @Override
    public void getPlaces() {
    }
}
