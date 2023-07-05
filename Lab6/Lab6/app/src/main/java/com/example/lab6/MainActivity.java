package com.example.lab6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.FragmentManager;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener, CommentDialog.ExampleDialogListener, DemoDialog.DemoListener {
    Button btnComment,btnGoodbye,btnDone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnComment = findViewById(R.id.btnComment);
        btnGoodbye = findViewById(R.id.btnGoodBye);
        btnDone = findViewById(R.id.btnDone);

        btnComment.setOnClickListener(this);
        btnGoodbye.setOnClickListener(this);
        btnDone.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnComment) {
            AppCompatDialogFragment commentDialog = CommentDialog.newInstance();
            commentDialog.show(getSupportFragmentManager(),commentDialog.getClass().getName());
        }else if(view.getId() == R.id.btnGoodBye){
            Toast.makeText(this, "good bye", Toast.LENGTH_SHORT).show();
        }else if(view.getId() == R.id.btnDone){
            AppCompatDialogFragment demoDialog =  DemoDialog.newInstance();
            demoDialog.show(getSupportFragmentManager(),"deoDIalog");
        }
    }
    @Override
    public void addComment(String comment) {
        Toast.makeText(this, "Comment: "+ comment, Toast.LENGTH_SHORT).show();
    }
    TextView result  = null;

    @Override
    public void select(String selectedItem, int selectedIndex) {
        if(result == null) result = findViewById(R.id.result);
        if(selectedIndex < 0) {
            Toast.makeText(this, "You Havent select anything", Toast.LENGTH_SHORT).show();
            return;
        }
        result.setText(selectedIndex +" "+ selectedItem);
        Toast.makeText(this, "Selected", Toast.LENGTH_SHORT).show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
         super.onCreateOptionsMenu(menu);
         return  true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.mtnExit){
            finishAffinity();
        }
        return super.onOptionsItemSelected(item);
    }



}