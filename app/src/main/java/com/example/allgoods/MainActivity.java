package com.example.allgoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {

    private GifImageView gifImageView;
    Thread timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gifImageView = (pl.droidsonroids.gif.GifImageView) findViewById(R.id.gifImageView);


        timer = new Thread() {
            public void run() {
                try {
                    sleep(9000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(MainActivity.this, StartingActivity.class);
                    startActivity(intent);
                }
            }
        };
        timer.start();
    }
    @Override
    public void onPause(){
        super.onPause();
        finish();

    }
}