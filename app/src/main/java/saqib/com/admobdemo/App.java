package saqib.com.admobdemo;

import android.app.Application;

import com.google.android.gms.ads.MobileAds;

/**
 *
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MobileAds.initialize(this, "ca-app-pub-2871096831416050~4670950630");
    }
}
