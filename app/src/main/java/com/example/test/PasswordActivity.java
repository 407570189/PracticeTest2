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
    public void login2(View view){
        EditText pass=findViewById(R.id.secendpass);
        String UserPass=pass.getText().toString();
        SharedPreferences sp=getSharedPreferences("test",MODE_PRIVATE);
        sp.edit()
                .putString("PW",UserPass)
                .commit();
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
