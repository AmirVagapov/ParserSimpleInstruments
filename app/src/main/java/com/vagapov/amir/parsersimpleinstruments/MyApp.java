package com.vagapov.amir.parsersimpleinstruments;

import android.app.Application;

import io.paperdb.Paper;


public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Paper.init(this);
    }
}
