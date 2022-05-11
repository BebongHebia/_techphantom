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

public class PayViaCreditPage extends AppCompatActivity {

    public static final String EXTRA_TEXT_CAR_ID = "com.example.cedula.example.EXTRA_TEXT_CAR_ID";
    public static final String EXTRA_TEXT_COMPANY_ID = "com.example.cedula.example.EXTRA_TEXT_COMPANY_ID";
    public static final String EXTRA_TEXT_COMPANY_NAME = "com.example.cedula.example.EXTRA_TEXT_COMPANY_NAME";
    public static final String EXTRA_TEXT_CAR_PRICE = "com.example.cedula.example.EXTRA_TEXT_CAR_PRICE";
    public static final String EXTRA_TEXT_COMPANY_ADDRESS = "com.example.cedula.example.EXTRA_TEXT_COMPANY_ADDRESS";
    public static final String EXTRA_TEXT_CAR_NAME = "com.example.cedula.example.EXTRA_TEXT_CAR_NAME";
    public static final String EXTRA_TEXT_BOOKER_ID = "com.example.cedula.example.EXTRA_TEXT_BOOKER_ID";

    public static final String EXTRA_TEXT_BOOKER_FULLNAME = "com.example.cedula.example.EXTRA_TEXT_BOOKER_FULLNAME";
    public static final String EXTRA_TEXT_BOOKER_ADDRESS = "com.example.cedula.example.EXTRA_TEXT_BOOKER_ADDRESS";
    public static final String EXTRA_TEXT_BOOKER_AGE = "com.example.cedula.example.EXTRA_TEXT_BOOKER_AGE";
    public static final String EXTRA_TEXT_BOOKER_EMAIL = "com.example.cedula.example.EXTRA_TEXT_BOOKER_EMAIL";
    public static final String EXTRA_TEXT_BOOKER_PHONE_NUMBER = "com.example.cedula.example.EXTRA_TEXT_BOOKER_PHONE_NUMBER";
    public static final String EXTRA_TEXT_BOOKER_TRIP_DATE_FROM = "com.example.cedula.example.EXTRA_TEXT_BOOKER_TRIP_DATE_FROM";
    public static final String EXTRA_TEXT_BOOKER_TRIP_DATE_TO = "com.example.cedula.example.EXTRA_TEXT_BOOKER_TRIP_DATE_TO";
    public static final String EXTRA_TEXT_BOOKER_TRIP_ADDRESS = "com.example.cedula.example.EXTRA_TEXT_BOOKER_TRIP_ADDRESS";
    public static final String EXTRA_TEXT_BOOKER_GCASH = "com.example.cedula.example.EXTRA_TEXT_BOOKER_GCASH";
    public static final String EXTRA_TEXT_BOOKER_AMOUNT = "com.example.cedula.example.EXTRA_TEXT_BOOKER_AMOUNT";
    public static final String EXTRA_TEXT_BOOKER_DRIVER_OPTION = "com.example.cedula.example.EXTRA_TEXT_BOOKER_DRIVER_OPTION";


    String passValue_CarID, passValue_CarName, passValue_CarPrice, passValue_CompanyID, passValue_CompanyAddress, passValue_CompanyName, bookerID, driverAccommodation;

    Button payViaCreditContinueButton;
    TextView payViaCreditCarNameTextView,
    payViaCreditCarPriceTextView, payViaCredit_AttachButton, providedDriverTextView;

    EditText payViaCreditFirstName,
            payViaCreditLastName,
            payViaCreditEmail,
            payViaCreditPhoneNumber,
            payViaCreditAge,
            payViaCreditAddress,
            payViaCreditTripMunicipality,
            payViaCreditMobileNumber,
            payViaCreditAmount;

    String fullName, firstName, lastName, email, mobileNumber, age, address, tripAddress, gCashNumber, amountInGCash,tripFrom, tripTo;

