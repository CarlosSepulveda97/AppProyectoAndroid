package com.example.chooseus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText ed1,ed2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        ed1 = (EditText) findViewById(R.id.pn);
        ed2 = (EditText) findViewById(R.id.pw);

    }

    public void login(View view){

        if (ed1.getText().toString().equalsIgnoreCase("user") &&
            ed2.getText().toString().equalsIgnoreCase("123") ){

        Intent intent = new Intent(this, Load.class);
        startActivity(intent);

    }else{
            Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
            ed1.setText("");
            ed2.setText("");
        }
    }
}