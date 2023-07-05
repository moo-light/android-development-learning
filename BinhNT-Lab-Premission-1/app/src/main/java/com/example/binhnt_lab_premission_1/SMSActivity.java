package com.example.binhnt_lab_premission_1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SMSActivity extends AppCompatActivity {
    private static final int REQUEST_PERMISSION_CODE = 10;
    private Button btnReq;
    private Button btnSendSMS;
    private EditText etPhone;
    private EditText etMessage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen_4);
        btnReq = (Button) findViewById(R.id.btnReq);
        btnSendSMS = (Button) findViewById(R.id.btnSendSMS);
        etPhone = (EditText) findViewById(R.id.etPhone);
        etMessage = (EditText) findViewById(R.id.etMessage);

        btnReq.setOnClickListener(v -> request(btnReq));
        btnSendSMS.setOnClickListener(v -> sendSMS(btnSendSMS, etPhone.getText().toString(), etMessage.getText().toString()));
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

    private void sendSMS(Button btnSendSMS, String phone, String message) {
        phone = String.format("smsto: %s", phone);
        // Create the intent.
        Intent smsIntent = new Intent(Intent.ACTION_SENDTO);
// Set the data for the intent as the phone number.
        smsIntent.setData(Uri.parse(phone));
        // Add the message (sms) with the key ("sms_body").
        smsIntent.putExtra("sms_body", message);
        if (smsIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(smsIntent);
        } else {
            Log.e(this.getLocalClassName(), "Can't resolve app for ACTION_SENDTO Intent");
        }
    }

    private void request(Button btnReq) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return;
        }

        if (checkSelfPermission(Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Premission Granted", Toast.LENGTH_SHORT).show();
        } else {
            String permissions = (Manifest.permission.SEND_SMS);

            requestPermissions(new String[]{permissions}, REQUEST_PERMISSION_CODE);
        }
    }
}
