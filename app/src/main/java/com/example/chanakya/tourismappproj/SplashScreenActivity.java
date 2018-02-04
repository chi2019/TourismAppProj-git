package com.example.chanakya.tourismappproj;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread splashThread = new Thread(){

            @Override
            public void run() {

                try{
                        Thread.sleep(15000);
                }
                catch (Exception e){

                }

                finally{
                     startActivity(new Intent(getApplicationContext(),LoginScreen.class));
                     finish();
                }

            }
        };

        splashThread.start();

    }
}
