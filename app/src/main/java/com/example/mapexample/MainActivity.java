package com.example.mapexample;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.libraries.maps.GoogleMap;
import com.google.android.libraries.maps.OnMapReadyCallback;
import com.google.android.libraries.maps.SupportMapFragment;
import com.google.android.libraries.maps.model.BitmapDescriptorFactory;
import com.google.android.libraries.maps.model.LatLng;
import com.google.android.libraries.maps.model.Marker;
import com.google.android.libraries.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.InfoWindowAdapter, GoogleMap.OnInfoWindowClickListener {
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        if (supportMapFragment != null) {
            supportMapFragment.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng latLngObj = new LatLng(31.283598, 34.252791);
        MarkerOptions markerOptions = new MarkerOptions()
                .position(latLngObj)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_marker_default))
                .anchor(0.5f, 0.5f);
        mMap.addMarker(markerOptions);

        mMap.setInfoWindowAdapter(this);

        googleMap.setOnInfoWindowClickListener(this);



    }

    @Override
    public void onInfoWindowClick(Marker marker) {

    }

    @Nullable
    @Override
    public View getInfoWindow(@NonNull Marker marker) {
        View v = getLayoutInflater().inflate(R.layout.map_custom_info, null);

        TextView title = v.findViewById(R.id.map_custom_info_title);
        title.setText("wejdan murad");

        return v;
    }

    @Nullable
    @Override
    public View getInfoContents(@NonNull Marker marker) {
        return null;
    }
}