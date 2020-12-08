package com.example.allgoods;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Sharethoughts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharethoughts);
        getSupportActionBar().setTitle("Share Thoughts");
    }
}