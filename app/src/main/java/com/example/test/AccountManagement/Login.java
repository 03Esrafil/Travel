package com.example.test.AccountManagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.test.Databse.MainDatabaseHelper;
import com.example.test.MainActivity;
import com.example.test.Mainmodel.modelUserInfo;
import com.example.test.databinding.ActivityLoginBinding;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Login extends AppCompatActivity {

     ActivityLoginBinding binding;
   MainDatabaseHelper databaseHelper;

//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        databaseHelper= new MainDatabaseHelper(this);

        binding.gotoRagister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Ragister.class));
                finish();
            }
        });

        binding.btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.progressbar.setVisibility(View.VISIBLE);

                UserProfileInfo info= new UserProfileInfo();

                String email=String.valueOf(binding.loginemail.getText().toString());
                String password=String.valueOf(binding.loginPassword.getText().toString());

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(Login.this, "pls fil up phone email", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(password)){
                    Toast.makeText(Login.this, "pls fil up phone password", Toast.LENGTH_SHORT).show();
                }
                else if(isEmail(email)){

                    loginCheck(email,password);

                }else {
                    Toast.makeText(Login.this, "this is not a email Structure", Toast.LENGTH_SHORT).show();
                }

            }
        });





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
    public  boolean isPassword(String password){
        return  true;
    }

    public  void loginCheck(String email,String password){


            Boolean checkcredential=databaseHelper.checkEmailPassword(email,password);


            if(checkcredential==true){
                SharedPreferences prefs=getSharedPreferences("login",MODE_PRIVATE);
                SharedPreferences.Editor edit=prefs.edit();
                edit.putBoolean("logFlag",true);
                edit.apply();

                SharedPreferences user=getSharedPreferences("user",MODE_PRIVATE);
                SharedPreferences.Editor useedit=user.edit();

                useedit.putString("userEmail",email);
                useedit.apply();
                Toast.makeText(Login.this, "Login Succesfuly", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getApplicationContext(), MainActivity.class);

                startActivity(intent);
                finish();
            }else {
                Toast.makeText(Login.this, "Login is failed", Toast.LENGTH_SHORT).show();
            }

    }
}