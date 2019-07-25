package com.sugar.boilerplate.Network.Retrofit;

import android.app.Application;



public class AppController extends Application{

    public static AppController mAppControllerInstance;

    private static ApiInterface apiInterface;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppControllerInstance=this;
        configRetrofit();
    }

    private void configRetrofit() {

        apiInterface= ApiClient.getMretrofit().create(ApiInterface.class);
    }
    public static synchronized AppController getMappControllerInstance(){
        return mAppControllerInstance;
    }
    public static ApiInterface getApiInterface(){
        return apiInterface;
    }
}
