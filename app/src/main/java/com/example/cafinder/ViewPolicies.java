package com.example.cafinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ViewPolicies extends AppCompatActivity {

    MyDatabaseHelper myDB = new MyDatabaseHelper(ViewPolicies.this);

    EditText rental_policies_input;

    Button addOrEditPolicies_button;

    String companyID, companyPolicies, getCompanyPolicies_input;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_policies);

        Bundle intent = getIntent().getExtras();





        rental_policies_input = findViewById(R.id.rental_policies_input);

        addOrEditPolicies_button = findViewById(R.id.addOrEditPolicies_button);




        companyID = intent.getString("companyID");
        addOrEditPolicies_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                companyPolicies = rental_policies_input.getText().toString();
                boolean updateTrue = myDB.UpdatePolicies(companyID, companyPolicies);
                if (updateTrue == true){
                    Toast.makeText(ViewPolicies.this, "Update Policies Completed", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(ViewPolicies.this, "Update Policies Failed", Toast.LENGTH_SHORT).show();

                }
            }
        });

        getCompanyPolicies_input = myDB.getCompanyPolicies(companyID).toString();

        rental_policies_input.setText(getCompanyPolicies_input);










    }
}