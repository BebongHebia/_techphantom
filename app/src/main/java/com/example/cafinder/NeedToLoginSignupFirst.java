package com.example.cafinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class NeedToLoginSignupFirst extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.need_to_login_signup_first);
        //Start of Pop up

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width* .9), (int) (height* .3));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);
        //End of Pop up


        Button needAccountProceedButton = findViewById(R.id.needAccountProceedButton);
        needAccountProceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginOption();
            }
        });
    }

    public void openLoginOption(){
        Intent intent = new Intent(this, LoginOptions.class);
        startActivity(intent);
    }
}