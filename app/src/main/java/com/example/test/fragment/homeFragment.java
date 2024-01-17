package com.example.test.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.test.R;

import java.util.ArrayList;
import com.example.test.Mainmodel.datamodel;
import com.example.test.MainAdepter.myadepter;


public class homeFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<datamodel> dataholders;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView=view.findViewById(R.id.catagorylist);




        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dataholders=new ArrayList<>();
        dataholders.add(new datamodel(R.drawable.puroliyahils,"puroliya","the famouse puroliya hills","6"));
        dataholders.add(new datamodel(R.drawable.grandcanyon,"madney pur","the famouse madney pur grand canyon","7"));
        dataholders.add(new datamodel(R.drawable.hawamahel_heritage,"haidra baad","the famouse hawai mahel heritage","3"));
        dataholders.add(new datamodel(R.drawable.bamboo_boat,"kerala","the famouse kerala boat racing","6"));
        dataholders.add(new datamodel(R.drawable.waterplace,"punjab","the famouse water floating temple","6"));
        dataholders.add(new datamodel(R.drawable.temple_jain,"himachal pradesh","the famouse himachal prodesh jaina tempel","6"));
        dataholders.add(new datamodel(R.drawable.hills_mountains,"himachal canyuon","the famouse himachal canyon ","6"));
        dataholders.add(new datamodel(R.drawable.hindupanchulingree,"tamil nadu","the famouse long tample ","6"));

        recyclerView.setAdapter(new myadepter(dataholders,getContext()));

        LinearLayoutManager linerLayoutManager=new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(linerLayoutManager);



        return view;
    }
}