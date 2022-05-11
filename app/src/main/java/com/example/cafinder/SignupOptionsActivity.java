package com.example.cafinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignupOptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_options);

        Button goToClientSignUpBTN = findViewById(R.id.gotoClientSignupBTN);
        Button goToBusinessOwnerSignUpBTN = findViewById(R.id.gotoBusinessOwnerSignupBTN);
        goToClientSignUpBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openClientSignupBtn();
            }
        });
        goToBusinessOwnerSignUpBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBusinessOwnerSignup();
            }
        });
    }

    public void openBusinessOwnerSignup() {
        Intent intent = new Intent(this, BusinessOwnerSignupActivity.class);
        startActivity(intent);
    }

    public void openClientSignupBtn() {
        Intent intent = new Intent(this, SignupClientActivity.class);
        startActivity(intent);
    }
}