package com.example.cafinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class ConfirmRequestReturn extends AppCompatActivity {
    MyDatabaseHelper myDB;
    String transactionID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_request_return);
        myDB = new MyDatabaseHelper(ConfirmRequestReturn.this);
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

        transactionID = intent.getStringExtra(ViewOutgoingTransactionDetails.PASS_BOOKING_ID);

        String bookingID = myDB.getTransactionBookingID_ByTransactionID(transactionID).toString();




        Button confirmRequest_requestButton = findViewById(R.id.confirmRequest_requestButton);
        confirmRequest_requestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDB.rentedExpire(transactionID, "Car Rented Days Due");
                myDB.rentedCarPicked(bookingID, "Rented Days Expired");
                finish();
            }
        });

    }
}