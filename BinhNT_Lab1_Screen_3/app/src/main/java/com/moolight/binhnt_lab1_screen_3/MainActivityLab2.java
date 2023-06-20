package com.moolight.binhnt_lab1_screen_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityLab2 extends AppCompatActivity implements View.OnClickListener {
    private Button btn1, btn2, btn3, btnLab1, btnLab3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_l2);
        btn1 = (Button) findViewById(R.id.btnScreen1);
        btn2 = (Button) findViewById(R.id.btnScreen2);
        btn3 = (Button) findViewById(R.id.btnScreen3);
        btnLab1 = (Button) findViewById(R.id.btnLeft);
        btnLab3 = (Button) findViewById(R.id.btnRight);
        btnLab1.setText("<");
        btnLab3.setText(">");

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btnLab1.setOnClickListener(this);
        btnLab3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = ((int) v.getId());
        if (id == R.id.btnScreen1) {
            ShowIntent(MainActivityLab2Screen1.class);
        } else if (id == R.id.btnScreen2) {
            ShowIntent(MainActivityLab2Screen2.class);
        } else if (id == R.id.btnScreen3) {
            ShowIntent(SignInActivityLab2Screen3.class);
        } else if (id == R.id.btnLeft) {
            ShowIntent(MainActivityLab1.class);
            finish();
        } else if (id == R.id.btnRight) {
            ShowIntent(MainActivityLab3.class);
            finish();
        }
    }

    private void ShowIntent(Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }
}