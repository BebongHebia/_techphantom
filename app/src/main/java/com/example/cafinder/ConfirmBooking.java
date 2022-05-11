package com.example.cafinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ConfirmBooking extends AppCompatActivity {
    public static final String COMPANY_NAME = "com.example.cedula.example.COMPANY_NAME";
    public static final String COMPANY_ID = "com.example.cedula.example.COMPANY_ID";
    public static final String PASS_BOOKING_ID = "com.example.cedula.example.PASS_BOOKING_ID";


    MyDatabaseHelper myDB = new MyDatabaseHelper(ConfirmBooking.this);
    RecyclerView recyclerView;
    private CustomAdapterForConfirmBooking.SelectingBookingOnClickListener listener;

    ImageView confirmBooking_logo;


    ArrayList<String> booking_id, booking_full_name, booking_car_name, booking_trip_from, booking_trip_to, booking_payment_method, booking_trip_address;
    CustomAdapterForConfirmBooking customAdapterForConfirmBooking;
    String companyName, companyID, companyAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_booking);
        recyclerView = findViewById(R.id.recycleViewforConfirmBooking);

        Intent intent = getIntent();

        companyID = myDB.getCompanyIDbyCompanyName(companyName).toString();
        companyName = intent.getStringExtra(BusinessOwnerDashboard.COMPANY_NAME);

        TextView confirm_booking_company_name = findViewById(R.id.confirm_booking_company_name);
        confirm_booking_company_name.setText(companyName);

        companyID = myDB.getCompanyIDbyCompanyName(companyName).toString();



        companyAddress = myDB.getCarCompanyAddress(companyID).toString();
        TextView confirmBooking_CompanyAddress_TextView = findViewById(R.id.confirmBooking_CompanyAddress_TextView);
        confirmBooking_CompanyAddress_TextView.setText(companyAddress);

        setOnClickListener();
        booking_id = new ArrayList<>();
        booking_full_name = new ArrayList<>();
        booking_car_name = new ArrayList<>();
        booking_trip_from = new ArrayList<>();
        booking_trip_to = new ArrayList<>();
        booking_payment_method = new ArrayList<>();
        booking_trip_address = new ArrayList<>();


        customAdapterForConfirmBooking = new CustomAdapterForConfirmBooking(ConfirmBooking.this, booking_id, booking_full_name, booking_car_name, booking_trip_from, booking_trip_to, booking_payment_method, booking_trip_address, listener);
        recyclerView.setAdapter(customAdapterForConfirmBooking);
        recyclerView.setLayoutManager(new LinearLayoutManager(ConfirmBooking.this));

        displayAllData();

        Button confirmBooking_OngoingBookingButton = findViewById(R.id.confirmBooking_OngoingBookingButton);

        confirmBooking_OngoingBookingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openViewOutgoingTransactions();
            }
        });

        confirmBooking_logo = findViewById(R.id.confirmBooking_logo);

        byte[] getPic = myDB.getCompanyLogo(companyID);
        if (getPic != null){
            Bitmap bitmaps = convertByteArrayToBitmap(getPic);
            confirmBooking_logo.setImageBitmap(bitmaps);
        }








    }

    public Bitmap convertByteArrayToBitmap(byte[] bytes){
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }

    private void setOnClickListener() {
        listener = new CustomAdapterForConfirmBooking.SelectingBookingOnClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(), ViewBookingDetails.class);
                intent.putExtra(PASS_BOOKING_ID, booking_id.get(position));
                intent.putExtra(COMPANY_NAME, companyName);
                startActivity(intent);
            }
        };
    }

    public void displayAllData(){
        Cursor cursor = myDB.readAllDataFromBooking(companyID);

        if (cursor.getCount() == 0){
            Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                booking_id.add(cursor.getString(0));
                booking_full_name.add(cursor.getString(1));
                booking_car_name.add(cursor.getString(7));
                booking_trip_from.add(cursor.getString(9));
                booking_trip_to.add(cursor.getString(10));
                booking_payment_method.add(cursor.getString(12));
                booking_trip_address.add(cursor.getString(11));

            }
        }
    }

    public void openViewOutgoingTransactions(){
        Intent intent = new Intent(this, ViewOutgoingBooking.class);
        intent.putExtra(COMPANY_ID,companyID );
        startActivity(intent);
    }
}