package com.moolight.binhnt_lab1_screen_3.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.moolight.binhnt_lab1_screen_3.R;
import com.moolight.binhnt_lab1_screen_3.dtos.Cake;

import java.util.ArrayList;

public class CakeAdapterLab3Screen3 extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Cake> cakeList;

    public CakeAdapterLab3Screen3(Context context, int layout, ArrayList<Cake> cakeList) {
        this.context = context;
        this.layout = layout;
        this.cakeList = cakeList;
    }

    @Override
    public int getCount() {
        return cakeList.size();
    }

    @Override
    public Object getItem(int position) {
        return cakeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup grView) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);

        TextView txtName = view.findViewById(R.id.tvName);
        TextView txtDesc = view.findViewById(R.id.etDesc);
        ImageView img = view.findViewById(R.id.img);

        Cake cake = cakeList.get(i);
        txtName.setText(cake.getName());
        txtDesc.setText(cake.getDesc());
        Integer image = cake.getImg();
        if (image != -1)
            img.setImageResource(image);
        else {
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.context.getContentResolver(), cake.getImgUrl());
                img.setImageBitmap(bitmap);
            }catch(Exception e){
                Log.e(this.getClass().getName(),e.getMessage());
            }
        }
        return view;
    }
}
