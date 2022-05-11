package com.example.cafinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheckBookingStatus extends AppCompatActivity {
    public static final String EXTRA_TEXT_ID_NUMBER = "com.example.cedula.example.EXTRA_TEXT_ID_NUMBER";

    MyDatabaseHelper myDB = new MyDatabaseHelper(CheckBookingStatus.this);


    String passedID;
    TextView bookingStatus_bookerName_TV,
            bookingStatus_bookingStatus_TV,
            bookingStatus_bookingCarModel_TV,
            bookingStatus_bookingCarPrice_TV,
            bookingStatus_bookingCarCompanyOwner_TV,
            bookingStatus_bookingTripDate_TV,
            bookingStatus_bookingTripAddress_TV;

    TextView bookingStatus_bookingDaysRented_TV,
            bookingStatus_bookingDate_TV,
            bookingStatus_bookingDateApproved_TV,
            bookingStatus_bookingRemarks_TV,
            bookingStatus_bookingTotalAmount_TV,
            bookingStatus_bookingCarStatus_TV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_booking_status);


        Intent intent= getIntent();
        passedID  = intent.getStringExtra(ClientDashboard.EXTRA_TEXT_ID_NUMBER);
        String bookingStatus = myDB.getBookerStatus(passedID).toString();



        bookingStatus_bookerName_TV = findViewById(R.id.bookingStatus_bookerName_TV);
        bookingStatus_bookingStatus_TV = findViewById(R.id.bookingStatus_bookingStatus_TV);
        bookingStatus_bookingCarModel_TV = findViewById(R.id.bookingStatus_bookingCarModel_TV);
        bookingStatus_bookingCarPrice_TV = findViewById(R.id.bookingStatus_bookingCarPrice_TV);
        bookingStatus_bookingCarCompanyOwner_TV = findViewById(R.id.bookingStatus_bookingCarCompanyOwner_TV);
        bookingStatus_bookingTripDate_TV = findViewById(R.id.bookingStatus_bookingTripDate_TV);
        bookingStatus_bookingTripAddress_TV = findViewById(R.id.bookingStatus_bookingTripAddress_TV);

        bookingStatus_bookingDaysRented_TV = findViewById(R.id.bookingStatus_bookingDaysRented_TV);
        bookingStatus_bookingDate_TV = findViewById(R.id.bookingStatus_bookingDate_TV);
        bookingStatus_bookingDateApproved_TV = findViewById(R.id.bookingStatus_bookingDateApproved_TV);
        bookingStatus_bookingRemarks_TV = findViewById(R.id.bookingStatus_bookingRemarks_TV);

        bookingStatus_bookingTotalAmount_TV = findViewById(R.id.bookingStatus_bookingTotalAmount_TV);
        bookingStatus_bookingCarStatus_TV = findViewById(R.id.bookingStatus_bookingCarStatus_TV);

        Button checkBookingStatus_CancelBooking_Button = findViewById(R.id.checkBookingStatus_CancelBooking_Button);


        if (bookingStatus.equals("Pending")){
            bookingStatus_bookingStatus_TV.setTextColor(getResources().getColor(R.color.pending_color));
            checkBookingStatus_CancelBooking_Button.setVisibility(View.VISIBLE);
        }
        else if (bookingStatus.equals("Disapproved")){
            bookingStatus_bookingStatus_TV.setTextColor(getResources().getColor(R.color.pending_color));
        }
        else if (bookingStatus.equals("Approved")){
            bookingStatus_bookingStatus_TV.setTextColor(getResources().getColor(R.color.approved_color));
        }



        String tripDate = "From :" + myDB.getBookerTripDateFrom(passedID).toString() + " To : " + myDB.getBookerTripDateTo(passedID).toString();
        bookingStatus_bookerName_TV.setText(myDB.getBookerName(passedID).toString());
        bookingStatus_bookingStatus_TV.setText(myDB.getBookerStatus(passedID).toString());
        bookingStatus_bookingCarModel_TV.setText(myDB.getBookerCarModel(passedID).toString());
        bookingStatus_bookingCarPrice_TV.setText(myDB.getBookerCarPrice(passedID).toString());
        bookingStatus_bookingCarCompanyOwner_TV.setText(myDB.getBookerCarCompanyOwner(passedID).toString());
        bookingStatus_bookingTripDate_TV.setText(tripDate);
        bookingStatus_bookingTripAddress_TV.setText(myDB.getBookerTripDateAddress(passedID));

        bookingStatus_bookingDaysRented_TV.setText(myDB.viewBookingDaysRented(passedID).toString());
        bookingStatus_bookingDate_TV.setText(myDB.viewBookingDate(passedID).toString());
        bookingStatus_bookingDateApproved_TV.setText(myDB.viewBookingDateApproved(passedID).toString());
        bookingStatus_bookingRemarks_TV.setText(myDB.viewBookingRemarks(passedID).toString());

        bookingStatus_bookingTotalAmount_TV.setText(myDB.getTotalAmount(passedID).toString());
        bookingStatus_bookingCarStatus_TV.setText(myDB.getCarPicked(passedID).toString());

        Button checkBookingStatus_PickUpCar_button,
        checkBookingStatus_ReturnCar_button;

        checkBookingStatus_PickUpCar_button = findViewById(R.id.checkBookingStatus_PickUpCar_button);
        checkBookingStatus_ReturnCar_button = findViewById(R.id.checkBookingStatus_ReturnCar_button);



        Button checkBookingStatus_BackButton = findViewById(R.id.checkBookingStatus_BackButton);
        checkBookingStatus_BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backtoClientDashboard();
            }
        });

        if (bookingStatus_bookingCarStatus_TV.getText().toString().equals("Ready to Pickup")){
            checkBookingStatus_PickUpCar_button.setVisibility(View.VISIBLE);
        }
        else if (bookingStatus_bookingCarStatus_TV.getText().toString().equals("Rented Days Expired")){
            checkBookingStatus_ReturnCar_button.setVisibility(View.VISIBLE);
        }

        checkBookingStatus_PickUpCar_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openConfirmPickup();
            }
        });

        checkBookingStatus_ReturnCar_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openConfirmReturnCar();
            }
        });

        checkBookingStatus_CancelBooking_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCancelBooking();
            }
        });



    }

    public void openCancelBooking(){
        Intent intent = new Intent(this, CancelReasons.class);
        intent.putExtra("BookerID", passedID);
        startActivity(intent);
    }

    private void backtoClientDashboard() {
        Intent intent = new Intent(this, ClientDashboard.class);
        intent.putExtra(EXTRA_TEXT_ID_NUMBER, passedID);
        finish();
    }

    public void openConfirmPickup(){
        Intent intent = new Intent(this, ConfirmPickupPopUp.class);
        intent.putExtra(EXTRA_TEXT_ID_NUMBER, passedID);
        startActivity(intent);
    }

    public void openConfirmReturnCar(){
        Intent intent = new Intent(this, ConfirmReturnCar.class);
        intent.putExtra(EXTRA_TEXT_ID_NUMBER, passedID);
        startActivity(intent);
    }

}