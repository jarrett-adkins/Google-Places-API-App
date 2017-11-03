package com.example.admin.googleplacesapplication.di.mainActivity;

import com.example.admin.googleplacesapplication.data.RetrofitHelper;
import com.example.admin.googleplacesapplication.view.mainActivity.MainActivity;

import dagger.Component;

/**
 * Created by Admin on 10/20/2017.
 */

@Component(modules = MainActivityModule.class)
public interface MainActivityComponent {

    void inject(MainActivity mainActivity);
    RetrofitHelper retrofitHelper();
}
