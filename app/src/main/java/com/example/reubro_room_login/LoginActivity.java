package com.example.reubro_room_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    TextView tvName,tvEmail,tvPhno,tvCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvCountry=findViewById(R.id.tvCountry);
        tvEmail=findViewById(R.id.tvMail);
        tvName=findViewById(R.id.tvName);
        tvPhno=findViewById(R.id.tvPhno);


        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        String email = intent.getStringExtra("email");
        String country = intent.getStringExtra("country");
        String phno = intent.getStringExtra("phno");

        tvName.setText(name);
        tvPhno.setText(phno);
        tvEmail.setText(email);
        tvCountry.setText(country);

    }
}