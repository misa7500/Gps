package com.example.rv_od.mygps;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LocationListener {

    TextView Pantalla;
    LocationManager Ontoy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Pantalla = (TextView) findViewById(R.id.Pantalla);
        Ontoy = (LocationManager) getSystemService(LOCATION_SERVICE);
        Ontoy.requestLocationUpdates(LocationManager.GPS_PROVIDER,2000,3, this);
    }

    @Override
    public void onLocationChanged(Location location) {
        Pantalla.setText("\n Latitud: " + location.getLatitude());
        Pantalla.append("\n Longitud: " + location.getLongitude());
        Pantalla.append("\n Altura: " + location.getAltitude() + " m");
        Pantalla.append("\n Velocidad: " + location.getSpeed() + " m/s");
        Pantalla.append("\n Exactitud: " + location.getAccuracy() + " m");
        Pantalla.append("\n Orientacion: " + location.getBearing() + " N");
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {
        Pantalla.setText("Gracias");
    }

    @Override
    public void onProviderDisabled(String s) {
        Pantalla.setText("Prende el GPS PLOX");
    }
}
