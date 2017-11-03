package com.example.admin.googleplacesapplication.di.mainActivity;

import com.example.admin.googleplacesapplication.data.RetrofitHelper;
import com.example.admin.googleplacesapplication.view.mainActivity.MainActivityPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Admin on 10/20/2017.
 */

//denote the module with @module annotation
@Module
public class MainActivityModule {

    //method that provides the mainActivityPresenter object
    @Provides
    MainActivityPresenter providesMainActivityPresenter (RetrofitHelper retrofitHelper) {
        return new MainActivityPresenter( retrofitHelper );
    }

    @Provides
    RetrofitHelper provideRetrofitHelper() { return new RetrofitHelper(); }

//    @Provides
//    MainActivityPresenter providesMainActivityPresenter() {
//        return new MainActivityPresenter();
//    }
}
