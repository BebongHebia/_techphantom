package com.example.cafinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ReviewBookingData extends AppCompatActivity {
    MyDatabaseHelper myDB;
    String booking_full_name,
            booking_address,
            booking_age,
            booking_email_STR,
            booking_phone_number,
            booking_status,
            booking_car_name,
            booking_car_price,
            booking_trip_date_from,
            booking_trip_date_to,
            booking_trip_address,
            booking_payment_method,
            booking_g_cash_number,
            booking_amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review_booking_data);
        myDB = new MyDatabaseHelper(ReviewBookingData.this);

        Intent intent = getIntent();
        String passedBookingID = intent.getStringExtra(ConfirmBooking.PASS_BOOKING_ID);

        //TextViews
        TextView booking_review_fullname, booking_review_address, booking_review_age, booking_review_email,
                booking_review_mobile_number, booking_review_booking_status, booking_review_car_name, booking_review_car_price,
                booking_review_trip_date_from, booking_review_trip_date_to,
                booking_review_trip_routes, booking_review_payment_method, booking_review_g_cash_number,
                booking_review_car_amount;

        booking_review_fullname = findViewById(R.id.booking_review_fullname);
        booking_review_address = findViewById(R.id.booking_review_address);
        booking_review_age = findViewById(R.id.booking_review_age);
        booking_review_email = findViewById(R.id.booking_review_email);
        booking_review_mobile_number = findViewById(R.id.booking_review_mobile_number);
        booking_review_booking_status = findViewById(R.id.booking_review_booking_status);
        booking_review_car_name = findViewById(R.id.booking_review_car_name);
        booking_review_car_price = findViewById(R.id.booking_review_car_price);
        booking_review_trip_date_from = findViewById(R.id.booking_review_trip_date_from);
        booking_review_trip_date_to = findViewById(R.id.booking_review_trip_date_to);
        booking_review_trip_routes = findViewById(R.id.booking_review_trip_routes);
        booking_review_payment_method = findViewById(R.id.booking_review_payment_method);
        booking_review_g_cash_number = findViewById(R.id.booking_review_g_cash_number);
        booking_review_car_amount = findViewById(R.id.booking_review_car_amount);



        //EditText
        EditText booking_review_days_granted_ET = findViewById(R.id.booking_review_days_granted_ET);


        //Button
        Button booking_review_approve_button, booking_review_decline_button;

        booking_review_approve_button = findViewById(R.id.booking_review_approve_button);
        booking_review_decline_button = findViewById(R.id.booking_review_decline_button);

        //Methods From Database


        //Strings
        booking_full_name = myDB.getBookingName(passedBookingID).toString();
        booking_address = myDB.getBookingAddress(passedBookingID).toString();
        booking_age = myDB.getBookingAge(passedBookingID).toString();
        booking_email_STR = myDB.getBookingEmail(passedBookingID).toString();
        booking_phone_number = myDB.getBookingMobileNumber(passedBookingID).toString();
        booking_status = myDB.getBookingStatus1(passedBookingID).toString();
        booking_car_name = myDB.getBookingCarName(passedBookingID).toString();
        booking_car_price = myDB.getBookingCarPrice(passedBookingID).toString();
        booking_trip_date_from = myDB.getBookingTripDateFrom(passedBookingID).toString();
        booking_trip_date_to = myDB.getBookingTripDateTo(passedBookingID).toString();
        booking_trip_address = myDB.getBookingTripAddress(passedBookingID).toString();
        booking_payment_method = myDB.getBookingPaymentMethod(passedBookingID).toString();
        booking_g_cash_number = myDB.getBookingGCashNumber(passedBookingID).toString();
        booking_amount = myDB.getBookingAmount(passedBookingID).toString();

        booking_review_fullname.setText(booking_full_name);
        booking_review_address.setText("Address: " + booking_address);
        booking_review_age.setText("Age :" + booking_age);
        booking_review_email.setText("Email: " + booking_email_STR);
        booking_review_mobile_number.setText("Mobile Number: " + booking_phone_number);
        booking_review_booking_status.setText("Booking Status: " + booking_status);
        booking_review_car_name.setText("Car Name: " + booking_car_name);
        booking_review_car_price.setText("Car Price : " + booking_car_price);
        booking_review_trip_date_from.setText(booking_trip_date_from);
        booking_review_trip_date_to.setText(booking_trip_date_to);
        booking_review_trip_routes.setText("Trip Address: " + booking_trip_address);
        booking_review_payment_method.setText("Payment Method: " + booking_payment_method);
        booking_review_g_cash_number.setText("G-cash Number: " + booking_g_cash_number);
        booking_review_car_amount.setText("Amount : " + booking_amount);



        booking_review_approve_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checkUpdate = myDB.ApproveRequest(passedBookingID, "Approved");
                if (checkUpdate == true){
                    Toast.makeText(ReviewBookingData.this, "Approval Send", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ReviewBookingData.this, "Approval FAiled", Toast.LENGTH_SHORT).show();
                }
            }
        });






    }

    public void ApproveBooking(){






    }
}