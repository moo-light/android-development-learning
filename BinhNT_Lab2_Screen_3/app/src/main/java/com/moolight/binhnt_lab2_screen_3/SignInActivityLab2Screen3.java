package com.moolight.binhnt_lab2_screen_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignInActivityLab2Screen3 extends AppCompatActivity implements View.OnClickListener {
    private static final String REQUIRE = "Required";
    EditText etUsername;
    EditText etPassword;
    TextView tvNoAcount;
    Button btnSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_l2_screen3);

        // Reference from Layout

        etUsername = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);
        tvNoAcount = findViewById(R.id.tvNotAccount);
        btnSignIn = findViewById(R.id.btnSignIn);

        // Register event
        tvNoAcount.setOnClickListener(this);
        btnSignIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int vId = v.getId();
        if(vId == R.id.btnSignIn){
            signIn();
        }
        if(vId == R.id.tvNotAccount){
            signUpForm();
        }
    }

    private void signUpForm() {
        Intent intent = new Intent(this, SignUpActivityLab2Screen3.class);
        startActivity(intent);
        finish();
    }
    private boolean checkInput() {
        // Username
        if (TextUtils.isEmpty(etUsername.getText().toString())) {
            etUsername.setError(REQUIRE);
            return false;
        }
        // Password
        if (TextUtils.isEmpty(etPassword.getText().toString())) {
            etPassword.setError(REQUIRE);
            return false;
        }
        // VaLid
        return true;
    }
    private void signIn() {
        if(checkInput()==false){
            return;
        }

        Intent intent = new Intent(this, MainActivityLab2Screen3.class);
        startActivity(intent);
        finish();
    }
}