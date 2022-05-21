package com.example.cafinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class CarRatingPage extends AppCompatActivity {

    MyDatabaseHelper myDB = new MyDatabaseHelper(CarRatingPage.this);
    String carId, bookerID, comment, firstName, lastName, carName, fullname;
    EditText commentEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.car_rating_page);


        Spinner spinnerRating = findViewById(R.id.spinnerRating);

        Bundle intent = getIntent().getExtras();

        carId  = intent.getString("carId");
        bookerID  = intent.getString("clientID");

        ArrayAdapter<CharSequence> adapter_spinnerRating =  ArrayAdapter.createFromResource(this, R.array.rating, android.R.layout.simple_spinner_item);
        adapter_spinnerRating.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRating.setAdapter(adapter_spinnerRating);


        firstName = myDB.getClientFirstName(bookerID).toString();
        lastName = myDB.getClientFirstName(bookerID).toString();
        carName = myDB.getClientFirstName(carId).toString();

        commentEditText = findViewById(R.id.commentEditText);
        comment = commentEditText.getText().toString();



        Button submitRateButton = findViewById(R.id.submitRateButton);
        submitRateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int myRating = Integer.parseInt(spinnerRating.getSelectedItem().toString());

                firstName = myDB.getClientFirstName(bookerID).toString();
                lastName = myDB.getClientFirstName(bookerID).toString();
                carName = myDB.getClientFirstName(carId).toString();
                fullname = firstName + " " + lastName;

                commentEditText = findViewById(R.id.commentEditText);
                comment = commentEditText.getText().toString();

                carId  = intent.getString("carId");
                bookerID  = intent.getString("clientID");
                int carCount = myDB.getCarCountBooked(carId) + 1;
                int carScore = myDB.getCarBookedScore(carId) + myRating;

                boolean updateRating = myDB.addCarRatings(carId, carCount, carScore);
                boolean addingComments = myDB.addComment(bookerID, carId, carName, fullname, comment);
                if (updateRating == true || addingComments == true){
                    openClientDashboard();
                }
                else{
                    Toast.makeText(CarRatingPage.this, "Unable to Update Rating", Toast.LENGTH_SHORT).show();
                }
            }
        });




    }

    public void openClientDashboard(){
        Intent intent = new Intent(this, ClientDashboard.class);
        intent.putExtra("clientID", bookerID);
        startActivity(intent);
    }
}