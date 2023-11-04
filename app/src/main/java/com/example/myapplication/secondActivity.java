package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.databinding.ActivitySecondBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class secondActivity extends AppCompatActivity {
    private ActivitySecondBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new homeFragment());
        binding.bottomNavigationView.setSelectedItemId(R.id.home);
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
        int id = item.getItemId();
        if( id == R.id.location)
        {
            replaceFragment(new locationfragment());
        }else if( id == R.id.home)
        {
            replaceFragment(new homeFragment());
        }
        else if( id == R.id.infor)
        {
            replaceFragment(new inforFragment());
        }
            return true;
        });

    }
    private void replaceFragment(Fragment fragment)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }

}