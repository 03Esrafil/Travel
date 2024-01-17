package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.test.MainAdepter.myadepter;
import com.example.test.MainAdepter.roomlistAdepter;
import com.example.test.Mainmodel.datamodel;
import com.example.test.Mainmodel.roomlistModel;
import com.example.test.databinding.ActivityProductDetailsBinding;

import java.util.ArrayList;

public class productDetails extends AppCompatActivity {
    ActivityProductDetailsBinding binding;
    ArrayList<roomlistModel> dataholders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityProductDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int imge=getIntent().getIntExtra("Image",0);
        int price=Integer.parseInt(getIntent().getStringExtra("Price"));
        String PlaceName=getIntent().getStringExtra("Place Name");
        String description=getIntent().getStringExtra("Description");

        binding.itemImage.setImageResource(imge);
        binding.itemName.setText(PlaceName);
        binding.priceDetails.setText(String.format("%d",price));
        binding.itemDesc.setText(description);


        binding.orderRoomlist.setLayoutManager(new LinearLayoutManager(this));
        dataholders=new ArrayList<>();

        dataholders.add(new roomlistModel(R.drawable.gskhotel,"SCCA HOTEL PLAZA","Purulia ,katika ,723212","3","1600"));
        dataholders.add(new roomlistModel(R.drawable.gwt_marriott_hotel_kolkata,"CHELE  MAYE  HOTEL ","Purulia ,katika ,723212","5","1400"));
        dataholders.add(new roomlistModel(R.drawable.hotel_bride_stm,"SOSUR BARI JINDA BAAD HOTEL PLAZA","Purulia ,katika ,723212","6","1300"));
        dataholders.add(new roomlistModel(R.drawable.jw_marriott_hotel_kolkata,"KHOKA BABU HOTEL PLAZA","Purulia ,katika ,723212","5","1100"));
        dataholders.add(new roomlistModel(R.drawable.ktm_marriot_hotel_kolkata,"ANIMAL BLOCKBUSTER HOTEL PLAZA","Purulia ,katika ,723212","4","1300"));
        dataholders.add(new roomlistModel(R.drawable.ssk_marriott_hotel_kolkata,"BUMBA THE GREAT HOTEL PLAZA","Purulia ,katika ,723212","2","1700"));
        dataholders.add(new roomlistModel(R.drawable.submerge_hoteldlight,"BCA 5th HOTEL PLAZA","Purulia ,katika ,723212","3","1300"));
        dataholders.add(new roomlistModel(R.drawable.the_westin_kolkata_rajarhat,"GOPAL BHAR  HOTEL AND RESTORENT","Purulia ,katika ,723212","1","1000"));
        binding.orderRoomlist.setAdapter(new roomlistAdepter(dataholders,this));
        LinearLayoutManager linerLayoutManager=new LinearLayoutManager(this);
        binding.orderRoomlist.setLayoutManager(linerLayoutManager);
    }
}