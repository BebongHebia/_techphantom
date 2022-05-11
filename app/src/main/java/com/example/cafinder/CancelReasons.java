package com.example.cafinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CancelReasons extends AppCompatActivity {

    MyDatabaseHelper myDB = new MyDatabaseHelper(CancelReasons.this);
    String carID;
    String bookerID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cancel_reasons);

        Bundle intent = getIntent().getExtras();

        bookerID = intent.getString("BookerID").toString();

        carID = myDB.getCarID(bookerID).toString();

        Button cancelReason_cancelButton = findViewById(R.id.cancelReason_cancelButton);

        cancelReason_cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCancelBookingPromp();
            }
        });




    }

    public void openCancelBookingPromp(){
        Intent intent = new Intent(this, CancelBookingPromp.class);
        intent.putExtra("bookerID", bookerID);
        intent.putExtra("carID", carID);
        startActivity(intent);
    }
}