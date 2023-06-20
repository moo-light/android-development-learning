package com.example.binhnt_lab3_screen_3.dtos;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Cake implements Serializable {
    private Integer img;
    private String name;
    private String desc;
    private String imgUrl;

    public Cake() {
    }

    public Cake(int img, String name, String desc) {
        this.img = img;
        this.name = name;
        this.desc = desc;
    }

    public Uri getImgUrl() {
        if(imgUrl == null ) return null;
        return Uri.parse(imgUrl);
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setImgUrl(Uri uri) {
        if(uri== null) return;
        this.imgUrl = uri.toString();
    }

    public Integer getImg() {
        return img;
    }

    public void setImg(Integer img) {
        this.img = img;
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

    public Bitmap getBitmap(Context context) {
        try {
            return MediaStore.Images.Media.getBitmap(context.getContentResolver(), this.getImgUrl());
        } catch (Exception e) {
            Log.e(this.getClass().getName(), e.toString());
        }
        return null;
    }
}
