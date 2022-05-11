package com.example.cafinder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmDeleteCars extends AppCompatActivity {
    MyDatabaseHelper myDb;
    TextView confirmDeleteCars_carName_Holder, confirmDeleteCars_carPice_Holder, confirmDeleteCars_carCompanyOwner_Holder,
            confirmDeleteCars_carCapacity_Holder, confirmDeleteCars_carEngine_Holder, confirmDeleteCars_carDoors_Holder;

    Button confirmDelete_confirmDeleteButton, confirmDelete_cancelButton;

    TextView confirmDeleteCars_ID_Holder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_delete_cars);
        myDb = new MyDatabaseHelper(ConfirmDeleteCars.this);

        confirmDeleteCars_ID_Holder = findViewById(R.id.confirmDeleteCars_ID_Holder);

        String carID = "No Car Id";

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            carID = extras.getString("carID");
        }

        confirmDeleteCars_ID_Holder.setText(carID);

        confirmDeleteCars_carName_Holder = findViewById(R.id.confirmDeleteCars_carName_Holder);
        confirmDeleteCars_carPice_Holder = findViewById(R.id.confirmDeleteCars_carPice_Holder);
        confirmDeleteCars_carCompanyOwner_Holder = findViewById(R.id.confirmDeleteCars_carCompanyOwner_Holder);
        confirmDeleteCars_carCapacity_Holder = findViewById(R.id.confirmDeleteCars_carCapacity_Holder);
        confirmDeleteCars_carEngine_Holder = findViewById(R.id.confirmDeleteCars_carEngine_Holder);
        confirmDeleteCars_carDoors_Holder = findViewById(R.id.confirmDeleteCars_carDoors_Holder);

        confirmDelete_confirmDeleteButton = findViewById(R.id.confirmDelete_confirmDeleteButton);
        confirmDelete_cancelButton = findViewById(R.id.confirmDelete_cancelButton);

        confirmDeleteCars_carName_Holder.setText(myDb.getCarName(carID));
        confirmDeleteCars_carPice_Holder.setText(myDb.getCarPrice(carID));
        confirmDeleteCars_carCompanyOwner_Holder.setText(myDb.getCarCompanyOwner(carID));
        confirmDeleteCars_carCapacity_Holder.setText(myDb.getCarCapacity(carID));
        confirmDeleteCars_carEngine_Holder.setText(myDb.getCarEngine(carID));
        confirmDeleteCars_carDoors_Holder.setText(myDb.getCarDoorCount(carID));




    }
}