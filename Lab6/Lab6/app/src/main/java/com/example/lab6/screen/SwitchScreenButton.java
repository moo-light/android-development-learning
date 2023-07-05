package com.example.lab6.screen;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.ButtonBarLayout;

public class SwitchScreenButton extends AppCompatButton implements View.OnClickListener {

    private final Class screen;
    private final Context context;

    public SwitchScreenButton(@NonNull Context context, String text, Class screen) {
        super(context);
        this.context = context;
        this.screen = screen;
        this.setText(text);
        this.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        this.setLayoutParams(layoutParams);
        this. context.getTheme();
    }
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(context, screen);
        context.startActivity(intent);
    }
}
