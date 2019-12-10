package com.softwarica.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.softwarica.fragments.fragments.FirstFragment;
import com.softwarica.fragments.fragments.SecondFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnFragment;
    //if status is true them load first fragment
    private Boolean status = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFragment = findViewById(R.id.btnFragment);
        btnFragment.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if(status){
            FirstFragment firstFragment = new FirstFragment();
            fragmentTransaction.replace(R.id.fragmentContainer,firstFragment);
            fragmentTransaction.commit();
            btnFragment.setText("Load Second Fragments");
            status = false;
        }
        else {
            SecondFragment secondFragment = new SecondFragment();
            fragmentTransaction.replace(R.id.fragmentContainer,secondFragment);
            fragmentTransaction.commit();
            btnFragment.setText("Load First Fragment");
            status = true;
        }

    }
}

