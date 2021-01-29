package com.example.allgoods;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class Music extends AppCompatActivity {

    ImageView play, prev, next, imagview;
    TextView songTitle;
    SeekBar mSeekBarTime, mSeekBarVol;
    static MediaPlayer mMediaPlayer;
    private Runnable runnable;
    private AudioManager audioManager;
    int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        play = findViewById(R.id.play);
        prev = findViewById(R.id.prev);
        next = findViewById(R.id.next);
        songTitle = findViewById(R.id.songTitle);
        mSeekBarTime = findViewById(R.id.seeBarTime);
        mSeekBarVol = findViewById(R.id.seeBarVol);
        imagview = findViewById(R.id.imagview);

        ImageView imageView = findViewById(R.id.music_click);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Music.this, Categories.class);
                startActivity(intent);
            }
        });

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Integer> songs = new ArrayList<>();
        songs.add(0, R.raw.balangaraw);
        songs.add(1, R.raw.howwouldyoufeel);
        songs.add(2, R.raw.mylove);
        songs.add(3, R.raw.canwekissforever);
        songs.add(4, R.raw.coldplayyellow);
        songs.add(5, R.raw.culturecode);
        songs.add(6, R.raw.halloffame);
        songs.add(7, R.raw.pureimagination);
        songs.add(8, R.raw.superheroes);
        songs.add(9, R.raw.supermarketflowers);
        songs.add(10, R.raw.whenilookatyou);
        songs.add(11, R.raw.plainwhite);

        mMediaPlayer = MediaPlayer.create(getApplicationContext(), songs.get(currentIndex));

        int maxV = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curV = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        mSeekBarVol.setMax(maxV);
        mSeekBarVol.setProgress(curV);

        mSeekBarVol.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        play.setOnClickListener(v -> {
            mSeekBarTime.setMax(mMediaPlayer.getDuration());
            if(mMediaPlayer != null && mMediaPlayer.isPlaying()){
                mMediaPlayer.pause();
                play.setImageResource(R.drawable.play);
            } else{
                mMediaPlayer.start();
                play.setImageResource(R.drawable.pause);
            }
            SongNames();
        });

        next.setOnClickListener(v -> {
            if(mMediaPlayer != null){
                play.setImageResource(R.drawable.pause);
            }
            if(currentIndex < songs.size() - 1){
                currentIndex ++;
            } else {
                currentIndex = 0;
            }
            if(mMediaPlayer.isPlaying()){
                mMediaPlayer.stop();
            }
            mMediaPlayer = MediaPlayer.create(getApplicationContext(), songs.get(currentIndex));
            mMediaPlayer.start();
            SongNames();
        });

        prev.setOnClickListener(v -> {
            if(mMediaPlayer != null){
                play.setImageResource(R.drawable.pause);
            }
            if(currentIndex > 0){
                currentIndex--;
            } else{
                currentIndex = songs.size() -1;
            }
            if(mMediaPlayer.isPlaying()){
                mMediaPlayer.stop();
            }
            mMediaPlayer = MediaPlayer.create(getApplicationContext(), songs.get(currentIndex));
            mMediaPlayer.start();
            SongNames();
        });

        mSeekBarTime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    mMediaPlayer.seekTo(progress);
                    mSeekBarTime.setProgress(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    private  void SongNames(){
        if(currentIndex == 0){
            songTitle.setText("I Belong to the zoo - Balang Araw");
            imagview.setImageResource(R.drawable.ibelongtothezoo);
        }
        if(currentIndex == 1){
            songTitle.setText("how Would You Feel - Ed Sheeran");
            imagview.setImageResource(R.drawable.edsheeran);
        }
        if(currentIndex == 2){
            songTitle.setText("My Love - Westlife");
            imagview.setImageResource(R.drawable.westlife);
        }
        if(currentIndex == 0){
            songTitle.setText("Kina - Can We Kiss Forever");
            imagview.setImageResource(R.drawable.kina);
        }
        if(currentIndex == 1){
            songTitle.setText("Coldplay - Yellow");
            imagview.setImageResource(R.drawable.coldplay);
        }
        if(currentIndex == 2){
            songTitle.setText("Culture Code - Make Me Move ft. Karra");
            imagview.setImageResource(R.drawable.ncs);
        }
        if(currentIndex == 0){
            songTitle.setText("The Script -  Hall of Fame");
            imagview.setImageResource(R.drawable.thescript);
        }
        if(currentIndex == 1){
            songTitle.setText("Angelo Javier Cover - Pure Imagination");
            imagview.setImageResource(R.drawable.pureimagination);
        }
        if(currentIndex == 2){
            songTitle.setText("The Script - Superheroes");
            imagview.setImageResource(R.drawable.thescript);
        }
        if(currentIndex == 0){
            songTitle.setText("Coldplay - Supermarket Flowers");
            imagview.setImageResource(R.drawable.coldplay);
        }
        if(currentIndex == 1){
            songTitle.setText("Miley Cyrus - When I Look At You");
            imagview.setImageResource(R.drawable.mileycyrus);
        }
        if(currentIndex == 2){
            songTitle.setText("Plain White - 1,2,3,4");
            imagview.setImageResource(R.drawable.plainwhite);
        }
        mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mSeekBarTime.setMax(mMediaPlayer.getDuration());
                mMediaPlayer.start();
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mMediaPlayer != null){
                    try{
                        if(mMediaPlayer.isPlaying()){
                            Message message = new Message();
                            message.what = mMediaPlayer.getCurrentPosition();
                            handler.sendMessage(message);
                            Thread.sleep(1000);
                        }
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
    @SuppressLint("HandlerLeak")
    Handler handler = new Handler(){

        @Override
        public void handleMessage(@NonNull Message msg) {
            mSeekBarTime.setProgress(msg.what);
        }
    };
}