package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.test.AccountManagement.Login;
import com.example.test.MainAdepter.myadepter;
import com.example.test.MainAdepter.roomImageAdepter;
import com.example.test.MainAdepter.roomlistAdepter;
import com.example.test.Mainmodel.datamodel;
import com.example.test.Mainmodel.roomimgeModel;
import com.example.test.Mainmodel.roomlistModel;
import com.example.test.databinding.ActivityHotelbookingBinding;

import java.util.ArrayList;
import java.util.Random;

public class hotelbooking extends AppCompatActivity {
    ActivityHotelbookingBinding binding;
    ArrayList<roomimgeModel> dataholders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityHotelbookingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        int image=getIntent().getIntExtra("Image",0);
        int price=Integer.parseInt(getIntent().getStringExtra("roomPrice"));
        String hotelName=getIntent().getStringExtra("Hotel Name");
        String location=getIntent().getStringExtra("location");
        String bedNumber=getIntent().getStringExtra("bedNumber");

        binding.itemroomImage.setImageResource(image);
        binding.HotelName.setText(hotelName);
        binding.Roomlocationaddress.setText(location);
        binding.roomPriceDetails.setText(String.format("%d",price));
        binding.BednumberId.setText(bedNumber);

        dataholders=new ArrayList<>();
        dataholders.add(new roomimgeModel(R.drawable.roomdetail_1));
        dataholders.add(new roomimgeModel(R.drawable.roomdetail_2));
        dataholders.add(new roomimgeModel(R.drawable.roomdetails_3));
        dataholders.add(new roomimgeModel(R.drawable.roomdetails_4));
        dataholders.add(new roomimgeModel(R.drawable.roomdetails_5));
        dataholders.add(new roomimgeModel(R.drawable.roomdetails_6));

        binding.roomcatlog.setAdapter(new roomImageAdepter(dataholders,this.getApplicationContext()));
        GridLayoutManager layoutManager=new GridLayoutManager(this.getApplicationContext(),3);

        binding.roomcatlog.setLayoutManager(layoutManager);

      binding.bookNowtogoOderConfrim.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {


              SharedPreferences prefs=getSharedPreferences("login",MODE_PRIVATE);
              Boolean checklog= prefs.getBoolean("logFlag",false);

              if(checklog){

                  Random random = new Random();
                  int randomInteger = random.nextInt();
                  String roomNumber=String.valueOf( Math.abs(randomInteger));
                  String  orderPrice=String.valueOf(price);

                  roomlistModel roomconfirm=new roomlistModel(image,hotelName,location,roomNumber,orderPrice);

                  Intent intent=new Intent(getApplicationContext(),RegisterOderProduct.class);

                  intent.putExtra("orderImage",roomconfirm.getRoomtImage());
                  intent.putExtra("orderHotelName",roomconfirm.getHotelName());
                  intent.putExtra("booklocation",roomconfirm.getLocation());
                  intent.putExtra("bookRoomNumber",roomconfirm.getRoomNumeber());
                  intent.putExtra("comfirmPrice",roomconfirm.getRoomprice());

                  startActivity(intent);
              }else {
                  Dialog dialog=new Dialog(hotelbooking.this);
                  dialog.setContentView(R.layout.alert_diolog_box);
                  dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                  Button ok=dialog.findViewById(R.id.dialog_button);
                  ok.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View view) {

                          startActivity(new Intent(getApplicationContext(), Login.class));
                          finish();
                      }

                  });
                  dialog.show();
              }






          }
      });
    }
}