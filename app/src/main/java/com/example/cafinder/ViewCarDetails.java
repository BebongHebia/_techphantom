package com.example.cafinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ViewCarDetails extends AppCompatActivity {
    public static final String EXTRA_TEXT_CAR_ID = "com.example.cedula.example.EXTRA_TEXT_CAR_ID";
    public static final String EXTRA_TEXT_COMPANY_ID = "com.example.cedula.example.EXTRA_TEXT_COMPANY_ID";
    public static final String EXTRA_TEXT_COMPANY_NAME = "com.example.cedula.example.EXTRA_TEXT_COMPANY_NAME";
    public static final String EXTRA_TEXT_CAR_PRICE = "com.example.cedula.example.EXTRA_TEXT_CAR_PRICE";
    public static final String EXTRA_TEXT_COMPANY_ADDRESS = "com.example.cedula.example.EXTRA_TEXT_COMPANY_ADDRESS";
    public static final String EXTRA_TEXT_CAR_NAME = "com.example.cedula.example.EXTRA_TEXT_CAR_NAME";
    public static final String EXTRA_TEXT_BOOKER_ID = "com.example.cedula.example.EXTRA_TEXT_BOOKER_ID";

    MyDatabaseHelper myDB = new MyDatabaseHelper(ViewCarDetails.this);

    TextView viewCarDetails_carID_holder_TV, viewCompanyDetails_CompanyName_TextView, viewCompanyDetails_CompanyAddress_TextView,
        viewCompanyDetails_CarName_TextView, viewCompanyDetails_CarPrice_TextView, viewCompanyDetails_CarCapacity_TextView,
        viewCompanyDetails_CarEngine_TextView, viewCompanyDetails_CarDoors_TextView, viewCompanyDetails_CompanyNameInsured_TextView,
        viewCompanyDetails_CarPickUpAndReturn_textView,
        viewCompanyDetails_CompanyEmail_TextView,
        viewCompanyDetails_CompanyContactNumber_TextView,
        viewCompanyDetails_CompanyDTINumber_TextView,
        viewCompanyDetails_CompanyMayorPermitNumber_TextView,
        viewCompanyDetails_CompanyBIRNumber_TextView,
        viewCompanyDetails_CompanyPGNumber_TextView,
        viewCompanyDetails_CarGasType_TextView,
        viewCompanyDetails_PlateNumber_TextView,
            viewCompanyDetails_BookedCount_TextView, viewCompanyDetails_Rating_TextView;

    String viewCarDetails_carID_holder_String, viewCompanyDetails_CompanyName_TextView_String, viewCompanyDetails_CompanyAddress_TextView_String,
            viewCompanyDetails_CarName_TextView_String, viewCompanyDetails_CarPrice_TextView_String, viewCompanyDetails_CarCapacity_TextView_String,
            viewCompanyDetails_CarEngine_TextView_String, viewCompanyDetails_CarDoors_TextView_String, viewCompanyDetails_CompanyNameInsured_TextView_String,
            viewCompanyDetails_CarPickUpAndReturn_textView_String, companyID, bookerID;

    String passValue_CarID, passValue_CarName, passValue_CarPrice, passValue_CompanyID, passValue_CompanyAddress, passValue_CompanyName;

    Button viewCarDetails_ProceedButton;
    String car_ID;

    ImageView viewCarDetails_CarPhoto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_car_details);
        viewCarDetails_carID_holder_TV = findViewById(R.id.viewCarDetails_carID_holder_TV);

        String carID = "Car ID not Set";

        Bundle extras = getIntent().getExtras();

        if (extras != null){
            carID = extras.getString("carID");
        }
        viewCarDetails_carID_holder_TV.setText(carID);




        companyID = myDB.getCarCompanyID(carID).toString();

        viewCompanyDetails_CompanyName_TextView = findViewById(R.id.viewCompanyDetails_CompanyName_TextView);
        viewCompanyDetails_CompanyAddress_TextView = findViewById(R.id.viewCompanyDetails_CompanyAddress_TextView);
        viewCompanyDetails_CarName_TextView = findViewById(R.id.viewCompanyDetails_CarName_TextView);
        viewCompanyDetails_CarPrice_TextView = findViewById(R.id.viewCompanyDetails_CarPrice_TextView);
        viewCompanyDetails_CarCapacity_TextView = findViewById(R.id.ViewCompanyDetails_CarCapacity_TextView);
        viewCompanyDetails_CarEngine_TextView = findViewById(R.id.viewCompanyDetails_CarEngine_TextView);
        viewCompanyDetails_CarDoors_TextView = findViewById(R.id.viewCompanyDetails_CarDoors_TextView);
        viewCompanyDetails_CompanyNameInsured_TextView = findViewById(R.id.ViewCompanyDetails_CompanyNameInsured_TextView);
        viewCompanyDetails_CarPickUpAndReturn_textView = findViewById(R.id.viewCompanyDetails_CarPickUpAndReturn_textView);

        viewCompanyDetails_CarGasType_TextView = findViewById(R.id.viewCompanyDetails_CarGasType_TextView);
        viewCompanyDetails_PlateNumber_TextView = findViewById(R.id.viewCompanyDetails_PlateNumber_TextView);

        viewCompanyDetails_CompanyEmail_TextView = findViewById(R.id.viewCompanyDetails_CompanyEmail_TextView);
        viewCompanyDetails_CompanyContactNumber_TextView = findViewById(R.id.viewCompanyDetails_CompanyContactNumber_TextView);
        viewCompanyDetails_CompanyDTINumber_TextView = findViewById(R.id.viewCompanyDetails_CompanyDTINumber_TextView);
        viewCompanyDetails_CompanyMayorPermitNumber_TextView = findViewById(R.id.viewCompanyDetails_CompanyMayorPermitNumber_TextView);
        viewCompanyDetails_CompanyBIRNumber_TextView = findViewById(R.id.viewCompanyDetails_CompanyBIRNumber_TextView);
        viewCompanyDetails_CompanyPGNumber_TextView = findViewById(R.id.viewCompanyDetails_CompanyPGNumber_TextView);

        viewCompanyDetails_BookedCount_TextView = findViewById(R.id.viewCompanyDetails_BookedCount_TextView);
        viewCompanyDetails_Rating_TextView = findViewById(R.id.viewCompanyDetails_Rating_TextView);

        viewCompanyDetails_CompanyName_TextView.setText(myDB.getCarCompanyOwner(carID));
        viewCompanyDetails_CompanyAddress_TextView.setText(myDB.getCarCompanyAddress(companyID));
        viewCompanyDetails_CarName_TextView.setText(myDB.getCarName(carID));
        viewCompanyDetails_CarPrice_TextView.setText(myDB.getCarPrice(carID));
        viewCompanyDetails_CarCapacity_TextView.setText(myDB.getCarCapacity(carID));
        viewCompanyDetails_CarEngine_TextView.setText(myDB.getCarEngine(carID));
        viewCompanyDetails_CarDoors_TextView.setText(myDB.getCarDoorCount(carID));
        viewCompanyDetails_CompanyNameInsured_TextView.setText(myDB.getCarCapacity(carID) + " Persons Insured By " + myDB.getCarCompanyOwner(carID));
        viewCompanyDetails_CarPickUpAndReturn_textView.setText(myDB.getCarCompanyAddress(companyID));

        viewCompanyDetails_CarGasType_TextView.setText(myDB.getCar_GasType(carID));
        viewCompanyDetails_PlateNumber_TextView.setText(myDB.getCar_PlateNumber(carID));

        viewCompanyDetails_CompanyEmail_TextView.setText("Company Email : \t\t"  + myDB.getCompany_Email(companyID));
        viewCompanyDetails_CompanyContactNumber_TextView.setText("Company Contact # : \t\t" + myDB.getCompany_PhoneNumber(companyID));
        viewCompanyDetails_CompanyDTINumber_TextView.setText("DTI No. : \t\t" + myDB.getCompany_DTI_Number(companyID));
        viewCompanyDetails_CompanyMayorPermitNumber_TextView.setText("Mayor Permit No. : \t\t" + myDB.getCompany_MayorPermit_Number(companyID));
        viewCompanyDetails_CompanyBIRNumber_TextView.setText("BIR Reg. No. \t\t" + myDB.getCompany_BIRPermit_Number(companyID));
        viewCompanyDetails_CompanyPGNumber_TextView.setText("PHILGEPS REG. NO : \t\t" + myDB.getCompany_PhilGeps_Number(companyID));



        //Rating and Booked Count
        int carBookedCount = myDB.getCarCountBooked(carID);
        int carRatingScore = myDB.getCarBookedScore(carID);

        String carBookedCountStr = String.valueOf(carBookedCount);
        float rating = carRatingScore / carBookedCount;
        String ratingSTR = String.valueOf(rating);

        viewCompanyDetails_BookedCount_TextView.setText("Booked Count : " + carBookedCountStr);
        viewCompanyDetails_Rating_TextView.setText("Rating : " + ratingSTR);








        Bundle intent = getIntent().getExtras();

        bookerID = extras.getString("clientID");
        Toast.makeText(this, bookerID, Toast.LENGTH_SHORT).show();
        car_ID = carID;



        viewCarDetails_ProceedButton = findViewById(R.id.viewCarDetails_ProceedButton);
        viewCarDetails_ProceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean checkIfIHaveBooking = myDB.checkIfIHaveBooking(bookerID);
                String carAvailability = myDB.checkCarAvailablity(car_ID).toString();
                String getCarAvailabality = myDB.getCar_Availability(car_ID).toString();
                if (checkIfIHaveBooking == true){
                    Toast.makeText(ViewCarDetails.this, "You Still have pending Booking, You can Book 1 at a time", Toast.LENGTH_SHORT).show();
                }

                else if (carAvailability.equals("Not Available")){
                    Toast.makeText(ViewCarDetails.this, "This Car Is not Available", Toast.LENGTH_SHORT).show();
                }
                else{

                    if (getCarAvailabality.equals("Booked")){
                        Toast.makeText(ViewCarDetails.this, "This car of " +
                                myDB.getCarCompanyOwner(car_ID) + " is still in booked", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        openPaymentOption();
                    }

                }
            }
        });

        viewCarDetails_CarPhoto = findViewById(R.id.viewCarDetails_CarPhoto);

        byte[] getPic = myDB.getImageCar(car_ID);
        if (getPic != null){
            Bitmap bitmaps = convertByteArrayToBitmap(getPic);
            viewCarDetails_CarPhoto.setImageBitmap(bitmaps);
        }

    }

    public Bitmap convertByteArrayToBitmap(byte[] bytes){
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }

    public void openPaymentOption(){


        passValue_CarID =  viewCarDetails_carID_holder_TV.getText().toString();
        passValue_CarName = viewCompanyDetails_CarName_TextView.getText().toString();
        passValue_CarPrice = viewCompanyDetails_CarPrice_TextView.getText().toString();
        passValue_CompanyID = companyID;
        passValue_CompanyAddress = viewCompanyDetails_CompanyName_TextView.getText().toString();
        passValue_CompanyName = viewCompanyDetails_CompanyAddress_TextView.getText().toString();



        Intent intent = new Intent(this, PaymentOption.class);
        intent.putExtra(EXTRA_TEXT_CAR_ID, passValue_CarID);
        intent.putExtra(EXTRA_TEXT_CAR_NAME, passValue_CarName);
        intent.putExtra(EXTRA_TEXT_CAR_PRICE, passValue_CarPrice);
        intent.putExtra(EXTRA_TEXT_COMPANY_ID, passValue_CompanyID);
        intent.putExtra(EXTRA_TEXT_COMPANY_NAME, passValue_CompanyName);
        intent.putExtra(EXTRA_TEXT_COMPANY_ADDRESS, passValue_CompanyAddress);
        intent.putExtra(EXTRA_TEXT_BOOKER_ID, bookerID);

        startActivity(intent);

        finish();


    }
}