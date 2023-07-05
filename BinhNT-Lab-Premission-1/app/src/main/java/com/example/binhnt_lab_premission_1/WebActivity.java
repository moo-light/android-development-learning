package com.example.binhnt_lab_premission_1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class WebActivity extends AppCompatActivity {
    private static final int REQUEST_PERMISSION_CODE = 10;
    private Button btnReq;
    private Button btnOpenWeb;
    private Button btnIntentWeb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen_3);
        btnReq = (Button) findViewById(R.id.btnReq);
        btnOpenWeb = (Button) findViewById(R.id.btnOpenWeb);
        btnIntentWeb = (Button) findViewById(R.id.btnIntentWeb);
        btnReq.setOnClickListener(v -> request(btnReq));
        btnOpenWeb.setOnClickListener(v -> browseWeb(btnOpenWeb));
        btnIntentWeb.setOnClickListener(v -> intentWeb(btnIntentWeb));
    }

    private void intentWeb(Button btnIntentWeb) {
        Intent viewIntent = new Intent(this, WebViewActivity.class);
        startActivity(viewIntent);
    }

    private void browseWeb(Button btnSetting) {
        Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.stackoverflow.com/"));
        startActivity(viewIntent);
    }

    private void request(Button btnReq) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return;
        }

        if (checkSelfPermission(Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Premission Granted", Toast.LENGTH_SHORT).show();
        } else {
            String permissions = (Manifest.permission.INTERNET);

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
}
