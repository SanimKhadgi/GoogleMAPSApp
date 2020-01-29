package com.example.googlemapsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Marker;

import java.util.List;

public class SearchActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private AutoCompleteTextView etCity;
    private Button btnSearch;
    private List<Model>latLngsList;
    Marker markerName;
    CameraUpdate center,zoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        SupportMapFragment mapFragment=(SupportMapFragment) getSupportFragmentManager() .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        etCity=findViewById(R.id.etCity);
        btnSearch=findViewById(R.id.btnSearch);

        fillArrayListAndSetAdapter();
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etCity.setError("Please enter a place name");
                return;
            }
            int position=SearchArrayList(etCity.getText()).toString());
            if(position>-1)
            loadMap(position);
            else
            Toast
        });


    }
}
