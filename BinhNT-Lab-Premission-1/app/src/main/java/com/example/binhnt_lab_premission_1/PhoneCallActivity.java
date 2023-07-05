package com.example.binhnt_lab_premission_1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PhoneCallActivity extends AppCompatActivity {
    private static final int REQUEST_PERMISSION_CODE = 10;
    Button btnReq, btnSetting;
    private EditText etPhone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen_2);

        btnReq = (Button) findViewById(R.id.btnReq);
        btnSetting = (Button) findViewById(R.id.btnPhone);
        etPhone = (EditText) findViewById(R.id.etPhone);

        btnReq.setOnClickListener(v -> request(btnReq));
        btnSetting.setOnClickListener(v -> makeCall(btnSetting));
    }



    private void request(Button btnReq) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return;
        }

        if (checkSelfPermission(Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Premission Granted", Toast.LENGTH_SHORT).show();
        } else {
            String permissions = (Manifest.permission.CALL_PHONE);

            requestPermissions(new String[]{permissions}, REQUEST_PERMISSION_CODE);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
        }
    }
    private void makeCall(Button btnSetting) {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + etPhone.getText().toString()));
        startActivity(intent);
    }
}
