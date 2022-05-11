package com.example.cafinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class ConfirmReturnCar extends AppCompatActivity {
    String BookingID;

    MyDatabaseHelper myDB = new MyDatabaseHelper(ConfirmReturnCar.this);

    String history_booking_id_str,
            history_booker_id_str,
            history_booking_full_name_str,
            history_booking_address_str,
            history_booking_age_str,
            history_booking_email_str,
            history_booking_phone_number_str,
            history_booking_status_str,
            history_booking_car_name_str,
            history_booking_car_price_str,
            history_booking_trip_date_from_str,
            history_booking_trip_date_to_str,
            history_booking_trip_address_str,
            history_booking_payment_method_str,
            history_booking_g_cash_number_str,
            history_booking_amount_str,
            history_booking_company_id_str,
            history_booking_company_name_str,
            history_booking_company_address_str,
            history_booking_car_id_str,
            history_booking_date_str,
            history_booking_date_approved_str,
            history_booking_remarks_str,
            history_booking_days_rented_str,
            history_booking_car_PICKED_str,
            history_booking_date_PICKED_str;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_return_car);
        //Start of Pop up

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width* .8), (int) (height* .3));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);
        //End of Pop up
        Intent intent = getIntent();
        BookingID = intent.getStringExtra(CheckBookingStatus.EXTRA_TEXT_ID_NUMBER);

        history_booking_id_str = myDB.getBookingID_ByBookerID(BookingID).toString();
        history_booking_full_name_str = myDB.getBookerFullName_ByBookerID(BookingID).toString();
        history_booking_address_str = myDB.getBookerAddress_ByBookerID(BookingID).toString();
        history_booking_age_str = myDB.getBookerAge_ByBookerID(BookingID).toString();
        history_booking_email_str = myDB.getBookerEmail_ByBookerID(BookingID).toString();
        history_booking_phone_number_str = myDB.getBookerPhoneNumber_ByBookerID(BookingID).toString();
        history_booking_status_str = myDB.getBookerStatus_ByBookerID(BookingID).toString();
        history_booking_car_name_str = myDB.getBookerCarName_ByBookerID(BookingID).toString();
        history_booking_car_price_str = myDB.getBookerCarPrice_ByBookerID(BookingID).toString();
        history_booking_trip_date_from_str = myDB.getBookerTripDateFrom_ByBookerID(BookingID).toString();
        history_booking_trip_date_to_str = myDB.getBookerTripDateTo_ByBookerID(BookingID).toString();
        history_booking_trip_address_str = myDB.getBookerTripAddress_ByBookerID(BookingID).toString();
        history_booking_payment_method_str = myDB.getBookerPaymentMethod_ByBookerID(BookingID).toString();
        history_booking_g_cash_number_str = myDB.getBookerGCashNumber_ByBookerID(BookingID).toString();
        history_booking_amount_str = myDB.getBookerTotalAmount_ByBookerID(BookingID).toString();
        history_booking_company_id_str = myDB.getBookerCompanyID_ByBookerID(BookingID).toString();
        history_booking_company_name_str = myDB.getBookerCompanyName_ByBookerID(BookingID).toString();
        history_booking_company_address_str = myDB.getBookerCompanyAddress_ByBookerID(BookingID).toString();
        history_booking_car_id_str = myDB.getBookerCarID_ByBookerID(BookingID).toString();
        history_booking_date_str = myDB.getBookerDateBooked_ByBookerID(BookingID).toString();
        history_booking_date_approved_str = myDB.getBookerDateApproved_ByBookerID(BookingID).toString();
        history_booking_remarks_str = myDB.getBookerRemarks_ByBookerID(BookingID).toString();
        history_booking_days_rented_str = myDB.getBookerDaysRented_ByBookerID(BookingID).toString();
        history_booking_car_PICKED_str = myDB.getBookerCarPicked_ByBookerID(BookingID).toString();
        history_booking_date_PICKED_str = myDB.getBookerDatePicked_ByBookerID(BookingID).toString();


        Button returnButton = findViewById(R.id.returnButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myBookingID = myDB.getBookingID(BookingID).toString();
                String myTransactionNumber = myDB.getTransactionNumber_ByBookerID(BookingID).toString();
                myDB.addToHistory(
                        history_booking_id_str,
                        BookingID,
                        history_booking_full_name_str,
                        history_booking_address_str,
                        history_booking_age_str,
                        history_booking_email_str,
                        history_booking_phone_number_str,
                        history_booking_status_str,
                        history_booking_car_name_str,
                        history_booking_car_price_str,
                        history_booking_trip_date_from_str,
                        history_booking_trip_date_to_str,
                        history_booking_trip_address_str,
                        history_booking_payment_method_str,
                        history_booking_g_cash_number_str,
                        history_booking_amount_str,
                        history_booking_company_id_str,
                        history_booking_company_name_str,
                        history_booking_company_address_str,
                        history_booking_car_id_str,
                        history_booking_date_str,
                        history_booking_date_approved_str,
                        history_booking_remarks_str,
                        history_booking_days_rented_str,
                        history_booking_car_PICKED_str,
                        history_booking_date_PICKED_str
                );

                boolean deleteBooking = myDB.deleteBooking(myBookingID);
                boolean updateTransaction = myDB.rentedExpire(myTransactionNumber, "Car Returned");
                boolean updateCarAvailability = myDB.carAvailability(history_booking_car_id_str, "Available");

                if (deleteBooking == true || updateTransaction == true || updateCarAvailability == true){
                    openCarRating();
                }

            }
        });
    }

    public void openCarRating(){
        Intent intent = new Intent(this, CarRatingPage.class);
        intent.putExtra("clientID", BookingID);
        intent.putExtra("carId", history_booking_car_id_str);
        startActivity(intent);
    }
}