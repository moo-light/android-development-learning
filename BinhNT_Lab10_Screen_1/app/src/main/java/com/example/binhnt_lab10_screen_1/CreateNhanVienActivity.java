package com.example.binhnt_lab10_screen_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateNhanVienActivity extends AppCompatActivity {
    EditText etName,etEmail,etPhone,etGender;
    Button btnSave;
    private TraineeService traineeService;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        etName = findViewById(R.id.etName);
        etGender = findViewById(R.id.etGender);
        btnSave = findViewById(R.id.btnSave);
        textView = findViewById(R.id.textView5);
        textView.setText("Tạo Nhân Viên");

        traineeService = TraineeRepositoy.getTraineeService();
        btnSave.setOnClickListener(v-> save());

    }
    private void save(){
        String name = etName.getText().toString();
        String phone = etPhone.getText().toString();
        String email = etEmail.getText().toString();
        String gender = etGender.getText().toString();
        Log.i("gender",gender);
        Trainee trainee = new Trainee(name,email,phone,gender);
        try{
            Call<Trainee> call = traineeService.createTrainee(trainee);
            call.enqueue(new Callback<Trainee>() {
                @Override
                public void onResponse(Call<Trainee> call, Response<Trainee> response) {
                    if(response.body() != null){
                        Toast.makeText(CreateNhanVienActivity.this,"Save Successfully",Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<Trainee> call, Throwable t) {
                    Toast.makeText(CreateNhanVienActivity.this,"Save Failed!",Toast.LENGTH_LONG).show();

                }
            });
        }catch (Exception e){
            Log.e("Loi",e.toString());
        }
        setResult(RESULT_OK);
        finish();
    }
}