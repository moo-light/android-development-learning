package com.example.lab6;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class ChangeColorActivity extends AppCompatActivity {
    Button btnSwitchColor;
    ConstraintLayout screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colormenu);
        btnSwitchColor = (Button) findViewById(R.id.btnColor);
        screen = (ConstraintLayout) findViewById(R.id.screen);
        registerForContextMenu(btnSwitchColor);

        btnSwitchColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openContextMenu(view);
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.color_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.redMenu) {
            screen.setBackgroundColor(Color.RED);
        }
        if (item.getItemId() == R.id.YellowMenu) {
            screen.setBackgroundColor(Color.YELLOW);
        }
        if (item.getItemId() == R.id.blueMenu) {
            screen.setBackgroundColor(Color.BLUE);
        }
        return super.onContextItemSelected(item);
    }
}
