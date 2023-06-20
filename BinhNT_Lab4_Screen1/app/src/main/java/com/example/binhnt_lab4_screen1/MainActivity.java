package com.example.binhnt_lab4_screen1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button screen1,screen2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screen1 = findViewById(R.id.btnScreen1);
        screen2 = findViewById(R.id.btnScreen2);
        setOnClickAllButton(this,screen1,screen2);
    }

    private void setOnClickAllButton(View.OnClickListener context, Button ...button) {
        for(int i=0;i<button.length;i++){
            button[i].setOnClickListener(context);
            button[i].setText("Screen "+(i+1));
        }
    }
    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btnScreen1) {
            startNewActivity(MainActivityL4S1.class);
        } else if (id == R.id.btnScreen2) {
            startNewActivity(MainActivityL4S2.class);
        }
    }

    private void startNewActivity(Class activityClass) {
        Intent intent = new Intent(this,activityClass);
        startActivity(intent);
    }
}