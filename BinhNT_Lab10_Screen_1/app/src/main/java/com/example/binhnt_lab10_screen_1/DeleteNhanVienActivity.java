package com.example.binhnt_lab10_screen_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeleteNhanVienActivity extends AppCompatActivity {
    Button btnYes,btnNo;
    private TraineeService service;
    private Trainee trainee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_nhan_vien);
        btnYes = findViewById(R.id.btnYes);
        btnNo = findViewById(R.id.btnNo);
        trainee =(Trainee) this.getIntent().getExtras().getSerializable("trainee");
        if(trainee == null){
            Toast.makeText(this, "Trainee is null", Toast.LENGTH_SHORT).show();
            finish();
        }
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                service = TraineeRepositoy.getTraineeService();
                try{
                    Call<Trainee> call = service.removeTrainee(trainee.getId());
                    call.enqueue(new Callback<Trainee>() {
                        @Override
                        public void onResponse(Call<Trainee> call, Response<Trainee> response) {
                            Toast.makeText(DeleteNhanVienActivity.this, "Delete Success", Toast.LENGTH_SHORT).show();
                            setResult(RESULT_OK);
                            finish();
                        }

                        @Override
                        public void onFailure(Call<Trainee> call, Throwable t) {
                            Toast.makeText(DeleteNhanVienActivity.this, "Delete Failed", Toast.LENGTH_SHORT).show();

                        }
                    });
                }catch (Exception e){
                    Log.e(DeleteNhanVienActivity.class.getName(),e.toString());
                }
            }
        });
        btnNo.setOnClickListener(v->{
            Toast.makeText(DeleteNhanVienActivity.this, "Canceled", Toast.LENGTH_SHORT).show();
            setResult(RESULT_CANCELED);
            finish();
        });
    }
}