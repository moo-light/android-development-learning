package com.example.binhnt_lab4_screen1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NumberIntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string_intent);
        Intent intent = this.getIntent();
        TextView tvResult = findViewById(R.id.tvResult);

        Double result = intent.getDoubleExtra("request",-999);
        tvResult.setText(result.toString());

    }
}