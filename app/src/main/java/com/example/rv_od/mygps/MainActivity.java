package com.example.rv_od.mygps;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LocationListener {

    TextView Resultado;
    LocationManager Gps;
    float lati = 0,longi = 0,lava,lova,res1,res2,distanciat,distancia1,distancia2,diametro = 6371;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resultado = (TextView) findViewById(R.id.Pantalla);
        Gps = (LocationManager) getSystemService(LOCATION_SERVICE);
        Gps.requestLocationUpdates(LocationManager.GPS_PROVIDER,2000,3, this);
    }

    @Override
    public void onLocationChanged(Location location) {
        if (lati == 0 && longi == 0)
        {
            lati = location.getLatitud();
            longi = location.getLongitude();
            Resultado.setText("\n Latitud: " + location.getLatitude());
            Resultado.append("\n Longitud: " + location.getLongitude());
            res1 = Math.sqrt(Math.pow(lati-0)+Math.pow(longi-0))
        }
        else 
        {
            res2 = Math.sqrt(Math.pow(lava-lati)+Math.pow(lova-longi))
        }
        distancia1 =  res1 * diametro;
        distancia2 =  res2 * diametro;
        distanciat = (diastancia2 - distancia1) * 1000;
        Resultado.append("\n Distancia: " + distanciat + "m")
        
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
        Pantalla.setText("Prende el GPS:");
    }
}
