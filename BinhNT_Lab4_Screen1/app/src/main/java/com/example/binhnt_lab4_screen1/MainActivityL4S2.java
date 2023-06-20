package com.example.binhnt_lab4_screen1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;

public class MainActivityL4S2 extends AppCompatActivity implements View.OnClickListener {
    private Button btnString,btnNumber,btnArray,btnObject,btnBundle;

    private String stringRequest = "Hello World";
    private double numberRequest = 1293.1233;
    private int[] arrayRequest = new int[]{1,2,3,4,5,6,7,8,9,8,7,6,4,3,2,5};
    private Food objectRequest = new Food("Hamburger","Description about img hamburger",14.423,R.drawable.fimg3);
    private Bundle bundleRequest = new Bundle();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_l4_s2);
        btnString = (Button) findViewById(R.id.btnString);
        btnNumber = (Button) findViewById(R.id.btnNumber);
        btnArray = (Button) findViewById(R.id.btnArray);
        btnObject = (Button) findViewById(R.id.btnObject);
        btnBundle = (Button) findViewById(R.id.btnBundle);

        setOnClickAllButton(this,btnString,btnNumber,btnArray,btnObject,btnBundle);
    }

    private void setOnClickAllButton(View.OnClickListener context, Button ...button) {
        for(int i=0;i<button.length;i++){
            button[i].setOnClickListener(context);
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id  == btnString.getId()) {
            Intent intent = new Intent(this,StringIntentActivity.class);
            intent.putExtra("request",stringRequest);
            startActivity(intent);

        }else if(id == btnNumber.getId()){
            Intent intent = new Intent(this,NumberIntentActivity.class);
            intent.putExtra("request",numberRequest);
            startActivity(intent);
        }else if(id == btnArray.getId()){
            Intent intent = new Intent(this,ArrayIntentActivity.class);
            intent.putExtra("request",arrayRequest);
            startActivity(intent);
        }else if(id == btnObject.getId()){
            Intent intent = new Intent(this,ObjectIntentActivity.class);
            intent.putExtra("request",(Serializable) objectRequest);
            startActivity(intent);
        }else if(id == btnBundle.getId()){
            Intent intent = new Intent(this,BundleIntentActivity.class);
                bundleRequest.putString("string",stringRequest);
                bundleRequest.putDouble("number",numberRequest);
                bundleRequest.putIntArray("array",arrayRequest);
                bundleRequest.putSerializable("object", (Serializable) objectRequest);
                intent.putExtra("request",bundleRequest);
            startActivity(intent);
        }
    }


}