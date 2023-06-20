package com.moolight.binhnt_lab1_screen_3.binhnt_lab3_screen_4;

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

import com.moolight.binhnt_lab1_screen_3.Adapter.FootballerAdapterLab3Screen4;
import com.moolight.binhnt_lab1_screen_3.R;
import com.moolight.binhnt_lab1_screen_3.binhnt_lab3_screen_3.CakeDisplayActivityLab3Screen3;
import com.moolight.binhnt_lab1_screen_3.dtos.Cake;
import com.moolight.binhnt_lab1_screen_3.dtos.Footballer;

import java.util.ArrayList;

public class MainActivityLab3Screen4 extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    private static final int REQUEST_CODE_FOR_SOURCE = 1;
    ArrayList<Footballer> players;
    ListView lvFootballer;
    Button btnCreate;
    BaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_l3_screen3);
        AnhXa();
        adapter = new FootballerAdapterLab3Screen4(this, R.layout.player_layout_l3_screen4, players);
        lvFootballer.setAdapter(adapter);
        lvFootballer.setOnItemClickListener(this);
        lvFootballer.setOnItemLongClickListener(this);

        btnCreate.setOnClickListener(v -> {
            Intent intent = new Intent(this, FootballerDisplayActivityLab3Screen4.class);
            intent.putExtra("position", -1);
            startActivityForResult(intent, 2);
        });
    }

    private void AnhXa() {
        lvFootballer = findViewById(R.id.lvFootballer);
        btnCreate = findViewById(R.id.btnCreate);
        players = new ArrayList<>();
            String[] names = new String[]{"Rogerio Ceni", "David Luiz", "Ronaldinho", "Joey Barton", "Nicklas Bendtner"};
            String[] descs = new String[]{"Brazilian goalkeeper Rogerio Ceni is one of the few players to spend his entire career at one club. The 41-year-old custodian started his career at his beloved Sao Paolo in 1992 and has made an incredible 517 league appearances for the Tricolor.",
                    "Flamboyance can often be misconstrued as cockiness. But with Chelsea star David Luiz, that's not the case."
                    , "Ronaldinho evidently took pride in his ability to frustrate, humiliate and baffle his opponents—so much so that the current Atletico Mineiro player will unfortunately be remembered for his antics on the ball rather than for his many, many achievements in the game."
                    , "Joey Barton is unlike any other player on this list. In fact, the English midfielder is an enigma."
                    , "Arsenal striker Nicklas Bendtner is one of the most frustrating figures in world football. The Dane has immense ability, which he occasionally manages to produce, but more often than not, he is unable to showcase anything like the talent he possesses."};
        players.add(new Footballer(R.drawable.img6,R.drawable.img6f, names[0], descs[0]));
        players.add(new Footballer(R.drawable.img7,R.drawable.img7f, names[1], descs[1]));
        players.add(new Footballer(R.drawable.img8,R.drawable.img8f, names[2], descs[2]));
        players.add(new Footballer(R.drawable.img9,R.drawable.img9f, names[3], descs[3]));
        players.add(new Footballer(R.drawable.img10,R.drawable.img10f, names[4], descs[4]));

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
        Footballer footballer = players.get(position);
        Intent intent = new Intent(this, FootballerDisplayActivityLab3Screen4.class);
        intent.putExtra("position", position);
        intent.putExtra("name", footballer.getName());
        intent.putExtra("desc", footballer.getDesc());
        intent.putExtra("img_player", footballer.getImgPlayer());
        intent.putExtra("img_player_url", footballer.getImgPlayerUrl());
        intent.putExtra("img_flag", footballer.getImgFlag());
        intent.putExtra("img_flag_url", footballer.getImgFlagUrl());

        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);

        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode == Activity.RESULT_OK) {
            Footballer footballer = null;
            if (requestCode == 1) {
                int value = intent.getIntExtra("position", -1);
                if (value == -1) return;
                footballer = players.get(value);
            }

            if (requestCode == 2) {
                footballer = new Footballer();
            }

            // Handle the Intent
            footballer.setName(intent.getStringExtra("name"));
            footballer.setDesc(intent.getStringExtra("desc"));
            footballer.setImgPlayer(intent.getIntExtra("img_player", -1));
            //Check if img is machine or user Input
            if (footballer.getImgPlayer() == -1) {
                footballer.setImgPlayerUrl((Uri) intent.getParcelableExtra("img_player_url"));
            }
            footballer.setImgFlag(intent.getIntExtra("img_flag", -1));
            //Check if img is machine or user Input
            if (footballer.getImgFlag() == -1) {
                footballer.setImgFlagUrl((Uri) intent.getParcelableExtra("img_flag_url"));
            }
            // add player
            if (requestCode == 2) players.add(footballer);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i(this.getClass().getName(), "Removing " + position);

        Footballer footballer = players.get(position);
        try {
            players.remove(footballer);
            adapter.notifyDataSetChanged();
        } catch (Exception e) {
            Log.e(this.getClass().getName(), e.toString());
        }
        return true;
    }
}
