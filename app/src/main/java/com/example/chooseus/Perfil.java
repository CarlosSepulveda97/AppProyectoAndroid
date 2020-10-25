package com.example.chooseus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Perfil extends AppCompatActivity {
//https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-name/Doublelift?api_key=RGAPI-55fce171-413b-4ec2-a408-00a78ed65ecf




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        getSupportActionBar().hide();
    }
}