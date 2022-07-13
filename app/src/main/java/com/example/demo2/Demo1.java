package com.example.demo2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Demo1 extends AppCompatActivity {


    private TextView TextFullName;
    private TextView TextBirthDay;
    private TextView TextAbout;
    private TextView TextAvatar;
    public static String KeyUserFullName="UserFullName";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo1);

        getSupportActionBar().setTitle(" Add Information ");


          TextFullName = findViewById(R.id.FullName);
          TextBirthDay = findViewById(R.id.Birthday);
          TextAbout    = findViewById(R.id.About);
          TextAvatar = findViewById(R.id.Avatar);
          Intent mIntent=getIntent();
          String UserFullName = getIntent().getStringExtra(KeyUserFullName);
          String UserBirthday = getIntent().getStringExtra("UserDemoone");
          String UserAbout = getIntent().getStringExtra("UserDemoone1");
          String UserAvatar = getIntent().getStringExtra("UserDemoone2");
          TextFullName.setText(UserFullName);
          TextBirthDay.setText(UserBirthday);
          TextAbout.setText(UserAbout);
          TextAvatar.setText(UserAvatar);
        }
    }
