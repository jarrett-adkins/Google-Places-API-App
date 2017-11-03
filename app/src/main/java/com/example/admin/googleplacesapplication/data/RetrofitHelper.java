package com.example.admin.googleplacesapplication.data;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RetrofitHelper {

    public String BASE_URL;// = Constants.URLS.BASE_URL;
//    public static final String APP_ID = BuildConfig.APP_ID;
//    public static final String APP_KEY = BuildConfig.APP_KEY;

//    public RetrofitHelper(String baseUrl ) {
//        BASE_URL = baseUrl;
//    }
//
//    public Retrofit create(){
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .build();
//
//        return retrofit;
//    }
//
//    public Observable<MyResponse> getResponse(String query, int from, int to ){
//        Retrofit retrofit = create();
//        RequestService service = retrofit.create(RequestService.class);
//        return service.responseService( query, from, to, APP_ID, APP_KEY );
//    }
//
//    public interface RequestService{
//        @GET( "search" )
//        Observable<MyResponse> responseService(
//                @Query("q") String query,
//                @Query("from") int from,
//                @Query("to") int to,
//                @Query("app_id") String appId,
//                @Query("app_key") String appKey);
//
//    }
}