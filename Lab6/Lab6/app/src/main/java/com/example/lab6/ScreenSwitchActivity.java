package com.example.lab6;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lab6.screen.SwitchScreenButton;

public class ScreenSwitchActivity extends AppCompatActivity {
    private LinearLayout layout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_screen);
        layout =(LinearLayout) findViewById(R.id.ll);
        layout.setWeightSum(30);
        layout.setGravity(Gravity.CENTER);
        //Screens
        Button screen1 = new SwitchScreenButton(this,"Screen 1", MainActivity.class);
        Button screen2 = new SwitchScreenButton(this,"Screen 2", ChangeColorActivity.class);
        Button screen3 = new SwitchScreenButton(this,"Screen 3", PopupActivity.class);

        layout.addView(screen1);
        layout.addView(screen2);
        layout.addView(screen3);
    }
}
