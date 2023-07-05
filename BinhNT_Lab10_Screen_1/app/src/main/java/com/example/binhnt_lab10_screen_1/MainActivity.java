package com.example.binhnt_lab10_screen_1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private NhanVienAdapter adapter;
    private TraineeService traineeService;
    private ArrayList<Trainee> traineesList;
    private RecyclerView rv;
    private Button btnCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        traineeService = TraineeRepositoy.getTraineeService();
        btnCreate = (Button) findViewById(R.id.btnCreate);
        rv = findViewById(R.id.rv);
        traineesList = new ArrayList<>();

        LoadList();
        adapter = new NhanVienAdapter(traineesList,this);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(null));
        btnCreate.setOnClickListener( v->{
            Intent intent = new Intent(this,CreateNhanVienActivity.class);
            startActivityForResult(intent,Constants.REQUEST_CREATE);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(RESULT_OK == resultCode) {

            LoadList();
        }
    }

    private void LoadList() {
        try {
            Call<Trainee[]> call = traineeService.getAllTrainees();
            call.enqueue(new Callback<Trainee[]>() {
                @Override
                public void onResponse(Call<Trainee[]> call, Response<Trainee[]> response) {
                    Trainee[] trainees = response.body();
                    traineesList.clear();
                    for (Trainee trainee : trainees) {
                        traineesList.add(trainee);
                    }
                    adapter.notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call<Trainee[]> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Load Data Failed", Toast.LENGTH_SHORT).show();
                }
            });
        }catch (Exception e){
            Log.e(this.getClass().getName(), e.toString());
        }
    }
}