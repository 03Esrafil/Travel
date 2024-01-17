package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.test.Databse.MainDatabaseHelper;
import com.example.test.Mainmodel.modelUserInfo;
import com.example.test.databinding.ActivityRegisterOderProductBinding;
import com.example.test.fragment.fragmentDatabase.fragMytripDATAbaseHelper;
import com.example.test.fragment.mytripFragment;

import java.util.ArrayList;

public class RegisterOderProduct extends AppCompatActivity {
    MainDatabaseHelper databaseHelper;

    ActivityRegisterOderProductBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityRegisterOderProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        databaseHelper=new MainDatabaseHelper(getApplicationContext());
        SharedPreferences user= getSharedPreferences("user", Context.MODE_PRIVATE);
        String data =user.getString("userEmail","");

        modelUserInfo usermodel=databaseHelper.getuserinfo(data);


        String userName=usermodel.username;
        String email=usermodel.email;
        String phoneNumber=usermodel.phone;


        int image=getIntent().getIntExtra("orderImage",0);
        int price=Integer.parseInt(getIntent().getStringExtra("comfirmPrice"));
        String hotelName=getIntent().getStringExtra("orderHotelName");
        String location=getIntent().getStringExtra("booklocation");
        String roomNumber=getIntent().getStringExtra("bookRoomNumber");

       SETInfo(userName,email,phoneNumber,price,hotelName,location,roomNumber);
       final fragMytripDATAbaseHelper mytrip=new fragMytripDATAbaseHelper(this.getApplicationContext());
       binding.checkindate.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               checkIndate();
           }
       });
       binding.checkOutdate.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               checkOutdate();
           }
       });

       binding.ConfirmBooking.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
             boolean result=mytrip.insertOrder(email,userName,phoneNumber,hotelName,image,location,price,roomNumber);
             if(result==true){
                 Toast.makeText(RegisterOderProduct.this, "Booking Succesfuly", Toast.LENGTH_SHORT).show();
                
             }else {
                 Toast.makeText(RegisterOderProduct.this, "falied to insert ", Toast.LENGTH_SHORT).show();
             }
           }
       });

    }

    private  void checkIndate(){
        DatePickerDialog checkIndateDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                binding.checkindateText.setText(String.valueOf(year)+" : "+String.valueOf(month)+" : "+String.valueOf(day));
            }
        },2023,3,15);
        checkIndateDialog.show();
    }
    private  void checkOutdate(){

        DatePickerDialog checkOutdateDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                binding.checkOutdateText.setText(String.valueOf(year)+" : "+String.valueOf(month)+" : "+String.valueOf(day));
            }
        },2023,3,15);
        checkOutdateDialog.show();
    }

    private void SETInfo(String userName,String email,String phoneNumber,int price,String hotelName,String location,String roomNumber) {
        binding.orderRegUserName.setText(userName);
        binding.orderRegPhone.setText(phoneNumber);
        binding.oderRegEmail.setText(email);

        binding.TotalOrderPrice.setText(String.valueOf(price));
        binding.orderRegRoomNumber.setText(roomNumber);
        binding.oderRegHotelName.setText(hotelName);
        binding.orderReglocation.setText(location);

    }
}