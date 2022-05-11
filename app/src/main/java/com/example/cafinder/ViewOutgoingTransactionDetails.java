package com.example.cafinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewOutgoingTransactionDetails extends AppCompatActivity {
        public static final String PASS_BOOKING_ID = "com.example.cedula.example.PASS_BOOKING_ID";

        MyDatabaseHelper myDB = new MyDatabaseHelper(ViewOutgoingTransactionDetails.this);


        TextView
        transaction_booker_name_tv,
        transaction_car_model_tv,
        transaction_trip_date_tv,
        transaction_trip_routes_tv,
        transaction_date_pickup_tv,
        transaction_return_status_tv,
        transaction_company_owner_tv,
        transaction_company_id_tv,
        transaction_booker_id_tv;

        String getIDBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_outgoing_transaction_details);

        TextView transactionID_tv = findViewById(R.id.transactionID_tv);

        String transactionID = "ID not found";
        Bundle extras = getIntent().getExtras();
        if (extras != null){
            transactionID = extras.getString("transactionID");
        }

        transactionID_tv.setText(transactionID);




        transaction_booker_name_tv = findViewById(R.id.transaction_booker_name_tv);
        transaction_car_model_tv = findViewById(R.id.transaction_car_model_tv);
        transaction_trip_date_tv = findViewById(R.id.transaction_trip_date_tv);
        transaction_trip_routes_tv = findViewById(R.id.transaction_trip_routes_tv);
        transaction_date_pickup_tv = findViewById(R.id.transaction_date_pickup_tv);
        transaction_return_status_tv = findViewById(R.id.transaction_return_status_tv);
        transaction_company_owner_tv = findViewById(R.id.transaction_company_owner_tv);
        transaction_company_id_tv = findViewById(R.id.transaction_company_id_tv);
        transaction_booker_id_tv = findViewById(R.id.transaction_booker_id_tv);

        //Car Returned

        transaction_booker_name_tv.setText(myDB.getTransactionName_ByTransactionID(transactionID));
        transaction_car_model_tv.setText(myDB.getTransactionCarName_ByTransactionID(transactionID));
        transaction_trip_date_tv.setText(myDB.getTransactionTripDate_ByTransactionID(transactionID));
        transaction_trip_routes_tv.setText(myDB.getTransactionTripRoutes_ByTransactionID(transactionID));
        transaction_date_pickup_tv.setText(myDB.getTransactionDatePickedUp_ByTransactionID(transactionID));
        transaction_return_status_tv.setText(myDB.getTransactionReturnStatus_ByTransactionID(transactionID));
        transaction_company_owner_tv.setText(myDB.getTransactionCompanyOwner_ByTransactionID(transactionID));
        transaction_company_id_tv.setText(myDB.getTransactionCompanyID_ByTransactionID(transactionID));
        transaction_booker_id_tv.setText(myDB.getTransactionBookerID_ByTransactionID(transactionID));

        Button transaction_request_return_Button = findViewById(R.id.transaction_request_return_Button);
        if (myDB.getTransactionReturnStatus_ByTransactionID(transactionID).toString().equals("Car Returned")){
            transaction_request_return_Button.setEnabled(false);
        }



        transaction_request_return_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openConfirmRequestReturn();
            }
        });

        getIDBooking = transactionID;

        Button outgoing_DeleteButton = findViewById(R.id.outgoing_DeleteButton);
        outgoing_DeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openConfirmDeleteTransaction();
            }
        });

    }

    public void openConfirmRequestReturn(){
        Intent intent = new Intent(this, ConfirmRequestReturn.class);
        intent.putExtra(PASS_BOOKING_ID, getIDBooking);
        startActivity(intent);
    }

    public void openConfirmDeleteTransaction(){
        Intent intent = new Intent(this, ConfirmDeleteTransaction.class);
        intent.putExtra(PASS_BOOKING_ID, getIDBooking);
        startActivity(intent);
    }
}