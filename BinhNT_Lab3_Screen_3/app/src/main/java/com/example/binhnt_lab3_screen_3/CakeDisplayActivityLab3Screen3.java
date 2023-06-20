package com.example.binhnt_lab3_screen_3;

import static android.provider.MediaStore.Images.Media.getBitmap;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.binhnt_lab3_screen_3.dtos.Cake;


public class CakeDisplayActivityLab3Screen3 extends AppCompatActivity implements View.OnClickListener {

    private static final int GET_FROM_GALLERY = 3;
    private EditText etTitle, etDesc;
    private ImageView imageView;
    private Button btnAction;
    private Intent intent;
    private Cake cake = null;
    private Integer selectedImageId, position;
    private Uri uri = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cake_display_l3_screen3);
        AnhXa();
        btnAction.setOnClickListener(this);
        imageView.setOnClickListener(this);
    }

    private void AnhXa() {
        intent = this.getIntent();
        imageView = (ImageView) findViewById(R.id.imageView);
        etTitle = (EditText) findViewById(R.id.etTitle);
        etDesc = (EditText) findViewById(R.id.etDesc);
        btnAction = (Button) findViewById(R.id.btnAction);
        position = intent.getIntExtra("position", -1);

        if (position == -1) {
            cake = new Cake();
        } else {
            btnAction.setText("Save");
            cake = getCakeData(intent);
        }
    }

    private Cake getCakeData(Intent intent) {
        Cake cake = new Cake();
        cake.setName(intent.getStringExtra("name"));
        cake.setDesc(intent.getStringExtra("desc"));
        cake.setImg(intent.getIntExtra("img", -1));
        cake.setImgUrl((Uri) intent.getParcelableExtra("img_url"));
        selectedImageId = cake.getImg();
        etDesc.setText(cake.getDesc());
        etTitle.setText(cake.getName());
        if(cake.getImg()!=-1)
        imageView.setImageResource(cake.getImg());
        else{
            try {
                Bitmap bitmap = cake.getBitmap(this);
                imageView.setImageBitmap(bitmap);
            }catch (Exception e){
                Log.e(this.getClass().getName(),e.getClass().getName()+": " +e.getMessage());
            }
        }
        return cake;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        if (v.getId() == R.id.btnAction) {
            if (btnAction.getText().toString().equals("Create")) {
                createNew(intent);
            }
            if (btnAction.getText().toString().equals("Save")) {
                updateNew(intent);
            }
        }
        if (v.getId() == R.id.imageView) {
            Intent imageIntent = new Intent(
                    Intent.ACTION_PICK,
                    android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI
            );
            startActivityForResult(imageIntent,GET_FROM_GALLERY);
        }
        return;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            switch (requestCode) {

                case GET_FROM_GALLERY:
                    if (resultCode == Activity.RESULT_OK) {
                        //data gives you the image uri. Try to convert that to bitmap
                        Uri uri = data.getData();
                        Bitmap bitmap = null;
                        try {
                            bitmap = getBitmap(this.getContentResolver(), uri);
                            imageView.setImageBitmap(bitmap);
                            cake.setImgUrl(uri);
                            selectedImageId = null;
                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        break;
                    } else if (resultCode == Activity.RESULT_CANCELED) {
                        Log.e(this.getClass().getName(), "Selecting picture cancelled");
                    }
                    break;
            }
        } catch (Exception e) {
            Log.e(this.getClass().getName(), "Exception in onActivityResult : " + e.getMessage());
        }

    }

    private void updateNew(Intent intent) {
        intent.putExtra("name", etTitle.getText().toString());
        intent.putExtra("desc", etDesc.getText().toString());
        intent.putExtra("img", selectedImageId);
        intent.putExtra("img_url",cake.getImgUrl());
        intent.putExtra("position", this.intent.getIntExtra("position", -1));
        setResult(RESULT_OK, intent);
        intent.getExtras().get("img_url");
        finish();
    }

    private void createNew(Intent intent) {
        intent.putExtra("name", etTitle.getText().toString());
        intent.putExtra("desc", etDesc.getText().toString());
        intent.putExtra("img", selectedImageId);
        intent.putExtra("img_url",cake.getImgUrl());
        intent.putExtra("position", -1);
        setResult(RESULT_OK, intent);
        finish();
    }
}