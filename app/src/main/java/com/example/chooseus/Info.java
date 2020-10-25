package com.example.chooseus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.VideoView;

public class Info extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        getSupportActionBar().hide();

        VideoView videoview = (VideoView) findViewById(R.id.videoView2);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.info2);
        videoview.setVideoURI(uri);

        videoview.start();

    }



    public void onInfoClick(MenuItem item) {

    }

    public void onGamesClick(MenuItem item){
        Toast.makeText(this, "Games", Toast.LENGTH_SHORT).show();
    }

    public void onSettingsClick(MenuItem item){
        Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();

    }



}