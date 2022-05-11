package com.example.cafinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class FindCarResults extends AppCompatActivity {

    TextView filterTextResult;
    RecyclerView filterCarResultRecyclerView;
    MyDatabaseHelper myDB;
    ArrayList<String> car_id, car_model, car_rates, car_type, company_owner;

    String getPassedCarType, getPassedClientID;
    FindCarResultCustomAdapter findCarResultCustomAdapter;

    private FindCarResultCustomAdapter.FindCarResultClickListener listener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_car_results);

        Bundle extras = getIntent().getExtras();
        getPassedClientID = extras.getString("clientID");
        Toast.makeText(this, getPassedClientID, Toast.LENGTH_SHORT).show();

        filterTextResult = findViewById(R.id.filterTextResult);
        Intent intent = getIntent();
        getPassedCarType = intent.getStringExtra(FindCarPopUpKey.CAR_TYPE);
        filterTextResult.setText("Result for Searching " + getPassedCarType);

        setOnClickListener();

        filterCarResultRecyclerView = findViewById(R.id.filterCarResultRecyclerView);
        myDB = new MyDatabaseHelper(FindCarResults.this);
        car_id = new ArrayList<>();
        car_model = new ArrayList<>();
        car_rates = new ArrayList<>();
        car_type = new ArrayList<>();
        company_owner = new ArrayList<>();

        displayData();

        findCarResultCustomAdapter = new FindCarResultCustomAdapter(FindCarResults.this, car_id, car_model, car_rates, car_type, company_owner, listener);
        filterCarResultRecyclerView.setAdapter(findCarResultCustomAdapter);
        filterCarResultRecyclerView.setLayoutManager(new LinearLayoutManager(FindCarResults.this));







    }

    private void setOnClickListener() {
        listener = new FindCarResultCustomAdapter.FindCarResultClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(), ViewCarDetails.class);
                intent.putExtra("carID", car_id.get(position));
                intent.putExtra("clientID", getPassedClientID);
                startActivity(intent);
            }
        };
    }

    public void displayData(){
        Cursor cursor = myDB.filterCars(getPassedCarType);

        if (cursor.getCount() == 0){
            Toast.makeText(this, "No Car Type Available", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                car_id.add(cursor.getString(0));
                car_model.add(cursor.getString(1));
                car_rates.add(cursor.getString(2));
                car_type.add(cursor.getString(11));
                company_owner.add(cursor.getString(4));
            }
        }
    }


}