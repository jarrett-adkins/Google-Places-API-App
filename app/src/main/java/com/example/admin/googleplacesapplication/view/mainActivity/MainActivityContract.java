package com.example.admin.googleplacesapplication.view.mainActivity;

import com.example.admin.googleplacesapplication.BasePresenter;
import com.example.admin.googleplacesapplication.BaseView;

/**
 * Created by Admin on 11/2/2017.
 */

public interface MainActivityContract {
    interface View extends BaseView {
        //data passed from activity here
        void updateRecyclerView();
        void showProgress(int MODE);
    }

    interface Presenter extends BasePresenter<View> {
        //activity calls this to get data
        void getPlaces();
    }
}
