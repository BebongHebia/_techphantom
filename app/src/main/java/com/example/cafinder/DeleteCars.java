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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DeleteCars extends AppCompatActivity {

    private DeleteCarsCustomAdapter.RecyclerViewForDeleteCarsClickListener listener;
    RecyclerView recyclerViewForDeleteCars;
    MyDatabaseHelper myDB;
    DeleteCarsCustomAdapter deleteCarsCustomAdapter;

    ArrayList<String> carID, carName;
    ArrayList<AddCarModelClass> objectModelClass;

    String companyName, companyAddress;

    TextView deleteCars_CompanyName_TV, deleteCars_CompanyAddress_TV;

    ImageView businessOwnerDashboard_logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_cars);
        Intent intent = getIntent();
        companyName = intent.getStringExtra(ManageCars.COMPANY_NAME);
        companyAddress = intent.getStringExtra(ManageCars.COMPANY_ADDRESS);

        setOnClickListener();



        carID = new ArrayList<>();
        carName = new ArrayList<>();
        objectModelClass = new ArrayList<>();


        myDB = new MyDatabaseHelper(DeleteCars.this);
        recyclerViewForDeleteCars = findViewById(R.id.recyclerViewForDeleteCars);
        deleteCarsCustomAdapter = new DeleteCarsCustomAdapter(DeleteCars.this, carID, carName, listener, objectModelClass);
        recyclerViewForDeleteCars.setAdapter(deleteCarsCustomAdapter);
        recyclerViewForDeleteCars.setLayoutManager(new LinearLayoutManager(DeleteCars.this));




        displayData();

        deleteCars_CompanyName_TV = findViewById(R.id.deleteCars_CompanyName_TV);
        deleteCars_CompanyAddress_TV = findViewById(R.id.deleteCars_CompanyAddress_TV);

        deleteCars_CompanyName_TV.setText(companyName);
        deleteCars_CompanyAddress_TV.setText(companyAddress);

        Bundle intentGetter = getIntent().getExtras();

        String companyID = intentGetter.getString("companyID");

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

    private void setOnClickListener() {
        listener = new DeleteCarsCustomAdapter.RecyclerViewForDeleteCarsClickListener() {
            @Override
            public void OnClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(), ConfirmDeleteCars.class);
                intent.putExtra("carID", carID.get(position));
                startActivity(intent);
            }
        };
    }

    public void displayData(){
        Cursor cursor = myDB.readAllDataFromMyCars(companyName);
        if (cursor.getCount() == 0){
            Toast.makeText(DeleteCars.this, "No Data", Toast.LENGTH_SHORT).show();
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