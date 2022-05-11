package com.example.cafinder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class WithoutDriverTermsAndAgreement extends AppCompatActivity {

    MyDatabaseHelper myDB = new MyDatabaseHelper(WithoutDriverTermsAndAgreement.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.without_driver_terms_and_agreement);
        CheckBox checkBox = findViewById(R.id.checkBox);

        TextView termsAndAgreement_Text = findViewById(R.id.termsAndAgreement_Text);



        Bundle intent = getIntent().getExtras();
        String companyID = intent.getString("companyID");

        String getCompany_Policies = myDB.getCompanyPolicies(companyID).toString();
        termsAndAgreement_Text.setText("\n\nTerms And Agreements \n\n" + getCompany_Policies);





        Button driverAgreement_backButton = findViewById(R.id.driverAgreement_backButton);

        if (checkBox.isChecked()){
            driverAgreement_backButton.setEnabled(true);
        }

        driverAgreement_backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}