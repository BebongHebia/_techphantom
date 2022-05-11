package com.example.cafinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class DashboardNoAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_no_account);

        Button dashboardNoAccount_showMoreButton = findViewById(R.id.dashboardNoAccount_showMoreButton);
        dashboardNoAccount_showMoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNeedToLoginOrSignup();
            }
        });



    }

    public void openNeedToLoginOrSignup(){
        Intent intent = new Intent(this, NeedToLoginSignupFirst.class);
        startActivity(intent);
    }
}