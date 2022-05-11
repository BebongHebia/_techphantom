package com.example.cafinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ForgotPassword extends AppCompatActivity {
    public static final String EXTRA_TEXT_CLIENT_ID = "com.example.cedula.example.EXTRA_TEXT_CLIENT_ID";


    MyDatabaseHelper myDB = new MyDatabaseHelper(ForgotPassword.this);

    String myInputEmail, myDatabaseEmail, myDatabaseID, myNewPassword;
    TextView textView124;
    EditText forgotPassword_NewPassword_ET, forgotPassword_Email_ET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password);

        forgotPassword_Email_ET = findViewById(R.id.forgotPassword_Email_ET);

        textView124 = findViewById(R.id.textView124);
        forgotPassword_NewPassword_ET = findViewById(R.id.forgotPassword_NewPassword_ET);


        Button forgotPassword_IdentifyEmail_Button = findViewById(R.id.forgotPassword_IdentifyEmail_Button);

        forgotPassword_IdentifyEmail_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myInputEmail = forgotPassword_Email_ET.getText().toString();
                myDatabaseEmail = myDB.getForgotPassword_clientEmail(myInputEmail).toString();
                myDatabaseID = myDB.getForgotPassword_clientID(myDatabaseEmail).toString();
                if (myInputEmail.equals("")){
                    Toast.makeText(ForgotPassword.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                }
                else if (myInputEmail.equals(myDatabaseEmail)){
                    textView124.setVisibility(View.VISIBLE);
                    forgotPassword_NewPassword_ET.setVisibility(View.VISIBLE);
                }else{
                    Toast.makeText(ForgotPassword.this, "Sorry we didn't recognize your Account Try Contact Admin Support", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button forgotPassword_Save_Button = findViewById(R.id.forgotPassword_Save_Button);
        forgotPassword_Save_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDatabaseID = myDB.getForgotPassword_clientID(myDatabaseEmail).toString();
                myNewPassword = forgotPassword_NewPassword_ET.getText().toString();
                boolean myStatus = myDB.forgotPassword_ChangeClientPassword(myDatabaseID, myNewPassword);

                if (myStatus == true){
                    openForgotPasswordSuccess();
                }
                else{
                    Toast.makeText(ForgotPassword.this, "Failed", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void openForgotPasswordSuccess(){
        Intent intent = new Intent(this, ForgotPasswordPanel.class);
        intent.putExtra(EXTRA_TEXT_CLIENT_ID, myDatabaseID);
        startActivity(intent);
    }
}