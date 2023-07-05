package com.example.binhnt_lab10_screen_1;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditNhanVienActivity extends AppCompatActivity {
    EditText etName, etEmail, etPhone, etGender;
    Button btnSave;
    TextView textView;
    private TraineeService traineeService;
    private Trainee trainee;

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
        textView.setText("Cập Nhật Nhân Viên");

        trainee = (Trainee) this.getIntent().getExtras().getSerializable("trainee");
        etEmail.setText(trainee.getEmail());
        etName.setText(trainee.getName());
        etPhone.setText(trainee.getPhone());
        etGender.setText(trainee.getGender());

        traineeService = TraineeRepositoy.getTraineeService();
        btnSave.setOnClickListener(v -> save());

    }

    private void save() {
        int id = trainee.getId();
        String name = etName.getText().toString();
        String phone = etPhone.getText().toString();
        String email = etEmail.getText().toString();
        String gender = etGender.getText().toString();
        Log.i("gender", gender);
        Trainee trainee = new Trainee(name, email, phone, gender);
        try {
            Call<Trainee> call = traineeService.updateTrainee(id,trainee);
            call.enqueue(new Callback<Trainee>() {
                @Override
                public void onResponse(Call<Trainee> call, Response<Trainee> response) {
                    if (response.body() != null) {
                        Toast.makeText(EditNhanVienActivity.this, "Save Successfully", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<Trainee> call, Throwable t) {
                    Toast.makeText(EditNhanVienActivity.this, "Save Failed!", Toast.LENGTH_LONG).show();

                }
            });
        } catch (Exception e) {
            Log.e("Loi", e.toString());
        }
        setResult(RESULT_OK);
        finish();
    }
}