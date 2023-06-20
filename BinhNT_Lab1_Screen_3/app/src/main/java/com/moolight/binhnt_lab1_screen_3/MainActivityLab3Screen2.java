package com.moolight.binhnt_lab1_screen_3;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivityLab3Screen2 extends AppCompatActivity {
    ListView lvMonHoc;
    Button btnAdd;
    Button btnUpdate;
    EditText editText;
    ArrayList<String> arrayCourse;
    ArrayAdapter<String> adapter;
    private static int selectedTextIndex =-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_l3_screen2);
        editText = findViewById(R.id.editText);
        btnAdd = findViewById(R.id.button);
        btnUpdate = findViewById(R.id.button2);
        lvMonHoc = findViewById(R.id.lvList);

        arrayCourse = new ArrayList<>();
        arrayCourse.add("Android 2017");
        arrayCourse.add("PHP");
        arrayCourse.add("iOS");
        arrayCourse.add("Unity");

        adapter = new ArrayAdapter<>(MainActivityLab3Screen2.this,
                android.R.layout.simple_list_item_1,arrayCourse);
        lvMonHoc.setAdapter(adapter);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String monhoc = editText.getText().toString();
                arrayCourse.add(monhoc);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivityLab3Screen2.this, monhoc, Toast.LENGTH_SHORT).show();
            }
        });

        lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = arrayCourse.get(position);
                editText.setText(text);
                selectedTextIndex = position;
                Toast.makeText(MainActivityLab3Screen2.this,"Selected: "+text, Toast.LENGTH_SHORT).show();
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String monhoc = editText.getText().toString();
                arrayCourse.set(selectedTextIndex,monhoc);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivityLab3Screen2.this, monhoc, Toast.LENGTH_SHORT).show();
            }
        });
        lvMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                arrayCourse.remove(position);
                selectedTextIndex = -1;
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}