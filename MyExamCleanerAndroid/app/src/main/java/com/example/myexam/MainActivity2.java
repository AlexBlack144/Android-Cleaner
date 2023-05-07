package com.example.myexam;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener{
    private AdView mAdView2;
    TextView procent_20, charging_ti;
    ProgressBar progressBar2;
    Button btn_boost2, btn_raketa2, btn_battery2, btn_fan2, btn_trash2;
    static boolean flag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().hide();

        btn_boost2 = findViewById(R.id.btn_boost2);
        btn_boost2.setOnClickListener(this);
        btn_raketa2 = findViewById(R.id.btn_raketa2);
        btn_raketa2.setOnClickListener(this);
        btn_battery2 = findViewById(R.id.btn_battery2);
        btn_battery2.setOnClickListener(this);
        btn_fan2 = findViewById(R.id.btn_fan2);
        btn_fan2.setOnClickListener(this);
        btn_trash2 = findViewById(R.id.btn_trash2);
        btn_trash2.setOnClickListener(this);

        progressBar2 = findViewById(R.id.progress_circular2);

        charging_ti = findViewById(R.id.charging_ti);
        procent_20 = findViewById(R.id.procent_20);
        Typeface customFont2 = Typeface.createFromAsset(getAssets(),"fonts/a_lcdnova.ttf");
        procent_20.setTypeface(customFont2);

        mAdView2 = findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView2.loadAd(adRequest);
        mAdView2.setAdListener(new AdListener() {
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
            case R.id.btn_boost2:
                flag = true;
                progressBar2.setVisibility(View.VISIBLE);
                btn_boost2.setText("SCANNING");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        String hide = "hide_boost_battery";
                        Intent intent = new Intent(MainActivity2.this, FinalActivity.class);
                        intent.putExtra("hide_boost_battery", hide);
                        startActivity(intent);
                    }
                }, 3000);
                break;
            case R.id.btn_raketa2:
                Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivityForResult(intent, 0);
                overridePendingTransition(0,0);
                break;
            case R.id.btn_fan2:
                Intent intent2 = new Intent(this, MainActivity3.class);
                intent2.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivityForResult(intent2, 0);
                overridePendingTransition(0,0);

                break;
            case R.id.btn_trash2:
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
            btn_boost2.setText("OPTIMIZED");
            btn_boost2.setEnabled(false);
            btn_battery2.setForegroundTintList(ColorStateList.valueOf(Color.parseColor("#FFFFFFFF")));
            int procent = getRandomNumber(1,99);
            int h = getRandomNumber(1,23);
            int m = getRandomNumber(1,59);
            procent_20.setText(procent + "%");
            charging_ti.setText("Charging time remaning\n" + h + "h " + m + "m");
        }
    }
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}