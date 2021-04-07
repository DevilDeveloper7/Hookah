package com.example.hookah;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class Sign_up extends Activity {
    EditText username, password, respassword;
    Button sign_up;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signup);
        username = (EditText) findViewById(R.id.login);
        password = (EditText) findViewById(R.id.password);
        respassword = (EditText) findViewById(R.id.respassword);
        sign_up = (Button) findViewById(R.id.btnSignUp);

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}