package com.example.cafinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignupClientActivity extends AppCompatActivity {
    MyDatabaseHelper myDB = new MyDatabaseHelper(SignupClientActivity.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_client);



        //Initialization of Elements
        EditText clientSignupFirstNameET, clientSignupLastNameET, clientSignupEmailET, clientSignupMobileNumberET, clientSignupPasswordET, clientSignupReEnterPasswordET;
        Button clientSignupButton = findViewById(R.id.clientSignupButton);

        //Setting Value of The Declared
        clientSignupFirstNameET = findViewById(R.id.clientSignupFirstNameET);
        clientSignupLastNameET = findViewById(R.id.clientSignupLastNameET);
        clientSignupEmailET = findViewById(R.id.clientSignupEmailET);
        clientSignupMobileNumberET = findViewById(R.id.clientSignupMobileNumberET);
        clientSignupPasswordET = findViewById(R.id.clientSignupPasswordET);
        clientSignupReEnterPasswordET = findViewById(R.id.clientSignupReEnterPasswordET);

        clientSignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clientSignupFirstNameET.getText().toString().equals("")||
                        clientSignupLastNameET.getText().toString().equals("")||
                        clientSignupEmailET.getText().toString().equals("")||
                        clientSignupMobileNumberET.getText().toString().equals("")||
                        clientSignupPasswordET.getText().toString().equals("")||
                        clientSignupReEnterPasswordET.getText().toString().equals("")){
                    Toast.makeText(SignupClientActivity.this, "You Skipped a form Please Review your Application", Toast.LENGTH_SHORT).show();
                }

                else{
                    if (clientSignupPasswordET.getText().toString().equals(clientSignupReEnterPasswordET.getText().toString())){
                        String firstName = clientSignupFirstNameET.getText().toString();
                        String lastName = clientSignupLastNameET.getText().toString();
                        String email = clientSignupEmailET.getText().toString();
                        String phoneNumber = clientSignupMobileNumberET.getText().toString();
                        String password = clientSignupPasswordET.getText().toString();

                        myDB.AddClient(firstName, lastName, phoneNumber, email, password);

                        clientSignupFirstNameET.getText().clear();
                        clientSignupLastNameET.getText().clear();
                        clientSignupEmailET.getText().clear();
                        clientSignupMobileNumberET.getText().clear();
                        clientSignupPasswordET.getText().clear();
                        clientSignupReEnterPasswordET.getText().clear();
                        openClientSignupPopUp();
                    }
                    else{
                        Toast.makeText(SignupClientActivity.this, "Password Does Not Match Please Try Again", Toast.LENGTH_SHORT).show();
                    }

                }


            }
        });



    }

    public void openClientSignupPopUp(){
        Intent intent = new Intent(this, ClientSignupCompletePopUp.class);
        startActivity(intent);
    }


}