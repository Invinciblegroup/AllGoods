package com.example.allgoods;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowInsets;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.ui.AppBarConfiguration;

public class Sidebar extends AppCompatActivity {

   DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sidebar);

        drawerLayout = findViewById(R.id.drawer_layout);

        ImageView imageView = findViewById(R.id.emotional);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sidebar.this, Emotional.class);
                startActivity(intent);
            }
        });
        ImageView imageView1 = findViewById(R.id.motivational);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sidebar.this, Motivational.class);
                startActivity(intent);
            }
        });
        ImageView imageView2 = findViewById(R.id.videos);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sidebar.this, Videos.class);
                startActivity(intent);
            }
        });
        ImageView imageView3 = findViewById(R.id.music);
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sidebar.this, Music.class);
                startActivity(intent);
            }
        });
    }

    public void ClickMenu1(View view){

        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        //open drawer layout
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void Clicklogo(View view){
        //Close Drawer
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        //Close drawer layout
        //check condition
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            //when the drawer is open
            //close drawer
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickCategories(View view){
        //Recreate activity
        recreate();
    }

    public void ClickSharethoughts(View view){
        //Redirect activity to Sharethoughts
        redirectActivity(this,Sharethoughts.class);
    }
    public void ClickAboutus(View view){
        redirectActivity(this,Aboutus.class);
    }

    public static void redirectActivity(Activity activity, Class aclass) {
        //initialize intent
        Intent intent = new Intent(activity,aclass);
        //set flags
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //start activity
        activity.startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //close drawer
        closeDrawer(drawerLayout);
    }
}