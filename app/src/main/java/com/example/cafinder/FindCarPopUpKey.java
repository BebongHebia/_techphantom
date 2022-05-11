package com.example.cafinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class FindCarPopUpKey extends AppCompatActivity {
    public static final String CAR_TYPE = "com.example.cedula.example.CAR_TYPE";
    Spinner filterSpinner;
    Button filterButton_SearchButton;
    String carType, bookerID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_car_pop_up_key);
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

        Bundle extras = getIntent().getExtras();

        filterButton_SearchButton = findViewById(R.id.filterButton_SearchButton);
        filterSpinner = findViewById(R.id.filterSpinner);

        ArrayAdapter<CharSequence> adapter_filterSpinner =  ArrayAdapter.createFromResource(this, R.array.carType, android.R.layout.simple_spinner_item);
        adapter_filterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filterSpinner.setAdapter(adapter_filterSpinner);

        bookerID = extras.getString("clientID");
        Toast.makeText(this, bookerID, Toast.LENGTH_SHORT).show();


        filterButton_SearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                carType = filterSpinner.getSelectedItem().toString();
                openFindCarResult();
            }
        });
    }

    public void openFindCarResult(){

        Intent intent = new Intent(this, FindCarResults.class);
        intent.putExtra(CAR_TYPE, carType);
        intent.putExtra("clientID", bookerID);
        startActivity(intent);
    }


}