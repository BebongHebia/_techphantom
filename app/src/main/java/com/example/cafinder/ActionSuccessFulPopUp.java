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

public class ActionSuccessFulPopUp extends AppCompatActivity {
    public static final String EXTRA_TEXT_COMPAYNAME = "com.example.cedula.example.EXTRA_PHONE_NUMBER";
    String getPassedValueCompanyName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.action_success_ful_pop_up);

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
        getPassedValueCompanyName =  intent.getStringExtra(ViewBookingDetails.EXTRA_TEXT_COMPAYNAME);
        Toast.makeText(this, getPassedValueCompanyName, Toast.LENGTH_SHORT).show();
        Button approvalComplete_backButton = findViewById(R.id.approvalComplete_backButton);
        approvalComplete_backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToDashboard();
            }
        });

    }

    public void backToDashboard(){
        Intent intent = new Intent(this, BusinessOwnerDashboard.class);
        intent.putExtra(EXTRA_TEXT_COMPAYNAME, getPassedValueCompanyName);
        startActivity(intent);
    }
}