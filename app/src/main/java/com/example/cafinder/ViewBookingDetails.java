package com.example.cafinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class ViewBookingDetails extends AppCompatActivity {
    public static final String EXTRA_TEXT_COMPAYNAME = "com.example.cedula.example.EXTRA_PHONE_NUMBER";
    public static final String EXTRA_TEXT_BOOKING_ID = "com.example.cedula.example.EXTRA_TEXT_BOOKING_ID";
    public static final String PASSED_TOTAL_AMOUNT = "com.example.cedula.example.PASSED_TOTAL_AMOUNT";

    Calendar calendar;


    TextView viewBookingDetails_FullName_TV,
            viewBookingDetails_Adress_TV,
            viewBookingDetails_Age_TV,
            viewBookingDetails_Email_TV,
            viewBookingDetails_PhoneNumber_TV,
            viewBookingDetails_CarModel_TV,
            viewBookingDetails_CarPrice_TV,
            viewBookingDetails_TripDate_TV,
            viewBookingDetails_TripAddress_TV,
            viewBookingDetails_PaymentMethod_TV,
            viewBookingDetails_GCashNumber_TV,
            viewBookingDetails_CompanyName_TV;

    String bookingID, passedTotalAmount;

    Spinner viewBookingDetails_daysRented_Spinner;
    EditText viewBookingDetails_TotalAmount_ET;

    MyDatabaseHelper myDB = new MyDatabaseHelper(ViewBookingDetails.this);

    String totalPayableAmount, getPassedValueCompanyName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_booking_details);

        Intent getIntent = getIntent();
        bookingID = getIntent.getStringExtra(ConfirmBooking.PASS_BOOKING_ID);
        String tripDate = "From : " +  myDB.viewBookingTripDateFrom(bookingID).toString() + " To : " + myDB.viewBookingTripDateTo(bookingID).toString();

        viewBookingDetails_FullName_TV = findViewById(R.id.viewBookingDetails_FullName_TV);
        viewBookingDetails_Adress_TV = findViewById(R.id.viewBookingDetails_Adress_TV);
        viewBookingDetails_Age_TV = findViewById(R.id.viewBookingDetails_Age_TV);
        viewBookingDetails_Email_TV = findViewById(R.id.viewBookingDetails_Email_TV);
        viewBookingDetails_PhoneNumber_TV = findViewById(R.id.viewBookingDetails_PhoneNumber_TV);
        viewBookingDetails_CarModel_TV = findViewById(R.id.viewBookingDetails_CarModel_TV);
        viewBookingDetails_CarPrice_TV = findViewById(R.id.viewBookingDetails_CarPrice_TV);
        viewBookingDetails_TripDate_TV = findViewById(R.id.viewBookingDetails_TripDate_TV);
        viewBookingDetails_TripAddress_TV = findViewById(R.id.viewBookingDetails_TripAddress_TV);
        viewBookingDetails_PaymentMethod_TV = findViewById(R.id.viewBookingDetails_PaymentMethod_TV);
        viewBookingDetails_GCashNumber_TV = findViewById(R.id.viewBookingDetails_GCashNumber_TV);
        viewBookingDetails_CompanyName_TV = findViewById(R.id.viewBookingDetails_CompanyName_TV);

        viewBookingDetails_FullName_TV.setText(myDB.viewBookingFullName(bookingID));
        viewBookingDetails_Adress_TV.setText(myDB.viewBookingAddress(bookingID));
        viewBookingDetails_Age_TV.setText(myDB.viewBookingAge(bookingID));
        viewBookingDetails_Email_TV.setText(myDB.viewBookingEmail(bookingID));
        viewBookingDetails_PhoneNumber_TV.setText(myDB.viewBookingPhoneNumber(bookingID));
        viewBookingDetails_CarModel_TV.setText(myDB.viewBookingCarModel(bookingID));
        viewBookingDetails_CarPrice_TV.setText(myDB.viewBookingCarPrice(bookingID));
        viewBookingDetails_TripDate_TV.setText(tripDate);
        viewBookingDetails_TripAddress_TV.setText(myDB.viewBookingTripAddress(bookingID));
        viewBookingDetails_PaymentMethod_TV.setText(myDB.viewBookingPaymentMethod(bookingID));
        viewBookingDetails_GCashNumber_TV.setText(myDB.viewBookingGCashNumber(bookingID));
        viewBookingDetails_CompanyName_TV.setText(myDB.viewBookingCompanyName(bookingID));

        viewBookingDetails_daysRented_Spinner = findViewById(R.id.viewBookingDetails_daysRented_Spinner);
        viewBookingDetails_TotalAmount_ET = findViewById(R.id.viewBookingDetails_TotalAmount_ET);

        ArrayAdapter<CharSequence> viewBookingDetails_daysRented_Spinner_adapter =  ArrayAdapter.createFromResource(this, R.array.daysRented, android.R.layout.simple_spinner_item);
        viewBookingDetails_daysRented_Spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        viewBookingDetails_daysRented_Spinner.setAdapter(viewBookingDetails_daysRented_Spinner_adapter);

        EditText viewBookingDetails_TotalAmount_ET = findViewById(R.id.viewBookingDetails_TotalAmount_ET);

        Button viewBookingDetails_Approve_Button,
                viewBookingDetails_DisApprove_Button;

        viewBookingDetails_Approve_Button = findViewById(R.id.transaction_request_return_Button);
        viewBookingDetails_DisApprove_Button = findViewById(R.id.viewBookingDetails_DisApprove_Button);

        viewBookingDetails_Approve_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String daysRented = viewBookingDetails_daysRented_Spinner.getSelectedItem().toString();
                String totalAmount = viewBookingDetails_TotalAmount_ET.getText().toString();
                calendar = Calendar.getInstance();
                String dateToday = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
                if (viewBookingDetails_TotalAmount_ET.getText().toString().equals("")){
                    Toast.makeText(ViewBookingDetails.this, "Please Input Total Payable Amount", Toast.LENGTH_SHORT).show();
                }else{
                    boolean checkApproveBooking =  myDB.ApproveBooking(bookingID, "Approved", totalAmount, dateToday, "N/A", daysRented, "Ready to Pickup");
                    if(checkApproveBooking == true){
                        OpenPopUpSuccessButton();
                    }
                }

            }
        });

        viewBookingDetails_DisApprove_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewBookingDetails_TotalAmount_ET.getText().toString().equals("")){
                    Toast.makeText(ViewBookingDetails.this, "Please Input Total Payable Amount", Toast.LENGTH_SHORT).show();
                }else{
                    openDisapproval();
                }
            }
        });








    }

    public void OpenPopUpSuccessButton(){
        Intent intent = new Intent(this, ActionSuccessFulPopUp.class);
        startActivity(intent);
    }


    public void openDisapproval(){
        EditText viewBookingDetails_TotalAmount_ET = findViewById(R.id.viewBookingDetails_TotalAmount_ET);
        passedTotalAmount = viewBookingDetails_TotalAmount_ET.getText().toString();
        Intent intent = new Intent(this, ReasonsOfDisapproval.class);
        intent.putExtra(EXTRA_TEXT_BOOKING_ID, bookingID);
        intent.putExtra(PASSED_TOTAL_AMOUNT, passedTotalAmount);
        startActivity(intent);
    }
}