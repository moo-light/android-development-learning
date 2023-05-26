package com.example.randomnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txtNumber;
    Button btnRandom;
    EditText number1;
    EditText number2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNumber = (TextView) findViewById(R.id.textViewNoidung);
        btnRandom = (Button) findViewById(R.id.buttonClick);
        number1 = (EditText) findViewById(R.id.number1);
        number2 = (EditText) findViewById(R.id.number2);

        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateRandomNumber();
            }
        });
    }

    private void generateRandomNumber() {
        //tao so ngau nhien
        try {
            int min = Integer.parseInt(number1.getText().toString());
            int max = Integer.parseInt(number2.getText().toString());

            if (min > max)  throw new Exception("Error: The minimum number cannot be greater than the maximum number.");

            Random random = new Random();
            int randomNumber = random.nextInt(max - min + 1) + min;

            txtNumber.setText(String.valueOf(randomNumber));
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), ex.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}