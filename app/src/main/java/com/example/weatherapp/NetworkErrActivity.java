package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class NetworkErrActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        //Log.i("返回键","按下了返回键");
        finish();
        finishAffinity();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_err);
    }
}