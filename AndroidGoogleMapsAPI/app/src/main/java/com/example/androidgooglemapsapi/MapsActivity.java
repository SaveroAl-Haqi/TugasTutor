package com.example.androidgooglemapsapi;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.example.androidgooglemapsapi.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Membuat objek SupportMapFragment untuk mendapatkan notifikas saat map siap digunakan
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    /*
        Ketika map tersedia, maka map akan di manipulasi seperti mengatur posisi map langsung
        ke posisi Longitude Latitude yang kita tentukan. Dalam kasus ini JL. Petogogan I No. 41
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Menambahkan marker ko lokasi yang kita tentukan
        LatLng petogogan = new LatLng(-6.252828, 106.794783);
        mMap.addMarker(new MarkerOptions().position(petogogan).title("Jl. Petogogan I No. 41"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(petogogan));
    }
}
