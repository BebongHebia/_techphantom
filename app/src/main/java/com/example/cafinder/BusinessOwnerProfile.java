package com.example.cafinder;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BusinessOwnerProfile extends AppCompatActivity {

    MyDatabaseHelper myDB = new MyDatabaseHelper(BusinessOwnerProfile.this);


    TextView businessOwnerProfile_BusinessName_TV;
    ImageView businessLogo_IV;

    EditText businessOwnerProfile_BusinessName_ET,
    businessOwnerProfile_Contact_ET,
    businessOwnerProfile_Address_ET,
    businessOwnerProfile_Email_ET,
    businessOwnerProfile_DTINo_ET,
    businessOwnerProfile_MayorPermitNo_ET,
    businessOwnerProfile_BIRPermitNo_ET,
    businessOwnerProfile_PhilGepsPermitNo_ET3;

    String businessOwnerProfile_BusinessName_ET_Str,
    businessOwnerProfile_Contact_ET_Str,
    businessOwnerProfile_Address_ET_Str,
    businessOwnerProfile_Email_ET_Str,
    businessOwnerProfile_DTINo_ET_Str,
    businessOwnerProfile_MayorPermitNo_ET_Str,
    businessOwnerProfile_BIRPermitNo_ET_Str,
    businessOwnerProfile_PhilGepsPermitNo_ET3_Str;

    private Uri imageFilePath;
    private Bitmap imageToStore;

    public static final int PICK_IMAGE_REQUEST = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.business_owner_profile);
        Bundle extras = getIntent().getExtras();
        String companyID = extras.getString("businessOwnerID");


        String businessOwnerName = myDB.getBusinessOwnerNameByCompanyID(companyID).toString();

        Toast.makeText(this, businessOwnerName, Toast.LENGTH_SHORT).show();

        businessOwnerProfile_BusinessName_TV = findViewById(R.id.businessOwnerProfile_BusinessName_TV);
        businessOwnerProfile_BusinessName_TV.setText(businessOwnerName);

        businessLogo_IV = findViewById(R.id.businessLogo_IV);


        businessOwnerProfile_BusinessName_ET = findViewById(R.id.businessOwnerProfile_BusinessName_ET);
        businessOwnerProfile_Contact_ET = findViewById(R.id.businessOwnerProfile_Contact_ET);
        businessOwnerProfile_Address_ET = findViewById(R.id.businessOwnerProfile_Address_ET);
        businessOwnerProfile_Email_ET = findViewById(R.id.businessOwnerProfile_Email_ET);
        businessOwnerProfile_DTINo_ET = findViewById(R.id.businessOwnerProfile_DTINo_ET);
        businessOwnerProfile_MayorPermitNo_ET = findViewById(R.id.businessOwnerProfile_MayorPermitNo_ET);
        businessOwnerProfile_BIRPermitNo_ET = findViewById(R.id.businessOwnerProfile_BIRPermitNo_ET);
        businessOwnerProfile_PhilGepsPermitNo_ET3 = findViewById(R.id.businessOwnerProfile_PhilGepsPermitNo_ET3);


        businessOwnerProfile_BusinessName_ET_Str = myDB.getBusinessName_byCompanyID(companyID).toString();
        businessOwnerProfile_Contact_ET_Str = myDB.getBusinessContact_byCompanyID(companyID).toString();
        businessOwnerProfile_Address_ET_Str = myDB.getBusinessAddress_byCompanyID(companyID).toString();
        businessOwnerProfile_Email_ET_Str = myDB.getBusinessEmail_byCompanyID(companyID).toString();
        businessOwnerProfile_DTINo_ET_Str = myDB.getBusinessDTI_byCompanyID(companyID).toString();
        businessOwnerProfile_MayorPermitNo_ET_Str = myDB.getBusinessMayorPermit_byCompanyID(companyID).toString();
        businessOwnerProfile_BIRPermitNo_ET_Str = myDB.getBusinessBIRPermit_byCompanyID(companyID).toString();
        businessOwnerProfile_PhilGepsPermitNo_ET3_Str = myDB.getBusinessPhilGeps_byCompanyID(companyID).toString();

        businessOwnerProfile_BusinessName_ET.setText(businessOwnerProfile_BusinessName_ET_Str);
        businessOwnerProfile_Contact_ET.setText(businessOwnerProfile_Contact_ET_Str);
        businessOwnerProfile_Address_ET.setText(businessOwnerProfile_Address_ET_Str);
        businessOwnerProfile_Email_ET.setText(businessOwnerProfile_Email_ET_Str);
        businessOwnerProfile_DTINo_ET.setText(businessOwnerProfile_DTINo_ET_Str);
        businessOwnerProfile_MayorPermitNo_ET.setText(businessOwnerProfile_MayorPermitNo_ET_Str);
        businessOwnerProfile_BIRPermitNo_ET.setText(businessOwnerProfile_BIRPermitNo_ET_Str);
        businessOwnerProfile_PhilGepsPermitNo_ET3.setText(businessOwnerProfile_PhilGepsPermitNo_ET3_Str);

        Button updateBusinessProfileButton = findViewById(R.id.updateBusinessProfileButton);

        updateBusinessProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateProfile();
            }
        });



    }

    public void chooseImage(View view){
        try{
            Intent objectIntent = new Intent();
            objectIntent.setType("image/*");
            objectIntent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(objectIntent, PICK_IMAGE_REQUEST);


        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        try{
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data !=null && data.getData() !=null){
                imageFilePath = data.getData();
                imageToStore = MediaStore.Images.Media.getBitmap(getContentResolver(), imageFilePath);
                businessLogo_IV.setImageBitmap(imageToStore);
            }
        }
        catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void updateProfile(){
        try{
            Bundle extras = getIntent().getExtras();
            String companyID = extras.getString("businessOwnerID");
            boolean updateBusinessProfile = myDB.updateBusinessProfile(companyID, businessOwnerProfile_BusinessName_ET_Str, businessOwnerProfile_Contact_ET_Str,
                    businessOwnerProfile_Address_ET_Str, businessOwnerProfile_Email_ET_Str, businessOwnerProfile_DTINo_ET_Str, businessOwnerProfile_MayorPermitNo_ET_Str,
                    businessOwnerProfile_BIRPermitNo_ET_Str, businessOwnerProfile_PhilGepsPermitNo_ET3_Str);

            if (updateBusinessProfile == true){
                myDB.storeBusinessOwnerLogo(companyID, new GetterAndSetterForBusinessOwnerLogo(imageToStore));
            }
        }
        catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

}