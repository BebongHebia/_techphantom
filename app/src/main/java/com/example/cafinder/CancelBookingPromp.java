package com.example.cafinder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class CancelBookingPromp extends AppCompatActivity {

    MyDatabaseHelper myDB = new MyDatabaseHelper(CancelBookingPromp.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cancel_booking_promp);


        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width* .8), (int) (height* .8));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);
        //End of Pop up

        Bundle intent = getIntent().getExtras();



        Button promp_cancelButton = findViewById(R.id.promp_cancelButton);
        promp_cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String bookerID = intent.getString("bookerID");
                String carID = intent.getString("carID");

                boolean carAvailability = myDB.carAvailability(carID, "Available");
                if (carAvailability == true){
                    boolean cancelBooking = myDB.deleteBookingByCancellation(bookerID);
                    if (cancelBooking == true){
                        Toast.makeText(CancelBookingPromp.this, "Booking has been Canceled", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(CancelBookingPromp.this, "Booking Cancellation Failed", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });


    }
}