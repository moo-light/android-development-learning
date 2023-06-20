package com.example.binhnt_lab4_screen1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class DrinkActivity extends AppCompatActivity {
    private ListView lvDrink;
    private DrinkAdapter adapter;
    private List<Drink> drinkList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        lvDrink = findViewById(R.id.lvDrink);
        drinkList = new ArrayList<>();
        drinkList.add(new Drink("Vodka","This is a description about img 1",10.0,R.drawable.dimg1));
        drinkList.add(new Drink("Cocacola","This is a description about img 2",5.0,R.drawable.dimg2));
        drinkList.add(new Drink("BeverageX","This is a description about img 3",90.5,R.drawable.dimg3));
        drinkList.add(new Drink("Blu","This is a description about img 4",2.23,R.drawable.dimg4));
        drinkList.add(new Drink("Monster Energy","This is a description about img 5",50.7,R.drawable.dimg5));
        adapter = new DrinkAdapter(this,R.layout.drink_layout,drinkList);
        lvDrink.setAdapter(adapter);

        lvDrink.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent result = new Intent();
                Drink drink = drinkList.get(position);
                Bundle bundle = new Bundle();
                bundle.putString("name",drink.getName());
                bundle.putString("desc",drink.getDesc());
                bundle.putDouble("calo",drink.getCalogies());
                bundle.putInt("img",drink.getImg());
                result.putExtra("result",bundle);
                setResult(RESULT_OK,result);
                finish();
            }
        });
    }
}