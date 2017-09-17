package com.mercari.mercaritest;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final MercariApp app;

    AppModule(@NonNull MercariApp app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public Application provideApp() {
        return app;
    }

    @Provides
    @Singleton
    public Context provideContext(){
        return  app.getApplicationContext();
    }
}
