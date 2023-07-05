package com.example.binhnt_lab_premission_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1;
    private Button btn2;
    private Button btn4;
    private Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.btnScreen1);
        btn2 = (Button) findViewById(R.id.btnScreen2);
        btn3 = (Button) findViewById(R.id.btnScreen3);
        btn4 = (Button) findViewById(R.id.btnScreen4);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        int id = ((int) v.getId());
        if (id == R.id.btnScreen1) {
            ShowIntent(LocationActivity.class);
        } else if (id == R.id.btnScreen2) {
            ShowIntent(PhoneCallActivity.class);
        } else if (id == R.id.btnScreen3) {
            ShowIntent(WebActivity.class);
        } else if (id == R.id.btnScreen4) {
            ShowIntent(SMSActivity.class);
        }
    }
    private void ShowIntent(Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }

}