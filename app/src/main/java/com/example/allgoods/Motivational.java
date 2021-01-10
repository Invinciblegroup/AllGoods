package com.example.allgoods;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Motivational extends AppCompatActivity {
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motivational);

        drawerLayout = findViewById(R.id.drawer_layout);

        ImageView imageView = findViewById(R.id.motivational1);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Motivational.this, Motivational1.class);
                startActivity(intent);
            }
        });
    }
    public void Motivational(View view){

        Sidebar.openDrawer(drawerLayout);
    }

    public void Clicklogo(View view){
        //close drawer
        Sidebar.closeDrawer(drawerLayout);
    }

    public void ClickCategories(View view){
        Sidebar.redirectActivity(this, Sidebar.class);
    }
    public void ClickSharethoughts(View view){
        //redirect to sharethoughts
        Sidebar.redirectActivity(this, Sharethoughts.class);
    }

    public void ClickAboutus(View view){
        //recreate activity
        Sidebar.redirectActivity(this, Aboutus.class);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //close drawer
        Sidebar.closeDrawer(drawerLayout);
    }
}