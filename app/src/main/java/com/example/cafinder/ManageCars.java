package com.example.cafinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ManageCars extends AppCompatActivity {
    public static final String COMPANY_NAME = "com.example.carfinder.example.COMPANY_NAME";
    public static final String COMPANY_ADDRESS = "com.example.carfinder.example.COMPANY_ADDRESS";

    String companyName;
    String businessAddress;

    TextView manageCars_companyName_TV, manageCars_companyAddress_TV;

    //Custom Adapter

    RecyclerView recyclerViewForCompanyCars;
    MyDatabaseHelper myDB;
    MyCompanyCarsCustomAdapter myCompanyCarsCustomAdapter;

    ArrayList<String> carID, carName;
    ArrayList<AddCarModelClass> objectModelClass;

    ImageView businessOwnerDashboard_logo;

    String companyID;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_cars);

        Intent intent = getIntent();
        companyName = intent.getStringExtra(BusinessOwnerDashboard.COMPANY_NAME);
        businessAddress = intent.getStringExtra(BusinessOwnerDashboard.COMPANY_ADDRESS);
        manageCars_companyName_TV = findViewById(R.id.deleteCars_CompanyName_TV);
        manageCars_companyAddress_TV = findViewById(R.id.deleteCars_CompanyAddress_TV);

        manageCars_companyName_TV.setText(companyName);
        manageCars_companyAddress_TV.setText(businessAddress);



        Button addCarsBTN = findViewById(R.id.addCarsBTN);
        Button deleteCarsBTN = findViewById(R.id.deleteCarsBTN);

        addCarsBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddCars();
            }
        });

        deleteCarsBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDeleteCars();
            }
        });

        recyclerViewForCompanyCars = findViewById(R.id.recyclerViewForCompanyCars);

        myDB = new MyDatabaseHelper(ManageCars.this);

        carID = new ArrayList<>();
        carName = new ArrayList<>();
        objectModelClass = new ArrayList<>();

        displayData();

        myCompanyCarsCustomAdapter = new MyCompanyCarsCustomAdapter(ManageCars.this, carID, carName, objectModelClass);
        recyclerViewForCompanyCars.setAdapter(myCompanyCarsCustomAdapter);
        recyclerViewForCompanyCars.setLayoutManager(new LinearLayoutManager(ManageCars.this));

        businessOwnerDashboard_logo = findViewById(R.id.businessOwnerDashboard_logo);

        Bundle gettingIntent = getIntent().getExtras();
        companyID = gettingIntent.getString("companyID");

        byte[] getPic = myDB.getCompanyLogo(companyID);
        if (getPic != null){
            Bitmap bitmaps = convertByteArrayToBitmap(getPic);
            businessOwnerDashboard_logo.setImageBitmap(bitmaps);
        }




    }

    public Bitmap convertByteArrayToBitmap(byte[] bytes){
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }

    public void openAddCars(){
        Intent intent = new Intent(this, AddCars.class);
        intent.putExtra(COMPANY_NAME, companyName);
        intent.putExtra(COMPANY_ADDRESS, businessAddress);
        intent.putExtra("companyID", companyID);
        startActivity(intent);
    }
    public void openDeleteCars(){
        Intent intent = new Intent(this, DeleteCars.class);
        intent.putExtra(COMPANY_NAME, companyName);
        intent.putExtra(COMPANY_ADDRESS, businessAddress);
        intent.putExtra("companyID", companyID);
        startActivity(intent);
    }

    public void displayData(){
        Cursor cursor = myDB.readAllDataFromMyCars(companyName);
        if (cursor.getCount() == 0){
            Toast.makeText(ManageCars.this, "No Data", Toast.LENGTH_SHORT).show();
        }
        else{
            while (cursor.moveToNext() ){
                byte[] imageBytes = cursor.getBlob(17);
                Bitmap objectBitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);

                carID.add(cursor.getString(0));
                carName.add(cursor.getString(1));

                objectModelClass.add(new AddCarModelClass(objectBitmap));
            }
        }
    }
}