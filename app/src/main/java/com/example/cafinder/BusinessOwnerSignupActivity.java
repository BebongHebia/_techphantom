package com.example.cafinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BusinessOwnerSignupActivity extends AppCompatActivity {
    MyDatabaseHelper myDB = new MyDatabaseHelper(BusinessOwnerSignupActivity.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.business_owner_signup);
        //Initialization of Elements
        Button businessOwner_SignupButton = findViewById(R.id.businessOwner_SignupButton);
        EditText businessOwnerSignup_BusinessName_ET, businessOwnerSignup_BusinessAddress_ET, businessOwnerSignup_BusinessHotLine_ET, businessOwnerSignup_BusinessUsername_ET,
                businessOwnerSignup_BusinessEmail_ET, businessOwnerSignup_BusinessPassword_ET, businessOwnerSignup_BusinessReEnterPassword_ET, businessOwnerSignup_DTINo_ET,
        businessOwnerSignup_MayorPermitNo_ET, businessOwnerSignup_BIRRegNo_ET, businessOwnerSignup_PhilGepsRegNo_ET;




        businessOwnerSignup_BusinessName_ET = findViewById(R.id.businessOwnerSignup_BusinessName_ET);
        businessOwnerSignup_BusinessAddress_ET = findViewById(R.id.businessOwnerSignup_BusinessAddress_ET);
        businessOwnerSignup_BusinessHotLine_ET = findViewById(R.id.businessOwnerSignup_BusinessHotLine_ET);
        businessOwnerSignup_BusinessUsername_ET = findViewById(R.id.businessOwnerSignup_BusinessUsername_ET);
        businessOwnerSignup_BusinessEmail_ET = findViewById(R.id.businessOwnerSignup_BusinessEmail_ET);
        businessOwnerSignup_BusinessPassword_ET = findViewById(R.id.businessOwnerSignup_BusinessPassword_ET);
        businessOwnerSignup_BusinessReEnterPassword_ET = findViewById(R.id.businessOwnerSignup_BusinessReEnterPassword_ET);

        businessOwnerSignup_DTINo_ET = findViewById(R.id.businessOwnerSignup_DTINo_ET);
        businessOwnerSignup_MayorPermitNo_ET = findViewById(R.id.businessOwnerSignup_MayorPermitNo_ET);
        businessOwnerSignup_BIRRegNo_ET = findViewById(R.id.businessOwnerSignup_BIRRegNo_ET);
        businessOwnerSignup_PhilGepsRegNo_ET = findViewById(R.id.businessOwnerSignup_PhilGepsRegNo_ET);



        businessOwner_SignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Initialization of Strings

                String businessOwnerSignup_DTINo_STR,
                        businessOwnerSignup_MayorPermitNo_STR,
                        businessOwnerSignup_BIRRegNo_STR,
                        businessOwnerSignup_PhilGepsRegNo_STR;

                String BusinessOwnerName = businessOwnerSignup_BusinessName_ET.getText().toString();
                String BusinessOwnerAddress = businessOwnerSignup_BusinessAddress_ET.getText().toString();
                String BusinessOwnerHotline = businessOwnerSignup_BusinessHotLine_ET.getText().toString();
                String BusinessOwnerUserName = businessOwnerSignup_BusinessUsername_ET.getText().toString();
                String BusinessOwnerEmail = businessOwnerSignup_BusinessEmail_ET.getText().toString();
                String BusinessOwnerPassword = businessOwnerSignup_BusinessPassword_ET.getText().toString();

                businessOwnerSignup_DTINo_STR =  businessOwnerSignup_DTINo_ET.getText().toString();
                businessOwnerSignup_MayorPermitNo_STR =  businessOwnerSignup_MayorPermitNo_ET.getText().toString();
                businessOwnerSignup_BIRRegNo_STR =  businessOwnerSignup_BIRRegNo_ET.getText().toString();
                businessOwnerSignup_PhilGepsRegNo_STR =  businessOwnerSignup_PhilGepsRegNo_ET.getText().toString();

                if (businessOwnerSignup_BusinessName_ET.getText().toString().equals("")|| businessOwnerSignup_BusinessAddress_ET.getText().toString().equals("")|| businessOwnerSignup_BusinessHotLine_ET.getText().toString().equals("")|| businessOwnerSignup_BusinessUsername_ET.getText().toString().equals("")|| businessOwnerSignup_BusinessEmail_ET.getText().toString().equals("")|| businessOwnerSignup_BusinessPassword_ET.getText().toString().equals("")|| businessOwnerSignup_BusinessReEnterPassword_ET.getText().toString().equals("") ||
                    businessOwnerSignup_DTINo_STR.equals("") ||
                    businessOwnerSignup_MayorPermitNo_STR.equals("") ||
                    businessOwnerSignup_BIRRegNo_STR.equals("")
                ){
                    Toast.makeText(BusinessOwnerSignupActivity.this, "You Skipped Something on your Application, Please Review", Toast.LENGTH_SHORT).show();
                }else{
                    if (businessOwnerSignup_BusinessPassword_ET.getText().toString().equals(businessOwnerSignup_BusinessReEnterPassword_ET.getText().toString())){

                        myDB.addBusinessOwner(BusinessOwnerUserName, BusinessOwnerEmail, BusinessOwnerHotline, BusinessOwnerName, BusinessOwnerAddress,BusinessOwnerPassword, businessOwnerSignup_DTINo_STR,
                                businessOwnerSignup_MayorPermitNo_STR, businessOwnerSignup_BIRRegNo_STR, businessOwnerSignup_PhilGepsRegNo_STR);

                        businessOwnerSignup_BusinessName_ET.getText().clear();
                        businessOwnerSignup_BusinessAddress_ET.getText().clear();
                        businessOwnerSignup_BusinessHotLine_ET.getText().clear();
                        businessOwnerSignup_BusinessUsername_ET.getText().clear();
                        businessOwnerSignup_BusinessEmail_ET.getText().clear();
                        businessOwnerSignup_BusinessPassword_ET.getText().clear();
                        businessOwnerSignup_BusinessReEnterPassword_ET.getText().clear();
                        businessOwnerSignup_DTINo_ET.getText().clear();
                        businessOwnerSignup_MayorPermitNo_ET.getText().clear();
                        businessOwnerSignup_BIRRegNo_ET.getText().clear();
                        businessOwnerSignup_PhilGepsRegNo_ET.getText().clear();

                        openBusinessOwnerSignupCompletePopUp();

                    }
                    else{
                        Toast.makeText(BusinessOwnerSignupActivity.this, "Password Not Equal, Please Try Again", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }

    public void openBusinessOwnerSignupCompletePopUp(){
        Intent intent = new Intent(this, BusinessOwnerSignupSuccessfulPopUp.class);
        startActivity(intent);
        finish();
    }
}