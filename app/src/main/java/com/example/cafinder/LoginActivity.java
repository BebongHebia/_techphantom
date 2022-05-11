package com.example.cafinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cafinder.ui.gallery.GalleryFragment;

public class LoginActivity extends AppCompatActivity {
    public static final String EXTRA_TEXT_PHONE_NUMBER = "com.example.cedula.example.EXTRA_PHONE_NUMBER";
    public static final String EXTRA_TEXT_ID_NUMBER = "com.example.cedula.example.EXTRA_ID_NUMBER";

    MyDatabaseHelper myDB = new MyDatabaseHelper(LoginActivity.this);
    GetterAndStoreHelper helper = new GetterAndStoreHelper();
    String clientIDNumber;

    EditText loginEmailOrPhoneNumberET;
    String trypass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);



        String loginText1 = "Forgot Password? Click Here";
        String loginText2 = "Don't have an Account?: Click Here";

        TextView loginForgotPasswordTextView = findViewById(R.id.loginForgotPasswordTextView);
        TextView loginClickToCreateAccountTextView = findViewById(R.id.loginClickToCreateAccountTextView);

        SpannableString ssLoginText1 = new SpannableString(loginText1);
        SpannableString ssLoginText2 = new SpannableString(loginText2);

        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                openForgotpassword();
            }
        };

        ClickableSpan clickableSpan2 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                openSignupOption();
            }
        };

        ssLoginText1.setSpan(clickableSpan1, 17, 27, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        loginForgotPasswordTextView.setText(ssLoginText1);
        loginForgotPasswordTextView.setMovementMethod(LinkMovementMethod.getInstance());

        ssLoginText2.setSpan(clickableSpan2, 24, 34, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        loginClickToCreateAccountTextView.setText(ssLoginText2);
        loginClickToCreateAccountTextView.setMovementMethod(LinkMovementMethod.getInstance());

        Button login_button = findViewById(R.id.login_button);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginEmailOrPhoneNumberET = findViewById(R.id.loginEmailOrPhoneNumberET);
                EditText loginPasswordET = findViewById(R.id.loginPasswordET);
                String input1 = loginEmailOrPhoneNumberET.getText().toString();
                String input2 = loginPasswordET.getText().toString();

                trypass = input1;

                boolean chckerClient = myDB.checkClient_Routes(input1, input2);
                boolean checkerOwner = myDB.checkOwner_Routes(input1, input2);

                if (chckerClient == true){
                    openClientDashboard();

                }
                else if (checkerOwner == true){
                    openBusinessOwnerDashboard();
                }
                else{
                    Toast.makeText(LoginActivity.this ,"Invalid Credentials", Toast.LENGTH_SHORT).show();
                }

            }
        });
        loginEmailOrPhoneNumberET = findViewById(R.id.loginEmailOrPhoneNumberET);

        trypass = loginEmailOrPhoneNumberET.getText().toString();





    }

    public void openClientDashboard() {
        EditText loginEmailOrPhoneNumberET = findViewById(R.id.loginEmailOrPhoneNumberET);
        EditText loginPasswordET = findViewById(R.id.loginPasswordET);

        String loginEmailOrPhoneNumberTEXT = loginEmailOrPhoneNumberET.getText().toString();
        String loginPasswordTEXT = loginPasswordET.getText().toString();
        clientIDNumber = myDB.getClientID(loginEmailOrPhoneNumberTEXT).toString();

        boolean checkNow =  myDB.checkClient(loginEmailOrPhoneNumberTEXT, loginPasswordTEXT);

        if (checkNow == true){
            Intent intent = new Intent(this, ClientDashboard.class);
            intent.putExtra(EXTRA_TEXT_PHONE_NUMBER, loginEmailOrPhoneNumberTEXT);
            intent.putExtra("clientID", clientIDNumber);
            startActivity(intent);
            Toast.makeText(LoginActivity.this, "Login Completed", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
        }


    }
    public void openBusinessOwnerDashboard() {
        EditText loginEmailOrPhoneNumberET = findViewById(R.id.loginEmailOrPhoneNumberET);
        EditText loginPasswordET = findViewById(R.id.loginPasswordET);

        String loginEmailOrPhoneNumberTEXT = loginEmailOrPhoneNumberET.getText().toString();
        String loginPasswordTEXT = loginPasswordET.getText().toString();


        boolean checkNow =  myDB.checkOwner(loginEmailOrPhoneNumberTEXT, loginPasswordTEXT);

        if (checkNow == true){
            Intent intent = new Intent(this, BusinessOwnerDashboard.class);
            intent.putExtra(EXTRA_TEXT_PHONE_NUMBER, loginEmailOrPhoneNumberTEXT);

            startActivity(intent);
            Toast.makeText(LoginActivity.this, "Login Completed", Toast.LENGTH_SHORT).show();

        }
        else{
            Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
        }

    }

    public void openSignupOption(){
        Intent intent = new Intent(this, SignupOptionsActivity.class);
        startActivity(intent);
    }

    public void openForgotpassword(){
        Intent intent = new Intent(this, ForgotPassword.class);
        startActivity(intent);
    }





}