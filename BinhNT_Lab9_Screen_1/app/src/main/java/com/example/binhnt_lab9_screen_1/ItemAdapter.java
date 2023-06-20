package com.example.binhnt_lab9_screen_1;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private AppCompatActivity context;
    private final List<CongViec> items;
    public ItemAdapter(AppCompatActivity context, List<CongViec> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflator = LayoutInflater.from(context);

        View view = inflator.inflate(R.layout.layout_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CongViec item = items.get(position);
        holder.tvDisplay.setText(item.getTenCV());
        holder.ivEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateItem(item);
            }
        });
        holder.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, EditActivity.class);
                intent.putExtra("item",(Serializable) item);
                intent.putExtra("request",2);
                context.startActivityForResult(intent,2);
            }
        });
    }

    private void updateItem(CongViec item) {
        Intent intent = new Intent(context, EditActivity.class);
        intent.putExtra("request", 1);
        intent.putExtra("item",(Serializable) item);
        context.startActivityForResult(intent,1);
    }
    @Override
    public int getItemCount() {
        return items.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvDisplay;
        ImageView ivEdit, ivDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDisplay = itemView.findViewById(R.id.tvDisplay);
            ivDelete = itemView.findViewById(R.id.ivDelete);
            ivEdit = itemView.findViewById(R.id.ivEdit);
        }


    }


}
