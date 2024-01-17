package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.test.AccountManagement.Login;

public class splashscrean extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscrean);
        Button button;
        button=findViewById(R.id.buttonsplash);


        SharedPreferences prefs=getSharedPreferences("login",MODE_PRIVATE);
        Boolean checklog= prefs.getBoolean("logFlag",false);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Intent intent ;


                 intent =new Intent(splashscrean.this, MainActivity.class);

                startActivity(intent);
                finish();
            }
        });
    }
}