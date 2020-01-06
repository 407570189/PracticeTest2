package com.example.test;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public boolean logon=false;
    private EditText username;
    private EditText up;
    public boolean isNext=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        username = findViewById(R.id.name);
        up = findViewById(R.id.pass);
        SharedPreferences sp = getSharedPreferences("test", MODE_PRIVATE);
        username.setText(sp.getString("NAME", ""));
        up.setText(sp.getString("PW", "132"));
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Switch sw = findViewById(R.id.switch1);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isNext=isChecked;
                TextView ty=findViewById(R.id.type);
                ty.setText(isNext?getString(R.string.Name):getString(R.string.word));
            }
        });
    }
    public void creat(View view){
        if(!logon){
            Intent intent=new Intent(this,nameActivity.class);
            startActivity(intent);
        }
    }
    public void enter(View view){
        String Username=username.getText().toString();
        String UP=up.getText().toString();
        SharedPreferences sp=getSharedPreferences("test",MODE_PRIVATE);
        if (Username.equals(sp.getString("NAME", ""))&&UP.equals(sp.getString("PW",""))) {
            Intent intent=new Intent(this,EnterActivity.class);
            startActivity(intent);
        }else{
            new AlertDialog.Builder(this)
                    .setTitle("登入失敗")
                    .setMessage("帳密有錯")
                    .setPositiveButton("ok",null)
                    .show();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
