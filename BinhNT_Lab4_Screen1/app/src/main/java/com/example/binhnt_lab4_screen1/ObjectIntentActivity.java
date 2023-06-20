package com.example.binhnt_lab4_screen1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ObjectIntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string_intent);
        Intent intent = this.getIntent();
        TextView tvResult = findViewById(R.id.tvResult);
        ImageView image = findViewById(R.id.image);

        Food result = (Food) intent.getSerializableExtra("request");
        tvResult.setText(result.toString());
        image.setImageResource(result.getImg());
    }
}