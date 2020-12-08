package com.example.allgoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Categories extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        getSupportActionBar().setTitle("Categories");

        ImageView imageView = (ImageView) findViewById(R.id.emotional);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Categories.this, Emotional.class);
                startActivity(intent);
            }
        });
        ImageView imageView2 = (ImageView) findViewById(R.id.motivational);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Categories.this, Motivational.class);
                startActivity(intent);
            }
        });
        ImageView imageView3 = (ImageView) findViewById(R.id.videos);
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Categories.this, Videos.class);
                startActivity(intent);
            }
        });
        ImageView imageView4 = (ImageView) findViewById(R.id.music);
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Categories.this, Music.class);
                startActivity(intent);
            }
        });
    }
}