package com.moolight.binhnt_lab1_screen_3.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.moolight.binhnt_lab1_screen_3.R;
import com.moolight.binhnt_lab1_screen_3.dtos.Footballer;

import java.util.ArrayList;

public class FootballerAdapterLab3Screen4 extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Footballer> footballers;

    public FootballerAdapterLab3Screen4(Context context, int layout, ArrayList<Footballer> footballers) {
        this.context = context;
        this.layout = layout;
        this.footballers = footballers;
    }

    @Override
    public int getCount() {
        return footballers.size();
    }

    @Override
    public Object getItem(int position) {
        return footballers.get(position);
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
        ImageView imgPlayer = view.findViewById(R.id.imgPlayer);
        ImageView imgFlag = view.findViewById(R.id.imgFlag);

        Footballer footballer = footballers.get(i);
        txtName.setText(footballer.getName());
        txtDesc.setText(footballer.getDesc());
        setImageView(imgPlayer, footballer.getImgPlayer(),footballer.getImgPlayerUrl());
        setImageView(imgFlag, footballer.getImgFlag(),footballer.getImgFlagUrl());

        return view;
    }

    private void setImageView(ImageView imageView, Integer image, Uri uri) {
        if (image != -1)
            imageView.setImageResource(image);
        else {
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.context.getContentResolver(), uri);
                imageView.setImageBitmap(bitmap);
            }catch(Exception e){
                Log.e(this.getClass().getName(),e.getMessage());
            }
        }
    }
}
