package com.example.chooseus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.chooseus.interfaces.GameApi;
import com.example.chooseus.models.Game;
import com.example.chooseus.models.TwitchRespuesta;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Menu extends AppCompatActivity {

    private Retrofit retrofit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getSupportActionBar().hide();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.twitch.tv/kraken/games/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        obtenerDatos();

    }

    private void obtenerDatos() {

        GameApi service = retrofit.create(GameApi.class);
        final Call<TwitchRespuesta> apiCall = service.obtenerListaJuegos();

        apiCall.enqueue(new Callback<TwitchRespuesta>() {
            @Override
            public void onResponse(Call<TwitchRespuesta> call, Response<TwitchRespuesta> response) {

                    if (response.isSuccessful()){
                        TwitchRespuesta resp = response.body();
                        
                        /*
                        ArrayList<Game> lista = resp.getResults();
                        for (int i=0; i< lista.size(); i++){
                            Game p = lista.get(i);
                            Log.e("Nombre", "onResponse: "+p.getName());
                        }
                        */
                    }else{
                        Log.e("holi", "onResponse: "+call.toString());
                        Log.e("Tag","errrrrrrrrrrorrrrrrrrrrrrrrrrrr");
                    }

            }

            @Override
            public void onFailure(Call<TwitchRespuesta> call, Throwable t) {

            }
        });
    }


    public void onPlayClick(View view){
        Intent intent = new Intent(this, Region.class);
        startActivity(intent);
    }

    public void onInfoClick(MenuItem item) {
        Intent intent = new Intent(this,Info.class);
        startActivity(intent);
    }

    public void onGamesClick(MenuItem item){
        Toast.makeText(this, "Games", Toast.LENGTH_SHORT).show();
    }

    public void onSettingsClick(MenuItem item){
        Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();

    }


}