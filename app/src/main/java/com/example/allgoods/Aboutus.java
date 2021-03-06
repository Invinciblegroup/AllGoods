package com.example.allgoods;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class Aboutus extends AppCompatActivity {

    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);

        drawerLayout = findViewById(R.id.drawer_layout);
    }

    public void ClickMenu1(View view){
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
        recreate();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //close drawer
        Sidebar.closeDrawer(drawerLayout);
    }
}