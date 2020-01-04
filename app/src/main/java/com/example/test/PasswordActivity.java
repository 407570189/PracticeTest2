package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
    }
    public void login(View view){
        EditText password=findViewById(R.id.Secondpass);
        String userpassword=password.getText().toString();
        SharedPreferences sp=getSharedPreferences("this",MODE_PRIVATE);
        sp.edit()
                .putString("PW",userpassword)
                .commit();
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
