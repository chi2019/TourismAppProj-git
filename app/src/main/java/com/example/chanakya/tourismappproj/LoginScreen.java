package com.example.chanakya.tourismappproj;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LoginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewpager = findViewById(R.id.viewpager);
        Communicator communicator = new Communicator(getSupportFragmentManager());// Connecting view pager with communicator
        viewpager.setAdapter(communicator);
        viewpager.setCurrentItem(0);
    }
}
