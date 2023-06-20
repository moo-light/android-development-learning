package com.moolight.binhnt_lab3_screen_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivityLab3Screen1 extends AppCompatActivity {
    ListView lvList;

    ArrayList<String> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_l3_screen1);
        lvList = findViewById(R.id.lvList);

        arrayList = new ArrayList<>();
        arrayList.add("Android");
        arrayList.add("PHP");
        arrayList.add("iOS");
        arrayList.add("Unity");
        arrayList.add("ASP.Net");
            
        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivityLab3Screen1.this,
                android.R.layout.simple_list_item_1,arrayList);

        lvList.setAdapter(arrayAdapter);
        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Toast.makeText(MainActivityLab3Screen1.this, arrayList.get(i), Toast.LENGTH_SHORT).show();
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