package com.moolight.binhnt_lab1_screen_3.binhnt_lab3_screen_3;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.moolight.binhnt_lab1_screen_3.R;
import com.moolight.binhnt_lab1_screen_3.Adapter.CakeAdapterLab3Screen3;
import com.moolight.binhnt_lab1_screen_3.dtos.Cake;

import java.util.ArrayList;

public class MainActivityLab3Screen3 extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    private static final int REQUEST_CODE_FOR_SOURCE = 1;
    ArrayList<Cake> cakeList;
    ListView lvCake;
    Button btnCreate;
    BaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_l3_screen3);
        AnhXa();
        adapter = new CakeAdapterLab3Screen3(this, R.layout.cake_layout_l3_screen3, cakeList);
        lvCake.setAdapter(adapter);
        lvCake.setOnItemClickListener(this);
        lvCake.setOnItemLongClickListener(this);

        btnCreate.setOnClickListener(v -> {
            Intent intent = new Intent(this, CakeDisplayActivityLab3Screen3.class);
            intent.putExtra("position", -1);
            startActivityForResult(intent, 2);
        });
    }

    private void AnhXa() {
        lvCake = findViewById(R.id.lvFootballer);
        btnCreate = findViewById(R.id.btnCreate);
        cakeList = new ArrayList<>();
        cakeList.add(new Cake(R.drawable.img1, "Yellow Butter Cake", "A classic cake made with butter, sugar, eggs, flour, and baking powder. It’s a simple cake that’s perfect for any occasion."));
        cakeList.add(new Cake(R.drawable.img2, "Pound Cake", "A dense cake made with butter, sugar, eggs, and flour. It’s called pound cake because it originally called for a pound of each ingredient."));
        cakeList.add(new Cake(R.drawable.img3, "Red Velvet Cake", "A cake made with cocoa powder and red food coloring. It’s often topped with cream cheese frosting."));
        cakeList.add(new Cake(R.drawable.img4, "Black Forest Cake", "A chocolate sponge cake layered with whipped cream and cherries."));
        cakeList.add(new Cake(R.drawable.img5, "Funfetti Cake", "A vanilla cake filled with rainbow sprinkles. It’s often topped with vanilla frosting and more sprinkles."));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(
                        new String[]{
                                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                Manifest.permission.ACCESS_COARSE_LOCATION,
                                Manifest.permission.ACCESS_FINE_LOCATION,
                                Manifest.permission.INTERNET}, REQUEST_CODE_FOR_SOURCE);
            }
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(
                        new String[]{
                                Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_CODE_FOR_SOURCE);
            }
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(
                        new String[]{
                                Manifest.permission.CAMERA}, REQUEST_CODE_FOR_SOURCE);
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Cake cake = cakeList.get(position);
        Intent intent = new Intent(this, CakeDisplayActivityLab3Screen3.class);
        intent.putExtra("position", position);
        intent.putExtra("name", cake.getName());
        intent.putExtra("desc", cake.getDesc());
        intent.putExtra("img", cake.getImg());
        intent.putExtra("img_url", cake.getImgUrl());
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);

        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode == Activity.RESULT_OK) {
            Cake cake = null;
            if (requestCode == 1) {
                int value = intent.getIntExtra("position", -1);
                if (value == -1) return;
                cake = cakeList.get(value);
            }

            if (requestCode == 2) {
                cake = new Cake();
            }

            // Handle the Intent
            cake.setName(intent.getStringExtra("name"));
            cake.setDesc(intent.getStringExtra("desc"));
            cake.setImg(intent.getIntExtra("img", -1));
            //Check if img is machine or user Input
            if (cake.getImg() == -1) {
                cake.setImgUrl((Uri) intent.getParcelableExtra("img_url"));
            }
            // add cake
            if (requestCode == 2) cakeList.add(cake);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i(this.getClass().getName(), "Removing " + position);

        Cake cake = cakeList.get(position);
        try {
            cakeList.remove(cake);
            adapter.notifyDataSetChanged();
        } catch (Exception e) {
            Log.e(this.getClass().getName(), e.toString());
        }
        return true;
    }
}
