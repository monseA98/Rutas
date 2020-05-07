package com.example.rutas;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Location;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Configurar extends AppCompatActivity {
    MapsActivity obj = new MapsActivity();
    TextView latitud = findViewById(R.id.txtLatitud);
    TextView longitud = findViewById(R.id.txtLongitud);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurar);
        latitud = findViewById(R.id.txtLatitud);
        longitud = findViewById(R.id.txtLongitud);

        Button btnConfigurar = findViewById(R.id.btnConfigurar);
        //longitud es x

    }



    public void onClick (View view) {
        LatLng destino = new LatLng(Double.parseDouble(longitud.toString()),Double.parseDouble(latitud.toString())); //Definimos el destino con las cajas de texto

        MarkerOptions marcadorDestino= new MarkerOptions();
        marcadorDestino.position(destino);
        marcadorDestino.title("Este es tu destino");
        marcadorDestino.icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("ic_marcador_destino",80,80)));
        obj.mMap.addMarker(marcadorDestino);



        String url = obtenerDireccionesURL(origen.getPosition(), destino);
        DownloadTask downloadTask = new DownloadTask();
        downloadTask.execute(url);
    }

    private String obtenerDireccionesURL(LatLng origin,LatLng dest){

        String str_origin = "origin="+origin.latitude+","+origin.longitude;

        String str_dest = "destination="+dest.latitude+","+dest.longitude;

        String sensor = "sensor=false";

        String parameters = str_origin+"&"+str_dest+"&"+sensor;

        String output = "json";

        String url = "https://maps.googleapis.com/maps/api/directions/"+output+"?"+parameters;

        return url;
    }


}
