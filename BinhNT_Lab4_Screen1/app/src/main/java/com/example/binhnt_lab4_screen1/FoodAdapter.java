package com.example.binhnt_lab4_screen1;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class FoodAdapter extends BaseAdapter {
    private AppCompatActivity context;
    private List<Food> foodList;
    private int layout;

    public FoodAdapter( AppCompatActivity context, int layout,List<Food> foodList) {
        this.foodList = foodList;
        this.context = context;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return foodList.size();
    }

    @Override
    public Object getItem(int position) {
        return foodList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);

        ImageView img = view.findViewById(R.id.imageView);
        TextView tvName = view.findViewById(R.id.tvTitle);
        TextView tvDesc = view.findViewById(R.id.tvDesc);
        TextView tvCalo = view.findViewById(R.id.tvCalories);

        Food food = foodList.get(i);

        img.setImageResource(food.getImg());
        tvName.setText(food.getName());
        tvDesc.setText(food.getDesc());
        tvCalo.setText(food.getCalogies()+"lbs");

        return view;
    }
}
