package saqib.com.admobdemo.GridAds;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeContentAdView;

import java.util.List;

import saqib.com.admobdemo.Helpers.Logs;
import saqib.com.admobdemo.R;

/**
 *
 */

public class GridAdapter  extends  RecyclerView.Adapter<GridAdapter.MyViewHolder>{
    private Context context;
    private List<String> adsList;
    private AdRequest adRequest;

    public GridAdapter(Context context, List<String> adsList) {
        this.context = context;
        this.adsList = adsList;
        adRequest = new AdRequest.Builder()
                .build();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_grid_adapter, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //AdSize adSize = new AdSize(320,320);
        //holder.ads.setAdSize(adSize);

        //holder.ads.loadAd(adRequest);
        nativeAdView();
        adsCallback(holder.ads,position);
    }

    @Override
    public int getItemCount() {
        return adsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public NativeContentAdView ads;

        public MyViewHolder(View view) {
            super(view);
            ads = (NativeContentAdView) view.findViewById(R.id.ads);
        }
    }

    private void adsCallback(NativeContentAdView view, final int pos){

        /*view.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                Toast.makeText(context, pos+" is loaded!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdClosed() {
                Toast.makeText(context, pos+" is closed!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                Toast.makeText(context, pos+" failed to load! error code: " + errorCode, Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onAdLeftApplication() {
                Toast.makeText(context, pos+" left application!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdOpened() {
                Toast.makeText(context, pos+" is opened!", Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    private void nativeAdView(){
        AdLoader adLoader = new AdLoader.Builder(context, "ca-app-pub-3940256099942544/2247696110")
                .forAppInstallAd(new NativeAppInstallAd.OnAppInstallAdLoadedListener() {
                    @Override
                    public void onAppInstallAdLoaded(NativeAppInstallAd appInstallAd) {
                        // Show the app install ad.
                        Toast.makeText(context, "onAppInstallAdLoaded is !", Toast.LENGTH_SHORT).show();
                        Logs.p("NativeAppInstallAd Body: "+appInstallAd.getBody());
                        Logs.p("NativeAppInstallAd Headline : "+appInstallAd.getHeadline());
                        Logs.p("NativeAppInstallAd ChoicesInfo: "+appInstallAd.getAdChoicesInfo());
                        Logs.p("NativeAppInstallAd Icon : "+appInstallAd.getIcon());
                        Logs.p("NativeAppInstallAd Images: "+appInstallAd.getImages());
                        Logs.p("NativeAppInstallAd Price: "+appInstallAd.getPrice());
                        Logs.p("NativeAppInstallAd Rating : "+appInstallAd.getStarRating());
                        Logs.p("NativeAppInstallAd Store : "+appInstallAd.getStore());
                        Logs.p("NativeAppInstallAd CallToAction : "+appInstallAd.getCallToAction());
                    }
                })
                .forContentAd(new NativeContentAd.OnContentAdLoadedListener() {
                    @Override
                    public void onContentAdLoaded(NativeContentAd contentAd) {
                        // Show the content ad.
                        Toast.makeText(context, "onContentAdLoaded ads!", Toast.LENGTH_SHORT).show();
                    }
                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(int errorCode) {
                        // Handle the failure by logging, altering the UI, and so on.
                        Toast.makeText(context, errorCode+" ads!", Toast.LENGTH_SHORT).show();
                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()
                        // Methods in the NativeAdOptions.Builder class can be
                        // used here to specify individual options settings.
                        .build())
                .build();

        adLoader.loadAd(adRequest);

    }
}
