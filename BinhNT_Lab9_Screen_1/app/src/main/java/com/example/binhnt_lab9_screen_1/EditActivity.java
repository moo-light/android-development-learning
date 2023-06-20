package com.example.binhnt_lab9_screen_1;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

public class EditActivity extends AppCompatActivity {

    EditText etDisplay;
    TextView textView;
    Button btnSave, btnCancel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adapter_item_edit);
        Intent intent = this.getIntent();
        int requestCode = intent.getIntExtra("request", -1);
        CongViec cv = (CongViec) intent.getExtras().get("item");
        etDisplay = findViewById(R.id.etDisplay);
        textView = findViewById(R.id.tvId);
        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(v -> {
            setResult(RESULT_CANCELED);
            finish();
        });
        if (cv == null && requestCode == 3) {
            cv = new CongViec();
            textView.setText("Thêm Công Việc");

        } else {
            etDisplay.setText(cv.getTenCV());
            textView.setText("Sửa Công Việc");
        }
        if (requestCode == 1 || requestCode == 3) {
            etDisplay.setVisibility(View.VISIBLE);
            CongViec finalCv = cv;
            btnSave.setOnClickListener(v -> {
                Intent result = new Intent();
                finalCv.setTenCV(etDisplay.getText().toString());
                result.putExtra("item", (Serializable) finalCv);
                setResult(RESULT_OK, result);
                finish();
            });
        } else if (requestCode == 2) {
            btnSave.setText("Delete");
            textView.setText("Xoá Công Việc?");
            etDisplay.setVisibility(View.INVISIBLE);

            CongViec finalCv = cv;
            btnSave.setOnClickListener(view -> {
                Intent result = new Intent();
                result.putExtra("item", (Serializable) finalCv);
                setResult(RESULT_OK, result);
                finish();
            });
        }
    }
}
