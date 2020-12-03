package com.example.allgoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.allgoods.ui.categories.CategoriesFragment;

public class StartingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);

        Button start = findViewById(R.id.btnstart);
        start.setOnClickListener(v -> {
            Intent intent = new Intent(StartingActivity.this, Sidebar.class);
            startActivity(intent);
        });
    }
}