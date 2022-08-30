package com.example.admobtesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.gms.ads.rewarded.RewardItem
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback

class MainActivity : AppCompatActivity() {

    var mInterstitialAd: InterstitialAd? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lateinit var mAdView : AdView



        /* ca-app-pub-3560802488472325/6075651003 */



        findViewById<TextView>(R.id.tvbtn).text=BuildConfig.AD_ID

        val adRequest= AdRequest.Builder().build()
        InterstitialAd.load(this,resources.getString(R.string.INTERSTITIAL_ADD_ID), adRequest, object : InterstitialAdLoadCallback() {
            override fun onAdFailedToLoad(adError: LoadAdError) {
                Log.d("messi3", "Interstial error")
                mInterstitialAd = null
            }

            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                Log.d("messi3", "Interstial Loaded")
                mInterstitialAd = interstitialAd

            }
        })

        mAdView = findViewById(R.id.adView)
        mAdView.loadAd(adRequest)

        mAdView.adListener = object: AdListener() {
            override fun onAdClicked() {
            }

            override fun onAdClosed() {

            }

            override fun onAdFailedToLoad(adError : LoadAdError) {
            }

            override fun onAdImpression() {

            }

            override fun onAdLoaded() {
            }

            override fun onAdOpened() {
            }
        }





        findViewById<TextView>(R.id.tvbtn).setOnClickListener {
            mInterstitialAd?.show(this@MainActivity)
        }




    }
}