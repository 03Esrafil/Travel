package com.example.test.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.test.AccountManagement.Login;
import com.example.test.Databse.MainDatabaseHelper;
import com.example.test.R;
import com.example.test.databinding.FragmentProfileBinding;
import com.example.test.Mainmodel.modelUserInfo;

import java.util.ArrayList;


public class profileFragment extends Fragment {
     FragmentProfileBinding binding;
    MainDatabaseHelper databaseHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding=FragmentProfileBinding.inflate(inflater,container,false);

        SharedPreferences prefs=getContext().getSharedPreferences("login",Context.MODE_PRIVATE);
        Boolean checklog= prefs.getBoolean("logFlag",false);

        if(checklog){
            setuserInfo();
            binding.logout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    binding.mainusername.setText("");
                    binding.userEmail.setText("");

                    SharedPreferences prefs= getContext().getSharedPreferences("login", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit=prefs.edit();
                    edit.putBoolean("logFlag",false);

                    edit.apply();
                    Toast.makeText(getContext(), "You are now logout , pls login ", Toast.LENGTH_SHORT).show();
                }
            });
        }else {

            Dialog dialog=new Dialog(requireContext());
            dialog.setContentView(R.layout.alert_diolog_box);
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            Button ok=dialog.findViewById(R.id.dialog_button);
            dialog.show();
            ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    startActivity(new Intent(getContext(), Login.class));
                    getActivity().finish();
                }
            });

        }




        return  binding.getRoot();
    }

    public  void setuserInfo(){

        databaseHelper=new MainDatabaseHelper(getContext());


        SharedPreferences user= getContext().getSharedPreferences("user",Context.MODE_PRIVATE);
        String data =user.getString("userEmail","");


        modelUserInfo usermodel=databaseHelper.getuserinfo(data);

        int position =databaseHelper.getUserId(data);

        String userName=usermodel.username;
        String email=usermodel.email;

        binding.mainusername.setText(userName);
        binding.userEmail.setText(email);
    }
}