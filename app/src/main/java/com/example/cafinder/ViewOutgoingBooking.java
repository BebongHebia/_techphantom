package com.example.cafinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewOutgoingBooking extends AppCompatActivity {
    String passedCompanyID;

    RecyclerView recyclerViewForOngoingBooking;
    MyDatabaseHelper myDB;

    ArrayList<String> transactionID, transactionFullName, transactionCarModel, transactionTripDate, transactionTripRoutes, transactionReturnStatus;

    OutgoingTransactionCustomAdapter outgoingTransactionCustomAdapter;

    private OutgoingTransactionCustomAdapter.OutgoingTransactionClickListener listener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_outgoing_booking);
        setOnClickListener();

        Intent intent = getIntent();

        passedCompanyID = intent.getStringExtra(ConfirmBooking.COMPANY_ID);

        myDB = new MyDatabaseHelper(ViewOutgoingBooking.this);
        recyclerViewForOngoingBooking = findViewById(R.id.recyclerViewForOngoingBooking);




        transactionID = new ArrayList<>();
        transactionFullName = new ArrayList<>();
        transactionCarModel = new ArrayList<>();
        transactionTripDate = new ArrayList<>();
        transactionTripRoutes = new ArrayList<>();
        transactionReturnStatus = new ArrayList<>();

        outgoingTransactionCustomAdapter = new OutgoingTransactionCustomAdapter(ViewOutgoingBooking.this, transactionID,
                transactionFullName,
                transactionCarModel,
                transactionTripDate,
                transactionTripRoutes,
                transactionReturnStatus, listener);

        recyclerViewForOngoingBooking.setAdapter(outgoingTransactionCustomAdapter);
        recyclerViewForOngoingBooking.setLayoutManager(new LinearLayoutManager(ViewOutgoingBooking.this));


        displayAllData();






    }

    public void displayAllData(){
        Cursor cursor = myDB.readAllDataForOngoingTransactions(passedCompanyID);
        if (cursor.getCount() == 0){
            Toast.makeText(ViewOutgoingBooking.this, "No Data Found", Toast.LENGTH_SHORT).show();
        }
        else{
            while (cursor.moveToNext()){


                transactionID.add(cursor.getString(0));
                transactionFullName.add(cursor.getString(1));
                transactionCarModel.add(cursor.getString(2));
                transactionTripDate.add(cursor.getString(3));
                transactionTripRoutes.add(cursor.getString(4));
                transactionReturnStatus.add(cursor.getString(6));

            }
        }
    }

    public void setOnClickListener(){
        listener = new OutgoingTransactionCustomAdapter.OutgoingTransactionClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(), ViewOutgoingTransactionDetails.class);
                intent.putExtra("transactionID", transactionID.get(position));
                startActivity(intent);
            }
        };
    }
}