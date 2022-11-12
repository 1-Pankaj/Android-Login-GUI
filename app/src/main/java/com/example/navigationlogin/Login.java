package com.example.navigationlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Login extends AppCompatActivity {

    public int i = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ImageView login = findViewById(R.id.loginbtn);
        TextView signup = findViewById(R.id.signup);
        EditText user = findViewById(R.id.username);
        EditText pass = findViewById(R.id.password);
        ImageView back = findViewById(R.id.back);
        TextView forget = findViewById(R.id.forget);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = user.getText().toString();
                String password = pass.getText().toString();
                Intent intent = getIntent();
                Bundle bundle = intent.getBundleExtra("bundle");
                if(username.isEmpty() || password.isEmpty()){
                    Toast.makeText(getApplicationContext(), "error in username or password", Toast.LENGTH_SHORT).show();
                }
                if(username.equals(bundle.getString("username")) && password.equals(bundle.getString("password"))){
                    Toast.makeText(getApplicationContext(), "Login Successfull", Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(getApplicationContext(), HomePage.class);
                    startActivity(intent1);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Login Unsuccessfull", Toast.LENGTH_SHORT).show();
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                Toast.makeText(getApplicationContext(), "Register Again", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }
}