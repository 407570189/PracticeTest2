package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EnterActivity extends AppCompatActivity {
    public GameView gameView;
    private Button down;
    private Button up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
        gameView=findViewById(R.id.view);
        up = findViewById(R.id.button);
        down = findViewById(R.id.button2);
    }

    public void up(View view){
        gameView.setPy(gameView.getPy()-50);
        gameView.invalidate();
    }
    public void down(View view){
        gameView.setPy(gameView.getPy()+50);
        gameView.invalidate();
    }
}