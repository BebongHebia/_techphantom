package com.example.cafinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class PlacesToVisitSearch extends AppCompatActivity {

    Spinner selectPlacesSpinner;
    TextView mapShow_TV;
    ImageView imageMap;
    String clientID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.places_to_visit_search);

        Intent intent = getIntent();

        selectPlacesSpinner = findViewById(R.id.selectPlacesSpinner);

        mapShow_TV = findViewById(R.id.mapShow_TV);
        imageMap = findViewById(R.id.imageMap);

        ArrayAdapter<CharSequence> adapter_selectPlacesSpinner =  ArrayAdapter.createFromResource(this, R.array.placesToVisit, android.R.layout.simple_spinner_item);
        adapter_selectPlacesSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectPlacesSpinner.setAdapter(adapter_selectPlacesSpinner);

        Button searchPlaceButton = findViewById(R.id.searchPlaceButton);

        searchPlaceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectPlacesSpinner_str = selectPlacesSpinner.getSelectedItem().toString();
                if (selectPlacesSpinner_str.equals("Malaybalay City")){
                    mapShow_TV.setVisibility(View.VISIBLE);
                    imageMap.setVisibility(View.VISIBLE);

                }
                else if (selectPlacesSpinner_str.equals("Valencia City")){
                    mapShow_TV.setVisibility(View.VISIBLE);
                    imageMap.setVisibility(View.VISIBLE);
                    imageMap.setImageResource(R.drawable.valencia_map);
                }
                else if (selectPlacesSpinner_str.equals("Municipality of Lantapan")){
                    mapShow_TV.setVisibility(View.VISIBLE);
                    imageMap.setVisibility(View.VISIBLE);
                    imageMap.setImageResource(R.drawable.lantapan_map);
                }
                else{
                    Toast.makeText(PlacesToVisitSearch.this,"Sorry Map is Still Unloaded", Toast.LENGTH_SHORT).show();
                }
            }
        });

        imageMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectPlacesSpinner_str = selectPlacesSpinner.getSelectedItem().toString();
                gotoGoogleMap("https://www.google.com/maps/place/ '"+ selectPlacesSpinner_str +"'");
            }
        });

        Button findPlacesFindCarNow = findViewById(R.id.findPlacesFindCarNow);
        findPlacesFindCarNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFindPopUpKey();
            }
        });

        clientID = intent.getStringExtra("clientID");


    }

    public void gotoGoogleMap(String places){
        Uri uri = Uri.parse(places);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }

    public void openFindPopUpKey(){
        Intent intent = new Intent(this, FindCarPopUpKey.class);
        intent.putExtra("clientID", clientID);
        startActivity(intent);

    }
}