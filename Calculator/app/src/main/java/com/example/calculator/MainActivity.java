package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private enum Operation {
        ADD,
        SUB,
        MUL,
        DIV
    }

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
        setContentView(R.layout.activity_main);
        number1 = (EditText) findViewById(R.id.number1);
        number2 = (EditText) findViewById(R.id.number2);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        txtResult = (TextView) findViewById(R.id.result);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculator(Operation.ADD);
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculator(Operation.SUB);
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculator(Operation.MUL);
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculator(Operation.DIV);
            }
        });
     }

     private void Calculator(Operation o) {
        try {
            double result = 0.0;
            double a = Double.parseDouble(number1.getText().toString());
            double b = Double.parseDouble(number2.getText().toString());
            switch (o) {
                case ADD:
                    result = a + b;
                    break;
                case SUB:
                    result = a - b;
                    break;
                case MUL:
                    result = a * b;
                    break;
                case DIV:
                    if (b != 0) {
                        result = a / b;
                    } else {
                        throw new ArithmeticException("Divisor cannot be zero");
                    }
                    break;
            }
            txtResult.setText(String.valueOf(result));

        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), ex.toString(), Toast.LENGTH_SHORT).show();
        }
     }
}