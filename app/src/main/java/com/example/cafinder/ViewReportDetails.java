package com.example.cafinder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ViewReportDetails extends AppCompatActivity {

        MyDatabaseHelper myDB = new MyDatabaseHelper(ViewReportDetails.this);

        TextView reportsBookingID_TV,
            reportsFullName_TV,
            reportsBookerAddress_TV,
            reportsBookerAge_TV,
            reportsBookerEmail_TV,
            reportsBookerPhoneNumber_TV,
            reportsCarModel_TV,
            reportsPaymentMethod_TV,
            reportsDateBooked_TV;


    String historyID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_report_details);

        Bundle intent = getIntent().getExtras();

        historyID = intent.getString("historyID");



        reportsBookingID_TV = findViewById(R.id.reportsBookingID_TV);
        reportsFullName_TV = findViewById(R.id.reportsFullName_TV);
        reportsBookerAddress_TV = findViewById(R.id.reportsBookerAddress_TV);
        reportsBookerAge_TV = findViewById(R.id.reportsBookerAge_TV);
        reportsBookerEmail_TV = findViewById(R.id.reportsBookerEmail_TV);
        reportsBookerPhoneNumber_TV = findViewById(R.id.reportsBookerPhoneNumber_TV);
        reportsCarModel_TV = findViewById(R.id.reportsCarModel_TV);
        reportsPaymentMethod_TV = findViewById(R.id.reportsPaymentMethod_TV);
        reportsDateBooked_TV = findViewById(R.id.reportsDateBooked_TV);

        reportsBookingID_TV.setText(historyID);
        reportsFullName_TV.setText(myDB.reportsBookingFullName(historyID));
        reportsBookerAddress_TV.setText(myDB.reportsBookingAddress(historyID));
        reportsBookerAge_TV.setText(myDB.reportsBookingAddress(historyID));
        reportsBookerEmail_TV.setText(myDB.reportsBookingEmail(historyID));
        reportsBookerPhoneNumber_TV.setText(myDB.reportsBookingPhoneNumber(historyID));
        reportsCarModel_TV.setText(myDB.reportsBookingCarModelName(historyID));
        reportsPaymentMethod_TV.setText(myDB.reportsBookingPaymentMethod(historyID));
        reportsDateBooked_TV.setText(myDB.reportsBookingDateBooked(historyID));

        Button reportsBackButton = findViewById(R.id.reportsBackButton);
        reportsBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}