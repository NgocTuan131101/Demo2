package com.example.demo2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Demo extends AppCompatActivity {
    private static final int MY_REQUEST_CODE = 10;
    private EditText editFullName;
    private EditText editBirthday;
    private EditText editAbout;
    private Button buttonShow;
    private EditText editAvatar;
    private Button btn_new;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo1);

        getSupportActionBar().setTitle("Add Information");

        editFullName = findViewById(R.id.FullName);
        editBirthday = findViewById(R.id.Birthday);
        editAbout = findViewById(R.id.About);
        buttonShow = findViewById(R.id.ShowInFor);
        editAvatar = findViewById(R.id.Avatar);
        btn_new = findViewById(R.id.button_new);


        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextActivity();
            }
        });
    }

    private void nextActivity() {
        String UseFullName = editFullName.getText().toString().trim();
        String UseBirthday = editBirthday.getText().toString().trim();
        String UseAbout = editAbout.getText().toString().trim();
        String UseAvatar = editAvatar.getText().toString().trim();

        Intent intent = new Intent(Demo.this, Demo1.class);
        intent.putExtra(Demo1.KeyUserFullName, UseFullName);
        intent.putExtra("UserDemoone",UseBirthday);
        intent.putExtra("UserDemoone1", UseAbout);
        intent.putExtra("UserDemoone2",UseAvatar);
        startActivityForResult(intent, MY_REQUEST_CODE);

    }

    public class KeyUserFullName {
    }
}
