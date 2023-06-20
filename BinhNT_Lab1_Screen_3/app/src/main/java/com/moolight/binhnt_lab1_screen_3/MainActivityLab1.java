package com.moolight.binhnt_lab1_screen_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivityLab1 extends AppCompatActivity implements View.OnClickListener {
    private Button btn1,btn2,btn3,btn4,btn5,btnLab2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_l1);
        btn1= (Button) findViewById(R.id.btnScreen1);
        btn2= (Button) findViewById(R.id.btnScreen2);
        btn3= (Button) findViewById(R.id.btnScreen3);
        btn4= (Button) findViewById(R.id.btnScreen4);
        btn5= (Button) findViewById(R.id.btnScreen5);
        btnLab2= (Button) findViewById(R.id.btnRight);
        btnLab2.setText(">");

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btnLab2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = ((int) v.getId());
        if (id == R.id.btnScreen1) {
            ShowIntent(MainActivityScreen1.class);
        } else if (id == R.id.btnScreen2) {
            ShowIntent(MainActivityScreen2.class);
        } else if (id == R.id.btnScreen3) {
            ShowIntent(MainActivityScreen3.class);
        } else if (id == R.id.btnScreen4) {
            ShowIntent(MainActivityScreen4.class);
        } else if (id == R.id.btnScreen5) {
            ShowIntent(MainActivityScreen5.class);
        } else if (id == R.id.btnRight) {
            ShowIntent(MainActivityLab2.class);
            finish();
        }
    }

    private void ShowIntent(Class activity) {
        Intent intent =  new Intent(this, activity);
        startActivity(intent);
    }
}