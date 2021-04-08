package com.example.hookah;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Sign_up extends AppCompatActivity {
    EditText username, password, respassword;
    Button sign_up;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);
        username = (EditText) findViewById(R.id.login);
        password = (EditText) findViewById(R.id.password);
        respassword = (EditText) findViewById(R.id.respassword);
        sign_up = (Button) findViewById(R.id.btnSignUp);
        DB = new DBHelper(this);

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String respass = respassword.getText().toString();

                if (user.equals("")||pass.equals("")||respass.equals(""))
                    Toast.makeText(Sign_up.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                else {
                    if (pass.equals(respass)){
                        Boolean checkuser = DB.checkusername(user);
                        if (checkuser ==false){
                            Boolean insert = DB.insertData(user,pass);
                            if (insert==true){
                                Toast.makeText(Sign_up.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),Questions.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(Sign_up.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(Sign_up.this, "User already exist! Please sign in.", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(Sign_up.this, "Password not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}