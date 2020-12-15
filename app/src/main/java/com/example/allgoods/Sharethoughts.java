package com.example.allgoods;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class Sharethoughts extends AppCompatActivity {
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharethoughts);

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
        //redirect to categories
        Sidebar.redirectActivity(this, Sidebar.class);
    }

    public void ClickSharethoughts(View view){
        //recreate activity
        Sidebar.redirectActivity(this, Sharethoughts.class);
    }

    public void ClickAboutus(View view){
        //redirect to about us
        Sidebar.redirectActivity(this, Aboutus.class);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //close drawer
        Sidebar.closeDrawer(drawerLayout);
    }
}