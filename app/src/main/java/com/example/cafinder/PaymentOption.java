package com.example.cafinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class PaymentOption extends AppCompatActivity {

    public static final String EXTRA_TEXT_CAR_ID = "com.example.cedula.example.EXTRA_TEXT_CAR_ID";
    public static final String EXTRA_TEXT_COMPANY_ID = "com.example.cedula.example.EXTRA_TEXT_COMPANY_ID";
    public static final String EXTRA_TEXT_COMPANY_NAME = "com.example.cedula.example.EXTRA_TEXT_COMPANY_NAME";
    public static final String EXTRA_TEXT_CAR_PRICE = "com.example.cedula.example.EXTRA_TEXT_CAR_PRICE";
    public static final String EXTRA_TEXT_COMPANY_ADDRESS = "com.example.cedula.example.EXTRA_TEXT_COMPANY_ADDRESS";
    public static final String EXTRA_TEXT_CAR_NAME = "com.example.cedula.example.EXTRA_TEXT_CAR_NAME";
    public static final String EXTRA_TEXT_BOOKER_ID = "com.example.cedula.example.EXTRA_TEXT_BOOKER_ID";
    public static final String EXTRA_TEXT_BOOKER_DRIVER_OPTION = "com.example.cedula.example.EXTRA_TEXT_BOOKER_DRIVER_OPTION";

    TextView paymentOptionCarName, paymentOptionCarPrice, textView55;
    RadioGroup radio_group_payment_mode;
    String passValue_CarID, passValue_CarName, passValue_CarPrice, passValue_CompanyID, passValue_CompanyAddress, passValue_CompanyName, bookerID, driverAccommodation;

    Button paymentOption_withDriver_Button, paymentOption_withoutDriver_Button;

    MyDatabaseHelper myDB = new MyDatabaseHelper(PaymentOption.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_option);



        paymentOption_withDriver_Button = findViewById(R.id.paymentOption_withDriver_Button);
        paymentOption_withoutDriver_Button = findViewById(R.id.paymentOption_withoutDriver_Button);

        radio_group_payment_mode = findViewById(R.id.radio_group_payment_mode);
        textView55 = findViewById(R.id.textView55);

        paymentOption_withDriver_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                driverAccommodation = "With Driver";
                radio_group_payment_mode.setVisibility(View.VISIBLE);
                textView55.setVisibility(View.VISIBLE);
            }
        });

        paymentOption_withoutDriver_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                driverAccommodation = "Self Drive";
                radio_group_payment_mode.setVisibility(View.VISIBLE);
                textView55.setVisibility(View.VISIBLE);
                openDriverAgreement();
            }
        });


        Intent intent = getIntent();
        passValue_CarID = intent.getStringExtra(ViewCarDetails.EXTRA_TEXT_CAR_ID);
        passValue_CarName = intent.getStringExtra(ViewCarDetails.EXTRA_TEXT_CAR_NAME);
        passValue_CarPrice = intent.getStringExtra(ViewCarDetails.EXTRA_TEXT_CAR_PRICE);
        passValue_CompanyID = intent.getStringExtra(ViewCarDetails.EXTRA_TEXT_COMPANY_ID);
        passValue_CompanyAddress = intent.getStringExtra(ViewCarDetails.EXTRA_TEXT_COMPANY_ADDRESS);
        passValue_CompanyName = intent.getStringExtra(ViewCarDetails.EXTRA_TEXT_COMPANY_NAME);
        bookerID = intent.getStringExtra(ViewCarDetails.EXTRA_TEXT_BOOKER_ID);

        Toast.makeText(this, bookerID, Toast.LENGTH_SHORT).show();

        paymentOptionCarName = findViewById(R.id.paymentOptionCarName);
        paymentOptionCarPrice = findViewById(R.id.paymentOptionCarPrice);

        paymentOptionCarName.setText("Car Model : " + passValue_CarName);
        paymentOptionCarPrice.setText("Car Price : " + passValue_CarPrice);

        RadioButton payViaCounterRadioButton = findViewById(R.id.payViaCounterRadioButton);
        RadioButton payViaCreditRadioButton = findViewById(R.id.payViaCreditRadioButton);
        Button continueButton = findViewById(R.id.continueButton);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (payViaCounterRadioButton.isChecked()){
                    openViaCounter();
                }
                else if(payViaCreditRadioButton.isChecked()){
                    openViaCredit();
                }
                else{

                }
            }
        });

        String gotDriver = myDB.gotDriver(passValue_CarID).toString();

        if (gotDriver.equals("With Driver")){
            driverAccommodation = "With Driver";
            radio_group_payment_mode.setVisibility(View.VISIBLE);
            textView55.setVisibility(View.VISIBLE);

            paymentOption_withoutDriver_Button.setVisibility(View.INVISIBLE);
            paymentOption_withDriver_Button.setVisibility(View.INVISIBLE);
        }






    }

    private void openViaCredit() {
        Intent intent = new Intent(this, PayViaCreditPage.class);

        intent.putExtra(EXTRA_TEXT_CAR_ID, passValue_CarID);
        intent.putExtra(EXTRA_TEXT_CAR_NAME, passValue_CarName);
        intent.putExtra(EXTRA_TEXT_CAR_PRICE, passValue_CarPrice);
        intent.putExtra(EXTRA_TEXT_COMPANY_ID, passValue_CompanyID);
        intent.putExtra(EXTRA_TEXT_COMPANY_NAME, passValue_CompanyName);
        intent.putExtra(EXTRA_TEXT_COMPANY_ADDRESS, passValue_CompanyAddress);
        intent.putExtra(EXTRA_TEXT_BOOKER_ID, bookerID);
        intent.putExtra(EXTRA_TEXT_BOOKER_DRIVER_OPTION, driverAccommodation);
        startActivity(intent);
        finish();

    }

    private void openViaCounter() {
        Intent intent = new Intent(this, PayViaCounterPage.class);

        intent.putExtra(EXTRA_TEXT_CAR_ID, passValue_CarID);
        intent.putExtra(EXTRA_TEXT_CAR_NAME, passValue_CarName);
        intent.putExtra(EXTRA_TEXT_CAR_PRICE, passValue_CarPrice);
        intent.putExtra(EXTRA_TEXT_COMPANY_ID, passValue_CompanyID);
        intent.putExtra(EXTRA_TEXT_COMPANY_NAME, passValue_CompanyName);
        intent.putExtra(EXTRA_TEXT_COMPANY_ADDRESS, passValue_CompanyAddress);
        intent.putExtra(EXTRA_TEXT_BOOKER_ID, bookerID);
        intent.putExtra(EXTRA_TEXT_BOOKER_DRIVER_OPTION, driverAccommodation);

        startActivity(intent);
        finish();

    }

    public void openDriverAgreement(){
        Intent intent = new Intent(this, WithoutDriverTermsAndAgreement.class);
        intent.putExtra("companyID", passValue_CompanyID);
        startActivity(intent);
    }
}