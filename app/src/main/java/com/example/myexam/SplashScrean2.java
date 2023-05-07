package com.example.myexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SplashScrean2 extends AppCompatActivity {

    TextView textView;
    ProgressBar progressBar;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screan2);
        getSupportActionBar().hide();
        textView = findViewById(R.id.procent);
        Typeface customFont = Typeface.createFromAsset(getAssets(),"fonts/a_lcdnova.ttf");
        textView.setTypeface(customFont);
        progressBar = findViewById(R.id.progressBar);

        doStartProgressBar();
    }
    private void doStartProgressBar()  {
        final int MAX = 110;
        this.progressBar.setMax(MAX);
        Thread thread = new Thread(new Runnable()  {
            @Override
            public void run() {
                for( int i =0; i < MAX; i++) {
                    final int progress = i + 1;
                    SystemClock.sleep(30);
                    handler.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(progress);
                            int percent = (progress * 100) / MAX;

                            textView.setText(percent + " %");
                            if(progress == MAX)  {
                                textView.setText("100");
                            }
                        }
                    });
                }
                startActivity(new Intent(SplashScrean2.this, MainActivity.class));
                finish();
            }
        });
        thread.start();
    }
}