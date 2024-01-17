package com.example.test.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.test.R;
import com.example.test.fragment.fragAdepter.wishlistAdepter;
import com.example.test.fragment.fragModel.wishlistmodel;

import java.util.ArrayList;

public class wishlistFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<wishlistmodel> dataholders;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_wishlist, container, false);
        recyclerView=view.findViewById(R.id.wishlistdata);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dataholders=new ArrayList<>();

        dataholders.add(new wishlistmodel(R.drawable.puroliyahils,"puroliya "));
        dataholders.add(new wishlistmodel(R.drawable.grandcanyon,"madney pur"));
        dataholders.add(new wishlistmodel(R.drawable.hawamahel_heritage,"haidra baad"));
        dataholders.add(new wishlistmodel(R.drawable.bamboo_boat,"kerala"));
        dataholders.add(new wishlistmodel(R.drawable.waterplace,"punjab"));
        dataholders.add(new wishlistmodel(R.drawable.temple_jain,"himachal pradeshl"));
        dataholders.add(new wishlistmodel(R.drawable.hills_mountains,"himachal canyuon "));
        dataholders.add(new wishlistmodel(R.drawable.hindupanchulingree,"tamil nadu "));

        recyclerView.setAdapter(new wishlistAdepter(dataholders));

        return view;
    }
}