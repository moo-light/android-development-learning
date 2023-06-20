package com.moolight.demo_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvList;

    ArrayList<String> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvList = findViewById(R.id.lvList);

        arrayList = new ArrayList<>();
        arrayList.add("PHP");
        arrayList.add("Python");
        arrayList.add("Java");
        arrayList.add("C#");
        arrayList.add("C++");

        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this,
                android.R.layout.simple_list_item_1,arrayList);

        lvList.setAdapter(arrayAdapter);
        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Toast.makeText(MainActivity.this, arrayList.get(i), Toast.LENGTH_SHORT).show();
            }
        });

        lvList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                arrayList.remove(position);
                arrayAdapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}