package com.example.cafinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class PayViaCounterPage extends AppCompatActivity {
    public static final String EXTRA_TEXT_CAR_ID = "com.example.cedula.example.EXTRA_TEXT_CAR_ID";
    public static final String EXTRA_TEXT_COMPANY_ID = "com.example.cedula.example.EXTRA_TEXT_COMPANY_ID";
    public static final String EXTRA_TEXT_COMPANY_NAME = "com.example.cedula.example.EXTRA_TEXT_COMPANY_NAME";
    public static final String EXTRA_TEXT_CAR_PRICE = "com.example.cedula.example.EXTRA_TEXT_CAR_PRICE";
    public static final String EXTRA_TEXT_COMPANY_ADDRESS = "com.example.cedula.example.EXTRA_TEXT_COMPANY_ADDRESS";
    public static final String EXTRA_TEXT_CAR_NAME = "com.example.cedula.example.EXTRA_TEXT_CAR_NAME";
    public static final String EXTRA_TEXT_BOOKER_ID = "com.example.cedula.example.EXTRA_TEXT_BOOKER_ID";
    public static final String EXTRA_TEXT_BOOKER_NAME = "com.example.cedula.example.EXTRA_TEXT_BOOKER_NAME";
    public static final String EXTRA_TEXT_BOOKER_ADDRESS = "com.example.cedula.example.EXTRA_TEXT_BOOKER_ADDRESS";
    public static final String EXTRA_TEXT_BOOKER_AGE = "com.example.cedula.example.EXTRA_TEXT_BOOKER_AGE";
    public static final String EXTRA_TEXT_BOOKER_EMAIL = "com.example.cedula.example.EXTRA_TEXT_BOOKER_EMAIL";
    public static final String EXTRA_TEXT_BOOKER_MOBILE = "com.example.cedula.example.EXTRA_TEXT_BOOKER_MOBILE";
    public static final String EXTRA_TEXT_BOOKING_STATUS = "com.example.cedula.example.EXTRA_TEXT_BOOKING_STATUS";
    public static final String EXTRA_TEXT_BOOKING_TRIP_FROM = "com.example.cedula.example.EXTRA_TEXT_BOOKING_TRIP_FROM";
    public static final String EXTRA_TEXT_BOOKING_TRIP_TO = "com.example.cedula.example.EXTRA_TEXT_BOOKING_TRIP_TO";
    public static final String EXTRA_TEXT_BOOKING_TRIP_ADDRESS = "com.example.cedula.example.EXTRA_TEXT_BOOKING_TRIP_ADDRESS";
    public static final String EXTRA_TEXT_BOOKER_PAYMENT_METHOD = "com.example.cedula.example.EXTRA_TEXT_BOOKER_PAYMENT_METHOD";
    public static final String EXTRA_TEXT_BOOKER_F_CASH_NUMBER = "com.example.cedula.example.EXTRA_TEXT_BOOKER_F_CASH_NUMBER";
    public static final String EXTRA_TEXT_BOOKER_AMOUNT = "com.example.cedula.example.EXTRA_TEXT_BOOKER_AMOUNT";
    public static final String EXTRA_TEXT_BOOKER_DRIVER_OPTION = "com.example.cedula.example.EXTRA_TEXT_BOOKER_DRIVER_OPTION";


    String passValue_CarID, passValue_CarName, passValue_CarPrice, passValue_CompanyID, driverAccommodation, passValue_CompanyAddress, passValue_CompanyName,
    passValue_BookerID, passValue_BookerFullName, passValue_BookerAddress, passValue_BookerAge, passValue_BookerEmail,
    passValue_BookerMobileNumber, passValue_Status, passValue_BookingTripFrom, passValue_BookingTripTo, passValue_BookingTripAddress,
            passValue_BookingPaymentMethod, passValue_BookingGCashNumber, passValue_BookingAmount;

    TextView payViaCounterCarName, payViaCounterCarPrice, textView139, textView140;
    EditText payViaCounterFirstName, payViaCounterLastName, payViaCounterEmail, payViaCounterMobileNumber, payViaCounterAge,
            payViaCounterAddress, payViaCounterTripMunicipality;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_via_counter_page);

        Spinner spinnerPayViaCounterFromMonth = findViewById(R.id.spinnerOverCounterFromMonth);
        Spinner spinnerPayViaCounterFromDay = findViewById(R.id.spinnerOverCounterFromDay);
        Spinner spinnerPayViaCounterFromYear = findViewById(R.id.spinnerOverCounterFromYear);

        Spinner spinnerPayViaCounterToMonth = findViewById(R.id.spinnerOverCounterToMonth);
        Spinner spinnerPayViaCounterToDay = findViewById(R.id.spinnerOverCounterToDay);
        Spinner spinnerPayViaCounterToYear = findViewById(R.id.spinnerOverCounterToYear);

        Spinner spinnerOverCounterTripRegion = findViewById(R.id.spinnerOverCounterTripRegion);
        Spinner spinnerOverCounterTripProvince = findViewById(R.id.spinnerOverCounterTripProvince);

        Spinner spinnerOverCounterNumberofHours = findViewById(R.id.spinnerOverCounterNumberofHours);

        Spinner spinnerOverCounterTripMunicipalities = findViewById(R.id.spinnerOverCounterTripMunicipalities);



        ArrayAdapter<CharSequence> adapter_spinnerPayViaCounterFromMonth =  ArrayAdapter.createFromResource(this, R.array.month, android.R.layout.simple_spinner_item);
        adapter_spinnerPayViaCounterFromMonth.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPayViaCounterFromMonth.setAdapter(adapter_spinnerPayViaCounterFromMonth);

        ArrayAdapter<CharSequence> adapter_spinnerPayViaCounterFromDay =  ArrayAdapter.createFromResource(this, R.array.days, android.R.layout.simple_spinner_item);
        adapter_spinnerPayViaCounterFromDay.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPayViaCounterFromDay.setAdapter(adapter_spinnerPayViaCounterFromDay);

        ArrayAdapter<CharSequence> adapter_spinnerPayViaCounterFromYear =  ArrayAdapter.createFromResource(this, R.array.years, android.R.layout.simple_spinner_item);
        adapter_spinnerPayViaCounterFromYear.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPayViaCounterFromYear.setAdapter(adapter_spinnerPayViaCounterFromYear);

        ArrayAdapter<CharSequence> adapter_spinnerPayViaCounterToMonth =  ArrayAdapter.createFromResource(this, R.array.month, android.R.layout.simple_spinner_item);
        adapter_spinnerPayViaCounterToMonth.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPayViaCounterToMonth.setAdapter(adapter_spinnerPayViaCounterToMonth);

        ArrayAdapter<CharSequence> adapter_spinnerPayViaCounterToDay =  ArrayAdapter.createFromResource(this, R.array.days, android.R.layout.simple_spinner_item);
        adapter_spinnerPayViaCounterToDay.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPayViaCounterToDay.setAdapter(adapter_spinnerPayViaCounterToDay);

        ArrayAdapter<CharSequence> adapter_spinnerPayViaCounterToYear =  ArrayAdapter.createFromResource(this, R.array.years, android.R.layout.simple_spinner_item);
        adapter_spinnerPayViaCounterToYear.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPayViaCounterToYear.setAdapter(adapter_spinnerPayViaCounterToYear);

        ArrayAdapter<CharSequence> adapter_spinnerOverCounterTripRegion =  ArrayAdapter.createFromResource(this, R.array.regions, android.R.layout.simple_spinner_item);
        adapter_spinnerOverCounterTripRegion.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOverCounterTripRegion.setAdapter(adapter_spinnerOverCounterTripRegion);

        ArrayAdapter<CharSequence> adapter_spinnerOverCounterTripProvince =  ArrayAdapter.createFromResource(this, R.array.provinces, android.R.layout.simple_spinner_item);
        adapter_spinnerOverCounterTripProvince.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOverCounterTripProvince.setAdapter(adapter_spinnerOverCounterTripProvince);

        ArrayAdapter<CharSequence> adapter_spinnerOverCounterNumberofHours =  ArrayAdapter.createFromResource(this, R.array.hoursOptions, android.R.layout.simple_spinner_item);
        adapter_spinnerOverCounterNumberofHours.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOverCounterNumberofHours.setAdapter(adapter_spinnerOverCounterNumberofHours);

        ArrayAdapter<CharSequence> adapter_spinnerOverCounterTripMunicipalities =  ArrayAdapter.createFromResource(this, R.array.municipalities, android.R.layout.simple_spinner_item);
        adapter_spinnerOverCounterTripMunicipalities.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOverCounterTripMunicipalities.setAdapter(adapter_spinnerOverCounterTripMunicipalities);


        payViaCounterFirstName = findViewById(R.id.payViaCounterFirstName);
        payViaCounterLastName = findViewById(R.id.payViaCounterLastName);
        payViaCounterEmail = findViewById(R.id.payViaCounterEmail);
        payViaCounterMobileNumber = findViewById(R.id.payViaCounterMobileNumber);
        payViaCounterAge = findViewById(R.id.payViaCounterAge);
        payViaCounterAddress = findViewById(R.id.payViaCounterAddress);

        textView139 = findViewById(R.id.textView139);
        textView140 = findViewById(R.id.textView140);


        Intent intent = getIntent();

        payViaCounterCarName = findViewById(R.id.payViaCounterCarName);
        payViaCounterCarPrice = findViewById(R.id.payViaCounterCarPrice);

        Button button3 = findViewById(R.id.button3);

        passValue_CarID = intent.getStringExtra(PaymentOption.EXTRA_TEXT_CAR_ID);
        passValue_CarPrice = intent.getStringExtra(PaymentOption.EXTRA_TEXT_CAR_PRICE);
        passValue_CarName = intent.getStringExtra(PaymentOption.EXTRA_TEXT_CAR_NAME);
        passValue_BookerID = intent.getStringExtra(PaymentOption.EXTRA_TEXT_BOOKER_ID);
        passValue_CompanyID = intent.getStringExtra(PaymentOption.EXTRA_TEXT_COMPANY_ID);
        passValue_CompanyAddress = intent.getStringExtra(PaymentOption.EXTRA_TEXT_COMPANY_ADDRESS);
        passValue_CompanyName = intent.getStringExtra(PaymentOption.EXTRA_TEXT_COMPANY_NAME);
        passValue_BookerFullName = payViaCounterFirstName.getText().toString() + " " + payViaCounterLastName.getText().toString();
        passValue_BookerAddress = payViaCounterAddress.getText().toString();
        passValue_BookerAge = payViaCounterAge.getText().toString();
        passValue_BookerEmail = payViaCounterEmail.getText().toString();
        passValue_BookerMobileNumber = payViaCounterMobileNumber.getText().toString();
        passValue_Status = "Pending";
        passValue_BookingTripAddress = spinnerOverCounterTripMunicipalities.getSelectedItem().toString() + ", " + spinnerOverCounterTripRegion.getSelectedItem().toString() + ", " + spinnerOverCounterTripProvince.getSelectedItem().toString();
        passValue_BookingPaymentMethod = "Pay Via Counter";
        passValue_BookingGCashNumber = "N/A";
        passValue_BookingAmount = intent.getStringExtra(PaymentOption.EXTRA_TEXT_CAR_PRICE);

        driverAccommodation = intent.getStringExtra(PaymentOption.EXTRA_TEXT_BOOKER_DRIVER_OPTION);


        if (driverAccommodation.equals("With Driver")){

            payViaCounterFirstName.setVisibility(View.INVISIBLE);
            payViaCounterLastName.setVisibility(View.INVISIBLE);
            payViaCounterEmail.setVisibility(View.INVISIBLE);
            payViaCounterMobileNumber.setVisibility(View.INVISIBLE);
            payViaCounterAge.setVisibility(View.INVISIBLE);
            payViaCounterAddress.setVisibility(View.INVISIBLE);

            textView139.setVisibility(View.VISIBLE);
            button3.setVisibility(View.INVISIBLE);
            textView140.setVisibility(View.INVISIBLE);

            payViaCounterFirstName.setText("N/A");
            payViaCounterLastName.setText("N/A");
            payViaCounterEmail.setText("N/A");
            payViaCounterMobileNumber.setText("N/A");
            payViaCounterAge.setText("N/A");
            payViaCounterAddress.setText("N/A");


        }


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFileResource();
            }
        });





        passValue_BookingTripFrom =
                spinnerPayViaCounterFromMonth.getSelectedItem().toString() + "/ " + spinnerPayViaCounterFromDay.getSelectedItem().toString() + "/"
       + spinnerPayViaCounterFromYear.getSelectedItem().toString();
        passValue_BookingTripTo = spinnerPayViaCounterToMonth.getSelectedItem().toString() + "/ " + spinnerPayViaCounterToDay.getSelectedItem().toString() + "/"
                + spinnerPayViaCounterToYear.getSelectedItem().toString();

        payViaCounterCarName.setText(passValue_CarName);
        payViaCounterCarPrice.setText(passValue_CarPrice);






        Button payViaCounterPageContinueButton = findViewById(R.id.payViaCounterPageContinueButton);
        payViaCounterPageContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (payViaCounterFirstName.getText().toString().equals("") ||
                payViaCounterLastName.getText().toString().equals("") ||
                        payViaCounterEmail.getText().toString().equals("") ||
                payViaCounterMobileNumber.getText().toString().equals("") ||
                        payViaCounterAge.getText().toString().equals("") ||
                payViaCounterAddress.getText().toString().equals("")){

                    Toast.makeText(PayViaCounterPage.this, "Please Dont Skip Any Textfield", Toast.LENGTH_SHORT).show();

                }
                else{
                    //Toast.makeText(PayViaCounterPage.this, passValue_BookingTripFrom +passValue_BookingTripTo , Toast.LENGTH_SHORT).show();
                    openReview();
                }

            }
        });

    }

    private void openReview() {
        Spinner spinnerPayViaCounterFromMonth = findViewById(R.id.spinnerOverCounterFromMonth);
        Spinner spinnerPayViaCounterFromDay = findViewById(R.id.spinnerOverCounterFromDay);
        Spinner spinnerPayViaCounterFromYear = findViewById(R.id.spinnerOverCounterFromYear);

        Spinner spinnerPayViaCounterToMonth = findViewById(R.id.spinnerOverCounterToMonth);
        Spinner spinnerPayViaCounterToDay = findViewById(R.id.spinnerOverCounterToDay);
        Spinner spinnerPayViaCounterToYear = findViewById(R.id.spinnerOverCounterToYear);

        Spinner spinnerOverCounterTripRegion = findViewById(R.id.spinnerOverCounterTripRegion);
        Spinner spinnerOverCounterTripProvince = findViewById(R.id.spinnerOverCounterTripProvince);

        Spinner spinnerOverCounterTripMunicipalities = findViewById(R.id.spinnerOverCounterTripMunicipalities);

        Intent getterIntent = getIntent();
        passValue_CarID = getterIntent.getStringExtra(PaymentOption.EXTRA_TEXT_CAR_ID);
        passValue_CarPrice = getterIntent.getStringExtra(PaymentOption.EXTRA_TEXT_CAR_PRICE);
        passValue_CarName = getterIntent.getStringExtra(PaymentOption.EXTRA_TEXT_CAR_NAME);
        passValue_BookerID = getterIntent.getStringExtra(PaymentOption.EXTRA_TEXT_BOOKER_ID);
        passValue_CompanyID = getterIntent.getStringExtra(PaymentOption.EXTRA_TEXT_COMPANY_ID);
        passValue_CompanyAddress = getterIntent.getStringExtra(PaymentOption.EXTRA_TEXT_COMPANY_ADDRESS);
        passValue_CompanyName = getterIntent.getStringExtra(PaymentOption.EXTRA_TEXT_COMPANY_NAME);
        passValue_BookerFullName = payViaCounterFirstName.getText().toString() + " " + payViaCounterLastName.getText().toString();
        passValue_BookerAddress = payViaCounterAddress.getText().toString();
        passValue_BookerAge = payViaCounterAge.getText().toString();
        passValue_BookerEmail = payViaCounterEmail.getText().toString();
        passValue_BookerMobileNumber = payViaCounterMobileNumber.getText().toString();
        passValue_Status = "Pending";
        passValue_BookingTripAddress = spinnerOverCounterTripMunicipalities.getSelectedItem().toString() + ", " + spinnerOverCounterTripRegion.getSelectedItem().toString() + ", " + spinnerOverCounterTripProvince.getSelectedItem().toString();
        passValue_BookingPaymentMethod = "Pay Via Counter";
        passValue_BookingGCashNumber = "N/A";
        passValue_BookingAmount = getterIntent.getStringExtra(PaymentOption.EXTRA_TEXT_CAR_PRICE);

        driverAccommodation = getterIntent.getStringExtra(PaymentOption.EXTRA_TEXT_BOOKER_DRIVER_OPTION);





        passValue_BookingTripFrom =
                spinnerPayViaCounterFromMonth.getSelectedItem().toString() + "/ " + spinnerPayViaCounterFromDay.getSelectedItem().toString() + "/"
                        + spinnerPayViaCounterFromYear.getSelectedItem().toString();
        passValue_BookingTripTo = spinnerPayViaCounterToMonth.getSelectedItem().toString() + "/ " + spinnerPayViaCounterToDay.getSelectedItem().toString() + "/"
                + spinnerPayViaCounterToYear.getSelectedItem().toString();

        Intent intent = new Intent(this, PaymentViaCounterReview.class);
        intent.putExtra(EXTRA_TEXT_CAR_ID, passValue_CarID);
        intent.putExtra(EXTRA_TEXT_COMPANY_ID, passValue_CompanyID);
        intent.putExtra(EXTRA_TEXT_COMPANY_NAME, passValue_CompanyName);
        intent.putExtra(EXTRA_TEXT_CAR_PRICE, passValue_CarPrice);
        intent.putExtra(EXTRA_TEXT_COMPANY_ADDRESS, passValue_CompanyAddress);
        intent.putExtra(EXTRA_TEXT_CAR_NAME, passValue_CarName);
        intent.putExtra(EXTRA_TEXT_BOOKER_ID, passValue_BookerID);
        intent.putExtra(EXTRA_TEXT_BOOKER_NAME, passValue_BookerFullName);
        intent.putExtra(EXTRA_TEXT_BOOKER_ADDRESS, passValue_BookerAddress);
        intent.putExtra(EXTRA_TEXT_BOOKER_AGE, passValue_BookerAge);
        intent.putExtra(EXTRA_TEXT_BOOKER_EMAIL, passValue_BookerEmail);
        intent.putExtra(EXTRA_TEXT_BOOKER_MOBILE, passValue_BookerMobileNumber);
        intent.putExtra(EXTRA_TEXT_BOOKING_STATUS, passValue_Status);
        intent.putExtra(EXTRA_TEXT_BOOKING_TRIP_FROM, passValue_BookingTripFrom);
        intent.putExtra(EXTRA_TEXT_BOOKING_TRIP_TO, passValue_BookingTripTo);
        intent.putExtra(EXTRA_TEXT_BOOKING_TRIP_ADDRESS, passValue_BookingTripAddress);
        intent.putExtra(EXTRA_TEXT_BOOKER_PAYMENT_METHOD, passValue_BookingPaymentMethod);
        intent.putExtra(EXTRA_TEXT_BOOKER_F_CASH_NUMBER, passValue_BookingGCashNumber);
        intent.putExtra(EXTRA_TEXT_BOOKER_AMOUNT, passValue_BookingAmount);
        intent.putExtra(EXTRA_TEXT_BOOKER_DRIVER_OPTION, driverAccommodation);
        startActivity(intent);

    }

    private void openFileResource() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        startActivityForResult(intent, 10);
    }


}