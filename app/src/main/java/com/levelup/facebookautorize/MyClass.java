package com.levelup.facebookautorize;

import android.app.Application;

import com.facebook.appevents.AppEventsLogger;


public class MyClass extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
    }
}
