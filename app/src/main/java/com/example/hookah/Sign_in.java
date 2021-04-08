package com.example.hookah;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Sign_in extends AppCompatActivity {

    EditText username, password;
    Button btnSignIn;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow ().setFlags (WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_in);

        username = (EditText) findViewById(R.id.emailField);
        password = (EditText) findViewById(R.id.passField);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        DB = new DBHelper(this);


        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("")||pass.equals("")){
                    Toast.makeText(Sign_in.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }else {
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if (checkuserpass ==true){
                        Toast.makeText(Sign_in.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Questions.class);
                        startActivity(intent);  
                    }
                    else {
                        Toast.makeText(Sign_in.this, "Invalid credintials   ", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}