package com.example.cafinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_options);

        TextView loginOptionLaterTextview = findViewById(R.id.loginOptionLaterTextview);
        String laterText = "Later";

        SpannableString ss1 = new SpannableString(laterText);

        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                openClientDashboard();
            }
        };

        ss1.setSpan(clickableSpan1, 0, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        loginOptionLaterTextview.setText(ss1);
        loginOptionLaterTextview.setMovementMethod(LinkMovementMethod.getInstance());


        Button gotoLoginBtn = findViewById(R.id.goToLoginBtn);
        Button gotoSignupBtn;
        gotoSignupBtn = findViewById(R.id.goToSignupBtn);

        gotoLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLoginActivity();
            }
        });

        gotoSignupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignupActivity();
            }
        });

    }

    public void openSignupActivity() {
        Intent intent = new Intent(this, SignupOptionsActivity.class);
        startActivity(intent);
    }

    public void openLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void openClientDashboard(){
        Intent intent = new Intent(this, DashboardNoAccount.class);
        startActivity(intent);
    }
}