package com.example.binhnt_lab9_screen_1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivityL9S2 extends AppCompatActivity {

    private Database db;
    private List<CongViec> cvList;
    private RecyclerView rv;
    private ImageView btnAdd;
    private ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_l9_s2);

        db = new Database(this, "Ghichu.sqllite", null, 1);
        db.queryData("Create table if not exists CongViec(id Integer primary key Autoincrement," +
                " TenCV nvarchar(200))");
        cvList = new ArrayList<>();
        Cursor dataCongViec = db.GetData("select * from CongViec");
        while (dataCongViec.moveToNext()) {
            String ten = dataCongViec.getString(1);
            int id = dataCongViec.getInt(0);
            cvList.add(new CongViec(ten, id));
            Toast.makeText(this, ten, Toast.LENGTH_SHORT).show();
        }
        rv = (RecyclerView) findViewById(R.id.rv);
        adapter = new ItemAdapter(this, cvList);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

        btnAdd = findViewById(R.id.ivAdd);
        btnAdd.setOnClickListener(v -> {
            Intent intent = new Intent(this, EditActivity.class);
            intent.putExtra("request", 3);
            startActivityForResult(intent, 3);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK) return;
        CongViec cv = (CongViec) data.getExtras().get("item");

        if (requestCode == 1) {
            db.queryData("Update CongViec Set TenCV = '" + cv.getTenCV() + "' where id = " + cv.getIdCV());
            Toast.makeText(this,"Updated "+cv.getIdCV(),Toast.LENGTH_SHORT).show();
        }
        if (requestCode == 2) {
            db.queryData("DELETE FROM CongViec WHERE id = " + cv.getIdCV());
            Toast.makeText(this,"Deleted "+cv.getIdCV(),Toast.LENGTH_SHORT).show();
        }
        if (requestCode == 3) {
            db.queryData("insert into CongViec values(null,'" + cv.getTenCV() + "')");
            Toast.makeText(this,"Created "+cv.getTenCV(),Toast.LENGTH_SHORT).show();
        }
        cvList.clear();
        Cursor dataCongViec = db.GetData("select * from CongViec");
        while (dataCongViec.moveToNext()) {
            String ten = dataCongViec.getString(1);
            int id = dataCongViec.getInt(0);
            cvList.add(new CongViec(ten, id));
            Toast.makeText(this, ten, Toast.LENGTH_SHORT).show();
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }
}