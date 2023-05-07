package com.example.myexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class SplashScrean extends AppCompatActivity  implements View.OnClickListener{
    CheckBox checkbox_start;
    Button btn_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screan);
        getSupportActionBar().hide();
        checkbox_start = findViewById(R.id.checkbox_start);
        btn_start = findViewById(R.id.btn_start);
        checkbox_start.setOnClickListener(this);
        btn_start.setOnClickListener(this);

        checkbox_start.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                    btn_start.setEnabled(true);
                }else{
                    btn_start.setEnabled(false);
                }
            }
        });
    }
    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btn_start:
                startActivity(new Intent(SplashScrean.this, SplashScrean2.class));
        }
    }
}