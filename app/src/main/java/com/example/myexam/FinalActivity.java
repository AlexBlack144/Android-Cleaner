package com.example.myexam;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;

import java.util.Objects;

public class FinalActivity extends AppCompatActivity implements View.OnClickListener{
    TextView text_C;
    Button btn_back, btn_boost_banner, btn_boost_battery_banner, btn_optimize_banner, btn_clean_banner;
    private AdView mAdView5;
    LinearLayout banner_boost, banner_boost_battery, banner_optimize, banner_clean;
    static int A=0;
    static int B=0;
    static int C=0;
    static int D=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        getSupportActionBar().hide();

        banner_boost = findViewById(R.id.banner_boost);
        banner_boost_battery = findViewById(R.id.banner_boost_battery);
        banner_optimize = findViewById(R.id.banner_optimize);
        banner_clean = findViewById(R.id.banner_clean);

        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(this);
        btn_boost_banner= findViewById(R.id.btn_boost_banner);
        btn_boost_banner.setOnClickListener(this);
        btn_boost_battery_banner = findViewById(R.id.btn_boost_battery_banner);
        btn_boost_battery_banner.setOnClickListener(this);
        btn_optimize_banner = findViewById(R.id.btn_optimize_banner);
        btn_optimize_banner.setOnClickListener(this);
        btn_clean_banner = findViewById(R.id.btn_clean_banner);
        btn_clean_banner.setOnClickListener(this);

        text_C= findViewById(R.id.text_C);
        TextPaint paint = text_C.getPaint();
        float width = paint.measureText(text_C.getText().toString());
        Shader textShader = new LinearGradient(0, 0, width, text_C.getTextSize(),
                new int[]{
                        Color.parseColor("#F31935"),
                        Color.parseColor("#FF8F3E"),
                }, null, Shader.TileMode.CLAMP);
        text_C.getPaint().setShader(textShader);

        mAdView5 = findViewById(R.id.adView5);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView5.loadAd(adRequest);
        mAdView5.setAdListener(new AdListener() {
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
    @Override
    protected void onStart() {
        super.onStart();
        bannerСhecking();
        if(A==1){banner_boost.setVisibility(View.GONE);}
        if(B==1){banner_boost_battery.setVisibility(View.GONE);}
        if(C==1){banner_optimize.setVisibility(View.GONE);}
        if(D==1){banner_clean.setVisibility(View.GONE);}
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
        switch (view.getId()) {
            case R.id.btn_back:
            case R.id.btn_boost_banner:
                startActivity(new Intent(FinalActivity.this, MainActivity.class));
                break;
            case R.id.btn_boost_battery_banner:
                startActivity(new Intent(FinalActivity.this, MainActivity2.class));
                break;
            case R.id.btn_optimize_banner:
                startActivity(new Intent(FinalActivity.this, MainActivity3.class));
                break;
            case R.id.btn_clean_banner:
                startActivity(new Intent(FinalActivity.this, MainActivity4.class));
                break;
        }
    }
    public void bannerСhecking(){
        Intent intent = getIntent();
        String hide_boost = intent.getStringExtra("hide_boost");
        String hide_boost_battery = intent.getStringExtra("hide_boost_battery");
        String hide_boost_optimize = intent.getStringExtra("hide_boost_optimize");
        String hide_boost_trash = intent.getStringExtra("hide_boost_trash");

        if(Objects.equals(hide_boost, "hide_boost")) {A=1;}
        else if(Objects.equals(hide_boost_battery, "hide_boost_battery")) {B=1;}
        else if(Objects.equals(hide_boost_optimize, "hide_boost_optimize")){C=1;}
        else if(Objects.equals(hide_boost_trash, "hide_boost_trash")){D=1;}
        else {return;}
    }
}