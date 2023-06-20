package com.example.binhnt_lab5_screen_1;

import android.os.Bundle;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AppActivity extends AppCompatActivity {

    private ArrayList<App> appList;
    private AppAdapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);

        RecyclerView rvApp = findViewById(R.id.recyclerView);

        ArrayList<App> appList = new ArrayList<>();
        App soundcloud = new App("SoundCloud", "Discover and share new music", R.drawable.soundcloud, "Android");
        App community = new App("Community", "Connect with people", R.drawable.community, "iOS");
        App wifi = new App("WiFi", "Connect to wireless networks", R.drawable.wifi, "Android");
        App phone = new App("Phone", "Make and receive calls", R.drawable.phone, "iOS");
        App music = new App("Music", "Listen to your favorite songs", R.drawable.music, "Android");
        App appleTv = new App("Apple TV", "Stream TV shows and movies", R.drawable.apple_tv, "iOS");
        App photos = new App("Photos", "View and edit photos", R.drawable.photos, "Android");
        App podcast = new App("Podcast", "Listen to your favorite podcasts", R.drawable.podcast, "iOS");
        App email = new App("Email", "Manage your emails", R.drawable.email, "Android");
        App appStore = new App("App Store", "Discover and download new apps", R.drawable.app_store, "iOS");

        appList = new ArrayList<>();
        appList.add(soundcloud);
        appList.add(community);
        appList.add(wifi);
        appList.add(phone);
        appList.add(music);
        appList.add(appleTv);

        adapter = new AppAdapter(appList);
        rvApp.setAdapter(adapter);
        rvApp.setLayoutManager( new LinearLayoutManager(this));
        appList.add(photos);
        appList.add(podcast);
        appList.add(email);
        appList.add(appStore);
    }


}
