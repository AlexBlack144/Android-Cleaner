package com.example.myexam;


import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView procent_95, gb_24_83_fr;
    Button btn_boost, btn_battery, btn_fan, btn_trash, btn_raketa;
    ProgressBar progressBar;
    private AdView mAdView;
    static boolean flag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        btn_boost = findViewById(R.id.btn_boost);
        btn_boost.setOnClickListener(this);
        btn_raketa = findViewById(R.id.btn_raketa);
        btn_raketa.setOnClickListener(this);
        btn_battery = findViewById(R.id.btn_battery);
        btn_battery.setOnClickListener(this);
        btn_fan = findViewById(R.id.btn_fan);
        btn_fan.setOnClickListener(this);
        btn_trash = findViewById(R.id.btn_trash);
        btn_trash.setOnClickListener(this);

        progressBar = findViewById(R.id.progress_circular);

        gb_24_83_fr = findViewById(R.id.gb_24_83_fr);
        procent_95 = findViewById(R.id.procent_95);
        Typeface customFont2 = Typeface.createFromAsset(getAssets(),"fonts/a_lcdnova.ttf");
        procent_95.setTypeface(customFont2);

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdClosed() {

            }
        });

    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onStart() {
        super.onStart();
        offButton();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_boost:
                flag = true;
                progressBar.setVisibility(View.VISIBLE);
                btn_boost.setText("SCANNING");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        String hide = "hide_boost";
                        Intent intent = new Intent(MainActivity.this, FinalActivity.class);
                        intent.putExtra("hide_boost", hide);
                        startActivity(intent);
                    }
                }, 3000);
                break;
            case R.id.btn_battery:
                Intent intent = new Intent(this, MainActivity2.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivityForResult(intent, 0);
                overridePendingTransition(0,0);
                break;
            case R.id.btn_fan:
                Intent intent2 = new Intent(this, MainActivity3.class);
                intent2.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivityForResult(intent2, 0);
                overridePendingTransition(0,0);
                break;
            case R.id.btn_trash:
                Intent intent3 = new Intent(this, MainActivity4.class);
                intent3.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivityForResult(intent3, 0);
                overridePendingTransition(0,0);
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void offButton(){
        if(flag){
            btn_boost.setText("OPTIMIZED");
            btn_boost.setEnabled(false);
            btn_raketa.setForegroundTintList(ColorStateList.valueOf(Color.parseColor("#FFFFFFFF")));
            int procent = getRandomNumber(1,99);
            double gb = getRandomNumber2(0.01,23.64);
            procent_95.setText(procent + "%");
            gb_24_83_fr.setText("23,64 Gb\n" + gb + " free space");
        }
    }
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    public double getRandomNumber2(double min, double max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}