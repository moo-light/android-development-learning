package com.moolight.demo_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    ListView lvMonHoc;
    Button btnAdd;
    EditText editText;
    ArrayList<String> arrayCourse;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editText = findViewById(R.id.editText);
        btnAdd = findViewById(R.id.button);
        lvMonHoc = findViewById(R.id.lvList);

        arrayCourse = new ArrayList<>();
        adapter = new ArrayAdapter<>(MainActivity2.this,
                android.R.layout.simple_list_item_1,arrayCourse);
        lvMonHoc.setAdapter(adapter);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String monhoc = editText.getText().toString();
                arrayCourse.add(monhoc);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity2.this, monhoc, Toast.LENGTH_SHORT).show();
            }
        });
    }
}