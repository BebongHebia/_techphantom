package com.example.cafinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UpdatingPassword extends AppCompatActivity {
    MyDatabaseHelper myDB = new MyDatabaseHelper(UpdatingPassword.this);
    EditText editPasswordPage_CurrentPassword_ET, editPasswordPage_NewPassword_ET2;
    Button checkPasswordButton, changePasswordButton;
    String passedPhoneNumber;
    TextView textView23;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updating_password);

        Intent intent = getIntent();
        passedPhoneNumber = intent.getStringExtra(EditProfilePage.EXTRA_TEXT_PHONE_NUMBER);
        textView23 = findViewById(R.id.textView23);
        editPasswordPage_NewPassword_ET2 = findViewById(R.id.editPasswordPage_NewPassword_ET2);

        editPasswordPage_CurrentPassword_ET = findViewById(R.id.editPasswordPage_CurrentPassword_ET);
        checkPasswordButton = findViewById(R.id.checkPasswordButton);
        changePasswordButton = findViewById(R.id.changePasswordButton);
        checkPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String editPasswordPage_CurrentPassword_TEXT = editPasswordPage_CurrentPassword_ET.getText().toString();
                String passwordChecker = myDB.getClientPassword(passedPhoneNumber).toString();
                if (editPasswordPage_CurrentPassword_TEXT.equals(passwordChecker)){
                    textView23.setVisibility(View.VISIBLE);
                    changePasswordButton.setVisibility(View.VISIBLE);
                    editPasswordPage_NewPassword_ET2.setVisibility(View.VISIBLE);
                }else{
                    Toast.makeText(UpdatingPassword.this, "You Entered Wrong Password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        changePasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newpassword = editPasswordPage_NewPassword_ET2.getText().toString();
                boolean isPasswordChanges = myDB.UpdateClientPassword(passedPhoneNumber, newpassword);
                if (isPasswordChanges == true){
                    Toast.makeText(UpdatingPassword.this, "Password Changes", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(UpdatingPassword.this, "Updating Password Fail", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}