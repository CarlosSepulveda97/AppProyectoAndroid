package com.example.chooseus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.chooseus.BBDD.AdminSQLiteOpenHelper;

public class Games extends AppCompatActivity {

    private EditText edcodigo, eduser, edgame, edrango;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);
        getSupportActionBar().hide();

        edcodigo = (EditText) findViewById(R.id.editTextTextPersonName6);
        eduser = (EditText) findViewById(R.id.editTextTextPersonName5);
        edgame = (EditText) findViewById(R.id.editTextTextPersonName4);
        edrango = (EditText) findViewById(R.id.editTextTextPersonName3);


    }

    public void guardar(View view){

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        if (!edcodigo.getText().toString().isEmpty()){
            ContentValues registro = new ContentValues();

            registro.put("codigo", edcodigo.getText().toString());
            registro.put("usuario", eduser.getText().toString());
            registro.put("game", edgame.getText().toString());
            registro.put("rango", edrango.getText().toString());

            bd.insert("clientes", null, registro);
            bd.close();
            Toast.makeText(this, "Se ha guardado un cliente", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this, "Debe agregar un codigo", Toast.LENGTH_SHORT).show();
        }
        refresh();

    }

    public void mostrar(View view){

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String codigo = edcodigo.getText().toString();

        if (!codigo.isEmpty()){

            Cursor fila = bd.rawQuery("SELECT usuario, game, rango FROM clientes WHERE codigo =" + codigo, null);

            if (fila.moveToFirst()){
                eduser.setText(fila.getString(0));
                edgame.setText(fila.getString(1));
                edrango.setText(fila.getString(2));
            }else{
                Toast.makeText(this, "Codigo no encontrado", Toast.LENGTH_SHORT).show();
                refresh();
            }
        }
        else{
            Toast.makeText(this, "Debe agregar un codigo", Toast.LENGTH_SHORT).show();
        }

    }

    public void eliminar(View view){

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String codigo = edcodigo.getText().toString();

        bd.delete("clientes", "codigo="+codigo, null);
        bd.close();

        Toast.makeText(this, "Eliminado", Toast.LENGTH_SHORT).show();

        refresh();

    }

    public void modificar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String codigo = edcodigo.getText().toString();

        if(!codigo.isEmpty()){

            ContentValues cont = new ContentValues();
            cont.put("codigo", edcodigo.getText().toString());
            cont.put("usuario", eduser.getText().toString());
            cont.put("game", edgame.getText().toString());
            cont.put("rango", edrango.getText().toString());

            bd.update("clientes", cont, "codigo="+codigo, null);
            Toast.makeText(this, "Actualizado", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this, "No encontrado", Toast.LENGTH_SHORT).show();
        }
        refresh();
    }

    public void refresh(){
        edcodigo.setText("");
        eduser.setText("");
        edgame.setText("");
        edrango.setText("");

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