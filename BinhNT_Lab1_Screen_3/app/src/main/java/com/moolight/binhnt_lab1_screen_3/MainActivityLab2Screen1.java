package com.moolight.binhnt_lab1_screen_3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivityLab2Screen1 extends AppCompatActivity {

    TextView tvNumber;
    Button btnRandom;
    EditText number1;
    EditText number2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_l2_screen1);

        tvNumber = (TextView) findViewById(R.id.tvResult);
        btnRandom = (Button) findViewById(R.id.btnRandom);
        number1 = (EditText) findViewById(R.id.number1);
        number2 = (EditText) findViewById(R.id.number2);

        btnRandom.setOnClickListener(x->generateRandom());
    }

    private void generateRandom() {
        Random rand = new Random(System.currentTimeMillis());
        try {
            int min = Integer.parseInt(number1.getText().toString());
            int max = Integer.parseInt(number2.getText().toString());
            Integer result = rand.nextInt(max - min + 1) + min;
            tvNumber.setText(result.toString());
        }catch (Exception ex)
        {
            tvNumber.setText("Error");
        }
    }
}