package com.example.cafinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class ConfirmPickupPopUp extends AppCompatActivity {
    MyDatabaseHelper myDB = new MyDatabaseHelper(ConfirmPickupPopUp.this);
    String getPassedBookerID, bookingDate;
    Calendar calendar;

    String bookerName, carModel, tripDate, tripRoutes, companyName, companyId, bookerID, bookingID;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_pickup_pop_up);
        Intent intent = getIntent();
        getPassedBookerID = intent.getStringExtra(CheckBookingStatus.EXTRA_TEXT_ID_NUMBER);

        //Start of Pop up

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width* .8), (int) (height* .3));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);
        //End of Pop up

        bookerName = myDB.getBookerName(getPassedBookerID).toString();
        carModel = myDB.getBookerCarModel(getPassedBookerID).toString();
        tripDate = "From : " + myDB.getBookerTripDateFrom(getPassedBookerID).toString() + " To : " +  myDB.getBookerTripDateTo(getPassedBookerID).toString();
        tripRoutes = myDB.getBookerTripDateAddress(getPassedBookerID).toString();
        companyName = myDB.getBookerCarCompanyOwner(getPassedBookerID).toString();

        bookerID = getPassedBookerID;
        bookingID = myDB.getBookingID(getPassedBookerID).toString();

        Button confirmPickUp_ConfirmButton = findViewById(R.id.confirmPickUp_ConfirmButton);
        confirmPickUp_ConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                companyId = myDB.getCompanyIDbyCompanyName(companyName).toString();
                calendar = Calendar.getInstance();
                bookingDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
                myDB.carPicked(getPassedBookerID, "Picked", bookingDate);
                myDB.addTransactions(bookerName, carModel, tripDate, tripRoutes, bookingDate, "Ongoing",
                        companyName, companyId, bookerID, bookingID);
                finish();
            }
        });
    }
}