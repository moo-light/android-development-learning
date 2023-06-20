package com.example.binhnt_lab4_screen1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivityL4S1 extends AppCompatActivity implements View.OnClickListener {
    private Button btnDoAn, btnDoUong, btnExit;
    private TextView tvResult;
    private ImageView imgFood, imgDrink;
    private String result, food = "", drink = "";
    private static final int REQUEST_FOOD = 100;
    private static final int REQUEST_DRINK = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_l4_s1);

        btnDoAn = (Button) findViewById(R.id.button);
        btnDoUong = (Button) findViewById(R.id.button2);
        btnExit = (Button) findViewById(R.id.button3);
        tvResult = (TextView) findViewById(R.id.tvResult);
        imgFood = (ImageView) findViewById(R.id.imgFood);
        imgDrink = (ImageView) findViewById(R.id.imgDrink);

        btnDoAn.setOnClickListener(this);
        btnDoUong.setOnClickListener(this);
        btnExit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.button) {
            startIntent(REQUEST_FOOD, FoodActivity.class);
        } else if (id == R.id.button2) {
            startIntent(REQUEST_DRINK, DrinkActivity.class);
        } else if (id == R.id.button3) {
            thoat();
        }


    }

    private void thoat() {
        this.finish();
    }

    private void startIntent(int requestCode, Class screen) {
        Intent intent = new Intent(this, screen);
        startActivityForResult(intent, requestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK) return;
        Bundle bundle = data.getBundleExtra("result");
        if (requestCode == REQUEST_FOOD) {
            food = bundle.getString("name");
            imgFood.setImageResource(bundle.getInt("img"));
        }

        if (requestCode == REQUEST_DRINK) {
            drink = data.getBundleExtra("result").getString("name");
            imgDrink.setImageResource(bundle.getInt("img"));

        }
        setResult();
        tvResult.setText(result);
    }

    private void setResult() {
        result = food + ((food.isEmpty() || drink.isEmpty()) ? "" : " | ") + drink;
    }
}