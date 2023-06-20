package com.example.binhnt_lab4_screen1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class StringIntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string_intent);
        Intent intent = this.getIntent();
        TextView tvResult = findViewById(R.id.tvResult);
        tvResult.setText(intent.getStringExtra("request"));

    }
}