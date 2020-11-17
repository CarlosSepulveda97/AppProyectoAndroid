package com.example.chooseus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Perfil extends AppCompatActivity {
//https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-name/Doublelift?api_key=RGAPI-55fce171-413b-4ec2-a408-00a78ed65ecf

    private ArrayList<String> planes = new ArrayList<>();
    private Spinner spin;
    private EditText edi1;
    private TextView tv1,tv2;


    private String[] lista = {"HAHDJA","DESC10","JIKSKK"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        getSupportActionBar().hide();

        tv1 = (TextView) findViewById(R.id.textView4);
        tv2 = (TextView) findViewById(R.id.textView2);
        edi1 = (EditText) findViewById(R.id.editTextTextPersonName2);
        edi1.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                tv1.setText("");
                for (String cod: lista) {
                    if (edi1.getText().toString().equalsIgnoreCase(cod)){
                        tv1.setText("Genial! un descuento suculento");
                    }

                }
                return false;
            }


        });

        spin = (Spinner) findViewById(R.id.spinner2);

        planes.add("Bronce");
        planes.add("Plata");
        planes.add("Oro");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, planes);
        spin.setAdapter(arrayAdapter);

    }

    public void guardar(View view){

        if(spin.getSelectedItem().toString().equals("Bronce")){
            int total = 5000;
            if (edi1.getText().toString().equalsIgnoreCase("HAHDJA")){
                total = 4800;

            }
            if (edi1.getText().toString().equalsIgnoreCase("DESC10")){
                total = 4500;
            }
            if (edi1.getText().toString().equalsIgnoreCase("JIKSKK")){
                total = 4000;
            }
            tv2.setText("El total del plan es de: " + total);
        }
        if(spin.getSelectedItem().toString().equals("Plata")){
            int total = 7000;
            if (edi1.getText().toString().equalsIgnoreCase("HAHDJA")){
                total = 6800;

            }
            if (edi1.getText().toString().equalsIgnoreCase("DESC10")){
                total = 6300;
            }
            if (edi1.getText().toString().equalsIgnoreCase("JIKSKK")){
                total = 6000;
            }
            tv2.setText("El total del plan es de: " + total);
        }
        if(spin.getSelectedItem().toString().equals("Oro")){
            int total = 9000;
            if (edi1.getText().toString().equalsIgnoreCase("HAHDJA")){
                total = 8800;

            }
            if (edi1.getText().toString().equalsIgnoreCase("DESC10")){
                total = 8100;
            }
            if (edi1.getText().toString().equalsIgnoreCase("JIKSKK")){
                total = 8000;
            }
            tv2.setText("El total del plan es de: " + total);
        }


        Toast.makeText(this, "Se guardo su suscripcion", Toast.LENGTH_SHORT).show();
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
        Intent intent = new Intent(this, Games.class);
        startActivity(intent);
    }

    public void onSettingsClick(MenuItem item){
        Intent intent = new Intent(this, Perfil.class);
        startActivity(intent);

    }

}