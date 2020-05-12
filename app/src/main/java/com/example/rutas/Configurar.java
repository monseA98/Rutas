package com.example.rutas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Configurar extends AppCompatActivity {
    MapsActivity obj = new MapsActivity();
    EditText latitud;
    EditText longitud;
    LocationManager locationManager;
    Location location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurar);
        latitud = findViewById(R.id.txtLatitud);
        longitud = findViewById(R.id.txtLongitud);

        Button btnConfigurar = findViewById(R.id.btnConfigurar);


    }


    public void onClick(View view) {
        //LatLng destino = new LatLng(Double.parseDouble(longitud.getText().toString()), Double.parseDouble(latitud.getText().toString())); //Definimos el destino con las cajas de texto



        /*locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            Toast.makeText(this, "Se requiere definir los permisos", Toast.LENGTH_SHORT).show();

            return;
        }
        location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        LatLng origen = new LatLng(location.getLongitude(), location.getLatitude());*/



        //mandar a la otra actividad
        Intent intent = new Intent(this, MapsActivity.class);

        intent.putExtra("longitud_destino", Double.parseDouble(longitud.getText().toString()));
        intent.putExtra("latitud_destino", Double.parseDouble(latitud.getText().toString()));

        startActivity(intent);

    }



}
