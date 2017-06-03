package com.example.kishan.myrpsgame;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               final Intent mainIntent=new Intent(MainScreen.this,MainActivity.class);
                MainScreen.this.startActivity(mainIntent);
                MainScreen.this.finish();
            }
        },3000);
    }
}
