package com.example.cafinder;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cafinder.databinding.ActivityClientDashboardBinding;

import java.util.ArrayList;

public class ClientDashboard extends AppCompatActivity {

    ImageView imageView18;

    private long backPressedTime;
    private Toast backToast;

    String getPassedIDNumber, getPassedValueFromCheckBookingStatus, passedValueToEditProfile_phone_number;

    MyDatabaseHelper myDB = new MyDatabaseHelper(ClientDashboard.this);
    private AppBarConfiguration mAppBarConfiguration;
    private ActivityClientDashboardBinding binding;
    public static final String EXTRA_TEXT_PHONE_NUMBER = "com.example.cedula.example.EXTRA_PHONE_NUMBER";
    public static final String EXTRA_TEXT_ID_NUMBER = "com.example.cedula.example.EXTRA_TEXT_ID_NUMBER";
    String passedPhone;
    String passIDNumber;

    /*Second dimension Elements*/

    String passedIDNumberFromCreditReview, passedFromCounterTransaction;

    /*Recycler View*/

    RecyclerView recyclerViewClientDashboard;
    CustomAdapterClientDashboard customAdapterClientDashboard;

    ArrayList<String> carID, carName, carPrice, carCompanyOwner, carAvailability;
    ArrayList<AddCarModelClass> objectModelClass;
    private CustomAdapterClientDashboard.SelectingCarsOnClickListener listener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent secondDimensionIntent = getIntent();
        passedIDNumberFromCreditReview = secondDimensionIntent.getStringExtra(PayViaCreditBookingSuccessfulPopUp.CLIENT_ID_NUMBER);





