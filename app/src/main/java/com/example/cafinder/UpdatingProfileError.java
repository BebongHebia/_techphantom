package com.example.cafinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class UpdatingProfileError extends AppCompatActivity {
    public static final String EXTRA_TEXT_PHONE_NUMBER = "com.example.cedula.example.EXTRA_PHONE_NUMBER";
    String passedPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updating_profile_error);

        //Start of Pop up

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width* .9), (int) (height* .4));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 1;
        params.y = -20;

        getWindow().setAttributes(params);
        //End of Pop up

        Button updatingProfile_BackButton = findViewById(R.id.updatingProfile_BackButton);
        updatingProfile_BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BackToUpdatingProfilePage();
            }
        });

        Intent intent = getIntent();
        passedPhoneNumber = intent.getStringExtra(EditProfilePage.EXTRA_TEXT_PHONE_NUMBER);


    }

    public void BackToUpdatingProfilePage(){
        Intent intent = new Intent(this, EditProfilePage.class);
        intent.putExtra(EXTRA_TEXT_PHONE_NUMBER, passedPhoneNumber);
        startActivity(intent);
    }
}