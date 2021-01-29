package com.example.allgoods;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.OnFullscreenListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerFullScreenListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import org.jetbrains.annotations.NotNull;

public class Videos extends AppCompatActivity{
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);
        drawerLayout = findViewById(R.id.drawer_layout);

        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);

        ImageView imageView = findViewById(R.id.videos_click);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Videos.this, Categories.class);
                startActivity(intent);
            }
        });


    }
    public void ClickMenuVideos(View view){
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