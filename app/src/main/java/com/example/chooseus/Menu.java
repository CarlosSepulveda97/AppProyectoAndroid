package com.example.chooseus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Menu extends AppCompatActivity {

    private BottomAppBar appBar;
    private MenuItem menuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getSupportActionBar().hide();

    }


    public void onInfoClick(MenuItem item) {
        Toast.makeText(this, "Info", Toast.LENGTH_SHORT).show();//Video clash lol
    }

    public void onGamesClick(MenuItem item){
        Toast.makeText(this, "Games", Toast.LENGTH_SHORT).show();
    }

    public void onSettingsClick(MenuItem item){
        Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();

    }


}