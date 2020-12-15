package com.example.allgoods;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class Emotional extends AppCompatActivity {

    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emotional);

        drawerLayout = findViewById(R.id.drawer_layout);
    }

    public void ClickMenuEmotional(View view){
        Sidebar.openDrawer(drawerLayout);
    }

    public void Clicklogo(View view){
        //close drawer
        Sidebar.closeDrawer(drawerLayout);
    }

    public void ClickCategories(View view){
        Sidebar.redirectActivity(this, Categories.class);
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