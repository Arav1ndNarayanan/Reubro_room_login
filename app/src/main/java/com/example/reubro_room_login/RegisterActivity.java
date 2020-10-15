package com.example.reubro_room_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    EditText etName,etEmail,etPass,etCountry,etPh;
    Button btReg;
    List<MainData> dataList=new ArrayList<>();
    RoomDB database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        database =RoomDB.getInstance(this);


        etName=findViewById(R.id.etName);
        etEmail=findViewById(R.id.etMail);
        etPass=findViewById(R.id.etPass);
        etCountry=findViewById(R.id.etCon);
        etPh=findViewById(R.id.etPhone);
        btReg=findViewById(R.id.btReg);

btReg.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        String sEmail=etEmail.getText().toString().trim();
        String sPass=etPass.getText().toString().trim();
        String sName=etName.getText().toString().trim();
        String sCountry=etCountry.getText().toString().trim();
        String sPhno=etPh.getText().toString().trim();

        MainData data=new MainData();
        data.setEmail(sEmail);
        data.setPass(sPass);
        data.setName(sName);
        data.setCountry(sCountry);
        data.setPhno(sPhno);
        database.mainDao().insert(data);
        etName.setText("");
        etEmail.setText("");
        etPass.setText("");
        etCountry.setText("");
        etPh.setText("");

        dataList.clear();
        Intent myIntentx = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(myIntentx);

    }
});

    }
}