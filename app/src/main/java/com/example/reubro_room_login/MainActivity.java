package com.example.reubro_room_login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText edtEmail,edtPass;
    Button btnLogin,btnSignUp;

    List<MainData> dataList=new ArrayList<>();
    RoomDB database;
   // MainAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtEmail=findViewById(R.id.edt_email);
        edtPass=findViewById(R.id.edt_pass);
        btnLogin=findViewById(R.id.btnLogin);
        btnSignUp=findViewById(R.id.btnSignUp);
        database =RoomDB.getInstance(this);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sEmail=edtEmail.getText().toString().trim();
                String sPass=edtEmail.getText().toString().trim();

                if (!sEmail.equals("")&&!sPass.equals("")){
                    MainData data=new MainData();
                    dataList=database.mainDao().login(sEmail,sPass);
                    MainData d=dataList.get(0);
                    String iEmail=d.getEmail();
                    String iName=d.getName();
                    String iCountry=d.getCountry();
                    String iPhno=d.getPhno();

                    Intent myIntent = new Intent(getApplicationContext(), LoginActivity.class);
                    myIntent.putExtra("name", iName);
                    myIntent.putExtra("email", iEmail);
                    myIntent.putExtra("country", iCountry);
                    myIntent.putExtra("phno", iPhno);
                    startActivity(myIntent);


                }
            }
        });


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntentx = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(myIntentx);

               // dataList.addAll(database.mainDao().getAll());
               // adapter.notifyDataSetChanged();
            }
        });

    }
}