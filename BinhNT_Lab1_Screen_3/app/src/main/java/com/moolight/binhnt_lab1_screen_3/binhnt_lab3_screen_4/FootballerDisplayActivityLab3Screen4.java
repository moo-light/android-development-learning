package com.moolight.binhnt_lab1_screen_3.binhnt_lab3_screen_4;

import static android.provider.MediaStore.Images.Media.getBitmap;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.moolight.binhnt_lab1_screen_3.R;
import com.moolight.binhnt_lab1_screen_3.dtos.Footballer;


public class FootballerDisplayActivityLab3Screen4 extends AppCompatActivity implements View.OnClickListener {

    private static final int GET_PLAYER_FROM_GALLERY = 3;
    private static final int GET_FLAG_FROM_GALLERY = 4;
    private EditText etTitle, etDesc;
    private ImageView ivPlayer, ivFlag;
    private Button btnAction;
    private Intent intent;
    private Footballer footballer = null;
    private Integer position;
    private Uri uri = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_display_l3_screen4);
        AnhXa();
        btnAction.setOnClickListener(this);
        ivPlayer.setOnClickListener(this);
        ivFlag.setOnClickListener(this);

    }

    private void AnhXa() {
        intent = this.getIntent();
        ivPlayer = (ImageView) findViewById(R.id.ivPlayer);
        ivFlag = (ImageView) findViewById(R.id.ivFlag);
        etTitle = (EditText) findViewById(R.id.etTitle);
        etDesc = (EditText) findViewById(R.id.etDesc);
        btnAction = (Button) findViewById(R.id.btnAction);
        position = intent.getIntExtra("position", -1);

        if (position == -1) {
            footballer = new Footballer();
        } else {
            btnAction.setText("Save");
            getCakeData(intent);
        }
    }

    private Footballer getCakeData(Intent intent) {
        footballer = new Footballer();
        footballer.setName(intent.getStringExtra("name"));
        footballer.setDesc(intent.getStringExtra("desc"));
        footballer.setImgPlayer(intent.getIntExtra("img_player", -1));
        footballer.setImgPlayerUrl((Uri) intent.getParcelableExtra("img_player_url"));
        footballer.setImgFlag(intent.getIntExtra("img_flag", -1));
        footballer.setImgFlagUrl((Uri) intent.getParcelableExtra("img_flag_url"));
        etDesc.setText(footballer.getDesc());
        etTitle.setText(footballer.getName());
        setImageView(ivPlayer, footballer.getImgPlayer(), footballer.getImgPlayerUrl());
        setImageView(ivFlag, footballer.getImgFlag(), footballer.getImgFlagUrl());
        return footballer;
    }

    private void setImageView(ImageView imageView, int image, Uri uri) {
        if (image != -1)
            imageView.setImageResource(image);
        else {
            try {
                Bitmap bitmap = footballer.getBitmap(this, uri);
                imageView.setImageBitmap(bitmap);
            } catch (Exception e) {
                Log.e(this.getClass().getName(), e.getClass().getName() + ": " + e.getMessage());
            }
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        if (v.getId() == R.id.btnAction) {
            intent.putExtra("name", etTitle.getText().toString());
            intent.putExtra("desc", etDesc.getText().toString());
            intent.putExtra("img_player", footballer.getImgPlayer());
            intent.putExtra("img_flag", footballer.getImgFlag());
            intent.putExtra("img_player_url", footballer.getImgPlayerUrl());
            intent.putExtra("img_flag_url", footballer.getImgFlagUrl());
            //Selection section
            if (btnAction.getText().toString().equals("Create")) {
                intent.putExtra("position", -1);
            }
            if (btnAction.getText().toString().equals("Save")) {
                intent.putExtra("position", this.intent.getIntExtra("position", -1));
            }
            //finish
            setResult(RESULT_OK, intent);
            finish();
        }
        if (v.getId() == R.id.ivPlayer) {
            Intent imageIntent = new Intent(
                    Intent.ACTION_PICK,
                    MediaStore.Images.Media.INTERNAL_CONTENT_URI
            );
            imageIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            imageIntent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            startActivityForResult(imageIntent, GET_PLAYER_FROM_GALLERY);
        }
        if (v.getId() == R.id.ivFlag) {
            Intent imageIntent = new Intent(
                    Intent.ACTION_PICK,
                    MediaStore.Images.Media.INTERNAL_CONTENT_URI
            );
            imageIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            imageIntent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            startActivityForResult(imageIntent, GET_FLAG_FROM_GALLERY);
        }
        return;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            switch (requestCode) {
                case GET_PLAYER_FROM_GALLERY:
                    if (resultCode == Activity.RESULT_OK) {
                        //data gives you the image uri. Try to convert that to bitmap
                        Uri uri = data.getData();
                        Bitmap bitmap = footballer.getBitmap(this, uri);
                        ivPlayer.setImageBitmap(bitmap);
                        footballer.setImgPlayerUrl(uri);
                        footballer.setImgPlayer(null);
                    }
                    break;
                case GET_FLAG_FROM_GALLERY:
                    if (resultCode == Activity.RESULT_OK) {
                        //data gives you the image uri. Try to convert that to bitmap
                        Uri uri = data.getData();
                        Bitmap bitmap = footballer.getBitmap(this, uri);
                        ivFlag.setImageBitmap(bitmap);
                        footballer.setImgFlagUrl(uri);
                        footballer.setImgFlag(null);
                    }
                    break;
            }
        } catch (Exception e) {
            Log.e(this.getClass().getName(), "Exception in onActivityResult : " + e.getMessage());
        }

    }
}