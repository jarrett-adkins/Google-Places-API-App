package com.example.admin.googleplacesapplication.view.mainActivity;

import android.util.Log;

import com.example.admin.googleplacesapplication.data.RetrofitHelper;
import com.example.admin.googleplacesapplication.model.MyResponse;
import com.google.android.gms.location.places.GeoDataClient;
import com.google.android.gms.location.places.Places;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Admin on 11/2/2017.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter {

    private static final String TAG = "MainActivityPresenter";
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

        Observer<MyResponse> observer = new Observer<MyResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

                Log.d(TAG, "onSubscribe: ");
            }

            @Override
            public void onNext(MyResponse myResponse) {
//                recipeList.add(recipe);
            }

            @Override
            public void onError(Throwable e) {
                view.showError(e.getMessage());
            }

            @Override
            public void onComplete() {
//                view.updateRecipes(recipeList);
            }
        };

        retrofitHelper.getResponse( "", 0 )
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);
    }
}
