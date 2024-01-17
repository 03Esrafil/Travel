package com.example.test.AccountManagement;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.Databse.MainDatabaseHelper;
import com.example.test.databinding.ActivityRagisterBinding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ragister extends AppCompatActivity {
    ActivityRagisterBinding binding;
    MainDatabaseHelper databseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRagisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databseHelper = new MainDatabaseHelper(this);


        binding.btnRagister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.progressbar.setVisibility(View.VISIBLE);
                String username = String.valueOf(binding.RagisterUserName.getText().toString());
                String email = String.valueOf(binding.RagisterEmailAddress.getText().toString());
                String password = String.valueOf(binding.RagisterPassword.getText().toString());
                String phoneNumber = binding.RagisterPhoneNumber.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(Ragister.this, "pls fil up email", Toast.LENGTH_SHORT).show();

                } else if (TextUtils.isEmpty(username)) {
                    Toast.makeText(Ragister.this, "pls fil up username", Toast.LENGTH_SHORT).show();

                } else if (TextUtils.isEmpty(password)) {
                    Toast.makeText(Ragister.this, "pls fil up  password", Toast.LENGTH_SHORT).show();


                } else if (TextUtils.isEmpty(phoneNumber)) {
                    Toast.makeText(Ragister.this, "pls fil up phone number", Toast.LENGTH_SHORT).show();
                }else {
                    boolean curectemail=isEmail(email);
                    if(curectemail){
                        if (isValidPhoneNumber(phoneNumber)){
                                  register(username,email,password,phoneNumber);
                        }else{
                            Toast.makeText(Ragister.this, "phone is not valid", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(Ragister.this, "email is not valid", Toast.LENGTH_SHORT).show();
                    }

                }


            }
        });

        binding.gotologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), Login.class));
                finish();
            }
        });


    }


    public void register(String username, String email, String password, String phoneNumber) {
        Boolean checkUsersEmail = databseHelper.checkEmail(email);
        if (checkUsersEmail == false) {
            Boolean insert = databseHelper.insertData(username, email, password, phoneNumber);
            if (insert == true) {
                Toast.makeText(getApplicationContext(), "Register Successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), Login.class));
                finish();
            } else {
                Toast.makeText(getApplicationContext(), "Register is Failed", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "Users data is already exists ", Toast.LENGTH_SHORT).show();
        }


}
    public  static  boolean isEmail(String email){

        String emailReged="^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@"+
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern=Pattern.compile(emailReged);
        if(pattern.matcher(email).matches()){
            return true;
        }else {
            return  false;
        }

    }
    public static boolean isValidPhoneNumber(String phoneNumber) {
        // Regular expression pattern for a basic phone number validation
        String regex = "^(\\+\\d{1,3}[- ]?)?\\d{10}$"; // Modify as needed for different formats

        // Compile the pattern
        Pattern pattern = Pattern.compile(regex);

        // Match the given phone number with the pattern
        Matcher matcher = pattern.matcher(phoneNumber);

        // Return true if the phone number matches the pattern, otherwise false
        return matcher.matches();
    }


}