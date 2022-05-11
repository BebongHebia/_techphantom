package com.example.cafinder;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ConfirmAddCar extends AppCompatActivity {
    MyDatabaseHelper myDB = new MyDatabaseHelper(ConfirmAddCar.this);

    String companyName, companyID, carName, carPrice, carCapacity, carEngine, carDoors, carGasType, carPlateNumber, carAvailability,
            confirmAddingCar_CarType_STR, confirmAddingCar_DriverName_STR, confirmAddingCar_DriverAddress_STR, confirmAddingCar_DriverContact_STR,
            confirmAddingCar_DriverLicenseNo_STR, gotDriver;



    TextView confirmAddingCar_CarName_TV, confirmAddingCar_CarPrice_TV, confirmAddingCar_CarCapacity_TV, confirmAddingCar_CarEngine_TV,
            confirmAddingCar_CarDoors_TV, confirmAddingCar_CompanyName_TV, confirmAddingCar_CompanyID_TV, confirmAddingCar_GasType_TV,
            confirmAddingCar_PlateNumber_TV, confirmAddingCar_CarType_TV, confirmAddingCar_DriverName_TV, confirmAddingCar_DriverAddress_TV,
            confirmAddingCar_DriverContact_TV, confirmAddingCar_DriverLicenseNo_TV;

    ImageView confirmAddCar_CarPhoto_IV;

    private static final int PICK_IMAGE_REQUEST = 100;

    private Uri imageFilePath;
    private Bitmap imageToStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_add_car);

        confirmAddCar_CarPhoto_IV = findViewById(R.id.confirmAddCar_CarPhoto_IV);

        Intent intent = getIntent();





        companyName = intent.getStringExtra(AddCars.COMPANY_NAME);
        companyID = intent.getStringExtra(AddCars.COMPANY_ID);
        carName = intent.getStringExtra(AddCars.CAR_NAME);
        carPrice = intent.getStringExtra(AddCars.CAR_PRICE);
        carCapacity = intent.getStringExtra(AddCars.CAR_CAPACITY);
        carEngine = intent.getStringExtra(AddCars.CAR_ENGINE);
        carDoors = intent.getStringExtra(AddCars.CAR_DOORS);

        carGasType = intent.getStringExtra(AddCars.CAR_GAS);
        carPlateNumber = intent.getStringExtra(AddCars.CAR_PLATE_NUMBER);
        carAvailability = "Available";


        confirmAddingCar_CarType_STR = intent.getStringExtra(AddCars.CAR_TYPE);
        confirmAddingCar_DriverName_STR = intent.getStringExtra(AddCars.DRIVER_NAME);
        confirmAddingCar_DriverAddress_STR = intent.getStringExtra(AddCars.DRIVER_ADDRESS);
        confirmAddingCar_DriverContact_STR = intent.getStringExtra(AddCars.DRIVER_CONTACT_NUMBER);
        confirmAddingCar_DriverLicenseNo_STR = intent.getStringExtra(AddCars.DRIVER_LICENSE_NUMBER);


        confirmAddingCar_CarName_TV = findViewById(R.id.confirmAddingCar_CarName_TV);
        confirmAddingCar_CarPrice_TV = findViewById(R.id.confirmAddingCar_CarPrice_TV);
        confirmAddingCar_CarCapacity_TV = findViewById(R.id.confirmAddingCar_CarCapacity_TV);
        confirmAddingCar_CarEngine_TV = findViewById(R.id.confirmAddingCar_CarEngine_TV);
        confirmAddingCar_CarDoors_TV = findViewById(R.id.confirmAddingCar_CarDoors_TV);
        confirmAddingCar_CompanyName_TV = findViewById(R.id.confirmAddingCar_CompanyName_TV);
        confirmAddingCar_CompanyID_TV = findViewById(R.id.confirmAddingCar_CompanyID_TV);

        confirmAddingCar_GasType_TV = findViewById(R.id.confirmAddingCar_GasType_TV);
        confirmAddingCar_PlateNumber_TV = findViewById(R.id.confirmAddingCar_PlateNumber_TV);

        confirmAddingCar_CarType_TV = findViewById(R.id.confirmAddingCar_CarType_TV);
        confirmAddingCar_DriverName_TV = findViewById(R.id.confirmAddingCar_DriverName_TV);
        confirmAddingCar_DriverAddress_TV = findViewById(R.id.confirmAddingCar_DriverAddress_TV);
        confirmAddingCar_DriverContact_TV = findViewById(R.id.confirmAddingCar_DriverContact_TV);
        confirmAddingCar_DriverLicenseNo_TV = findViewById(R.id.confirmAddingCar_DriverLicenseNo_TV);

        confirmAddingCar_CarName_TV.setText(carName);
        confirmAddingCar_CarPrice_TV.setText(carPrice);
        confirmAddingCar_CarCapacity_TV.setText(carCapacity);
        confirmAddingCar_CarEngine_TV.setText(carEngine);
        confirmAddingCar_CarDoors_TV.setText(carDoors);
        confirmAddingCar_CompanyName_TV.setText(companyName);
        confirmAddingCar_CompanyID_TV.setText(companyID);

        confirmAddingCar_GasType_TV.setText(carGasType);
        confirmAddingCar_PlateNumber_TV.setText(carPlateNumber);

        confirmAddingCar_CarType_TV.setText(confirmAddingCar_CarType_STR);
        confirmAddingCar_DriverName_TV.setText(confirmAddingCar_DriverName_STR);
        confirmAddingCar_DriverAddress_TV.setText(confirmAddingCar_DriverAddress_STR);
        confirmAddingCar_DriverContact_TV.setText(confirmAddingCar_DriverContact_STR);
        confirmAddingCar_DriverLicenseNo_TV.setText(confirmAddingCar_DriverLicenseNo_STR);

        Button confirmAddingCar_addNowButton = findViewById(R.id.confirmAddingCar_addNowButton);
        confirmAddingCar_addNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int score = 1;
                int rating = 1;
                companyName = intent.getStringExtra(AddCars.COMPANY_NAME);
                companyID = intent.getStringExtra(AddCars.COMPANY_ID);
                carName = intent.getStringExtra(AddCars.CAR_NAME);
                carPrice = intent.getStringExtra(AddCars.CAR_PRICE);
                carCapacity = intent.getStringExtra(AddCars.CAR_CAPACITY);
                carEngine = intent.getStringExtra(AddCars.CAR_ENGINE);
                carDoors = intent.getStringExtra(AddCars.CAR_DOORS);
                gotDriver = intent.getStringExtra(AddCars.GOT_DRIVER);


                myDB.addCars(carName, carPrice, companyName, companyID, carCapacity, carEngine, carDoors, carAvailability, carPlateNumber, carGasType, confirmAddingCar_CarType_STR,
                        confirmAddingCar_DriverName_STR, confirmAddingCar_DriverAddress_STR, confirmAddingCar_DriverContact_STR, confirmAddingCar_DriverLicenseNo_STR, new AddCarModelClass(imageToStore),
                        score, rating, gotDriver);

                openSuccessfulAddingCar();
            }
        });




    }

    public void chooseImage(View objectView){
        try{
            Intent objectIntent = new Intent();
            objectIntent.setType("image/*");
            objectIntent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(objectIntent, PICK_IMAGE_REQUEST);
        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        try{
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode==PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null){
                imageFilePath = data.getData();
                imageToStore = MediaStore.Images.Media.getBitmap(getContentResolver(), imageFilePath);
                confirmAddCar_CarPhoto_IV.setImageBitmap(imageToStore);

            }

        }
        catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    public void openSuccessfulAddingCar(){
        Intent intent = new Intent(this, AddingCarSuccessfullPopUp.class);



        startActivity(intent);
        finish();
    }
}