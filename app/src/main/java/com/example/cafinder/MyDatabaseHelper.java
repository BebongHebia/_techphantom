package com.example.cafinder;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.ByteArrayOutputStream;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;

    //Clint Database
    private static final String CLIENT_TABLE_NAME = "clientTable";
    private static final String CLIENT_ID = "client_id";
    private static final String CLIENT_FIRST_NAME = "client_first_name";
    private static final String CLIENT_LAST_NAME = "client_last_name";
    private static final String CLIENT_EMAIL = "client_email";
    private static final String CLIENT_PHONE_NUMBER = "client_phone_number";
    private static final String CLIENT_PASSWORD = "client_password";
    private static final String CLIENT_PHOTO = "client_photo";


    //Business Owner Database
    private static final String BUSINESS_OWNER_TABLE = "businessOwnerTable";
    private static final String BUSINESS_ID = "businessOwnerID";
    private static final String BUSINESS_USERNAME = "businessOwnerUserName";
    private static final String BUSINESS_NAME = "businessOwnerName";
    private static final String BUSINESS_ADDRESS = "businessOwnerAddress";
    private static final String BUSINESS_EMAIL = "businessOwnerEmail";
    private static final String BUSINESS_PHONE_NUMBER = "businessOwnerPhoneNumber";
    private static final String BUSINESS_PASSWORD = "businessOwnerPassword";
    private static final String BUSINESS_DTI_NUMBER = "businessOwnerDTInumber";
    private static final String BUSINESS_MAYOR_PERMIT_NUMBER = "businessOwnerMayorsPermit";
    private static final String BUSINESS_BIR_NUMBER = "businessOwnerBIRNumber";
    private static final String BUSINESS_PHILGEPS_NUMBER = "businessOwnerPhilGepsNumber";
    private static final String BUSINESS_LOGO = "business_logo";
    private static final String BUSINESS_POLICIES = "business_policies";


    //CARs DATABASE
    private static final String CAR_TABLE = "cars_table";
    private static final String CAR_ID = "car_id";
    private static final String CAR_NAME = "car_name";
    private static final String CAR_PRICE = "car_price";
    private static final String COMPANY_OWNER = "car_owner";
    private static final String COMPANY_ID = "company_id";
    private static final String CAR_CAPACITY = "car_capacity";
    private static final String CAR_ENGINE = "car_engine";
    private static final String CAR_DOORS_COUNT = "car_door_count";
    private static final String CAR_AVAILABILITY = "car_availability";
    private static final String CAR_PLATE_NUMBER = "car_plate_number";
    private static final String CAR_GAS_TYPE = "car_gas_type";
    private static final String CAR_TYPE = "car_type";
    private static final String DRIVER_NAME = "driver_name";
    private static final String DRIVER_ADDRESS = "driver_address";
    private static final String DRIVER_CONTACT = "driver_contact";
    private static final String DRIVER_LICENSE = "driver_license";
    private static final String CAR_BOOKED_COUNT = "car_booked_count";
    private static final String CAR_RATING_SCORE = "car_rating_score";
    private static final String CAR_PHOTO = "car_photo";
    private static final String GOT_DRIVER = "gotDriver";



    //Booking Database

    private static final String BOOKING_TABLE = "bookingTABLE";
    private static final String BOOKING_ID = "booking_id";
    private static final String BOOKER_ID = "booker_id";
    private static final String BOOKING_FULL_NAME = "booking_full_name";
    private static final String BOOKING_ADDRESS = "booking_address";
    private static final String BOOKING_AGE = "booking_age";
    private static final String BOOKING_EMAIL = "booking_email";
    private static final String BOOKING_PHONE_NUMBER = "booking_phone_number";
    private static final String BOOKING_STATUS = "booking_status";
    private static final String BOOKING_CAR_NAME = "booking_car_name";
    private static final String BOOKING_CAR_PRICE = "booking_car_price";
    private static final String BOOKING_TRIP_DATE_FROM = "booking_trip_date_from";
    private static final String BOOKING_TRIP_DATE_TO = "booking_trip_date_to";
    private static final String BOOKING_TRIP_ADDRESS = "booking_trip_address";
    private static final String BOOKING_PAYMENT_METHOD = "booking_payment_method";
    private static final String BOOKING_G_CASH_NUMBER = "booking_g_cash_number";
    private static final String BOOKING_AMOUNT = "booking_amount";
    private static final String BOOKING_COMPANY_ID = "booking_company_id";
    private static final String BOOKING_COMPANY_NAME = "booking_company_name";
    private static final String BOOKING_COMPANY_ADDRESS = "booking_company_address";
    private static final String BOOKING_CAR_ID = "booking_car_id";
    private static final String BOOKING_DATE = "booking_date";
    private static final String BOOKING_DATE_APPROVED = "booking_date_approved";
    private static final String BOOKING_REMARKS = "booking_remarks";
    private static final String BOOKING_DAYS_RENTED = "booking_days_rented";
    private static final String BOOKING_CAR_PICKED = "booking_car_PICKED";
    private static final String BOOKING_DATE_PICKED = "booking_date_PICKED";
    private static final String BOOKING_DRIVER_OPTION = "booking_driver_option";

    //Outgoing Transaction Table
    private static final String OUTGOING_TRANSACTION_TABLE = "transaction_table";
    private static final String OUTGOING_TRANSACTION_ID = "transaction_id";
    private static final String OUTGOING_TRANSACTION_BOOKER_NAME = "transaction_booker_name";
    private static final String OUTGOING_TRANSACTION_CAR_MODEL = "transaction_car_model";
    private static final String OUTGOING_TRANSACTION_TRIP_DATE = "transaction_trip_date";
    private static final String OUTGOING_TRANSACTION_TRIP_ROUTES = "transaction_trip_routes";
    private static final String OUTGOING_TRANSACTION_DATE_PICKUP = "transaction_date_pickup";
    private static final String OUTGOING_TRANSACTION_RETURN_STATUS = "transaction_return_status";
    private static final String OUTGOING_TRANSACTION_COMPANY_OWNER = "transaction_company_owner";
    private static final String OUTGOING_TRANSACTION_COMPANY_ID = "transaction_company_id";
    private static final String OUTGOING_TRANSACTION_BOOKER_ID = "transaction_booker_id";
    private static final String OUTGOING_TRANSACTION_BOOKING_ID = "transaction_booking_id";



    //History Table


    private static final String HISTORY_BOOKING_TABLE = "history_Table";
    private static final String HISTORY_ID = "history_history_id";
    private static final String HISTORY_BOOKING_ID = "history_booking_id";
    private static final String HISTORY_BOOKER_ID = "history_booker_id";
    private static final String HISTORY_BOOKING_FULL_NAME = "history_booking_full_name";
    private static final String HISTORY_BOOKING_ADDRESS = "history_booking_address";
    private static final String HISTORY_BOOKING_AGE = "history_booking_age";
    private static final String HISTORY_BOOKING_EMAIL = "history_booking_email";
    private static final String HISTORY_BOOKING_PHONE_NUMBER = "history_booking_phone_number";
    private static final String HISTORY_BOOKING_STATUS = "history_booking_status";
    private static final String HISTORY_BOOKING_CAR_NAME = "history_booking_car_name";
    private static final String HISTORY_BOOKING_CAR_PRICE = "history_booking_car_price";
    private static final String HISTORY_BOOKING_TRIP_DATE_FROM = "history_booking_trip_date_from";
    private static final String HISTORY_BOOKING_TRIP_DATE_TO = "history_booking_trip_date_to";
    private static final String HISTORY_BOOKING_TRIP_ADDRESS = "history_booking_trip_address";
    private static final String HISTORY_BOOKING_PAYMENT_METHOD = "history_booking_payment_method";
    private static final String HISTORY_BOOKING_G_CASH_NUMBER = "history_booking_g_cash_number";
    private static final String HISTORY_BOOKING_AMOUNT = "history_booking_amount";
    private static final String HISTORY_BOOKING_COMPANY_ID = "history_booking_company_id";
    private static final String HISTORY_BOOKING_COMPANY_NAME = "history_booking_company_name";
    private static final String HISTORY_BOOKING_COMPANY_ADDRESS = "history_booking_company_address";
    private static final String HISTORY_BOOKING_CAR_ID = "history_booking_car_id";
    private static final String HISTORY_BOOKING_DATE = "history_booking_date";
    private static final String HISTORY_BOOKING_DATE_APPROVED = "history_booking_date_approved";
    private static final String HISTORY_BOOKING_REMARKS = "history_booking_remarks";
    private static final String HISTORY_BOOKING_DAYS_RENTED = "history_booking_days_rented";
    private static final String HISTORY_BOOKING_CAR_PICKED = "history_booking_car_PICKED";
    private static final String HISTORY_BOOKING_DATE_PICKED = "history_booking_date_PICKED";


    private ByteArrayOutputStream objectByteArrayOutputStream;
    private byte[] imageInByte;





    public MyDatabaseHelper(@Nullable Context context) {
        super(context, "carFinder.db", null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String client_query =
                "CREATE TABLE " + CLIENT_TABLE_NAME +
                        " (" + CLIENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        CLIENT_FIRST_NAME + " TEXT, " +
                        CLIENT_LAST_NAME + " TEXT, " +
                        CLIENT_EMAIL + " TEXT, " +
                        CLIENT_PHONE_NUMBER + " TEXT, " +
                        CLIENT_PHOTO + " BLOB, " +
                        CLIENT_PASSWORD + " TEXT);";

        String owner_query =
                "CREATE TABLE " + BUSINESS_OWNER_TABLE +
                        " (" + BUSINESS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        BUSINESS_USERNAME + " TEXT, " +
                        BUSINESS_NAME + " TEXT, " +
                        BUSINESS_ADDRESS + " TEXT, " +
                        BUSINESS_EMAIL + " TEXT, " +
                        BUSINESS_DTI_NUMBER + " TEXT, " +
                        BUSINESS_MAYOR_PERMIT_NUMBER + " TEXT, " +
                        BUSINESS_BIR_NUMBER + " TEXT, " +
                        BUSINESS_LOGO + " BLOB, " +
                        BUSINESS_POLICIES + " TEXT, " +
                        BUSINESS_PHILGEPS_NUMBER + " TEXT, " +
                        BUSINESS_PHONE_NUMBER + " TEXT, " +
                        BUSINESS_PASSWORD + " TEXT);";

        String booking_query =
                "CREATE TABLE " + BOOKING_TABLE +
                        " (" + BOOKING_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        BOOKER_ID + " TEXT, " +
                        BOOKING_FULL_NAME + " TEXT, " +
                        BOOKING_ADDRESS + " TEXT, " +
                        BOOKING_AGE + " TEXT, " +
                        BOOKING_EMAIL + " TEXT, " +
                        BOOKING_PHONE_NUMBER + " TEXT, " +
                        BOOKING_STATUS + " TEXT, " +
                        BOOKING_CAR_NAME + " TEXT, " +
                        BOOKING_CAR_PRICE + " TEXT, " +
                        BOOKING_COMPANY_ID + " TEXT, " +
                        BOOKING_COMPANY_NAME + " TEXT, " +
                        BOOKING_COMPANY_ADDRESS + " TEXT, " +
                        BOOKING_CAR_ID + " TEXT, " +
                        BOOKING_DATE_PICKED + " TEXT, " +
                        BOOKING_DRIVER_OPTION + " TEXT, " +
                        BOOKING_CAR_PICKED + " TEXT, " +
                        BOOKING_TRIP_DATE_FROM + " TEXT, " +
                        BOOKING_TRIP_DATE_TO + " TEXT, " +
                        BOOKING_TRIP_ADDRESS + " TEXT, " +
                        BOOKING_PAYMENT_METHOD + " TEXT, " +
                        BOOKING_G_CASH_NUMBER + " TEXT, " +
                        BOOKING_DATE + " TEXT, " +
                        BOOKING_DATE_APPROVED + " TEXT, " +
                        BOOKING_REMARKS + " TEXT, " +
                        BOOKING_DAYS_RENTED + " TEXT, " +
                        BOOKING_AMOUNT + " TEXT);";

        String car_query =
                "CREATE TABLE " + CAR_TABLE +
                        " (" + CAR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        CAR_NAME + " TEXT, " +
                        CAR_PRICE + " TEXT, " +
                        COMPANY_OWNER + " TEXT, " +
                        COMPANY_ID + " TEXT, " +
                        CAR_AVAILABILITY + " TEXT, " +
                        CAR_PLATE_NUMBER + " TEXT, " +
                        CAR_GAS_TYPE + " TEXT, " +
                        CAR_CAPACITY + " TEXT, " +
                        CAR_TYPE + " TEXT, " +
                        CAR_BOOKED_COUNT + " INTEGER, " +
                        CAR_RATING_SCORE + " INTEGER, " +
                        DRIVER_NAME + " TEXT, " +
                        GOT_DRIVER+ " TEXT, " +
                        DRIVER_ADDRESS + " TEXT, " +
                        DRIVER_CONTACT + " TEXT, " +
                        DRIVER_LICENSE + " TEXT, " +
                        CAR_ENGINE + " TEXT, " +
                        CAR_PHOTO + " BLOB, " +
                        CAR_DOORS_COUNT + " TEXT);";

        String transaction_ongoing_query =
                "CREATE TABLE " + OUTGOING_TRANSACTION_TABLE +
                        " (" + OUTGOING_TRANSACTION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        OUTGOING_TRANSACTION_BOOKER_NAME + " TEXT, " +
                        OUTGOING_TRANSACTION_CAR_MODEL + " TEXT, " +
                        OUTGOING_TRANSACTION_TRIP_DATE + " TEXT, " +
                        OUTGOING_TRANSACTION_DATE_PICKUP + " TEXT, " +
                        OUTGOING_TRANSACTION_COMPANY_OWNER + " TEXT, " +
                        OUTGOING_TRANSACTION_COMPANY_ID + " TEXT, " +
                        OUTGOING_TRANSACTION_RETURN_STATUS + " TEXT, " +
                        OUTGOING_TRANSACTION_BOOKING_ID + " TEXT, " +
                        OUTGOING_TRANSACTION_BOOKER_ID + " TEXT, " +
                        OUTGOING_TRANSACTION_TRIP_ROUTES + " TEXT);";


        String history_query =
                "CREATE TABLE " + HISTORY_BOOKING_TABLE +
                        " (" + HISTORY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        HISTORY_BOOKING_ID + " TEXT, " +
                        HISTORY_BOOKER_ID + " TEXT, " +
                        HISTORY_BOOKING_FULL_NAME + " TEXT, " +
                        HISTORY_BOOKING_ADDRESS + " TEXT, " +
                        HISTORY_BOOKING_AGE + " TEXT, " +
                        HISTORY_BOOKING_EMAIL + " TEXT, " +
                        HISTORY_BOOKING_PHONE_NUMBER + " TEXT, " +
                        HISTORY_BOOKING_STATUS + " TEXT, " +
                        HISTORY_BOOKING_CAR_NAME + " TEXT, " +
                        HISTORY_BOOKING_CAR_PRICE + " TEXT, " +
                        HISTORY_BOOKING_TRIP_DATE_FROM + " TEXT, " +
                        HISTORY_BOOKING_TRIP_DATE_TO + " TEXT, " +
                        HISTORY_BOOKING_TRIP_ADDRESS + " TEXT, " +
                        HISTORY_BOOKING_PAYMENT_METHOD + " TEXT, " +
                        HISTORY_BOOKING_G_CASH_NUMBER + " TEXT, " +
                        HISTORY_BOOKING_AMOUNT + " TEXT, " +
                        HISTORY_BOOKING_COMPANY_ID + " TEXT, " +
                        HISTORY_BOOKING_COMPANY_NAME + " TEXT, " +
                        HISTORY_BOOKING_COMPANY_ADDRESS + " TEXT, " +
                        HISTORY_BOOKING_CAR_ID + " TEXT, " +
                        HISTORY_BOOKING_DATE + " TEXT, " +
                        HISTORY_BOOKING_DATE_APPROVED + " TEXT, " +
                        HISTORY_BOOKING_REMARKS + " TEXT, " +
                        HISTORY_BOOKING_DAYS_RENTED + " TEXT, " +
                        HISTORY_BOOKING_CAR_PICKED + " TEXT, " +
                        HISTORY_BOOKING_DATE_PICKED + " TEXT);";


        db.execSQL(client_query);
        db.execSQL(owner_query);
        db.execSQL(booking_query);
        db.execSQL(car_query);
        db.execSQL(transaction_ongoing_query);

        db.execSQL(history_query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CLIENT_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + BUSINESS_OWNER_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + BOOKING_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + CAR_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + OUTGOING_TRANSACTION_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + HISTORY_BOOKING_TABLE);
        onCreate(db);
    }

    public void AddClient(String firstName, String lastName, String phoneNumber, String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(CLIENT_FIRST_NAME, firstName);
        cv.put(CLIENT_LAST_NAME, lastName);
        cv.put(CLIENT_EMAIL, email);
        cv.put(CLIENT_PHONE_NUMBER, phoneNumber);
        cv.put(CLIENT_PASSWORD, password);

        long result = db.insert(CLIENT_TABLE_NAME, null, cv);
        if (result == -1){
            Toast.makeText(context, "Create Account Failed", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Create Account Completed", Toast.LENGTH_SHORT).show();
        }

    }


    public boolean checkClient(String phoneNumber, String passwords){
        SQLiteDatabase myDB = this.getWritableDatabase();
        String [] columns = {CLIENT_PHONE_NUMBER};
        String selection = CLIENT_PHONE_NUMBER + "=?" + " and " + CLIENT_PASSWORD + "=?";
        String [] selectionargs = {phoneNumber, passwords};
        Cursor cursor = myDB.query(CLIENT_TABLE_NAME, columns, selection, selectionargs, null, null,  null);
        int count =cursor.getCount();

        if (count > 0){
            return true;
        }
        else{
            return false;
        }
    }

    public void addBusinessOwner(String businessUserName, String businessEmail, String phoneNumber, String businessName, String businessAddress, String password, String dtiNumber,
                                 String mayorsNumber, String birNumber, String philGepsNumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(BUSINESS_USERNAME, businessUserName);
        cv.put(BUSINESS_NAME, businessName);
        cv.put(BUSINESS_ADDRESS, businessAddress);
        cv.put(BUSINESS_EMAIL, businessEmail);
        cv.put(BUSINESS_PHONE_NUMBER, phoneNumber);
        cv.put(BUSINESS_PASSWORD, password);
        cv.put(BUSINESS_DTI_NUMBER, dtiNumber);
        cv.put(BUSINESS_MAYOR_PERMIT_NUMBER, mayorsNumber);
        cv.put(BUSINESS_BIR_NUMBER, birNumber);
        cv.put(BUSINESS_PHILGEPS_NUMBER, philGepsNumber);

        long result = db.insert(BUSINESS_OWNER_TABLE, null, cv);
        if (result == -1) {
            Toast.makeText(context, "Create Account Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Create Account Completed", Toast.LENGTH_SHORT).show();
        }

    }


    public boolean checkOwner(String username, String passwords){
        SQLiteDatabase myDB = this.getWritableDatabase();
        String [] columns = {BUSINESS_USERNAME};
        String selection = BUSINESS_USERNAME + "=?" + " and " + BUSINESS_PASSWORD + "=?";
        String [] selectionargs = {username, passwords};
        Cursor cursor = myDB.query(BUSINESS_OWNER_TABLE, columns, selection, selectionargs, null, null,  null);
        int count =cursor.getCount();

        if (count > 0){
            return true;
        }
        else{
            return false;
        }
    }

    public StringBuilder getBusinessOwnerName(String userName){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT businessOwnerName FROM businessOwnerTable WHERE businessOwnerUserName = '" + userName + "'", null);
        String firstNameValue;

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("businessOwnerName");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }


    public StringBuilder getBusinessOwnerAddress(String userName){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT businessOwnerAddress FROM businessOwnerTable WHERE businessOwnerUserName = '" + userName + "'", null);
        String firstNameValue;

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("businessOwnerAddress");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getClientFirstName(String clientID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT client_first_name FROM clientTable WHERE client_id = '" + clientID + "'", null);
        String firstNameValue;

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("client_first_name");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getClientLastName(String userName){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT client_last_name FROM clientTable WHERE client_id = '" + userName + "'", null);
        String firstNameValue;

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("client_last_name");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }
    public StringBuilder getClientEmail(String userName){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT client_email FROM clientTable WHERE client_id = '" + userName + "'", null);
        String firstNameValue;

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("client_email");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getClientPhoneNumber(String userName){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT client_phone_number FROM clientTable WHERE client_id = '" + userName + "'", null);
        String firstNameValue;

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("client_phone_number");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getClientID(String userName){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT client_id FROM clientTable WHERE client_phone_number = '" + userName + "'", null);
        String firstNameValue;

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("client_id");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }



    public void addBooking(String bookerID,
                           String fullname,
                           String address,
                           String age,
                           String email,
                           String phoneNumber,
                           String bookingStatus,
                           String carName,
                           String carPrice,
                           String tripDateFrom,
                           String tripDateTo,
                           String tripAddress,
                           String paymentMethod,
                           String gCashNumber,
                           String amount,
                           String companyID,
                           String companyName,
                           String companyAddress,
                           String carID,
                           String bookingDate,
                           String bookingDateApproved,
                           String remarks,
                           String daysRented,
                           String carPicked,
                           String datePicked,
                           String driverOption
    ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(BOOKER_ID, bookerID);
        cv.put(BOOKING_FULL_NAME, fullname);
        cv.put(BOOKING_ADDRESS, address);
        cv.put(BOOKING_AGE, age);
        cv.put(BOOKING_EMAIL, email);
        cv.put(BOOKING_PHONE_NUMBER, phoneNumber);
        cv.put(BOOKING_STATUS, bookingStatus);
        cv.put(BOOKING_CAR_NAME, carName);
        cv.put(BOOKING_CAR_PRICE, carPrice);
        cv.put(BOOKING_TRIP_DATE_FROM, tripDateFrom);
        cv.put(BOOKING_TRIP_DATE_TO, tripDateTo);
        cv.put(BOOKING_TRIP_ADDRESS, tripAddress);
        cv.put(BOOKING_PAYMENT_METHOD, paymentMethod);
        cv.put(BOOKING_G_CASH_NUMBER, gCashNumber);
        cv.put(BOOKING_AMOUNT, amount);
        cv.put(BOOKING_COMPANY_ID, companyID);
        cv.put(BOOKING_COMPANY_NAME, companyName);
        cv.put(BOOKING_COMPANY_ADDRESS, companyAddress);
        cv.put(BOOKING_CAR_ID, carID);
        cv.put(BOOKING_DATE, bookingDate);
        cv.put(BOOKING_DATE_APPROVED, bookingDateApproved);
        cv.put(BOOKING_REMARKS, remarks);
        cv.put(BOOKING_DAYS_RENTED, daysRented);
        cv.put(BOOKING_CAR_PICKED, carPicked);
        cv.put(BOOKING_DATE_PICKED, datePicked);
        cv.put(BOOKING_DRIVER_OPTION, driverOption);

        long result = db.insert(BOOKING_TABLE, null, cv);
        if (result == -1) {
            Toast.makeText(context, "Booking Created Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Booking Completed", Toast.LENGTH_SHORT).show();
        }

    }

    public Cursor readAllDataFromBooking(String companyID){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery("SELECT * FROM bookingTABLE WHERE booking_company_id = '" + companyID + "'", null);
        }
        return cursor;
    }

    public StringBuilder getCompanyIDbyCompanyName(String companyName){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT businessOwnerID FROM businessOwnerTable WHERE businessOwnerName = '" + companyName + "'", null);
        String firstNameValue;

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("businessOwnerID");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }


    public boolean checkIfIHaveBooking(String idNumber){
        SQLiteDatabase myDB = this.getWritableDatabase();
        String [] columns = {BOOKER_ID};
        String selection = BOOKER_ID + "=?";
        String [] selectionargs = {idNumber};
        Cursor cursor = myDB.query(BOOKING_TABLE, columns, selection, selectionargs, null, null,  null);
        int count =cursor.getCount();

        if (count > 0){
            return true;
        }
        else{
            return false;
        }
    }

    public StringBuilder getBookingStatus(String idNumber){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_status FROM bookingTABLE WHERE booker_id = '" + idNumber + "'", null);
        String firstNameValue;

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_status");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public boolean checkIfIBookingIDExisted(String idNumber){
        SQLiteDatabase myDB = this.getWritableDatabase();
        String [] columns = {BOOKING_ID};
        String selection = BOOKING_ID + "=?";
        String [] selectionargs = {idNumber};
        Cursor cursor = myDB.query(BOOKING_TABLE, columns, selection, selectionargs, null, null,  null);
        int count =cursor.getCount();

        if (count > 0){
            return true;
        }
        else{
            return false;
        }
    }

    public StringBuilder getBookingName(String booking_ID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_full_name FROM bookingTABLE WHERE booking_id = '" + booking_ID + "'", null);
        String firstNameValue;

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_full_name");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBookingAddress(String booking_ID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_address FROM bookingTABLE WHERE booking_id = '" + booking_ID + "'", null);
        String firstNameValue;

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_address");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBookingAge(String booking_ID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_age FROM bookingTABLE WHERE booking_id = '" + booking_ID + "'", null);
        String firstNameValue;

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_age");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBookingEmail(String booking_ID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_email FROM bookingTABLE WHERE booking_id = '" + booking_ID + "'", null);
        String firstNameValue;

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_email");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBookingMobileNumber(String booking_ID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_phone_number FROM bookingTABLE WHERE booking_id = '" + booking_ID + "'", null);
        String firstNameValue;

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_phone_number");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBookingStatus1(String booking_ID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_status FROM bookingTABLE WHERE booking_id = '" + booking_ID + "'", null);
        String firstNameValue;

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_status");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBookingCarName(String booking_ID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_car_name FROM bookingTABLE WHERE booking_id = '" + booking_ID + "'", null);
        String firstNameValue;

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_car_name");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBookingCarPrice(String booking_ID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_car_price FROM bookingTABLE WHERE booking_id = '" + booking_ID + "'", null);
        String firstNameValue;

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_car_price");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBookingTripDateFrom(String booking_ID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_trip_date_from FROM bookingTABLE WHERE booking_id = '" + booking_ID + "'", null);
        String firstNameValue;

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_trip_date_from");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBookingTripDateTo(String booking_ID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_trip_date_to FROM bookingTABLE WHERE booking_id = '" + booking_ID + "'", null);
        String firstNameValue;

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_trip_date_to");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBookingTripAddress(String booking_ID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_trip_address FROM bookingTABLE WHERE booking_id = '" + booking_ID + "'", null);
        String firstNameValue;

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_trip_address");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBookingPaymentMethod(String booking_ID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_payment_method FROM bookingTABLE WHERE booking_id = '" + booking_ID + "'", null);
        String firstNameValue;

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_payment_method");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBookingGCashNumber(String booking_ID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_g_cash_number FROM bookingTABLE WHERE booking_id = '" + booking_ID + "'", null);
        String firstNameValue;

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_g_cash_number");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBookingAmount(String booking_ID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_amount FROM bookingTABLE WHERE booking_id = '" + booking_ID + "'", null);
        String firstNameValue;

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_amount");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    boolean ApproveRequest(String booking_ID,
                           String bookingStatus){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(BOOKING_STATUS, bookingStatus);

        db.update(BOOKING_TABLE,  cv, "booking_id=?", new String[]{booking_ID});
        return true;

    }

    boolean UpdateClientProfile(String client_phoneNumber, String firstname, String lastname, String email, String mobileNumber){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(CLIENT_FIRST_NAME, firstname);
        cv.put(CLIENT_LAST_NAME, lastname);
        cv.put(CLIENT_EMAIL, email);
        cv.put(CLIENT_PHONE_NUMBER, mobileNumber);

        db.update(CLIENT_TABLE_NAME,  cv, "client_phone_number=?", new String[]{client_phoneNumber});
        return true;

    }

    public StringBuilder getClientPassword(String clientPhoneNumber){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT client_password FROM clientTable WHERE client_phone_number = '" + clientPhoneNumber + "'", null);
        String firstNameValue;

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("client_password");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    boolean UpdateClientPassword(String client_phoneNumber, String password){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(CLIENT_PASSWORD, password);

        db.update(CLIENT_TABLE_NAME,  cv, "client_phone_number=?", new String[]{client_phoneNumber});
        return true;

    }

    public StringBuilder getCompanyID(String companyName){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT businessOwnerID FROM businessOwnerTable WHERE businessOwnerName = '" + companyName + "'", null);
        String firstNameValue;

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("businessOwnerID");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public void addCars(String carName, String carPrice, String companyOwner, String companyID, String carCapacity, String carEngine, String carDoors,
                        String carAvailability, String carPlateNumber, String carGasType, String carType, String driverName,
                        String driverAddress, String driverContacts, String driverLicense, AddCarModelClass addCarModelClass, Integer carBookedCount, Integer carBookedRating, String gotDriver) {
        SQLiteDatabase db = this.getWritableDatabase();
        Bitmap imageToStoreBitmap = addCarModelClass.getImage();

        objectByteArrayOutputStream = new ByteArrayOutputStream();
        imageToStoreBitmap.compress(Bitmap.CompressFormat.PNG, 100, objectByteArrayOutputStream);

        imageInByte = objectByteArrayOutputStream.toByteArray();

        ContentValues cv = new ContentValues();

        cv.put(CAR_NAME, carName);
        cv.put(CAR_PRICE, carPrice);
        cv.put(COMPANY_OWNER, companyOwner);
        cv.put(COMPANY_ID, companyID);
        cv.put(CAR_CAPACITY, carCapacity);
        cv.put(CAR_ENGINE, carEngine);
        cv.put(CAR_DOORS_COUNT, carDoors);
        cv.put(CAR_AVAILABILITY, carAvailability);
        cv.put(CAR_PLATE_NUMBER, carPlateNumber);
        cv.put(CAR_GAS_TYPE, carGasType);
        cv.put(CAR_TYPE, carType);
        cv.put(DRIVER_NAME, driverName);
        cv.put(DRIVER_ADDRESS, driverAddress);
        cv.put(DRIVER_CONTACT, driverContacts);
        cv.put(DRIVER_LICENSE, driverLicense);
        cv.put(CAR_PHOTO, imageInByte);
        cv.put(CAR_BOOKED_COUNT, carBookedCount);
        cv.put(CAR_RATING_SCORE, carBookedRating);
        cv.put(GOT_DRIVER, gotDriver);

        long result = db.insert(CAR_TABLE, null, cv);
        if (result == -1) {
            Toast.makeText(context, "Car Upload Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Car Uploaded Successfully", Toast.LENGTH_SHORT).show();
        }

    }

    public Cursor readAllDataFromMyCars(String companyName){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery("SELECT * FROM cars_table WHERE car_owner =  '"+ companyName +"' ", null);
        }
        return cursor;
    }

    public StringBuilder getCarName(String carID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT car_name FROM cars_table WHERE car_id = '" + carID + "'", null);
        String firstNameValue;

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("car_name");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getCarPrice(String carID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT car_price FROM cars_table WHERE car_id = '" + carID + "'", null);
        String firstNameValue;

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("car_price");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getCarCompanyOwner(String carID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT car_owner FROM cars_table WHERE car_id = '" + carID + "'", null);
        String firstNameValue;

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("car_owner");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getCarCapacity(String carID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT car_capacity FROM cars_table WHERE car_id = '" + carID + "'", null);
        String firstNameValue;

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("car_capacity");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getCarEngine(String carID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT car_engine FROM cars_table WHERE car_id = '" + carID + "'", null);
        String firstNameValue;

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("car_engine");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getCarDoorCount(String carID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT car_door_count FROM cars_table WHERE car_id = '" + carID + "'", null);
        String firstNameValue;

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("car_door_count");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getCarCompanyID(String carID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT company_id FROM cars_table WHERE car_id = '" + carID + "'", null);
        String firstNameValue;

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("company_id");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getCarCompanyAddress(String companyID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT businessOwnerAddress FROM businessOwnerTable WHERE businessOwnerID = '" + companyID + "'", null);
        String firstNameValue;

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("businessOwnerAddress");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }



    public Cursor readAllCars(){
        String query = "SELECT * FROM " + CAR_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;

    }

    public StringBuilder getBookerName(String bookerID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_full_name FROM bookingTABLE WHERE booker_id = '" + bookerID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_full_name");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBookingID(String bookerID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_id FROM bookingTABLE WHERE booker_id = '" + bookerID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_id");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBookerStatus(String bookerID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_status FROM bookingTABLE WHERE booker_id = '" + bookerID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_status");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBookerCarModel(String bookerID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_car_name FROM bookingTABLE WHERE booker_id = '" + bookerID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_car_name");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBookerCarPrice(String bookerID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_car_price FROM bookingTABLE WHERE booker_id = '" + bookerID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_car_price");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBookerCarCompanyOwner(String bookerID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_company_name FROM bookingTABLE WHERE booker_id = '" + bookerID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_company_name");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBookerTripDateFrom(String bookerID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_trip_date_from FROM bookingTABLE WHERE booker_id = '" + bookerID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_trip_date_from");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBookerTripDateTo(String bookerID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_trip_date_to FROM bookingTABLE WHERE booker_id = '" + bookerID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_trip_date_to");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBookerTripDateAddress(String bookerID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_trip_address FROM bookingTABLE WHERE booker_id = '" + bookerID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_trip_address");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getCompanyAddress(String companyID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT businessOwnerAddress FROM businessOwnerTable WHERE businessOwnerID = '" + companyID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("businessOwnerAddress");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder viewBookingFullName(String bookingID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_full_name FROM bookingTABLE WHERE booking_id = '" + bookingID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_full_name");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder viewBookingAddress(String bookingID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_address FROM bookingTABLE WHERE booking_id = '" + bookingID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_address");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder viewBookingAge(String bookingID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_age FROM bookingTABLE WHERE booking_id = '" + bookingID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_age");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder viewBookingEmail(String bookingID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_email FROM bookingTABLE WHERE booking_id = '" + bookingID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_email");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder viewBookingPhoneNumber(String bookingID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_phone_number FROM bookingTABLE WHERE booking_id = '" + bookingID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_phone_number");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder viewBookingCarModel(String bookingID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_car_name FROM bookingTABLE WHERE booking_id = '" + bookingID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_car_name");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder viewBookingCarPrice(String bookingID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_car_price FROM bookingTABLE WHERE booking_id = '" + bookingID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_car_price");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder viewBookingTripDateFrom(String bookingID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_trip_date_from FROM bookingTABLE WHERE booking_id = '" + bookingID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_trip_date_from");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder viewBookingTripDateTo(String bookingID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_trip_date_to FROM bookingTABLE WHERE booking_id = '" + bookingID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_trip_date_to");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder viewBookingTripAddress(String bookingID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_trip_address FROM bookingTABLE WHERE booking_id = '" + bookingID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_trip_address");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder viewBookingPaymentMethod(String bookingID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_payment_method FROM bookingTABLE WHERE booking_id = '" + bookingID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_payment_method");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder viewBookingGCashNumber(String bookingID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_g_cash_number FROM bookingTABLE WHERE booking_id = '" + bookingID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_g_cash_number");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder viewBookingCompanyName(String bookingID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_company_name FROM bookingTABLE WHERE booking_id = '" + bookingID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_company_name");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder viewBookingDateApproved(String bookingID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_date_approved FROM bookingTABLE WHERE booker_id = '" + bookingID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_date_approved");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder viewBookingDaysRented(String bookingID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_days_rented FROM bookingTABLE WHERE booker_id = '" + bookingID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_days_rented");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder viewBookingRemarks(String bookingID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_remarks FROM bookingTABLE WHERE booker_id = '" + bookingID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_remarks");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder viewBookingDate(String bookingID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_date FROM bookingTABLE WHERE booker_id = '" + bookingID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_date");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getCompanyAddressByCompanyName(String companyName){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT businessOwnerAddress FROM businessOwnerTable WHERE businessOwnerName = '" + companyName + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("businessOwnerAddress");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    boolean ApproveBooking(String booking_ID,
                           String bookingStatus,
                           String bookingTotalAmount,
                           String bookingDateApproved,
                           String bookingRemarks,
                           String bookingDaysRented,
                           String bookingCarPicked){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(BOOKING_STATUS, bookingStatus);
        cv.put(BOOKING_AMOUNT, bookingTotalAmount);
        cv.put(BOOKING_DATE_APPROVED, bookingDateApproved);
        cv.put(BOOKING_REMARKS, bookingRemarks);
        cv.put(BOOKING_DAYS_RENTED, bookingDaysRented);
        cv.put(BOOKING_CAR_PICKED, bookingCarPicked);


        db.update(BOOKING_TABLE,  cv, "booking_id=?", new String[]{booking_ID});
        return true;
    }

    public StringBuilder getBookingStatusByBookerID(String bookerID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_status FROM bookingTABLE WHERE booker_id = '" + bookerID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_status");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getClientNumberByPhoneNumber(String phoneNumber){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT client_id FROM clientTable WHERE client_phone_number = '" + phoneNumber + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("client_id");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getTotalAmount(String bookingID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_amount FROM bookingTABLE WHERE booker_id = '" + bookingID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_amount");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getCarPicked(String bookingID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_car_PICKED FROM bookingTABLE WHERE booker_id = '" + bookingID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_car_PICKED");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public void addTransactions(String transaction_booker_name,
                                String transaction_car_model,
                                String transaction_trip_date,
                                String transaction_trip_routes,
                                String transaction_date_pickup,
                                String transaction_return_status,
                                String transaction_company_owner,
                                String transaction_company_id,
                                String transaction_booker_id,
                                String transaction_booking_id
    ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();


        cv.put(OUTGOING_TRANSACTION_BOOKER_NAME, transaction_booker_name);
        cv.put(OUTGOING_TRANSACTION_CAR_MODEL, transaction_car_model);
        cv.put(OUTGOING_TRANSACTION_TRIP_DATE, transaction_trip_date);
        cv.put(OUTGOING_TRANSACTION_TRIP_ROUTES, transaction_trip_routes);
        cv.put(OUTGOING_TRANSACTION_DATE_PICKUP, transaction_date_pickup);
        cv.put(OUTGOING_TRANSACTION_RETURN_STATUS, transaction_return_status);
        cv.put(OUTGOING_TRANSACTION_COMPANY_OWNER, transaction_company_owner);
        cv.put(OUTGOING_TRANSACTION_COMPANY_ID, transaction_company_id);
        cv.put(OUTGOING_TRANSACTION_BOOKER_ID, transaction_booker_id);
        cv.put(OUTGOING_TRANSACTION_BOOKING_ID, transaction_booking_id);

        long result = db.insert(OUTGOING_TRANSACTION_TABLE, null, cv);
        if (result == -1) {
            Toast.makeText(context, "Booking Created Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Booking Completed", Toast.LENGTH_SHORT).show();
        }

    }

    public void addToHistory(String history_booking_id,
                             String history_booker_id,
                             String history_booking_full_name,
                             String history_booking_address,
                             String history_booking_age,
                             String history_booking_email,
                             String history_booking_phone_number,
                             String history_booking_status,
                             String history_booking_car_name,
                             String history_booking_car_price,
                             String history_booking_trip_date_from,
                             String history_booking_trip_date_to,
                             String history_booking_trip_address,
                             String history_booking_payment_method,
                             String history_booking_g_cash_number,
                             String history_booking_amount,
                             String history_booking_company_id,
                             String history_booking_company_name,
                             String history_booking_company_address,
                             String history_booking_car_id,
                             String history_booking_date,
                             String history_booking_date_approved,
                             String history_booking_remarks,
                             String history_booking_days_rented,
                             String history_booking_car_PICKED,
                             String history_booking_date_PICKED
    ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();


        cv.put(HISTORY_BOOKING_ID, history_booking_id);
        cv.put(HISTORY_BOOKER_ID, history_booker_id);
        cv.put(HISTORY_BOOKING_FULL_NAME, history_booking_full_name);
        cv.put(HISTORY_BOOKING_ADDRESS, history_booking_address);
        cv.put(HISTORY_BOOKING_AGE, history_booking_age);
        cv.put(HISTORY_BOOKING_EMAIL, history_booking_email);
        cv.put(HISTORY_BOOKING_PHONE_NUMBER, history_booking_phone_number);
        cv.put(HISTORY_BOOKING_STATUS, history_booking_status);
        cv.put(HISTORY_BOOKING_CAR_NAME, history_booking_car_name);
        cv.put(HISTORY_BOOKING_CAR_PRICE, history_booking_car_price);
        cv.put(HISTORY_BOOKING_TRIP_DATE_FROM, history_booking_trip_date_from);
        cv.put(HISTORY_BOOKING_TRIP_DATE_TO, history_booking_trip_date_to);
        cv.put(HISTORY_BOOKING_TRIP_ADDRESS, history_booking_trip_address);
        cv.put(HISTORY_BOOKING_PAYMENT_METHOD, history_booking_payment_method);
        cv.put(HISTORY_BOOKING_G_CASH_NUMBER, history_booking_g_cash_number);
        cv.put(HISTORY_BOOKING_AMOUNT, history_booking_amount);
        cv.put(HISTORY_BOOKING_COMPANY_ID, history_booking_company_id);
        cv.put(HISTORY_BOOKING_COMPANY_NAME, history_booking_company_name);
        cv.put(HISTORY_BOOKING_COMPANY_ADDRESS, history_booking_company_address);
        cv.put(HISTORY_BOOKING_CAR_ID, history_booking_car_id);
        cv.put(HISTORY_BOOKING_DATE, history_booking_date);
        cv.put(HISTORY_BOOKING_DATE_APPROVED, history_booking_date_approved);
        cv.put(HISTORY_BOOKING_REMARKS, history_booking_remarks);
        cv.put(HISTORY_BOOKING_DAYS_RENTED, history_booking_days_rented);
        cv.put(HISTORY_BOOKING_CAR_PICKED, history_booking_car_PICKED);
        cv.put(HISTORY_BOOKING_DATE_PICKED, history_booking_date_PICKED);

        long result = db.insert(HISTORY_BOOKING_TABLE, null, cv);
        if (result == -1) {
            Toast.makeText(context, "Booking Created Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Booking Completed", Toast.LENGTH_SHORT).show();
        }

    }
    boolean carPicked(String booking_ID,
                      String bookingCarPicked,
                      String bookingDatePicked){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(BOOKING_CAR_PICKED, bookingCarPicked);
        cv.put(BOOKING_DATE_PICKED, bookingDatePicked);

        db.update(BOOKING_TABLE,  cv, "booker_id=?", new String[]{booking_ID});
        return true;
    }


    //Getting DataForHistoryTable
    public StringBuilder getBookingID_ByBookerID(String bookerID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_id FROM bookingTABLE WHERE booker_id = '" + bookerID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_id");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBookerFullName_ByBookerID(String bookerID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_full_name FROM bookingTABLE WHERE booker_id = '" + bookerID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_full_name");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBookerAddress_ByBookerID(String bookerID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_address FROM bookingTABLE WHERE booker_id = '" + bookerID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_address");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBookerAge_ByBookerID(String bookerID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_age FROM bookingTABLE WHERE booker_id = '" + bookerID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_age");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBookerEmail_ByBookerID(String bookerID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_email FROM bookingTABLE WHERE booker_id = '" + bookerID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_email");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBookerPhoneNumber_ByBookerID(String bookerID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_phone_number FROM bookingTABLE WHERE booker_id = '" + bookerID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_phone_number");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBookerStatus_ByBookerID(String bookerID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_status FROM bookingTABLE WHERE booker_id = '" + bookerID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_status");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBookerCarName_ByBookerID(String bookerID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_car_name FROM bookingTABLE WHERE booker_id = '" + bookerID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_car_name");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBookerCarPrice_ByBookerID(String bookerID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_car_price FROM bookingTABLE WHERE booker_id = '" + bookerID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_car_price");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBookerTripDateFrom_ByBookerID(String bookerID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_trip_date_from FROM bookingTABLE WHERE booker_id = '" + bookerID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_trip_date_from");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBookerTripDateTo_ByBookerID(String bookerID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_trip_date_to FROM bookingTABLE WHERE booker_id = '" + bookerID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_trip_date_to");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBookerTripAddress_ByBookerID(String bookerID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_trip_address FROM bookingTABLE WHERE booker_id = '" + bookerID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_trip_address");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBookerPaymentMethod_ByBookerID(String bookerID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_payment_method FROM bookingTABLE WHERE booker_id = '" + bookerID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_payment_method");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBookerGCashNumber_ByBookerID(String bookerID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_g_cash_number FROM bookingTABLE WHERE booker_id = '" + bookerID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_g_cash_number");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBookerTotalAmount_ByBookerID(String bookerID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_amount FROM bookingTABLE WHERE booker_id = '" + bookerID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_amount");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBookerCompanyID_ByBookerID(String bookerID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_company_id FROM bookingTABLE WHERE booker_id = '" + bookerID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_company_id");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBookerCompanyName_ByBookerID(String bookerID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_company_name FROM bookingTABLE WHERE booker_id = '" + bookerID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_company_name");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBookerCompanyAddress_ByBookerID(String bookerID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_company_address FROM bookingTABLE WHERE booker_id = '" + bookerID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_company_address");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBookerCarID_ByBookerID(String bookerID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_car_id FROM bookingTABLE WHERE booker_id = '" + bookerID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_car_id");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBookerDateBooked_ByBookerID(String bookerID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_date FROM bookingTABLE WHERE booker_id = '" + bookerID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_date");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBookerDateApproved_ByBookerID(String bookerID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_date_approved FROM bookingTABLE WHERE booker_id = '" + bookerID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_date_approved");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBookerRemarks_ByBookerID(String bookerID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_remarks FROM bookingTABLE WHERE booker_id = '" + bookerID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_remarks");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBookerDaysRented_ByBookerID(String bookerID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_days_rented FROM bookingTABLE WHERE booker_id = '" + bookerID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_days_rented");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBookerCarPicked_ByBookerID(String bookerID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_car_PICKED FROM bookingTABLE WHERE booker_id = '" + bookerID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_car_PICKED");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBookerDatePicked_ByBookerID(String bookerID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_date_PICKED FROM bookingTABLE WHERE booker_id = '" + bookerID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_date_PICKED");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    //End of Getting History Data

    public Cursor readAllDataForOngoingTransactions(String companyID){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;

        if (db != null){
            cursor = db.rawQuery("SELECT * FROM transaction_table WHERE transaction_company_id = '" + companyID + "'", null);
        }

        return cursor;
    }

    //get Transaction Data

    public StringBuilder getTransactionName_ByTransactionID(String transactionID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT transaction_booker_name FROM transaction_table WHERE transaction_id = '" + transactionID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("transaction_booker_name");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getTransactionCarName_ByTransactionID(String transactionID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT transaction_car_model FROM transaction_table WHERE transaction_id = '" + transactionID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("transaction_car_model");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getTransactionTripDate_ByTransactionID(String transactionID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT transaction_trip_date FROM transaction_table WHERE transaction_id = '" + transactionID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("transaction_trip_date");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getTransactionTripRoutes_ByTransactionID(String transactionID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT transaction_trip_routes FROM transaction_table WHERE transaction_id = '" + transactionID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("transaction_trip_routes");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getTransactionDatePickedUp_ByTransactionID(String transactionID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT transaction_date_pickup FROM transaction_table WHERE transaction_id = '" + transactionID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("transaction_date_pickup");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getTransactionReturnStatus_ByTransactionID(String transactionID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT transaction_return_status FROM transaction_table WHERE transaction_id = '" + transactionID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("transaction_return_status");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getTransactionCompanyOwner_ByTransactionID(String transactionID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT transaction_company_owner FROM transaction_table WHERE transaction_id = '" + transactionID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("transaction_company_owner");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getTransactionCompanyID_ByTransactionID(String transactionID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT transaction_company_id FROM transaction_table WHERE transaction_id = '" + transactionID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("transaction_company_id");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getTransactionBookerID_ByTransactionID(String transactionID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT transaction_booker_id FROM transaction_table WHERE transaction_id = '" + transactionID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("transaction_booker_id");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getTransactionBookingID_ByTransactionID(String transactionID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT transaction_booking_id FROM transaction_table WHERE transaction_id = '" + transactionID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("transaction_booking_id");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    //For BusinessOwner
    boolean rentedExpire(String transactionID,
                         String rentedStatus){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(OUTGOING_TRANSACTION_RETURN_STATUS, rentedStatus);

        db.update(OUTGOING_TRANSACTION_TABLE,  cv, "transaction_id=?", new String[]{transactionID});
        return true;
    }

    boolean rentedCarPicked(String booking_ID,
                            String rentedStatus){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(BOOKING_CAR_PICKED, rentedStatus);

        db.update(BOOKING_TABLE,  cv, "booking_id=?", new String[]{booking_ID});
        return true;
    }



    /*Deleting Booking*/

    public boolean deleteBooking(String bookingID){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM bookingTABLE WHERE booking_id = '" + bookingID + "'", null);
        if (cursor.getCount() > 0){
            long result = db.delete(BOOKING_TABLE, "booking_id=?", new String[]{bookingID});
            if (result == -1){
                return false;
            }else{
                return true;
            }
        }else{
            return false;
        }

    }

    public boolean deleteTransaction(String transactionID){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM transaction_table WHERE transaction_id = '" + transactionID + "'", null);
        if (cursor.getCount() > 0){
            long result = db.delete(OUTGOING_TRANSACTION_TABLE, "transaction_id=?", new String[]{transactionID});
            if (result == -1){
                return false;
            }else{
                return true;
            }
        }else{
            return false;
        }

    }

    public StringBuilder getTransactionNumber_ByBookerID(String transactionID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT transaction_id FROM transaction_table WHERE transaction_booker_id = '" + transactionID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("transaction_id");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getForgotPassword_clientEmail(String clientEmail){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT client_email FROM clientTable WHERE client_email = '" + clientEmail + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("client_email");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getForgotPassword_clientID(String clientEmail){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT client_id FROM clientTable WHERE client_email = '" + clientEmail + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("client_id");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    boolean forgotPassword_ChangeClientPassword(String clientID,
                                                String clientPassword){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(CLIENT_PASSWORD, clientPassword);

        db.update(CLIENT_TABLE_NAME,  cv, "client_id=?", new String[]{clientID});
        return true;
    }

    public boolean checkClient_Routes(String phoneNumber, String passwords){
        SQLiteDatabase myDB = this.getWritableDatabase();
        String [] columns = {CLIENT_PHONE_NUMBER};
        String selection = CLIENT_PHONE_NUMBER + "=?" + " and " + CLIENT_PASSWORD + "=?";
        String [] selectionargs = {phoneNumber, passwords};
        Cursor cursor = myDB.query(CLIENT_TABLE_NAME, columns, selection, selectionargs, null, null,  null);
        int count =cursor.getCount();

        if (count > 0){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean checkOwner_Routes(String phoneNumber, String passwords){
        SQLiteDatabase myDB = this.getWritableDatabase();
        String [] columns = {BUSINESS_USERNAME};
        String selection = BUSINESS_USERNAME + "=?" + " and " + BUSINESS_PASSWORD + "=?";
        String [] selectionargs = {phoneNumber, passwords};
        Cursor cursor = myDB.query(BUSINESS_OWNER_TABLE, columns, selection, selectionargs, null, null,  null);
        int count =cursor.getCount();

        if (count > 0){
            return true;
        }
        else{
            return false;
        }
    }


    public StringBuilder getCompany_Email(String businessOwnerID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT businessOwnerEmail FROM businessOwnerTable WHERE businessOwnerID = '" + businessOwnerID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("businessOwnerEmail");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getCompany_PhoneNumber(String businessOwnerID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT businessOwnerPhoneNumber FROM businessOwnerTable WHERE businessOwnerID = '" + businessOwnerID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("businessOwnerPhoneNumber");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getCompany_DTI_Number(String businessOwnerID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT businessOwnerDTInumber FROM businessOwnerTable WHERE businessOwnerID = '" + businessOwnerID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("businessOwnerDTInumber");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getCompany_MayorPermit_Number(String businessOwnerID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT businessOwnerMayorsPermit FROM businessOwnerTable WHERE businessOwnerID = '" + businessOwnerID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("businessOwnerMayorsPermit");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getCompany_BIRPermit_Number(String businessOwnerID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT businessOwnerBIRNumber FROM businessOwnerTable WHERE businessOwnerID = '" + businessOwnerID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("businessOwnerBIRNumber");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getCompany_PhilGeps_Number(String businessOwnerID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT businessOwnerPhilGepsNumber FROM businessOwnerTable WHERE businessOwnerID = '" + businessOwnerID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("businessOwnerPhilGepsNumber");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }



    public StringBuilder getCar_GasType(String carID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT car_gas_type FROM cars_table WHERE car_id = '" + carID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("car_gas_type");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getCar_PlateNumber(String carID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT car_plate_number FROM cars_table WHERE car_id = '" + carID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("car_plate_number");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getCar_Availability(String carID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT car_availability FROM cars_table WHERE car_id = '" + carID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("car_availability");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    boolean carAvailability(String carID,
                            String status){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(CAR_AVAILABILITY, status);

        db.update(CAR_TABLE,  cv, "car_id=?", new String[]{carID});
        return true;
    }

    public StringBuilder getClientPhoneNumber_byBookerID(String clientID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT client_phone_number FROM clientTable WHERE client_id = '" + clientID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("client_phone_number");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public boolean checkClientID(String clientID){
        SQLiteDatabase myDB = this.getWritableDatabase();
        String [] columns = {CLIENT_ID};
        String selection = CLIENT_ID + "=?";
        String [] selectionargs = {clientID};
        Cursor cursor = myDB.query(CLIENT_TABLE_NAME, columns, selection, selectionargs, null, null,  null);
        int count =cursor.getCount();

        if (count > 0){
            return true;
        }
        else{
            return false;
        }
    }
    public int getAllBusinessPendingBooking(String companyID){
        SQLiteDatabase db = this.getReadableDatabase();
        int numberOfCar;


        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery("SELECT booking_status, booking_company_id FROM bookingTABLE WHERE booking_company_id = '" + companyID + "' AND booking_status = 'Pending'", null);

        }
        numberOfCar = cursor.getCount();

        return numberOfCar;

    }

    public int getAllBusinessOngoingTransaction(String companyID){
        SQLiteDatabase db = this.getReadableDatabase();
        int numberOfCar;


        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery("SELECT * FROM transaction_table WHERE transaction_company_id = '" + companyID + "'", null);

        }
        numberOfCar = cursor.getCount();

        return numberOfCar;

    }

    public StringBuilder getDriverFirstName(String carID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT driver_name FROM cars_table WHERE car_id = '" + carID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("driver_name");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getDriverAddress(String carID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT driver_address FROM cars_table WHERE car_id = '" + carID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("driver_address");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getDriverContacts(String carID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT driver_contact FROM cars_table WHERE car_id = '" + carID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("driver_contact");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getDriverlicense(String carID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT driver_license FROM cars_table WHERE car_id = '" + carID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("driver_license");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public Cursor filterCars(String carType){
        String query = "SELECT * FROM cars_table WHERE car_type = '" + carType + "'";
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;

    }

    public boolean addCarRatings(String carID, int addingCount, int carScore){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(CAR_BOOKED_COUNT, addingCount);
        cv.put(CAR_RATING_SCORE, carScore);

        db.update(CAR_TABLE,  cv, "car_id=?", new String[]{carID});
        return true;
    }

    @SuppressLint("Range")
    public int getCarCountBooked(String carID){
        SQLiteDatabase db = this.getWritableDatabase();
        int rv = 1;
        Cursor cursor = db.rawQuery("SELECT car_booked_count FROM cars_table WHERE car_id = '" + carID + "'", null);

        if (cursor.moveToFirst()){
            rv = cursor.getInt(cursor.getColumnIndex("car_booked_count"));
        }
        cursor.close();
        return rv;

    }

    @SuppressLint("Range")
    public int getCarBookedScore(String carID){
        SQLiteDatabase db = this.getWritableDatabase();
        int rv = 1;
        Cursor cursor = db.rawQuery("SELECT car_rating_score FROM cars_table WHERE car_id = '" + carID + "'", null);

        if (cursor.moveToFirst()){
            rv = cursor.getInt(cursor.getColumnIndex("car_rating_score"));
        }
        cursor.close();
        return rv;

    }

    @SuppressLint("Range")
    public byte[] getImageCar(String carId){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT car_photo FROM cars_table WHERE car_id = '" + carId + "'", null);
        if (cursor.moveToFirst()){
            return cursor.getBlob(cursor.getColumnIndex("car_photo"));
        }
        return null;
    }

    boolean makeCarNotAvailable(String carID,
                                String car_availability){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(CAR_AVAILABILITY, car_availability);

        db.update(CAR_TABLE,  cv, "car_id=?", new String[]{carID});
        return true;

    }

    boolean makeCarAvailable(String carID,
                             String car_availability){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(CAR_AVAILABILITY, car_availability);

        db.update(CAR_TABLE,  cv, "car_id=?", new String[]{carID});
        return true;

    }

    public StringBuilder checkCarAvailablity(String carID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT car_availability FROM cars_table WHERE car_id = '" + carID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("car_availability");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBusinessOwnerNameByCompanyID(String companyID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT businessOwnerName FROM businessOwnerTable WHERE businessOwnerID = '" + companyID + "'", null);
        String firstNameValue;

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("businessOwnerName");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public void storeBusinessOwnerLogo(String companyID, GetterAndSetterForBusinessOwnerLogo objectModelClass){
        try{

            SQLiteDatabase myDB = this.getWritableDatabase();
            Bitmap imageToStoreBitmap = objectModelClass.getImage();

            objectByteArrayOutputStream = new ByteArrayOutputStream();
            imageToStoreBitmap.compress(Bitmap.CompressFormat.PNG, 100, objectByteArrayOutputStream);

            imageInByte = objectByteArrayOutputStream.toByteArray();
            ContentValues cv = new ContentValues();
            cv.put(BUSINESS_LOGO, imageInByte);

            long addBusinessLogo = myDB.update("businessOwnerTable", cv, "businessOwnerID=?", new String[]{companyID});

            if (addBusinessLogo != 0 ){
                Toast.makeText(context, "Business Logo Added Successfully", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(context, "Business Logo Added Failed", Toast.LENGTH_SHORT).show();
            }



        }catch (Exception e){
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }


    public StringBuilder getBusinessName_byCompanyID(String companyID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT businessOwnerName FROM businessOwnerTable WHERE businessOwnerID = '" + companyID + "'", null);
        String firstNameValue;

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("businessOwnerName");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBusinessContact_byCompanyID(String companyID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT businessOwnerPhoneNumber FROM businessOwnerTable WHERE businessOwnerID = '" + companyID + "'", null);
        String firstNameValue;

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("businessOwnerPhoneNumber");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBusinessAddress_byCompanyID(String companyID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT businessOwnerAddress FROM businessOwnerTable WHERE businessOwnerID = '" + companyID + "'", null);
        String firstNameValue;

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("businessOwnerAddress");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBusinessEmail_byCompanyID(String companyID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT businessOwnerEmail FROM businessOwnerTable WHERE businessOwnerID = '" + companyID + "'", null);
        String firstNameValue;

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("businessOwnerEmail");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBusinessDTI_byCompanyID(String companyID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT businessOwnerDTInumber FROM businessOwnerTable WHERE businessOwnerID = '" + companyID + "'", null);
        String firstNameValue;

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("businessOwnerDTInumber");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBusinessMayorPermit_byCompanyID(String companyID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT businessOwnerMayorsPermit FROM businessOwnerTable WHERE businessOwnerID = '" + companyID + "'", null);
        String firstNameValue;

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("businessOwnerMayorsPermit");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBusinessBIRPermit_byCompanyID(String companyID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT businessOwnerBIRNumber FROM businessOwnerTable WHERE businessOwnerID = '" + companyID + "'", null);
        String firstNameValue;

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("businessOwnerBIRNumber");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getBusinessPhilGeps_byCompanyID(String companyID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT businessOwnerPhilGepsNumber FROM businessOwnerTable WHERE businessOwnerID = '" + companyID + "'", null);
        String firstNameValue;

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("businessOwnerPhilGepsNumber");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    boolean updateBusinessProfile(String companyID,
                                  String businessName,
                                  String contact,
                                  String address,
                                  String email,
                                  String dtiNo,
                                  String mayorPermit,
                                  String birPermit,
                                  String philGepsPermit){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(BUSINESS_NAME, businessName);
        cv.put(BUSINESS_PHONE_NUMBER, contact);
        cv.put(BUSINESS_ADDRESS, address);
        cv.put(BUSINESS_EMAIL, email);
        cv.put(BUSINESS_DTI_NUMBER, dtiNo);
        cv.put(BUSINESS_MAYOR_PERMIT_NUMBER, mayorPermit);
        cv.put(BUSINESS_BIR_NUMBER, birPermit);
        cv.put(BUSINESS_PHILGEPS_NUMBER, philGepsPermit);


        db.update(BUSINESS_OWNER_TABLE,  cv, "businessOwnerID=?", new String[]{companyID});
        return true;

    }

    @SuppressLint("Range")
    public byte[] getCompanyLogo(String companyID){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT business_logo FROM businessOwnerTable WHERE businessOwnerID = '" + companyID + "'", null);
        if (cursor.moveToFirst()){
            return cursor.getBlob(cursor.getColumnIndex("business_logo"));
        }
        return null;
    }

    @SuppressLint("Range")
    public byte[] getProfilePic(String clientID){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT client_photo FROM clientTable WHERE client_id = '" + clientID + "'", null);
        if (cursor.moveToFirst()){
            return cursor.getBlob(cursor.getColumnIndex("client_photo"));
        }
        return null;
    }

    public void storeProfile(String clientID, GetterAndSetterProfileImage objectModelClass){
        try{

            SQLiteDatabase myDB = this.getWritableDatabase();
            Bitmap imageToStoreBitmap = objectModelClass.getImage();

            objectByteArrayOutputStream = new ByteArrayOutputStream();
            imageToStoreBitmap.compress(Bitmap.CompressFormat.PNG, 100, objectByteArrayOutputStream);

            imageInByte = objectByteArrayOutputStream.toByteArray();
            ContentValues cv = new ContentValues();
            cv.put(CLIENT_PHOTO, imageInByte);

            long addBusinessLogo = myDB.update("clientTable", cv, "client_id=?", new String[]{clientID});

            if (addBusinessLogo != 0 ){
                Toast.makeText(context, "Profile Picture Added Successfully", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(context, "Profile Picture Added Failed", Toast.LENGTH_SHORT).show();
            }



        }catch (Exception e){
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    boolean UpdatePolicies(String businessOwnerID,
                           String business_policies){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(BUSINESS_POLICIES, business_policies);

        db.update(BUSINESS_OWNER_TABLE,  cv, "businessOwnerID=?", new String[]{businessOwnerID});
        return true;
    }

    public StringBuilder getCompanyPolicies(String companyID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT business_policies FROM businessOwnerTable WHERE businessOwnerID = '" + companyID + "'", null);
        String firstNameValue;

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("business_policies");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder gotDriver(String carID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT gotDriver FROM cars_table WHERE car_id = '" + carID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("gotDriver");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder getCarID(String bookerID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT booking_car_id FROM bookingTABLE WHERE booker_id = '" + bookerID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("booking_car_id");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public boolean deleteBookingByCancellation(String bookerID){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM bookingTABLE WHERE booker_id = '" + bookerID + "'", null);
        if (cursor.getCount() > 0){
            long result = db.delete(BOOKING_TABLE, "booker_id=?", new String[]{bookerID});
            if (result == -1){
                return false;
            }else{
                return true;
            }
        }else{
            return false;
        }

    }

    public StringBuilder reportBusinessOwnerAddress(String companyID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT businessOwnerAddress FROM businessOwnerTable WHERE businessOwnerID = '" + companyID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("businessOwnerAddress");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public int myCompanyBookingCount(String companyID){
        SQLiteDatabase db = this.getReadableDatabase();
        int numberOfCar;


        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery("SELECT * FROM history_Table WHERE history_booking_company_id = '" + companyID + "'", null);

        }
        numberOfCar = cursor.getCount();

        return numberOfCar;

    }

    public int myCompanyTotalCarCount(String companyID){
        SQLiteDatabase db = this.getReadableDatabase();
        int numberOfCar;


        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery("SELECT * FROM cars_table WHERE company_id = '" + companyID + "'", null);

        }
        numberOfCar = cursor.getCount();

        return numberOfCar;

    }

    public Cursor readAllDataForReports(String companyID){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;

        if (db != null){
            cursor = db.rawQuery("SELECT * FROM history_Table WHERE history_booking_company_id = '" + companyID + "'", null);
        }

        return cursor;
    }

    public StringBuilder reportsBookingFullName(String bookingID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT history_booking_full_name FROM history_Table WHERE history_booking_id = '" + bookingID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("history_booking_full_name");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder reportsBookingAddress(String bookingID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT history_booking_address FROM history_Table WHERE history_booking_id = '" + bookingID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("history_booking_address");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder reportsBookingAge(String bookingID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT history_booking_age FROM history_Table WHERE history_booking_id = '" + bookingID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("history_booking_age");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder reportsBookingEmail(String bookingID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT history_booking_email FROM history_Table WHERE history_booking_id = '" + bookingID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("history_booking_email");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder reportsBookingPhoneNumber(String bookingID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT history_booking_phone_number FROM history_Table WHERE history_booking_id = '" + bookingID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("history_booking_phone_number");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder reportsBookingCarModelName(String bookingID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT history_booking_car_name FROM history_Table WHERE history_booking_id = '" + bookingID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("history_booking_car_name");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder reportsBookingPaymentMethod(String bookingID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT history_booking_payment_method FROM history_Table WHERE history_booking_id = '" + bookingID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("history_booking_payment_method");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }

    public StringBuilder reportsBookingDateBooked(String bookingID){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT history_booking_date FROM history_Table WHERE history_booking_id = '" + bookingID + "'", null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            int nameField = cursor.getColumnIndex("history_booking_date");
            stringBuilder.append(cursor.getString(nameField));
        }
        return stringBuilder;
    }










}



