package com.moolight.binhnt_lab1_screen_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.moolight.binhnt_lab1_screen_3.binhnt_lab3_screen_3.MainActivityLab3Screen3;
import com.moolight.binhnt_lab1_screen_3.binhnt_lab3_screen_4.MainActivityLab3Screen4;

public class MainActivityLab3 extends AppCompatActivity implements View.OnClickListener {
    private Button btn1, btn2, btn3,btn4, btnLab2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_l3);
        btn1 = (Button) findViewById(R.id.btnScreen1);
        btn2 = (Button) findViewById(R.id.btnScreen2);
        btn3 = (Button) findViewById(R.id.btnScreen3);
        btn4 = (Button) findViewById(R.id.btnScreen4);
        btnLab2 = (Button) findViewById(R.id.btnLeft);
        btnLab2.setText("<");

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btnLab2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = ((int) v.getId());
        if (id == R.id.btnScreen1) {
            ShowIntent(MainActivityLab3Screen1.class);
        } else if (id == R.id.btnScreen2) {
            ShowIntent(MainActivityLab3Screen2.class);
        } else if (id == R.id.btnScreen3) {
            ShowIntent(MainActivityLab3Screen3.class);
        } else if (id == R.id.btnScreen4) {
            ShowIntent(MainActivityLab3Screen4.class);
        } else if (id == R.id.btnLeft) {
            ShowIntent(MainActivityLab2.class);
            finish();
        }
    }
    private void ShowIntent(Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }
}