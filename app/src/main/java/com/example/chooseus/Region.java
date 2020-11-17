package com.example.chooseus;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class Region extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ArrayList<String> regiones = new ArrayList<>();

    private Spinner spin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_region);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        regiones.add("Norte America");
        regiones.add("Latinoamerica");
        regiones.add("Asia");
        regiones.add("Europa");


        spin = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> regionesAdapt = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item , regiones);

        spin.setAdapter(regionesAdapt);




    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        Log.d("hola","entro");
        mMap = googleMap;
        LatLng sydney = new LatLng(40.990175, -101.863103);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Norte America"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (spin.getSelectedItem().toString().equals("Latinoamerica")){
                    LatLng sydney = new LatLng(-8.837444, -61.021028);
                    mMap.addMarker(new MarkerOptions().position(sydney).title("Latinoamerica"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

                }else if(spin.getSelectedItem().toString().equals("Norte America")){
                    LatLng sydney = new LatLng(40.990175, -101.863103);
                    mMap.addMarker(new MarkerOptions().position(sydney).title("Norte America"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

                }else if(spin.getSelectedItem().toString().equals("Europa")){
                    LatLng sydney = new LatLng(50.838237, 10.681065);
                    mMap.addMarker(new MarkerOptions().position(sydney).title("Europa"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

                }else if(spin.getSelectedItem().toString().equals("Asia")){
                    LatLng sydney = new LatLng(33.638104, 104.101762);
                    mMap.addMarker(new MarkerOptions().position(sydney).title("Asia"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));


                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        // Add a marker in Sydney and move the camera
        // LatLng sydney = new LatLng(-34, 151);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
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