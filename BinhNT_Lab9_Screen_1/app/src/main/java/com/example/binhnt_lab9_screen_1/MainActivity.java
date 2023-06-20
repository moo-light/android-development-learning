package com.example.binhnt_lab9_screen_1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new Database(this, "Ghichu.sqllite", null, 1);
        db.queryData("Create table if not exists CongViec(id Integer primary key Autoincrement," +
                " TenCV nvarchar(200))");

//        db.queryData("insert into CongViec values(null,'Project Android')");
//        db.queryData("insert into CongViec values(null,'Design App')");

        Cursor dataCongViec = db.GetData("select * from CongViec");
        while (dataCongViec.moveToNext()) {
            String ten = dataCongViec.getString(1);
            Toast.makeText(this, ten, Toast.LENGTH_SHORT).show();
        }
        // Screen 2
        Button screen2 = findViewById(R.id.button2);

        screen2.setOnClickListener(c -> {
            Intent intent = new Intent(this, MainActivityL9S2.class);
            startActivityForResult(intent, 1);
            if (db != null)
                db.close();
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        db = new Database(this, "Ghichu.sqllite", null, 1);
        db.queryData("Create table if not exists CongViec(id Integer primary key Autoincrement," +
                " TenCV nvarchar(200))");
    }
}