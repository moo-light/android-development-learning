package com.example.binhnt_lab4_screen1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FoodActivity extends AppCompatActivity {
    private ListView lvFood;
    private FoodAdapter adapter;
    private List<Food> foodList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        lvFood = findViewById(R.id.lvFood);
        foodList = new ArrayList<>();
        foodList.add(new Food("Apple","This is a description about img 1",10.0,R.drawable.fimg1));
        foodList.add(new Food("Rice","This is a description about img 2",5.0,R.drawable.fimg2));
        foodList.add(new Food("Hamburger","This is a description about img 3",90.5,R.drawable.fimg3));
        foodList.add(new Food("Taco","This is a description about img 4",2.23,R.drawable.fimg4));
        foodList.add(new Food("Chicken Wings","This is a description about img 5",50.7,R.drawable.fimg5));
        adapter = new FoodAdapter(this,R.layout.food_layout,foodList);
        lvFood.setAdapter(adapter);

        lvFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent result = new Intent();
                Food food = foodList.get(position);
                Bundle bundle = new Bundle();
                bundle.putString("name",food.getName());
                bundle.putString("desc",food.getDesc());
                bundle.putDouble("calo",food.getCalogies());
                bundle.putInt("img",food.getImg());
                result.putExtra("result",bundle);
                setResult(RESULT_OK,result);
                finish();
            }
        });
    }
}