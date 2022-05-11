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

public class ConfirmDeleteTransaction extends AppCompatActivity {
    MyDatabaseHelper myDB = new MyDatabaseHelper(ConfirmDeleteTransaction.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_delete_transaction);

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
        String transactionID = intent.getStringExtra(ViewOutgoingTransactionDetails.PASS_BOOKING_ID);

        Button deleteTransactionButton = findViewById(R.id.deleteTransactionButton);
        deleteTransactionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean deleteTransaction = myDB.deleteTransaction(transactionID);
                if (deleteTransaction == true){
                    Toast.makeText(ConfirmDeleteTransaction.this, "Delete completed", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });


    }
}