package com.example.cafinder;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class AddCars extends AppCompatActivity {
    public static final String COMPANY_NAME = "com.example.carfinder.example.COMPANY_NAME";
    public static final String COMPANY_ID = "com.example.carfinder.example.COMPANY_ID";
    public static final String CAR_NAME = "com.example.carfinder.example.CAR_NAME";
    public static final String CAR_PRICE = "com.example.carfinder.example.CAR_PRICE";
    public static final String CAR_CAPACITY = "com.example.carfinder.example.CAR_CAPACITY";
    public static final String CAR_ENGINE = "com.example.carfinder.example.CAR_ENGINE";
    public static final String CAR_DOORS = "com.example.carfinder.example.CAR_DOORS";
    public static final String CAR_GAS = "com.example.carfinder.example.CAR_GAS";
    public static final String CAR_PLATE_NUMBER = "com.example.carfinder.example.CAR_PLATE_NUMBER";

    public static final String CAR_TYPE = "com.example.carfinder.example.CAR_TYPE";
    public static final String DRIVER_NAME = "com.example.carfinder.example.DRIVER_NAME";
    public static final String DRIVER_ADDRESS = "com.example.carfinder.example.DRIVER_ADDRESS";
    public static final String DRIVER_CONTACT_NUMBER = "com.example.carfinder.example.DRIVER_CONTACT_NUMBER";
    public static final String DRIVER_LICENSE_NUMBER = "com.example.carfinder.example.DRIVER_LICENSE_NUMBER";
    public static final String GOT_DRIVER = "com.example.carfinder.example.GOT_DRIVER";


    MyDatabaseHelper myDB = new MyDatabaseHelper(AddCars.this);
    TextView addCars_comanyName_TV, addCars_companyAddress_TV;
    String companyName, companyAddress;
    Spinner addCars_carEngine_spinners, addCars_gasType_spinners, addCars_carType_spinners;
    Button addCars_addCarNow_Button, addDriverButton, uploadPhoto_Button;
    String companyID, carName, carPrice, carCapacity, carEngine, carDoors, gasType, carPlateNumber, carType, driverName, driverAddress, driverContactNumber, driverLicense;

    EditText addCars_CarModelName_ET, addCars_CarPrice_ET, addCars_CarCapacity_ET, addCars_CarPrice_ET3, addCars_CarPlateNumber_ET,
            addCars_DriverName_ET, addCars_DriverAddress_ET, addCars_DriverContactNumber_ET, addCars_DriverLicenseNumber_ET;

    ImageView businessOwnerDashboard_logo;

    String gotDriver;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cars);

        gotDriver = "Without Driver";


        addCars_carEngine_spinners = findViewById(R.id.addCars_carEngine_spinners);
        addCars_gasType_spinners = findViewById(R.id.addCars_gasType_spinners);
        addCars_carType_spinners = findViewById(R.id.addCars_carType_spinners);

        ArrayAdapter<CharSequence> addCars_carEngine_spinners_adapter =  ArrayAdapter.createFromResource(this, R.array.engine_type, android.R.layout.simple_spinner_item);
        addCars_carEngine_spinners_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        addCars_carEngine_spinners.setAdapter(addCars_carEngine_spinners_adapter);

        ArrayAdapter<CharSequence> addCars_gasType_spinners_adapter =  ArrayAdapter.createFromResource(this, R.array.gasType, android.R.layout.simple_spinner_item);
        addCars_gasType_spinners_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        addCars_gasType_spinners.setAdapter(addCars_gasType_spinners_adapter);

        ArrayAdapter<CharSequence> addCars_carType_spinners_adapter =  ArrayAdapter.createFromResource(this, R.array.carType, android.R.layout.simple_spinner_item);
        addCars_carType_spinners_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        addCars_carType_spinners.setAdapter(addCars_carType_spinners_adapter);

        addCars_comanyName_TV = findViewById(R.id.deleteCars_CompanyName_TV);
        addCars_companyAddress_TV = findViewById(R.id.deleteCars_CompanyAddress_TV);

        Intent intent = getIntent();

        companyName = intent.getStringExtra(ManageCars.COMPANY_NAME);
        companyAddress = intent.getStringExtra(ManageCars.COMPANY_ADDRESS);
        companyID = myDB.getCompanyID(companyName).toString();

        addCars_comanyName_TV.setText(companyName);
        addCars_companyAddress_TV.setText(companyAddress);

        addCars_CarModelName_ET = findViewById(R.id.addCars_CarModelName_ET);
        addCars_CarPrice_ET = findViewById(R.id.addCars_CarPrice_ET);
        addCars_CarCapacity_ET = findViewById(R.id.addCars_CarCapacity_ET);
        addCars_CarPrice_ET3 = findViewById(R.id.addCars_CarPrice_ET3);
        addCars_CarPlateNumber_ET = findViewById(R.id.addCars_CarPlateNumber_ET);

        addCars_DriverName_ET = findViewById(R.id.addCars_DriverName_ET);
        addCars_DriverAddress_ET = findViewById(R.id.addCars_DriverAddress_ET);
        addCars_DriverContactNumber_ET = findViewById(R.id.addCars_DriverContactNumber_ET);
        addCars_DriverLicenseNumber_ET = findViewById(R.id.addCars_DriverLicenseNumber_ET);

        carName = addCars_CarModelName_ET.getText().toString();
        carPrice = addCars_CarPrice_ET.getText().toString();
        carCapacity = addCars_CarCapacity_ET.getText().toString();
        carDoors = addCars_CarPrice_ET3.getText().toString();
        carPlateNumber = addCars_CarPlateNumber_ET.getText().toString();





        addCars_addCarNow_Button = findViewById(R.id.addCars_addCarNow_Button);
        addCars_addCarNow_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                carPlateNumber = addCars_CarPlateNumber_ET.getText().toString();
                carEngine = addCars_carEngine_spinners.getSelectedItem().toString();
                gasType = addCars_gasType_spinners.getSelectedItem().toString();
                carName = addCars_CarModelName_ET.getText().toString();
                carPrice = addCars_CarPrice_ET.getText().toString();
                carCapacity = addCars_CarCapacity_ET.getText().toString();
                carDoors = addCars_CarPrice_ET3.getText().toString();
                carType = addCars_carType_spinners.getSelectedItem().toString();

                driverName = addCars_DriverName_ET.getText().toString();
                driverAddress = addCars_DriverAddress_ET.getText().toString();
                driverContactNumber = addCars_DriverContactNumber_ET.getText().toString();
                driverLicense = addCars_DriverLicenseNumber_ET.getText().toString();
                openConfirmAddCar();
            }
        });

        addDriverButton = findViewById(R.id.addDriverButton);
        addDriverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addCars_DriverName_ET.setVisibility(View.VISIBLE);
                addCars_DriverAddress_ET.setVisibility(View.VISIBLE);
                addCars_DriverContactNumber_ET.setVisibility(View.VISIBLE);
                addCars_DriverLicenseNumber_ET.setVisibility(View.VISIBLE);

                gotDriver = "With Driver";
            }
        });

        businessOwnerDashboard_logo = findViewById(R.id.businessOwnerDashboard_logo);

        byte[] getPic = myDB.getCompanyLogo(companyID);
        if (getPic != null){
            Bitmap bitmaps = convertByteArrayToBitmap(getPic);
            businessOwnerDashboard_logo.setImageBitmap(bitmaps);
        }











    }

    public Bitmap convertByteArrayToBitmap(byte[] bytes){
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }



    public void openConfirmAddCar(){

            Intent intent = new Intent(this, ConfirmAddCar.class);
            intent.putExtra(COMPANY_NAME, companyName);
            intent.putExtra(COMPANY_ID, companyID);
            intent.putExtra(CAR_NAME, carName);
            intent.putExtra(CAR_PRICE, carPrice);
            intent.putExtra(CAR_CAPACITY, carCapacity);
            intent.putExtra(CAR_ENGINE, carEngine);
            intent.putExtra(CAR_DOORS, carDoors);
            intent.putExtra(CAR_GAS, gasType);
            intent.putExtra(CAR_PLATE_NUMBER, carPlateNumber);
            intent.putExtra(CAR_TYPE, carType);
            intent.putExtra(DRIVER_NAME, driverName);
            intent.putExtra(DRIVER_ADDRESS, driverAddress);
            intent.putExtra(DRIVER_CONTACT_NUMBER, driverContactNumber);
            intent.putExtra(DRIVER_LICENSE_NUMBER, driverLicense);
            intent.putExtra(GOT_DRIVER, gotDriver);
            startActivity(intent);


    }



}