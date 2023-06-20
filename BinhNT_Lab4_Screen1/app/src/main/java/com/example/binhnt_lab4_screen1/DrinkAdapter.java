package com.example.binhnt_lab4_screen1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class DrinkAdapter extends BaseAdapter {
    private AppCompatActivity context;
    private List<Drink> drinkList;
    private int layout;

    public DrinkAdapter(AppCompatActivity context, int layout, List<Drink> drinkList) {
        this.drinkList = drinkList;
        this.context = context;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return drinkList.size();
    }

    @Override
    public Object getItem(int position) {
        return drinkList.get(position);
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

        Drink drink = drinkList.get(i);

        img.setImageResource(drink.getImg());
        tvName.setText(drink.getName());
        tvDesc.setText(drink.getDesc());
        tvCalo.setText(drink.getCalogies()+"lbs");

        return view;
    }
}
