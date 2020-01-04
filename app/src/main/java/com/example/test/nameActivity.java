package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class nameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
    }
    public void login(View view){
        EditText username=findViewById(R.id.firstname);
        String UserName=username.getText().toString();
        SharedPreferences sp=getSharedPreferences("test",MODE_PRIVATE);
            sp.edit()
                    .putString("NAME",UserName)
                    .commit();
        Intent intent=new Intent(this, PasswordActivity.class);
        startActivity(intent);
    }
}
