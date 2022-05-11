package com.example.cafinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class PaymentViaCounterReview extends AppCompatActivity {
    MyDatabaseHelper myDB = new MyDatabaseHelper(PaymentViaCounterReview.this);
    public static final String EXTRA_TEXT_CAR_ID = "com.example.cedula.example.EXTRA_TEXT_CAR_ID";

    String passValue_CarID, passValue_CarName, passValue_CarPrice, passValue_CompanyID, passValue_CompanyAddress, passValue_CompanyName,
            passValue_BookerID, passValue_BookerFullName, passValue_BookerAddress, passValue_BookerAge, passValue_BookerEmail,
            passValue_BookerMobileNumber, passValue_Status, passValue_BookingTripFrom, passValue_BookingTripTo, passValue_BookingTripAddress,
            passValue_BookingPaymentMethod, passValue_BookingGCashNumber, passValue_BookingAmount,driverAccommodation;
    TextView counterReviewCarFee,
            counterReviewCarName,
            counterReviewTripDate,
            counterReviewFullName,
            counterReviewEmail,
            counterReviewPhoneNumber,
            counterReviewAge,
            counterReviewTripAddress,
            payViaCounterReview_DriverAccommodation_text,
            payViaCounterReview_DriverFee_text,
            counterReviewDriverName,
            counterReviewDriverContact,
            counterReviewDriverAddress,
            counterReviewDriverLicense;

        String driver_name_str, driver_address_str, driver_contact_str, driver_license_str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_via_counter_review);




        Intent intent = getIntent();


        passValue_CarID = intent.getStringExtra(PayViaCounterPage.EXTRA_TEXT_CAR_ID);
        passValue_CarName = intent.getStringExtra(PayViaCounterPage.EXTRA_TEXT_CAR_NAME);
        passValue_CarPrice = intent.getStringExtra(PayViaCounterPage.EXTRA_TEXT_CAR_PRICE);
        passValue_CompanyID = intent.getStringExtra(PayViaCounterPage.EXTRA_TEXT_COMPANY_ID);
        passValue_CompanyAddress = intent.getStringExtra(PayViaCounterPage.EXTRA_TEXT_COMPANY_ADDRESS);
        passValue_CompanyName = intent.getStringExtra(PayViaCounterPage.EXTRA_TEXT_COMPANY_NAME);
        passValue_BookerID = intent.getStringExtra(PayViaCounterPage.EXTRA_TEXT_BOOKER_ID);
        passValue_BookerFullName = intent.getStringExtra(PayViaCounterPage.EXTRA_TEXT_BOOKER_NAME);
        passValue_BookerAddress = intent.getStringExtra(PayViaCounterPage.EXTRA_TEXT_BOOKER_ADDRESS);
        passValue_BookerAge = intent.getStringExtra(PayViaCounterPage.EXTRA_TEXT_BOOKER_AGE);
        passValue_BookerEmail = intent.getStringExtra(PayViaCounterPage.EXTRA_TEXT_BOOKER_EMAIL);
        passValue_BookerMobileNumber = intent.getStringExtra(PayViaCounterPage.EXTRA_TEXT_BOOKER_MOBILE);
        passValue_Status = intent.getStringExtra(PayViaCounterPage.EXTRA_TEXT_BOOKING_STATUS);
        passValue_BookingTripFrom = intent.getStringExtra(PayViaCounterPage.EXTRA_TEXT_BOOKING_TRIP_FROM);
        passValue_BookingTripTo = intent.getStringExtra(PayViaCounterPage.EXTRA_TEXT_BOOKING_TRIP_TO);
        passValue_BookingTripAddress = intent.getStringExtra(PayViaCounterPage.EXTRA_TEXT_BOOKING_TRIP_ADDRESS);
        passValue_BookingPaymentMethod = intent.getStringExtra(PayViaCounterPage.EXTRA_TEXT_BOOKER_PAYMENT_METHOD);
        passValue_BookingGCashNumber = intent.getStringExtra(PayViaCounterPage.EXTRA_TEXT_BOOKER_F_CASH_NUMBER);
        passValue_BookingAmount = intent.getStringExtra(PayViaCounterPage.EXTRA_TEXT_BOOKER_AMOUNT);
        driverAccommodation = intent.getStringExtra(PayViaCounterPage.EXTRA_TEXT_BOOKER_DRIVER_OPTION);

        driver_name_str = myDB.getDriverFirstName(passValue_CarID).toString();
        driver_address_str = myDB.getDriverAddress(passValue_CarID).toString();
        driver_contact_str = myDB.getDriverContacts(passValue_CarID).toString();
        driver_license_str = myDB.getDriverlicense(passValue_CarID).toString();

        counterReviewCarFee = findViewById(R.id.counterReviewCarFee);
        counterReviewCarName = findViewById(R.id.counterReviewCarName);
        counterReviewTripDate = findViewById(R.id.counterReviewTripDate);
        counterReviewFullName = findViewById(R.id.counterReviewFullName);
        counterReviewEmail = findViewById(R.id.counterReviewEmail);
        counterReviewPhoneNumber = findViewById(R.id.counterReviewPhoneNumber);
        counterReviewAge = findViewById(R.id.counterReviewAge);
        counterReviewTripAddress = findViewById(R.id.counterReviewTripAddress);

        payViaCounterReview_DriverAccommodation_text = findViewById(R.id.payViaCounterReview_DriverAccommodation_text);
        payViaCounterReview_DriverFee_text = findViewById(R.id.payViaCounterReview_DriverFee_text);

        counterReviewDriverName = findViewById(R.id.counterReviewDriverName);
        counterReviewDriverContact = findViewById(R.id.counterReviewDriverContact);
        counterReviewDriverAddress = findViewById(R.id.counterReviewDriverAddress);
        counterReviewDriverLicense = findViewById(R.id.counterReviewDriverLicense);


        counterReviewCarFee.setText(passValue_CarPrice);
        counterReviewCarName.setText(passValue_CarName);
        counterReviewTripDate.setText("From : " + passValue_BookingTripFrom + " To : " + passValue_BookingTripTo);
        counterReviewFullName.setText(passValue_BookerFullName);
        counterReviewEmail.setText(passValue_BookerEmail);
        counterReviewPhoneNumber.setText(passValue_BookerMobileNumber);
        counterReviewAge.setText(passValue_BookerAge);
        counterReviewTripAddress.setText(passValue_BookingTripAddress);

        payViaCounterReview_DriverAccommodation_text.setText(driverAccommodation);

        counterReviewDriverName.setText(driver_name_str);
        counterReviewDriverContact.setText(driver_contact_str);
        counterReviewDriverAddress.setText(driver_address_str);
        counterReviewDriverLicense.setText(driver_license_str);

        if (driverAccommodation.equals("With Driver")){
            payViaCounterReview_DriverFee_text.setText("P1,000");
        }



        Button CounterReviewButton = findViewById(R.id.CounterReviewButton);
        CounterReviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passValue_CarID = intent.getStringExtra(PayViaCounterPage.EXTRA_TEXT_CAR_ID);
                passValue_CarName = intent.getStringExtra(PayViaCounterPage.EXTRA_TEXT_CAR_NAME);
                passValue_CarPrice = intent.getStringExtra(PayViaCounterPage.EXTRA_TEXT_CAR_PRICE);
                passValue_CompanyID = intent.getStringExtra(PayViaCounterPage.EXTRA_TEXT_COMPANY_ID);
                passValue_CompanyAddress = intent.getStringExtra(PayViaCounterPage.EXTRA_TEXT_COMPANY_ADDRESS);
                passValue_CompanyName = intent.getStringExtra(PayViaCounterPage.EXTRA_TEXT_COMPANY_NAME);
                passValue_BookerID = intent.getStringExtra(PayViaCounterPage.EXTRA_TEXT_BOOKER_ID);
                passValue_BookerFullName = intent.getStringExtra(PayViaCounterPage.EXTRA_TEXT_BOOKER_NAME);
                passValue_BookerAddress = intent.getStringExtra(PayViaCounterPage.EXTRA_TEXT_BOOKER_ADDRESS);
                passValue_BookerAge = intent.getStringExtra(PayViaCounterPage.EXTRA_TEXT_BOOKER_AGE);
                passValue_BookerEmail = intent.getStringExtra(PayViaCounterPage.EXTRA_TEXT_BOOKER_EMAIL);
                passValue_BookerMobileNumber = intent.getStringExtra(PayViaCounterPage.EXTRA_TEXT_BOOKER_MOBILE);
                passValue_Status = intent.getStringExtra(PayViaCounterPage.EXTRA_TEXT_BOOKING_STATUS);
                passValue_BookingTripFrom = intent.getStringExtra(PayViaCounterPage.EXTRA_TEXT_BOOKING_TRIP_FROM);
                passValue_BookingTripTo = intent.getStringExtra(PayViaCounterPage.EXTRA_TEXT_BOOKING_TRIP_TO);
                passValue_BookingTripAddress = intent.getStringExtra(PayViaCounterPage.EXTRA_TEXT_BOOKING_TRIP_ADDRESS);
                passValue_BookingPaymentMethod = intent.getStringExtra(PayViaCounterPage.EXTRA_TEXT_BOOKER_PAYMENT_METHOD);
                passValue_BookingGCashNumber = intent.getStringExtra(PayViaCounterPage.EXTRA_TEXT_BOOKER_F_CASH_NUMBER);
                passValue_BookingAmount = intent.getStringExtra(PayViaCounterPage.EXTRA_TEXT_BOOKER_AMOUNT);
                String bookingRemarks, bookingDateApproved, bookingDate, daysRented;
                bookingDateApproved = "N/A";
                bookingRemarks = "N/A";
                daysRented = "N/A";
                Calendar calendar = Calendar.getInstance();
                bookingDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());


                myDB.addBooking(passValue_BookerID,
                        passValue_BookerFullName,
                        passValue_BookerAddress,
                        passValue_BookerAge,
                        passValue_BookerEmail,
                        passValue_BookerMobileNumber,
                        passValue_Status,
                        passValue_CarName,
                        passValue_CarPrice,
                        passValue_BookingTripFrom,
                        passValue_BookingTripTo,
                        passValue_BookingTripAddress,
                        passValue_BookingPaymentMethod,
                        passValue_BookingGCashNumber,
                        passValue_BookingAmount,
                        passValue_CompanyID,
                        passValue_CompanyAddress,
                        passValue_CompanyName,
                        passValue_CarID,
                        bookingDate,
                        bookingDateApproved,
                        bookingRemarks,
                        daysRented,
                        "On hold",
                        "N/A",
                        driverAccommodation
                );

                boolean makeCarUnavailable = myDB.makeCarNotAvailable(passValue_CarID, "No Available");
                if (makeCarUnavailable == true){
                    OpenSuccessPopUp();
                }

            }
        });
    }
    public void OpenSuccessPopUp(){
        Intent intent = new Intent(this, PayViaCounterPopUpSuccess.class);
        intent.putExtra(EXTRA_TEXT_CAR_ID, passValue_BookerID);
        startActivity(intent);
    }


}