package com.example.admin.googleplacesapplication.view.mainActivity;

import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.example.admin.googleplacesapplication.R;
import com.example.admin.googleplacesapplication.di.mainActivity.DaggerMainActivityComponent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.GeoDataClient;
import com.google.android.gms.location.places.PlaceDetectionClient;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.FusedLocationProviderClient;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    private static final String TAG = "MainActivity";

    @Inject
    MainActivityPresenter presenter;
    @BindView(R.id.mySearchView)
    SearchView mySearchView;
    @BindView(R.id.main_toolbar)
    Toolbar mainToolbar;
    @BindView(R.id.rvPlacesList)
    RecyclerView rvPlacesList;

    private RecyclerView.LayoutManager layoutManager;
    private MyItemListAdapter adapter;
    private ProgressDialog progress;
    private EndlessRecyclerViewScrollListener scrollListener;
    List<String> placeList = new ArrayList<>();

    protected GeoDataClient mGeoDataClient;
    private PlaceDetectionClient mPlaceDetectionClient;
    private FusedLocationProviderClient mFusedLocationProviderClient;
    private GoogleApiClient mGoogleApiClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initDaggerComponent();
        initSearchView();
        initGooglePlaces();
        initRecyclerView();
        presenter.addView(this);
    }

    private void initDaggerComponent() {
        DaggerMainActivityComponent.create().inject(this);
    }

    private void initSearchView() {
//        Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar( mainToolbar );

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//        SearchView searchView = findViewById(R.id.mySearchView);

        // Assumes current activity is the searchable activity
        mySearchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        mySearchView.setIconifiedByDefault(false); // Do not iconify the widget; expand it by default
    }

    private void initGooglePlaces() {
//        // Construct a GeoDataClient.
//        mGeoDataClient = Places.getGeoDataClient(this, null);
//
//        // Construct a PlaceDetectionClient.
//        mPlaceDetectionClient = Places.getPlaceDetectionClient(this, null);
//
//        // Construct a FusedLocationProviderClient.
//        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        // create an instance of the Google Play services API client.
//        mGoogleApiClient = new GoogleApiClient
//                .Builder(this)
//                .addApi(Places.GEO_DATA_API)
//                .addApi(Places.PLACE_DETECTION_API)
//                .enableAutoManage(this, new GoogleApiClient.OnConnectionFailedListener() {
//                    @Override
//                    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
//                        Log.d(TAG, "onConnectionFailed: " + connectionResult.getErrorMessage());
//                        showError( connectionResult.getErrorMessage() );
//                    }
//                })
//                .build();
    }

    private void initRecyclerView() {
        rvPlacesList.setLayoutManager( new LinearLayoutManager(this));
        rvPlacesList.setItemAnimator( new DefaultItemAnimator());
        adapter = new MyItemListAdapter(this, placeList);
        rvPlacesList.setAdapter(adapter);

        rvPlacesList.addOnScrollListener( new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
//                Toast.makeText(MainActivity.this, "onLoadMore", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void updateRecyclerView() {

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        // will be called after the user searches with the search view.
        Log.d(TAG, "onNewIntent: ");

        presenter.getPlaces();
    }

    @Override
    public void showProgress(int MODE) {
//        if(MODE == presenter.INIT_ITEMS){
//
//            progress = new ProgressDialog(this);
//            progress.setTitle("Loading");
//            progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
//            progress.show();
//        }
//        else{
//            Toast.makeText(this, "Loading more items..", Toast.LENGTH_SHORT).show();
//        }

        Log.d(TAG, "showProgress: ");
    }

    @Override
    public void showError(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}

/*
Create an application to
X 1. use Google Places API
2. populate the recycler view with the nearby places using your current location
3. create a menu item to query for different categories of places
4. Use Google AutoComplete API
5. show a map fragment above the recyclerView to show all the markers for places in the below list.
    https://developers.google.com/places/android-api/placepicker
6. open GoogleMaps to get directions from current location to the place address
7. use Glide to populate the imageViews for places.
8. open placeDetail activity on each item click
9. animate each item entry in the recycler view.
X -Use MVP
X -Dagger
X -Use Google Places API with REST calls rather than the SDK
Bonus points:
-to use ItemTouchHelper class in recyclerView
-use an interface to handle on click events in the adapter

https://developers.google.com/places/web-service/search
https://developers.google.com/places/android-api/current-place
https://developers.google.com/places/android-api/current-place-tutorial
 */