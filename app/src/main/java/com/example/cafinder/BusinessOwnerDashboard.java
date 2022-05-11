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

import com.example.cafinder.databinding.BusinessOwnerProfileBinding;

import java.util.ArrayList;

public class BusinessOwnerDashboard extends AppCompatActivity {
    public static final String COMPANY_NAME = "com.example.carfinder.example.COMPANY_NAME";
    public static final String COMPANY_ADDRESS = "com.example.carfinder.example.COMPANY_ADDRESS";


    private long backPressedTime;
    private Toast backToast;

    TextView onGoingRentedCount_TV, onGoingPendingBookingCount_TV;

    String companyName, companyID, companyNameFromApprovePopUp, companyIDFromAprovePopUp, companyAddressByPopUp;
    String businessAddress;
    String businessOwnerName;

    MyDatabaseHelper myDB = new MyDatabaseHelper(BusinessOwnerDashboard.this);
    GetterAndStoreHelper helper = new GetterAndStoreHelper();


    RecyclerView recyclerViewManageCarsPage;
    ArrayList<String> carID, carName;
    ArrayList<AddCarModelClass> objectModelClass;
    MyCompanyCarsCustomAdapter myCompanyCarsCustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.business_owner_dashboard);

        Intent intent = getIntent();
        String getPhoneNumber = intent.getStringExtra(LoginActivity.EXTRA_TEXT_PHONE_NUMBER);
        TextView businessOwnerName_textView = findViewById(R.id.businessOwnerName_textView);
        businessOwnerName = myDB.getBusinessOwnerName(getPhoneNumber).toString();



        businessOwnerName_textView.setText(businessOwnerName);

        TextView businessOwner_AddressTextview = findViewById(R.id.businessOwner_AddressTextview);
        businessAddress = myDB.getBusinessOwnerAddress(getPhoneNumber).toString();

        businessOwner_AddressTextview.setText(businessAddress);
        companyName = businessOwnerName;

        companyID = myDB.getCompanyIDbyCompanyName(companyName).toString();

        Button manageCarBTN = findViewById(R.id.manageCars_BTN);
        Button confirmBookingBTN = findViewById(R.id.confirmBooking_BTN);
        manageCarBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openManageCars();
            }
        });

        confirmBookingBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openConfirmBooking();
            }
        });

        recyclerViewManageCarsPage = findViewById(R.id.recyclerViewManageCarsPage);

        carID = new ArrayList<>();
        carName = new ArrayList<>();
        objectModelClass = new ArrayList<>();

        displayData();

        myCompanyCarsCustomAdapter = new MyCompanyCarsCustomAdapter(BusinessOwnerDashboard.this, carID, carName, objectModelClass);
        recyclerViewManageCarsPage.setAdapter(myCompanyCarsCustomAdapter);
        recyclerViewManageCarsPage.setLayoutManager(new LinearLayoutManager(BusinessOwnerDashboard.this));


        //Ongoing Rented Cars and Ongoing Pending Booking Sections

        onGoingRentedCount_TV = findViewById(R.id.onGoingRentedCount_TV);
        onGoingPendingBookingCount_TV = findViewById(R.id.onGoingPendingBookingCount_TV);

        int myPendingBooking = myDB.getAllBusinessPendingBooking(companyID);
        int myOngoingTransaction = myDB.getAllBusinessOngoingTransaction(companyID);
        String myOngoingTransactionString = String.valueOf(myOngoingTransaction);
        String myPendingBookingString = String.valueOf(myPendingBooking);
        onGoingPendingBookingCount_TV.setText(myPendingBookingString);
        onGoingRentedCount_TV.setText(myOngoingTransactionString);

        TextView logoutTextView = findViewById(R.id.logoutTextView);

        logoutTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLoginActivity();
            }
        });

        ImageView businessOwnerDashboard_logo = findViewById(R.id.businessOwnerDashboard_logo);

        byte[] getPic = myDB.getCompanyLogo(companyID);
        if (getPic != null){
            Bitmap bitmaps = convertByteArrayToBitmap(getPic);
            businessOwnerDashboard_logo.setImageBitmap(bitmaps);
        }

        Button businessOwnerDashboard_MyRentalPolicies_BTN = findViewById(R.id.businessOwnerDashboard_MyRentalPolicies_BTN);
        businessOwnerDashboard_MyRentalPolicies_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPolicies();
            }
        });

        Button businessOwnerDashboard_Reports_BTN = findViewById(R.id.businessOwnerDashboard_Reports_BTN);
        businessOwnerDashboard_Reports_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openReports();
            }
        });






    }

    public void openReports(){
        Intent intent = new Intent(this, BusinessOwnerReports.class);
        intent.putExtra("companyID", companyID);
        intent.putExtra("businessOwnerName", businessOwnerName);
        intent.putExtra("businessOwnerAddress", businessAddress);
        startActivity(intent);
    }
     public void openPolicies(){
        Intent intent = new Intent(this, ViewPolicies.class);
         intent.putExtra("companyID", companyID);
        startActivity(intent);
     }


    public Bitmap convertByteArrayToBitmap(byte[] bytes){
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }

    public void openManageCars(){
        Intent intent = new Intent(this, ManageCars.class);
        intent.putExtra(COMPANY_NAME, companyName);
        intent.putExtra(COMPANY_ADDRESS, businessAddress);
        intent.putExtra("companyID", businessAddress);
        startActivity(intent);
    }

    public void openConfirmBooking(){
        Intent intent = new Intent(this, ConfirmBooking.class);
        intent.putExtra(COMPANY_NAME, companyName);
        intent.putExtra("companyID", businessAddress);
        startActivity(intent);
    }

    public void displayData(){
        Cursor cursor = myDB.readAllDataFromMyCars(companyName);
        if (cursor.getCount() == 0){
            Toast.makeText(BusinessOwnerDashboard.this, "No Data", Toast.LENGTH_SHORT).show();
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

    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        }else{
            backToast = Toast.makeText(BusinessOwnerDashboard.this, "Press Back Again to Exit and Logout", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }

    public void openBusinessOwnerProfile(View view){
        Intent intent = new Intent(this, BusinessOwnerProfile.class);
        intent.putExtra("businessOwnerID", companyID);
        startActivity(intent);
    }

    public void openLoginActivity(){
        Intent intent = new Intent(this, LogoutPopUp.class);
        startActivity(intent);
        finish();
    }


}