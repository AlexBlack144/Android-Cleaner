package com.example.myexam;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextPaint;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener{
    private AdView mAdView3;
    TextView gradus_31;
    ProgressBar progressBar3;
    Button btn_optimize, btn_raketa3, btn_battery3, btn_fan3, btn_trash3;
    static boolean flag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getSupportActionBar().hide();

        btn_optimize = findViewById(R.id.btn_optimize);
        btn_optimize.setOnClickListener(this);
        btn_raketa3 = findViewById(R.id.btn_raketa3);
        btn_raketa3.setOnClickListener(this);
        btn_battery3 = findViewById(R.id.btn_battery3);
        btn_battery3.setOnClickListener(this);
        btn_fan3    = findViewById(R.id.btn_fan3);
        btn_fan3.setOnClickListener(this);
        btn_trash3 = findViewById(R.id.btn_trash3);
        btn_trash3.setOnClickListener(this);

        progressBar3 = findViewById(R.id.progress_circular3);

        gradus_31 = findViewById(R.id.gradus_31);
        Typeface customFont2 = Typeface.createFromAsset(getAssets(),"fonts/a_lcdnova.ttf");
        gradus_31.setTypeface(customFont2);

        TextPaint paint = gradus_31.getPaint();
        float width = paint.measureText(gradus_31.getText().toString());
        Shader textShader = new LinearGradient(0, 0, width, gradus_31.getTextSize(),
                new int[]{
                        Color.parseColor("#F31935"),
                        Color.parseColor("#FF8F3E"),
                }, null, Shader.TileMode.CLAMP);
        gradus_31.getPaint().setShader(textShader);

        mAdView3 = findViewById(R.id.adView3);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView3.loadAd(adRequest);
        mAdView3.setAdListener(new AdListener() {
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
            case R.id.btn_optimize:
                flag = true;
                progressBar3.setVisibility(View.VISIBLE);
                btn_optimize.setText("SCANNING");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        String hide = "hide_boost_optimize";
                        Intent intent = new Intent(MainActivity3.this, FinalActivity.class);
                        intent.putExtra("hide_boost_optimize", hide);
                        startActivity(intent);
                    }
                }, 3000);
                break;
            case R.id.btn_raketa3:
                Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivityForResult(intent, 0);
                overridePendingTransition(0,0);
                break;
            case R.id.btn_battery3:
                Intent intent2 = new Intent(this, MainActivity2.class);
                intent2.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivityForResult(intent2, 0);
                overridePendingTransition(0,0);
                break;
            case R.id.btn_trash3:
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
            btn_optimize.setText("OPTIMIZED");
            btn_optimize.setEnabled(false);
            btn_fan3.setForegroundTintList(ColorStateList.valueOf(Color.parseColor("#FFFFFFFF")));
            int gradus = getRandomNumber(1,99);
            gradus_31.setText(gradus+"°C");
        }
    }
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}