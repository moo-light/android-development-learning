package com.example.binhnt_lab5_screen_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class UserActivity extends AppCompatActivity {

    private ArrayList<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);

        RecyclerView rvUser = findViewById(R.id.recyclerView);
        userList = new ArrayList<User>();
        userList.add(new User("NguyenTT", "Tran Thanh Nguyen", "Nguyentt@fpt.edu.vn"));
        userList.add(new User("TranVanA", "A Tran Van", "atranvan@gmail.com"));
        userList.add(new User("LeThiB", "B Le Thi", "lethib@yahoo.com"));
        userList.add(new User("PhamVanC", "C Pham Van", "phamvanc@outlook.com"));
        userList.add(new User("VoThiD", "D Vo Thi", "vothid@gmail.com"));
        userList.add(new User("HoangVanE", "E Hoang Van", "hoangvane@yahoo.com"));
        userList.add(new User("JohnSmith","John Smith","john.smith123@gmail.com"));
        userList.add(new User("EmilyNguyen","Emily Nguyen","emily.nguyen456@hotmail.com"));
        userList.add(new User("DavidKim","David Kim","davidkim357@yahoo.com"));
        userList.add(new User("SophiaWang","Sophia Wang","sophia.wang888@gmail.com"));
        userList.add(new User("AlexLee","Alex Lee","alexlee789@outlook.com"));
        userList.add(new User("IsabellaGarcia","Isabella Garcia","isabella.garcia555@yahoo.com"));
        userList.add(new User("WilliamBrown","William Brown","williambrown123@gmail.com"));
        userList.add(new User("AvaChen","Ava Chen","avachen789@hotmail.com"));
        userList.add(new User("DanielNguyen","Daniel Nguyen","danielnguyen222@yahoo.com"));
        userList.add(new User("HannahKim","Hannah Kim","hannahkim555@gmail.com"));
        UserAdapter adapter= new UserAdapter(userList);
        rvUser.setAdapter(adapter);
        rvUser.setLayoutManager( new LinearLayoutManager(this));
    }
}