        binding = ActivityClientDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarClientDashboard.toolbar);
        binding.appBarClientDashboard.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPopUpWindow();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_contactAndSupport, R.id.nav_aboutUs)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_client_dashboard);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        setOnClickListener();


        carID = new ArrayList<>();
        carName = new ArrayList<>();
        carPrice = new ArrayList<>();
        carCompanyOwner = new ArrayList<>();
        carAvailability = new ArrayList<>();
        objectModelClass = new ArrayList<>();

        DisplayAllCarsClientDashboard();


        recyclerViewClientDashboard = findViewById(R.id.recyclerViewClientDashboard);
        customAdapterClientDashboard = new CustomAdapterClientDashboard(ClientDashboard.this, carID, carName, carPrice, carCompanyOwner, listener, objectModelClass, carAvailability);
        recyclerViewClientDashboard.setAdapter(customAdapterClientDashboard);
        recyclerViewClientDashboard.setLayoutManager(new LinearLayoutManager(ClientDashboard.this));





        Bundle intent = getIntent().getExtras();
        passedIDNumberFromCreditReview = intent.getString(PayViaCreditBookingSuccessfulPopUp.CLIENT_ID_NUMBER);
        passedPhone = intent.getString(LoginActivity.EXTRA_TEXT_PHONE_NUMBER);

        getPassedIDNumber = intent.getString("clientID");




        Button clientDashboard_EditProfile_Button = findViewById(R.id.clientDashboard_EditProfile_Button);

        clientDashboard_EditProfile_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openClientEditProfile();
            }
        });





        String bookerID = myDB.getClientNumberByPhoneNumber(passedPhone).toString();
        String bookingStatus = myDB.getBookingStatusByBookerID(bookerID).toString();

        String getCarPicked = myDB.getCarPicked(bookerID).toString();

        FrameLayout notificationFrameLayout = findViewById(R.id.notificationFrameLayout);

        if (getCarPicked.equals("Rented Days Expired")){
            notificationFrameLayout.setVisibility(View.VISIBLE);
        }

        Button finishNotificationButton = findViewById(R.id.finishNotificationButton);
        finishNotificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notificationFrameLayout.setVisibility(View.GONE);
            }
        });

        TextView clientDashboard_clientName_textview = findViewById(R.id.clientDashboard_clientName_textview);

        clientDashboard_clientName_textview.setText(
            myDB.getClientFirstName(getPassedIDNumber) + " " + myDB.getClientLastName(getPassedIDNumber)
        );



        passedPhone = myDB.getClientPhoneNumber(getPassedIDNumber).toString();
        getPassedValueFromCheckBookingStatus = intent.getString(CheckBookingStatus.EXTRA_TEXT_ID_NUMBER);



        TextView changeableBooking = findViewById(R.id.changeableBooking);
        Button clientDashboard_CheckBooking_Button = findViewById(R.id.clientDashboard_CheckBooking_Button);

        boolean checkBooking = myDB.checkIfIHaveBooking(getPassedIDNumber);

        if(checkBooking == true){
            changeableBooking.setText("You have Current Booking, Click Button to check status");
            clientDashboard_CheckBooking_Button.setVisibility(View.VISIBLE);

        }

        else if (bookingStatus.equals("Approved")){
            changeableBooking.setText("Your Booking has been Approved, Click Button to check status");
            clientDashboard_CheckBooking_Button.setVisibility(View.VISIBLE);
        }

        else if (bookingStatus.equals("Disapproved")){
            changeableBooking.setText("Your Booking has been Disapproved, Click Button to check status");
            clientDashboard_CheckBooking_Button.setVisibility(View.VISIBLE);
        }else{
            changeableBooking.setText("Your Have no Booking");

        }




        clientDashboard_CheckBooking_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(ClientDashboard.this, passIDNumber, Toast.LENGTH_SHORT).show();
                openCheckBookingStatus();
            }
        });

        //second Dimension After booking CreditPage

        //clientDashboard_clientName_textview

        //Slideshow
        ImageView slideShow = findViewById(R.id.slideShow);
        AnimationDrawable animationDrawable = (AnimationDrawable) slideShow.getDrawable();
        animationDrawable.start();

        Button clientDashboardPlacesToVisit_button = findViewById(R.id.clientDashboardPlacesToVisit_button);

        clientDashboardPlacesToVisit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPlacesToVisit();
            }
        });

        imageView18 = findViewById(R.id.imageView18);


        byte[] getPic = myDB.getProfilePic(bookerID);
        if (getPic != null){
            Bitmap bitmaps = convertByteArrayToBitmap(getPic);
            imageView18.setImageBitmap(bitmaps);
        }
        else{
            imageView18.setImageResource(R.drawable.profilephotonotavailable);
        }









    }

    public Bitmap convertByteArrayToBitmap(byte[] bytes){
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }


    @Override
    public void onBackPressed() {

        if (backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        }else{
            backToast = Toast.makeText(ClientDashboard.this, "Press Back Again to Exit and Logout", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }

    private void setOnClickListener() {
        listener = new CustomAdapterClientDashboard.SelectingCarsOnClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(), ViewCarDetails.class);
                intent.putExtra("carID", carID.get(position));
                intent.putExtra("clientID", getPassedIDNumber);
                startActivity(intent);
            }
        };
    }

    void DisplayAllCarsClientDashboard(){



        Cursor cursor = myDB.readAllCars();
        if (cursor.getCount() == 0){
            Toast.makeText(this, "No DATA", Toast.LENGTH_SHORT).show();
        }
        else{
            while(cursor.moveToNext()){

                byte[] imageBytes = cursor.getBlob(17);
                Bitmap objectBitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);

                carID.add(cursor.getString(0));
                carName.add(cursor.getString(1));
                carPrice.add(cursor.getString(2));
                carCompanyOwner.add(cursor.getString(3));
                carAvailability.add(cursor.getString(5));
                objectModelClass.add(new AddCarModelClass(objectBitmap));
            }
        }




    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.client_dashboard, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_client_dashboard);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void openPopUpWindow(){
        Intent intent = new Intent(this, FindCarPopUpKey.class);
        intent.putExtra("clientID", getPassedIDNumber);
        startActivity(intent);
    }

    public void openClientEditProfile(){
        Intent intent = new Intent(this, EditProfilePage.class);
        intent.putExtra("clientID", getPassedIDNumber);
        startActivity(intent);
    }

    public void openCheckBookingStatus(){
        Intent intent = new Intent(this, CheckBookingStatus.class);
        intent.putExtra(EXTRA_TEXT_ID_NUMBER, getPassedIDNumber);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_settings:
                openLogoutPopUp();
        }

        return super.onOptionsItemSelected(item);
    }

    public void openPlacesToVisit(){
        Intent intent = new Intent(this, PlacesToVisitSearch.class);
        intent.putExtra("clientID", getPassedIDNumber);
        startActivity(intent);
    }

    public void openLogoutPopUp(){
        Intent intent = new Intent(this, LogoutPopUp.class);
        startActivity(intent);
        finish();
    }



}