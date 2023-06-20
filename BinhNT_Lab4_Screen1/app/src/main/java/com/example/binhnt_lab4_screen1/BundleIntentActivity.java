package com.example.binhnt_lab4_screen1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BundleIntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bundle);
        Intent intent = this.getIntent();
        Bundle bundle = intent.getBundleExtra("request");
        //String result
        TextView tvString = findViewById(R.id.tvString);
        String stringResult = bundle.getString("string");
        tvString.setText(stringResult);
        //Number result
        TextView tvNumber = findViewById(R.id.tvNumber);
        Double doubleResult = bundle.getDouble("number");
        tvNumber.setText(doubleResult.toString());
        //Array result
        TextView tvArray = findViewById(R.id.tvArray);
        int[] array = bundle.getIntArray("array");
        String arrayResult= array[0]+"";
        for (int i = 1 ;i<array.length;i++){
            arrayResult+= ", "+array[i];
        }
        tvArray.setText(arrayResult);
        //Object result
        TextView tvObjectName = findViewById(R.id.tvObjectName);
        TextView tvObjectDesc = findViewById(R.id.tvObjectDesc);
        TextView tvObjectCalo = findViewById(R.id.tvObjectCalo);
        ImageView image = findViewById(R.id.image);

        Food objectResult = (Food) bundle.getSerializable("object");
        tvObjectName.setText(objectResult.getName());
        tvObjectDesc.setText(objectResult.getDesc());
        tvObjectCalo.setText(objectResult.getCalogies().toString()+"lbs");
        image.setImageResource(objectResult.getImg());
    }
}