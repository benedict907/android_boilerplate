package com.vip.exam.android_concepts.FBGOOGLEADDMOB;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class AddMobsActivity extends BaseActivity {

    private AdView mAdView;
    private Button btnFullscreenAd, btnShowRewardedVideoAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addmob);

        // initialize the AdMob app
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        /**
         * https://apps.admob.com/v2/apps/create
         * this site to create an add account for our package name use and create an ad unit
         * then copy the key values
           App id:    ca-app-pub-6436754528458537~2488692467
           unit id :  ca-app-pub-6436754528458537/4512220576
         **/

        btnShowRewardedVideoAd = (Button) findViewById(R.id.btn_show_rewarded_video);

        mAdView = (AdView) findViewById(R.id.adView);
       /* mAdView.setAdSize(AdSize.BANNER);
        mAdView.setAdUnitId(getString(R.string.normal_banner_id));*/

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                // Check the LogCat to get your test device ID
                //.addTestDevice("FD4C97AA9B6749D21C3A54605E988180") //
                .build();
        mAdView.loadAd(adRequest);

        /**
         * Project run time logcat to currespond device
         * test id get like,
         * AdRequest.Builder.addTestDevice("FD4C97AA9B6749D21C3A54605E988180")
         * lIve to go time this line remove to set and
         * valid app add id and banner id set
         * **/
        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
            }

            @Override
            public void onAdClosed() {
                Toast.makeText(getApplicationContext(), "Ad is closed!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                Toast.makeText(getApplicationContext(), "Ad failed to load! error code: " + errorCode, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdLeftApplication() {
                Toast.makeText(getApplicationContext(), "Ad left application!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
            }
        });



        setSnackBarView(mAdView);

        btnShowRewardedVideoAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showSnackBar("Vedio Loaded");

                debugLogD("Hello","Data");
                debugLogE("Hello","Error");

            /*    LogUtils.debugLogD("Hello","Data");
                LogUtils.debugLogE("Hello","Error");*/
/**
 * Dialog show fragment
 * **/
                MakeDialoge makeDialoge = new MakeDialoge(AddMobsActivity.this);
                makeDialoge.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                makeDialoge.setCancelable(false);
                makeDialoge.show();

            }
        });
    }

    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }
}
