package com.example.lab6;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;

public class PopupActivity extends AppCompatActivity {
    Button btnPopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popupmenu);
        btnPopup = (Button) findViewById(R.id.btnPopupMenu);
        btnPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMenu();
            }
        });
    }

    public void showMenu() {
        PopupMenu popupMenu = new PopupMenu(this, btnPopup);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.itemAdd) {
                    btnPopup.setText("Menu thêm");
                }
                if (menuItem.getItemId() == R.id.itemEdit) {
                    btnPopup.setText("Menu Sửa");
                }
                if (menuItem.getItemId() == R.id.itemDel) {
                    btnPopup.setText("Menu Xóa");
                }
                return false;
            }
        });
        popupMenu.show();
    }
}
