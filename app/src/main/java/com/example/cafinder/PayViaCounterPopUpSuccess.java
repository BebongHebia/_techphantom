package com.example.cafinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class PayViaCounterPopUpSuccess extends AppCompatActivity {
    public static final String EXTRA_TEXT_CAR_ID = "com.example.cedula.example.EXTRA_TEXT_CAR_ID";
    String passValue_BookerID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_via_counter_pop_up_success);

        //Start of Pop up

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width* .6), (int) (height* .4));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);
        //End of Pop up
        Intent getIntent = getIntent();

        passValue_BookerID = getIntent.getStringExtra(PaymentViaCounterReview.EXTRA_TEXT_CAR_ID);

        Button payViaCounterBackToDashboardBTN = findViewById(R.id.payViaCounterBackToDashboardButton);
        payViaCounterBackToDashboardBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDashboard();
            }
        });



    }

    public void openDashboard(){
        Intent intent = new Intent(this, ClientDashboard.class);
        intent.putExtra("clientID", passValue_BookerID);
        startActivity(intent);
    }


}