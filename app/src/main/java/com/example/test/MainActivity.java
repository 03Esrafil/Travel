package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.FrameLayout;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.test.databinding.ActivityMainBinding;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import com.example.test.fragment.mytripFragment;
import com.example.test.fragment.homeFragment;
import com.example.test.fragment.profileFragment;
import com.example.test.fragment.wishlistFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//
        replace(new homeFragment());



        binding.bottomNavigation.show(1,true);

        binding.bottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.explore));
        binding.bottomNavigation.add(new MeowBottomNavigation.Model(2,R.drawable.wishlist));
        binding.bottomNavigation.add(new MeowBottomNavigation.Model(3,R.drawable.mytrip));
        binding.bottomNavigation.add(new MeowBottomNavigation.Model(4,R.drawable.profile));

        meowNavigation();


    }


    private void meowNavigation(){
        binding.bottomNavigation.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
               switch (model .getId()){
                   case  1:
                          replace(new homeFragment());
                       break;
                   case  2:
                       replace(new wishlistFragment());
                       break;
                   case  3:
                       replace(new mytripFragment());
                       break;
                   case  4:
                       replace(new profileFragment());
                       break;

               }
                return null;
            }
        });

    }
    private void replace(Fragment fragment){
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.framelayout,fragment);
        fragmentTransaction.commit();


    }





}