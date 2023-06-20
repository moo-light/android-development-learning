package com.example.binhnt_lab5_screen_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn1 = findViewById(R.id.btnScreen1);
        Button btn2 = findViewById(R.id.btnScreen2);
        btn1.setOnClickListener(v->{
            Intent intent = new Intent(this,UserActivity.class);
            startActivity(intent);
        });
        btn2.setOnClickListener(v->{
            Intent intent = new Intent(this,AppActivity.class);
            startActivity(intent);
        });
    }
}