    Spinner spinnerPayViaCreditTripDateFromMonth,
            spinnerPayViaCreditTripDateFromDay,
            spinnerPayViaCreditTripDateFromYear,
            spinnerPayViaCreditTripDateToMonth,
            spinnerPayViaCreditTripDateToDay,
            spinnerPayViaCreditTripDateToYear,
            payViaCredit_PerHour_Spinner,
            spinnerPayViaCreditTripRegions_spinner,
            spinnerPayViaCreditTripProvince_spinner,
            spinnerPayViaCreditTripMunicipality_spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_via_credit_page);

        Intent intent = getIntent();

        spinnerPayViaCreditTripDateFromMonth = findViewById(R.id.spinnerPayViaCreditTripDateFromMonth);
        spinnerPayViaCreditTripDateFromDay = findViewById(R.id.spinnerPayViaCreditTripDateFromDay);
        spinnerPayViaCreditTripDateFromYear = findViewById(R.id.spinnerPayViaCreditTripDateFromYear);
        spinnerPayViaCreditTripDateToMonth = findViewById(R.id.spinnerPayViaCreditTripDateToMonth);
        spinnerPayViaCreditTripDateToDay = findViewById(R.id.spinnerPayViaCreditTripDateToDay);
        spinnerPayViaCreditTripDateToYear = findViewById(R.id.spinnerPayViaCreditTripDateToYear);
        payViaCredit_PerHour_Spinner = findViewById(R.id.payViaCredit_PerHour_Spinner);
        spinnerPayViaCreditTripRegions_spinner = findViewById(R.id.spinnerPayViaCreditTripRegions_spinner);
        spinnerPayViaCreditTripProvince_spinner = findViewById(R.id.spinnerPayViaCreditTripProvince_spinner);

        providedDriverTextView = findViewById(R.id.providedDriverTextView);

        spinnerPayViaCreditTripMunicipality_spinner = findViewById(R.id.spinnerPayViaCreditTripMunicipality_spinner);


        ArrayAdapter<CharSequence> spinnerPayViaCreditTripDateFromMonth_adapter =  ArrayAdapter.createFromResource(this, R.array.month, android.R.layout.simple_spinner_item);
        spinnerPayViaCreditTripDateFromMonth_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPayViaCreditTripDateFromMonth.setAdapter(spinnerPayViaCreditTripDateFromMonth_adapter);

        ArrayAdapter<CharSequence> spinnerPayViaCreditTripDateFromDay_adapter =  ArrayAdapter.createFromResource(this, R.array.days, android.R.layout.simple_spinner_item);
        spinnerPayViaCreditTripDateFromDay_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPayViaCreditTripDateFromDay.setAdapter(spinnerPayViaCreditTripDateFromDay_adapter);

        ArrayAdapter<CharSequence> spinnerPayViaCreditTripDateFromYear_adapter =  ArrayAdapter.createFromResource(this, R.array.years, android.R.layout.simple_spinner_item);
        spinnerPayViaCreditTripDateFromYear_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPayViaCreditTripDateFromYear.setAdapter(spinnerPayViaCreditTripDateFromYear_adapter);

        ArrayAdapter<CharSequence> spinnerPayViaCreditTripDateToMonth_adapter =  ArrayAdapter.createFromResource(this, R.array.month, android.R.layout.simple_spinner_item);
        spinnerPayViaCreditTripDateToMonth_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPayViaCreditTripDateToMonth.setAdapter(spinnerPayViaCreditTripDateToMonth_adapter);

        ArrayAdapter<CharSequence> spinnerPayViaCreditTripDateToDay_adapter =  ArrayAdapter.createFromResource(this, R.array.days, android.R.layout.simple_spinner_item);
        spinnerPayViaCreditTripDateToDay_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPayViaCreditTripDateToDay.setAdapter(spinnerPayViaCreditTripDateToDay_adapter);

        ArrayAdapter<CharSequence> spinnerPayViaCreditTripDateToYear_adapter =  ArrayAdapter.createFromResource(this, R.array.years, android.R.layout.simple_spinner_item);
        spinnerPayViaCreditTripDateToYear_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPayViaCreditTripDateToYear.setAdapter(spinnerPayViaCreditTripDateToYear_adapter);

        ArrayAdapter<CharSequence> payViaCredit_PerHour_Spinner_adapter =  ArrayAdapter.createFromResource(this, R.array.hoursOptions, android.R.layout.simple_spinner_item);
        payViaCredit_PerHour_Spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        payViaCredit_PerHour_Spinner.setAdapter(payViaCredit_PerHour_Spinner_adapter);

        ArrayAdapter<CharSequence> spinnerPayViaCreditTripRegions_spinner_adapter =  ArrayAdapter.createFromResource(this, R.array.regions, android.R.layout.simple_spinner_item);
        spinnerPayViaCreditTripRegions_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPayViaCreditTripRegions_spinner.setAdapter(spinnerPayViaCreditTripRegions_spinner_adapter);

        ArrayAdapter<CharSequence> spinnerPayViaCreditTripProvince_spinner_adapter =  ArrayAdapter.createFromResource(this, R.array.provinces, android.R.layout.simple_spinner_item);
        spinnerPayViaCreditTripProvince_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPayViaCreditTripProvince_spinner.setAdapter(spinnerPayViaCreditTripProvince_spinner_adapter);

        ArrayAdapter<CharSequence> spinnerPayViaCreditTripMunicipality_spinner_adapter =  ArrayAdapter.createFromResource(this, R.array.provinces, android.R.layout.simple_spinner_item);
        spinnerPayViaCreditTripMunicipality_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPayViaCreditTripMunicipality_spinner.setAdapter(spinnerPayViaCreditTripMunicipality_spinner_adapter);


        payViaCreditContinueButton = findViewById(R.id.payViaCreditContinueButton);
        payViaCreditCarNameTextView = findViewById(R.id.payViaCreditCarNameTextView);
        payViaCreditCarPriceTextView = findViewById(R.id.payViaCreditCarPriceTextView);

        payViaCreditFirstName = findViewById(R.id.payViaCreditFirstName);
        payViaCreditLastName = findViewById(R.id.payViaCreditLastName);
        payViaCreditEmail = findViewById(R.id.payViaCreditEmail);
        payViaCreditPhoneNumber = findViewById(R.id.payViaCreditPhoneNumber);
        payViaCreditAge = findViewById(R.id.payViaCreditAge);
        payViaCreditAddress = findViewById(R.id.payViaCreditAddress);
        payViaCreditMobileNumber = findViewById(R.id.payViaCreditMobileNumber);
        payViaCreditAmount = findViewById(R.id.payViaCreditAmount);



        passValue_CarID = intent.getStringExtra(PaymentOption.EXTRA_TEXT_CAR_ID);
        passValue_CarName = intent.getStringExtra(PaymentOption.EXTRA_TEXT_CAR_NAME);
        passValue_CarPrice = intent.getStringExtra(PaymentOption.EXTRA_TEXT_CAR_PRICE);
        passValue_CompanyID = intent.getStringExtra(PaymentOption.EXTRA_TEXT_COMPANY_ID);
        passValue_CompanyAddress = intent.getStringExtra(PaymentOption.EXTRA_TEXT_COMPANY_ADDRESS);
        passValue_CompanyName = intent.getStringExtra(PaymentOption.EXTRA_TEXT_COMPANY_NAME);
        bookerID = intent.getStringExtra(PaymentOption.EXTRA_TEXT_BOOKER_ID);

        driverAccommodation = intent.getStringExtra(PaymentOption.EXTRA_TEXT_BOOKER_DRIVER_OPTION);

        firstName = payViaCreditFirstName.getText().toString();
        lastName = payViaCreditLastName.getText().toString();
        email = payViaCreditEmail.getText().toString();
        mobileNumber = payViaCreditPhoneNumber.getText().toString();
        age = payViaCreditAge.getText().toString();
        address = payViaCreditAddress.getText().toString();
        tripAddress = spinnerPayViaCreditTripMunicipality_spinner.getSelectedItem().toString() + ", " + spinnerPayViaCreditTripRegions_spinner.getSelectedItem().toString() + ", " + spinnerPayViaCreditTripProvince_spinner.getSelectedItem().toString();
        gCashNumber = payViaCreditMobileNumber.getText().toString();
        amountInGCash = payViaCreditAmount.getText().toString();

        payViaCreditCarNameTextView.setText(passValue_CarName);
        payViaCreditCarPriceTextView.setText(passValue_CarPrice);

        payViaCredit_AttachButton = findViewById(R.id.payViaCredit_AttachButton);

        if (driverAccommodation.equals("With Driver")){

            payViaCreditFirstName.setVisibility(View.INVISIBLE);
            payViaCreditLastName.setVisibility(View.INVISIBLE);
            payViaCreditEmail.setVisibility(View.INVISIBLE);
            payViaCreditPhoneNumber.setVisibility(View.INVISIBLE);
            payViaCreditAge.setVisibility(View.INVISIBLE);
            payViaCreditAddress.setVisibility(View.INVISIBLE);
            payViaCredit_AttachButton.setEnabled(false);

            payViaCreditFirstName.setText("N/A");
            payViaCreditLastName.setText("N/A");
            payViaCreditEmail.setText("N/A");
            payViaCreditPhoneNumber.setText("N/A");
            payViaCreditAge.setText("N/A");
            payViaCreditAddress.setText("N/A");
            providedDriverTextView.setVisibility(View.VISIBLE);

        }

        payViaCreditContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                driverAccommodation = intent.getStringExtra(PaymentOption.EXTRA_TEXT_BOOKER_DRIVER_OPTION);
                if (driverAccommodation.equals("With Driver")){
                    payViaCreditFirstName.setVisibility(View.INVISIBLE);
                    payViaCreditLastName.setVisibility(View.INVISIBLE);
                    payViaCreditEmail.setVisibility(View.INVISIBLE);
                    payViaCreditPhoneNumber.setVisibility(View.INVISIBLE);
                    payViaCreditAge.setVisibility(View.INVISIBLE);
                    payViaCreditAddress.setVisibility(View.INVISIBLE);

                    if (
                            payViaCreditMobileNumber.getText().toString().equals("")||
                            payViaCreditAmount.getText().toString().equals("")
                    ){
                        Toast.makeText(PayViaCreditPage.this, "Please do not leave any blank text field", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        openCreditReview();
                    }
                }
                else if (
                    payViaCreditFirstName.getText().toString().equals("")||
                    payViaCreditLastName.getText().toString().equals("")||
                    payViaCreditEmail.getText().toString().equals("")||
                    payViaCreditPhoneNumber.getText().toString().equals("")||
                    payViaCreditAge.getText().toString().equals("")||
                    payViaCreditAddress.getText().toString().equals("")||
                    payViaCreditMobileNumber.getText().toString().equals("")||
                    payViaCreditAmount.getText().toString().equals("")){
                    Toast.makeText(PayViaCreditPage.this, "Please do not leave any blank text field", Toast.LENGTH_SHORT).show();

                }
                else{
                    openCreditReview();
                }
            }
        });


        payViaCredit_AttachButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFileResource();
            }
        });

    }

    public void openCreditReview(){
        Intent puttingIntent = getIntent();
        payViaCreditContinueButton = findViewById(R.id.payViaCreditContinueButton);
        payViaCreditCarNameTextView = findViewById(R.id.payViaCreditCarNameTextView);
        payViaCreditCarPriceTextView = findViewById(R.id.payViaCreditCarPriceTextView);

        payViaCreditFirstName = findViewById(R.id.payViaCreditFirstName);
        payViaCreditLastName = findViewById(R.id.payViaCreditLastName);
        payViaCreditEmail = findViewById(R.id.payViaCreditEmail);
        payViaCreditPhoneNumber = findViewById(R.id.payViaCreditPhoneNumber);
        payViaCreditAge = findViewById(R.id.payViaCreditAge);
        payViaCreditAddress = findViewById(R.id.payViaCreditAddress);
        payViaCreditMobileNumber = findViewById(R.id.payViaCreditMobileNumber);
        payViaCreditAmount = findViewById(R.id.payViaCreditAmount);



        passValue_CarID = puttingIntent.getStringExtra(PaymentOption.EXTRA_TEXT_CAR_ID);
        passValue_CarName = puttingIntent.getStringExtra(PaymentOption.EXTRA_TEXT_CAR_NAME);
        passValue_CarPrice = puttingIntent.getStringExtra(PaymentOption.EXTRA_TEXT_CAR_PRICE);
        passValue_CompanyID = puttingIntent.getStringExtra(PaymentOption.EXTRA_TEXT_COMPANY_ID);
        passValue_CompanyAddress = puttingIntent.getStringExtra(PaymentOption.EXTRA_TEXT_COMPANY_ADDRESS);
        passValue_CompanyName = puttingIntent.getStringExtra(PaymentOption.EXTRA_TEXT_COMPANY_NAME);
        bookerID = puttingIntent.getStringExtra(PaymentOption.EXTRA_TEXT_BOOKER_ID);

        firstName = payViaCreditFirstName.getText().toString();
        lastName = payViaCreditLastName.getText().toString();
        email = payViaCreditEmail.getText().toString();
        mobileNumber = payViaCreditPhoneNumber.getText().toString();
        age = payViaCreditAge.getText().toString();
        address = payViaCreditAddress.getText().toString();
        tripAddress = spinnerPayViaCreditTripMunicipality_spinner.getSelectedItem().toString() + ", " + spinnerPayViaCreditTripRegions_spinner.getSelectedItem().toString() + ", " + spinnerPayViaCreditTripProvince_spinner.getSelectedItem().toString();
        gCashNumber = payViaCreditMobileNumber.getText().toString();
        amountInGCash = payViaCreditAmount.getText().toString();

        fullName = firstName + " " + lastName;
        driverAccommodation = puttingIntent.getStringExtra(PaymentOption.EXTRA_TEXT_BOOKER_DRIVER_OPTION);




        tripFrom = spinnerPayViaCreditTripDateFromMonth.getSelectedItem().toString() +
                ", " + spinnerPayViaCreditTripDateFromDay.getSelectedItem().toString() +
                ", " + spinnerPayViaCreditTripDateFromYear.getSelectedItem().toString();

        tripTo = spinnerPayViaCreditTripDateToMonth.getSelectedItem().toString() +
                ", " + spinnerPayViaCreditTripDateToDay.getSelectedItem().toString() +
                ", " + spinnerPayViaCreditTripDateToYear.getSelectedItem().toString();


        Intent intent = new Intent(this, PayViaCreditReview.class);
        intent.putExtra(EXTRA_TEXT_CAR_ID, passValue_CarID);
        intent.putExtra(EXTRA_TEXT_COMPANY_ID, passValue_CompanyID);
        intent.putExtra(EXTRA_TEXT_COMPANY_NAME, passValue_CompanyName);
        intent.putExtra(EXTRA_TEXT_CAR_PRICE, passValue_CarPrice);
        intent.putExtra(EXTRA_TEXT_COMPANY_ADDRESS, passValue_CompanyAddress);
        intent.putExtra(EXTRA_TEXT_CAR_NAME, passValue_CarName);
        intent.putExtra(EXTRA_TEXT_BOOKER_ID, bookerID);
        intent.putExtra(EXTRA_TEXT_BOOKER_FULLNAME, fullName);
        intent.putExtra(EXTRA_TEXT_BOOKER_ADDRESS, address);
        intent.putExtra(EXTRA_TEXT_BOOKER_AGE, age);
        intent.putExtra(EXTRA_TEXT_BOOKER_EMAIL, email);
        intent.putExtra(EXTRA_TEXT_BOOKER_PHONE_NUMBER, mobileNumber);
        intent.putExtra(EXTRA_TEXT_BOOKER_TRIP_DATE_FROM, tripFrom);
        intent.putExtra(EXTRA_TEXT_BOOKER_TRIP_DATE_TO, tripTo);
        intent.putExtra(EXTRA_TEXT_BOOKER_TRIP_ADDRESS, tripAddress);
        intent.putExtra(EXTRA_TEXT_BOOKER_GCASH, gCashNumber);
        intent.putExtra(EXTRA_TEXT_BOOKER_AMOUNT, amountInGCash);
        intent.putExtra(EXTRA_TEXT_BOOKER_DRIVER_OPTION, driverAccommodation);

        startActivity(intent);
    }

    private void openFileResource() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        startActivityForResult(intent, 10);
    }

}