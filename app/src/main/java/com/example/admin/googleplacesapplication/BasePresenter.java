package com.example.admin.googleplacesapplication;

/**
 * Created by Admin on 10/18/2017.
 */

public interface BasePresenter<V extends BaseView> {
    //V is genertic type for view.

    void addView(V View);
    void removeView();
}
