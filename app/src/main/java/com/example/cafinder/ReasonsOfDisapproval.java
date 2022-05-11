package com.example.cafinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class ReasonsOfDisapproval extends AppCompatActivity {

    Calendar calendar;

    String getBookingID, geTotalAmount, bookingStatus, dateToday, remarks;

    MyDatabaseHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reasons_of_disapproval);

        myDB = new MyDatabaseHelper(ReasonsOfDisapproval.this);

        Intent intent = getIntent();
        Button disapproval_Button = findViewById(R.id.disapproval_Button);
        EditText editTextTextPersonName = findViewById(R.id.editTextTextPersonName);



        disapproval_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getBookingID = intent.getStringExtra(ViewBookingDetails.EXTRA_TEXT_BOOKING_ID);
                geTotalAmount = intent.getStringExtra(ViewBookingDetails.PASSED_TOTAL_AMOUNT);
                bookingStatus = "Disapproved";

                calendar = Calendar.getInstance();
                dateToday = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
                remarks = editTextTextPersonName.getText().toString();



                if (remarks.equals("")){
                    Toast.makeText(ReasonsOfDisapproval.this, "Please Enter Reasons of your Disapproval", Toast.LENGTH_SHORT).show();
                }else{
                    boolean checkApproveBooking =  myDB.ApproveBooking(getBookingID, bookingStatus, geTotalAmount, dateToday, remarks, "N/A",  "N/A");
                    if(checkApproveBooking == true){
                        Toast.makeText(ReasonsOfDisapproval.this, "Updating Complete", Toast.LENGTH_SHORT).show();
                        openDashboard();
                    }
                }
            }
        });



    }

    public void openDashboard(){
        Intent intent = new Intent(this, BusinessOwnerDashboard.class);
        startActivity(intent);
    }
}