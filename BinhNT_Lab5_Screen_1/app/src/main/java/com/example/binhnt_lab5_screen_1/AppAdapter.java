package com.example.binhnt_lab5_screen_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AppAdapter extends RecyclerView.Adapter<AppAdapter.ViewHolder> {

    private ArrayList<App> appList;

    public AppAdapter(ArrayList<App> appList) {
        this.appList = appList;
    }

    @NonNull
    @Override
    public AppAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        //inflate the layout
        View view = layoutInflater.inflate(R.layout.app_layout, parent, false);
        AppAdapter.ViewHolder viewHolder = new AppAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AppAdapter.ViewHolder holder, int position) {
        App app = appList.get(position);

        holder.tvName.setText(app.getName());
        holder.tvDescription.setText(app.getDescription());
        holder.tvType.setText(app.getName());
        holder.imgView.setImageResource(app.getImageId());
    }


    @Override
    public int getItemCount() {
        return appList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName, tvDescription, tvType;
        public ImageView imgView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName =  itemView.findViewById(R.id.tvName);
            tvDescription =  itemView.findViewById(R.id.tvDescription);
            tvType =  itemView.findViewById(R.id.tvType);
            imgView =  itemView.findViewById(R.id.imgView);
        }
    }

}
