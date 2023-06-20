package com.moolight.binhnt_lab2_screen_1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityLab2Screen2 extends AppCompatActivity implements View.OnClickListener {
    EditText number1;
    EditText number2;
    Button btnAdd;
    Button btnSub;
    Button btnMul;
    Button btnDiv;
    TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_l2_screen2);

        number1 = (EditText) findViewById(R.id.number1);
        number2 = (EditText) findViewById(R.id.number2);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        txtResult = (TextView) findViewById(R.id.result);

        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Double result = null;
        try {
            Double number1 = Double.parseDouble(this.number1.getText().toString());
            Double number2 = Double.parseDouble(this.number2.getText().toString());
            if (v.getId() == R.id.btnAdd) {
                result = number1 + number2;
            }
            if (v.getId() == R.id.btnSub) {
                result = number1 - number2;
            }
            if (v.getId() == R.id.btnMul) {
                result = number1 * number2;
            }
            if (v.getId() == R.id.btnDiv) {
                result = number1 / number2;
            }
            txtResult.setText(result.toString());

        }catch (Exception ex){
            txtResult.setText("Error");

        }
    }
}