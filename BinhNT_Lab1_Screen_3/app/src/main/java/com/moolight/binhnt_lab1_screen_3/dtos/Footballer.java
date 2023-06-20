package com.moolight.binhnt_lab1_screen_3.dtos;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Footballer implements Serializable {
    private Integer imgPlayer;
    private Integer imgFlag;
    private String name;
    private String desc;
    private Uri imgPlayerUrl;
    private Uri imgFlagUrl;

    public Footballer() {
    }

    public Footballer(int imgPlayer,int imgFlag, String name, String desc) {
        this.imgPlayer = imgPlayer;
        this.imgFlag= imgFlag;
        this.name = name;
        this.desc = desc;
    }

    public Integer getImgPlayer() {
        return imgPlayer;
    }

    public void setImgPlayer(Integer imgPlayer) {
        this.imgPlayer = imgPlayer;
    }

    public Integer getImgFlag() {
        return imgFlag;
    }

    public void setImgFlag(Integer imgFlag) {
        this.imgFlag = imgFlag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Uri getImgPlayerUrl() {
        return imgPlayerUrl;
    }

    public void setImgPlayerUrl(Uri imgPlayerUrl) {
        this.imgPlayerUrl = imgPlayerUrl;
    }

    public Uri getImgFlagUrl() {
        return imgFlagUrl;
    }

    public void setImgFlagUrl(Uri imgFlagUrl) {
        this.imgFlagUrl = imgFlagUrl;
    }

    public Bitmap getBitmap(Context context, @NonNull Uri uri) {
        try {
            return MediaStore.Images.Media.getBitmap(context.getContentResolver(), uri);
        } catch (Exception e) {
            Log.e(this.getClass().getName(), e.toString());
        }
        return null;
    }
}
