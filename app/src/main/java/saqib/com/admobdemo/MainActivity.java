package saqib.com.admobdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import saqib.com.admobdemo.GridAds.GridAactivity1;
import saqib.com.admobdemo.NativeAdsAdvanced.NativeAdAdvancedActivity;

public class MainActivity extends AppCompatActivity {
    private AdView mAdView1;
    private AdView mAdView2,mAdView3,mAdView4,mAdView5,mAdView6,mAdView7,mAdView8;
    private AdRequest adRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      /*  mAdView1 = findViewById(R.id.adView1);
        mAdView2 = findViewById(R.id.adView2);
        mAdView3 = findViewById(R.id.adView3);
        mAdView4 = findViewById(R.id.adView4);
        mAdView5 = findViewById(R.id.adView5);
        mAdView6 = findViewById(R.id.adView6);
        mAdView7 = findViewById(R.id.adView7);
        mAdView8 = findViewById(R.id.adView8);


        adRequest = new AdRequest.Builder()
                .build();
*/
        //ad(mAdView1,"ad1");
        //ad(mAdView2,"ad2");
       // ad(mAdView3,"ad3");
       // ad(mAdView4,"ad4");
       // ad(mAdView5,"ad5");
       // ad(mAdView6,"ad6");
        //ad(mAdView7,"ad7");
        //ad(mAdView8,"ad8");


       /* Intent i = new Intent(MainActivity.this, GridAactivity1.class);
        startActivity(i);*/
        Intent i = new Intent(MainActivity.this, NativeAdAdvancedActivity.class);
        startActivity(i);


    }

    public void ad(AdView view,final String adReq){
        view.loadAd(adRequest);
        view.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                Toast.makeText(getApplicationContext(), adReq+" is loaded!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdClosed() {
                Toast.makeText(getApplicationContext(), adReq+" is closed!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                Toast.makeText(getApplicationContext(), adReq+" failed to load! error code: " + errorCode, Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onAdLeftApplication() {
                Toast.makeText(getApplicationContext(), adReq+" left application!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdOpened() {
                Toast.makeText(getApplicationContext(), adReq+" is opened!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private static void p(String s){
        System.out.println("----** : "+s);
    }
}
