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

public class MainActivity4 extends AppCompatActivity implements View.OnClickListener{
    private AdView mAdView4;
    TextView procent_95_2, gb_24_83_fr_2;
    ProgressBar progressBar4;
    Button btn_clean, btn_raketa4, btn_battery4, btn_fan4, btn_trash4;
    static boolean flag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        getSupportActionBar().hide();

        btn_clean = findViewById(R.id.btn_clean);
        btn_clean.setOnClickListener(this);
        btn_raketa4 = findViewById(R.id.btn_raketa4);
        btn_raketa4.setOnClickListener(this);
        btn_battery4 = findViewById(R.id.btn_battery4);
        btn_battery4.setOnClickListener(this);
        btn_fan4 = findViewById(R.id.btn_fan4);
        btn_fan4.setOnClickListener(this);
        btn_trash4 = findViewById(R.id.btn_trash4);
        btn_trash4.setOnClickListener(this);

        progressBar4 = findViewById(R.id.progress_circular4);


        gb_24_83_fr_2 = findViewById(R.id.gb_24_83_fr_2);
        procent_95_2 = findViewById(R.id.procent_95_2);
        Typeface customFont2 = Typeface.createFromAsset(getAssets(),"fonts/a_lcdnova.ttf");
        procent_95_2.setTypeface(customFont2);

        mAdView4 = findViewById(R.id.adView4);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView4.loadAd(adRequest);
        mAdView4.setAdListener(new AdListener() {
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
            case R.id.btn_clean:
                flag = true;
                progressBar4.setVisibility(View.VISIBLE);
                btn_clean.setText("SCANNING");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        String hide = "hide_boost_trash";
                        Intent intent = new Intent(MainActivity4.this, FinalActivity.class);
                        intent.putExtra("hide_boost_trash", hide);
                        startActivity(intent);
                    }
                }, 3000);
                break;
            case R.id.btn_raketa4:
                Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivityForResult(intent, 0);
                overridePendingTransition(0,0);
                break;
            case R.id.btn_battery4:
                startActivity(new Intent(MainActivity4.this, MainActivity2.class));
                Intent intent2 = new Intent(this, MainActivity2.class);
                intent2.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivityForResult(intent2, 0);
                overridePendingTransition(0,0);
                break;
            case R.id.btn_fan4:
                Intent intent3 = new Intent(this, MainActivity3.class);
                intent3.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivityForResult(intent3, 0);
                overridePendingTransition(0,0);
                break;
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void offButton(){
        if(flag){
            btn_clean.setText("OPTIMIZED");
            btn_clean.setEnabled(false);
            btn_trash4.setForegroundTintList(ColorStateList.valueOf(Color.parseColor("#FFFFFFFF")));
            int procent = getRandomNumber(1,99);
            double gb = getRandomNumber2(0.01,23.64);
            procent_95_2.setText(procent + "%");
            gb_24_83_fr_2.setText("23,64 Gb\n" + gb + " free space");
        }
    }
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    public double getRandomNumber2(double min, double max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}