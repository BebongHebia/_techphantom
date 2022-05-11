package com.example.cafinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class BusinessOwnerReports extends AppCompatActivity {
    MyDatabaseHelper myDB = new MyDatabaseHelper(BusinessOwnerReports.this);

    String companyName, companyID, companyAddress, historyID;
    TextView businessOwnerReports_BusinessOwner_TextView, businessOwnerReports_BusinessAddress_TextView, reportsNumberOfBooking_TV, reportsNumberOfCars_TV;


    ArrayList<String> booking_id, booker_FullName, bookerCar_modelName;
    CustomAdapterForReports customAdapterForReports;
    RecyclerView reportRecyclerView;

    private CustomAdapterForReports.ReportsClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.business_owner_reports);

        setOnClickListener();



        booking_id = new ArrayList<>();
        booker_FullName = new ArrayList<>();
        bookerCar_modelName = new ArrayList<>();

        reportRecyclerView = findViewById(R.id.reports_RecyclerView);
        customAdapterForReports = new CustomAdapterForReports(BusinessOwnerReports.this, booking_id, booker_FullName, bookerCar_modelName, listener);
        reportRecyclerView.setAdapter(customAdapterForReports);
        reportRecyclerView.setLayoutManager(new LinearLayoutManager(BusinessOwnerReports.this));

        displayData();




        Bundle intent = getIntent().getExtras();

        companyName = intent.getString("businessOwnerName");

        companyID = intent.getString("companyID");
        companyAddress = intent.getString("companyAddress");

        int count = myDB.myCompanyBookingCount(companyID);
        String numberOfCompanyBooking = String.valueOf(count);

        businessOwnerReports_BusinessOwner_TextView = findViewById(R.id.businessOwnerReports_BusinessOwner_TextView);
        businessOwnerReports_BusinessAddress_TextView = findViewById(R.id.businessOwnerReports_BusinessAddress_TextView);
        reportsNumberOfCars_TV = findViewById(R.id.reportsNumberOfCars_TV);

        businessOwnerReports_BusinessOwner_TextView.setText(companyName);
        businessOwnerReports_BusinessAddress_TextView.setText(myDB.reportBusinessOwnerAddress(companyID));

        reportsNumberOfBooking_TV = findViewById(R.id.reportsNumberOfBooking_TV);

        reportsNumberOfBooking_TV.setText(numberOfCompanyBooking);

        int carCount = myDB.myCompanyTotalCarCount(companyID);
        String totalNumberOfCompanyCars = String.valueOf(carCount);

        reportsNumberOfCars_TV.setText(totalNumberOfCompanyCars);






    }

    private void setOnClickListener() {
        listener = new CustomAdapterForReports.ReportsClickListener() {
            @Override
            public void onClick(View v, int position) {
                historyID = booking_id.get(position);
                openReportDetails();
            }
        };
    }

    public void displayData(){
        Bundle intent = getIntent().getExtras();

        companyName = intent.getString("businessOwnerName");

        companyID = intent.getString("companyID");
        companyAddress = intent.getString("companyAddress");

        Cursor cursor = myDB.readAllDataForReports(companyID);
        if (cursor.getCount() == 0){
            Toast.makeText(BusinessOwnerReports.this, "No Booking Found", Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                booking_id.add(cursor.getString(0));
                booker_FullName.add(cursor.getString(3));
                bookerCar_modelName.add(cursor.getString(9));
            }
        }
    }

    public void openReportDetails(){
        Intent intent = new Intent(this, ViewReportDetails.class);
        intent.putExtra("historyID", historyID);
        startActivity(intent);
    }
}