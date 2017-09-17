package com.mercari.mercaritest;

import android.app.Application;


public class MercariApp extends Application {

    private AppComponent appComponent;
    @Override
    public void onCreate() {
        super.onCreate();

       appComponent= DaggerAppComponent.builder()
               .appModule(new AppModule(this))
               .netModule(new NetModule(this,"http://www.jsonplaceholder.typicode.com/"))
               .build();

    }

    public AppComponent getNetComponent() {
        return appComponent;
    }



}
