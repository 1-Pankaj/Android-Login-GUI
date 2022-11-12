package com.example.navigationlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int i = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);
        ImageView back = findViewById(R.id.back);
        ImageView signup = findViewById(R.id.signup);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();
                i--;
                if(i==0){
                    finishAffinity();
                }
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if (user.isEmpty() || pass.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Please enter correct information", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(getApplicationContext(), Login.class);
                    Toast.makeText(getApplicationContext(), "Registration successfull", Toast.LENGTH_SHORT).show();
                    Bundle bundle = new Bundle();
                   // intent.putExtra("username", user);
                   // intent.putExtra("password", pass);
                    bundle.putString("username", user);
                    bundle.putString("password", pass);
                    intent.putExtra("bundle", bundle);
                    startActivity(intent);
                }
            }
        });
    }
}