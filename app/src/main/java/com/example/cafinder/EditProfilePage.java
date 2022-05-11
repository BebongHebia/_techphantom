package com.example.cafinder;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class EditProfilePage extends AppCompatActivity {

    public static final String EXTRA_TEXT_PHONE_NUMBER = "com.example.cedula.example.EXTRA_PHONE_NUMBER";
    String passedPhoneNumber, passedIDNumber, getPhoneNumberValueFromClientDashboard;
    ImageView editProfile_profileLogo;

    TextView editPage_fullname_textView;
    MyDatabaseHelper myDB = new MyDatabaseHelper(EditProfilePage.this);
    EditText editPage_EditFirstName_EditText, editPage_EditLastName_EditText, editPage_EditEmail_EditText, editPage_EditMobileNumber_EditText;
    String editPage_EditFirstName_String, editPage_EditLastName_String, editPage_EditEmail_String, editPage_EditMobileNumber_String;

    private static final int PICK_IMAGE_REQUEST = 100;

    private Uri imageFilePath;
    private Bitmap imageToStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_profile_page);

        Bundle intent = getIntent().getExtras();


        getPhoneNumberValueFromClientDashboard = intent.getString("clientID");
        editPage_fullname_textView = findViewById(R.id.editPage_fullname_textView);

        editPage_fullname_textView.setText(myDB.getClientFirstName(getPhoneNumberValueFromClientDashboard) + " " + myDB.getClientLastName(getPhoneNumberValueFromClientDashboard));

        editPage_EditFirstName_EditText = findViewById(R.id.editPage_EditFirstName_EditText);
        editPage_EditLastName_EditText = findViewById(R.id.editPage_EditLastName_EditText);
        editPage_EditEmail_EditText = findViewById(R.id.editPage_EditEmail_EditText);
        editPage_EditMobileNumber_EditText = findViewById(R.id.editPage_EditMobileNumber_EditText);

        editPage_EditFirstName_EditText.setText(myDB.getClientFirstName(getPhoneNumberValueFromClientDashboard));
        editPage_EditLastName_EditText.setText(myDB.getClientLastName(getPhoneNumberValueFromClientDashboard));
        editPage_EditEmail_EditText.setText(myDB.getClientEmail(getPhoneNumberValueFromClientDashboard));
        editPage_EditMobileNumber_EditText.setText(myDB.getClientPhoneNumber(getPhoneNumberValueFromClientDashboard));



        Button editPage_saveChanges_Button  = findViewById(R.id.viewCarDetails_ProceedButton);

        editPage_saveChanges_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editPage_EditFirstName_String = editPage_EditFirstName_EditText.getText().toString();
                editPage_EditLastName_String = editPage_EditLastName_EditText.getText().toString();
                editPage_EditEmail_String = editPage_EditEmail_EditText.getText().toString();
                editPage_EditMobileNumber_String = editPage_EditMobileNumber_EditText.getText().toString();

               boolean updating = myDB.UpdateClientProfile(passedPhoneNumber, editPage_EditFirstName_String, editPage_EditLastName_String, editPage_EditEmail_String, editPage_EditMobileNumber_String);
               if (updating == true){
                   myDB.storeProfile(getPhoneNumberValueFromClientDashboard, new GetterAndSetterProfileImage(imageToStore));
                   finish();
               }else{
                   openUpdatingFail();
               }
            }
        });

        Button editPage_EditPassword_Button = findViewById(R.id.editPage_EditPassword_Button);
        editPage_EditPassword_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openChangePassword();

            }
        });

        editProfile_profileLogo = findViewById(R.id.editProfile_profileLogo);

        byte[] getPic = myDB.getProfilePic(getPhoneNumberValueFromClientDashboard);
        if (getPic != null){
            Bitmap bitmaps = convertByteArrayToBitmap(getPic);
            editProfile_profileLogo.setImageBitmap(bitmaps);
        }


    }

    public Bitmap convertByteArrayToBitmap(byte[] bytes){
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }

    public void openUpdatingFail(){
        Intent intent = new Intent(this, UpdatingProfileError.class);
        intent.putExtra(EXTRA_TEXT_PHONE_NUMBER, passedPhoneNumber);
        startActivity(intent);
    }
    public void openChangePassword(){
        Intent intent = new Intent(this, UpdatingPassword.class);
        intent.putExtra(EXTRA_TEXT_PHONE_NUMBER, passedPhoneNumber);
        startActivity(intent);
    }

    public void chooseProfile(View view){
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
                editProfile_profileLogo.setImageBitmap(imageToStore);
            }
        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}