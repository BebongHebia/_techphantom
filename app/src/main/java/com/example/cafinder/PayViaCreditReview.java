package com.example.cafinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class PayViaCreditReview extends AppCompatActivity {
    public static final String CLIENT_ID_NUMBER = "com.example.cedula.example.CLIENT_ID_NUMBER";

    MyDatabaseHelper myDB = new MyDatabaseHelper(PayViaCreditReview.this);

    Calendar calendar;

    String carName, carPrice, companyID, companyOwner, companyAddress, carID, bookerID, tripDateFrom, tripDateTo, bookerFullName,
            bookerEmail, bookerPhoneNumber, bookerAge, bookerTripAddress, bookerGCashNumber, bookerAddress, driverAccommodation;

    String bookingDate;

    TextView creditReviewCarNameTextView,
            creditReviewCarPriceTextView,
            creditReviewCarPriceTextView2,
            creditReviewCarNameTV,
            creditReviewTripDate,
            creditReviewFullName,
            creditReviewEmail,
            creditReviewPhoneNumber,
            creditReviewAge,
            creditReviewTripAddress,
            creditReview_RentalFee_tV,
            creditReview_driverAccommodation_tV,
            creditReview_DriverFee_tV,
            creditReviewGCashNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_via_credit_review);
        Intent intent = getIntent();

        creditReviewCarNameTextView = findViewById(R.id.creditReviewCarNameTextView);
        creditReviewCarPriceTextView = findViewById(R.id.creditReviewCarPriceTextView);
        creditReviewCarPriceTextView2 = findViewById(R.id.creditReview_RentalFee_tV);
        creditReviewCarNameTV = findViewById(R.id.creditReviewCarNameTV);
        creditReviewTripDate = findViewById(R.id.creditReviewTripDate);
        creditReviewFullName = findViewById(R.id.creditReviewFullName);
        creditReviewEmail = findViewById(R.id.creditReviewEmail);
        creditReviewPhoneNumber = findViewById(R.id.creditReviewPhoneNumber);
        creditReviewAge = findViewById(R.id.creditReviewAge);
        creditReviewTripAddress = findViewById(R.id.creditReviewTripAddress);
        creditReviewGCashNumber = findViewById(R.id.creditReviewGCashNumber);

        creditReview_RentalFee_tV = findViewById(R.id.creditReview_RentalFee_tV);
        creditReview_driverAccommodation_tV = findViewById(R.id.creditReview_driverAccommodation_tV);
        creditReview_DriverFee_tV = findViewById(R.id.creditReview_DriverFee_tV);

        carName = intent.getStringExtra(PayViaCreditPage.EXTRA_TEXT_CAR_NAME);
        carPrice = intent.getStringExtra(PayViaCreditPage.EXTRA_TEXT_CAR_PRICE);
        companyID = intent.getStringExtra(PayViaCreditPage.EXTRA_TEXT_COMPANY_ID);
        companyOwner = intent.getStringExtra(PayViaCreditPage.EXTRA_TEXT_COMPANY_NAME);
        companyAddress = intent.getStringExtra(PayViaCreditPage.EXTRA_TEXT_COMPANY_ADDRESS);
        carID = intent.getStringExtra(PayViaCreditPage.EXTRA_TEXT_CAR_ID);
        bookerID = intent.getStringExtra(PayViaCreditPage.EXTRA_TEXT_BOOKER_ID);
        tripDateFrom = intent.getStringExtra(PayViaCreditPage.EXTRA_TEXT_BOOKER_TRIP_DATE_FROM);
        tripDateTo = intent.getStringExtra(PayViaCreditPage.EXTRA_TEXT_BOOKER_TRIP_DATE_TO);
        bookerFullName = intent.getStringExtra(PayViaCreditPage.EXTRA_TEXT_BOOKER_FULLNAME);
        bookerEmail = intent.getStringExtra(PayViaCreditPage.EXTRA_TEXT_BOOKER_EMAIL);
        bookerPhoneNumber = intent.getStringExtra(PayViaCreditPage.EXTRA_TEXT_BOOKER_PHONE_NUMBER);
        bookerAge = intent.getStringExtra(PayViaCreditPage.EXTRA_TEXT_BOOKER_AGE);
        bookerTripAddress = intent.getStringExtra(PayViaCreditPage.EXTRA_TEXT_BOOKER_TRIP_ADDRESS);
        bookerGCashNumber = intent.getStringExtra(PayViaCreditPage.EXTRA_TEXT_BOOKER_GCASH);
        bookerAddress = intent.getStringExtra(PayViaCreditPage.EXTRA_TEXT_BOOKER_ADDRESS);
        driverAccommodation = intent.getStringExtra(PayViaCounterPage.EXTRA_TEXT_BOOKER_DRIVER_OPTION);

        calendar = Calendar.getInstance();
        bookingDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

        creditReviewCarNameTextView.setText(carName);
        creditReviewCarPriceTextView.setText(carPrice);
        creditReviewCarPriceTextView2.setText(carPrice);
        creditReviewCarNameTV.setText(carName);
        creditReviewTripDate.setText("FROM : " + tripDateFrom + "TO : " + tripDateTo);
        creditReviewFullName.setText(bookerFullName);
        creditReviewEmail.setText(bookerEmail);
        creditReviewPhoneNumber.setText(bookerPhoneNumber);
        creditReviewAge.setText(bookerAge);
        creditReviewTripAddress.setText(bookerTripAddress);
        creditReviewGCashNumber.setText(bookerGCashNumber);


        creditReview_RentalFee_tV.setText(carPrice);
        creditReview_driverAccommodation_tV.setText(driverAccommodation);

        if (driverAccommodation.equals("With Driver")){
            creditReview_DriverFee_tV.setText("P1,000");
        }



        Button creditReview_BackButton = findViewById(R.id.creditReview_BackButton);
        Button payViaCreditContinueButtonProcess = findViewById(R.id.payViaCreditContinueButtonProcess);

        creditReview_BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        payViaCreditContinueButtonProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


//
               myDB.addBooking(bookerID, bookerFullName, bookerAddress, bookerAge, bookerEmail, bookerPhoneNumber, "Pending",
                        carName, carPrice,  tripDateFrom, tripDateTo, bookerTripAddress, "Pay Via Credit",
                        bookerGCashNumber, "N/A", companyID, companyAddress, companyOwner, carID, bookingDate, "N/A",
                        "N/A", "N/A", "On hold", "N/A", driverAccommodation);
                myDB.carAvailability(carID, "Booked");
                openBackToDashboard();

                boolean makeCarUnavailable = myDB.makeCarNotAvailable(carID, "Not Available");
                if (makeCarUnavailable == true){
                    openBackToDashboard();
                }

            }
        });

    }

    public void openBackToDashboard(){
        Intent intent = new Intent(this, PayViaCreditBookingSuccessfulPopUp.class);
        intent.putExtra(CLIENT_ID_NUMBER, bookerID);
        startActivity(intent);
    }
}