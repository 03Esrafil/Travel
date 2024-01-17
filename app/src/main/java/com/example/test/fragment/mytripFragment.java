package com.example.test.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.test.Mainmodel.datamodel;
import com.example.test.R;
import com.example.test.databinding.FragmentMytripBinding;
import com.example.test.fragment.fragAdepter.OderTripAdepter;
import com.example.test.fragment.fragModel.tripModel;
import com.example.test.fragment.fragmentDatabase.fragMytripDATAbaseHelper;

import java.util.ArrayList;


public class mytripFragment extends Fragment {

     FragmentMytripBinding binding;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       binding= FragmentMytripBinding.inflate(inflater, container, false);
        fragMytripDATAbaseHelper helper=new fragMytripDATAbaseHelper(getContext());

        ArrayList<tripModel> triplist=helper.getBookinglist();




        OderTripAdepter adepter=new OderTripAdepter(triplist,getContext());
        binding.orderTripid.setAdapter(adepter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());

        binding.orderTripid.setLayoutManager(linearLayoutManager);

        return  binding.getRoot();
    }
}