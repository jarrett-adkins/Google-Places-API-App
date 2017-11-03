package com.example.admin.googleplacesapplication.data;

import com.example.admin.googleplacesapplication.BuildConfig;
import com.example.admin.googleplacesapplication.model.MyResponse;

import okhttp3.OkHttpClient;
import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

//import com.example.admin.googleplacesapplication.model.

public class RetrofitHelper {

    public String BASE_URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/";
    public static final String API_KEY = BuildConfig.API_KEY;

    public RetrofitHelper() {
    }

    public RetrofitHelper( String baseUrl ) {
        BASE_URL = baseUrl;
    }

    public Retrofit create(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit;
    }

    public Observable<MyResponse> getResponse(String location, int radius ){
        Retrofit retrofit = create();
        RequestService service = retrofit.create(RequestService.class);
        return service.responseService( location, radius, API_KEY );
    }

    public interface RequestService{
        @GET( "json" )
        Observable<MyResponse> responseService(
                @Query("location") String query,
                @Query("radius") int radius,
                @Query("key") String apiKey);
    }
}