package com.example.cafinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class PayViaCreditBookingSuccessfulPopUp extends AppCompatActivity {
    public static final String CLIENT_ID_NUMBER = "com.example.cedula.example.CLIENT_ID_NUMBER";
    String clientIDNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_via_credit_booking_successful_pop_up);

        //Start of Pop up

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width* .8), (int) (height* .3));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);
        //End of Pop up

        Intent intent = getIntent();
        clientIDNumber = intent.getStringExtra(PayViaCreditReview.CLIENT_ID_NUMBER);


        Button creditBackToDashButton = findViewById(R.id.creditBackToDashButton);
        creditBackToDashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openClientDashboard();
            }
        });
    }

    public void openClientDashboard() {
        Intent intent = new Intent(this, ClientDashboard.class);
        intent.putExtra("clientID", clientIDNumber);
        startActivity(intent);

    }
}