package com.example.binhnt_lab10_screen_1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;

public class NhanVienAdapter extends RecyclerView.Adapter<NhanVienAdapter.ViewHolder>{
    public NhanVienAdapter(ArrayList<Trainee> trainees, AppCompatActivity context) {
        this.trainees = trainees;
        this.context = context;
    }

    ArrayList<Trainee> trainees;
    AppCompatActivity context;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.layout_nhanvien, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Trainee nhanVien = trainees.get(position);

        holder.tvEmail.setText("Email: "+nhanVien.getEmail());
        holder.tvName.setText("Name: "+nhanVien.getName());
        holder.tvPhone.setText("Phone: "+nhanVien.getPhone());
        holder.tvGender.setText("Gender: "+nhanVien.getGender());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if(isLongClick) {
                    Toast.makeText(context, "Long Click: " + trainees.get(position), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context,DeleteNhanVienActivity.class);
                    Trainee nhanVien = trainees.get(position);
                    intent.putExtra("trainee",(Serializable) nhanVien);
                    context.startActivityForResult(intent,Constants.REQUEST_DELETE);
                }else {
                    Toast.makeText(context, " " + trainees.get(position), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context,EditNhanVienActivity.class);
                    Trainee nhanVien = trainees.get(position);
                    intent.putExtra("trainee",(Serializable) nhanVien);
                    context.startActivityForResult(intent,Constants.REQUEST_EDIT);
                }}
        });
    }

    @Override
    public int getItemCount() {
        return trainees.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        TextView tvName, tvEmail, tvPhone, tvGender;
        private ItemClickListener itemClickListener;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvPhone = itemView.findViewById(R.id.tvPhone);
            tvName = itemView.findViewById(R.id.tvName);
            tvGender = itemView.findViewById(R.id.tvGender);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }
        //Tạo setter cho biến itemClickListenenr
        public void setItemClickListener(ItemClickListener itemClickListener)
        {
            this.itemClickListener = itemClickListener;
        }
        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition(),false); // Gọi interface , false là vì đây là onClick
        }

        @Override
        public boolean onLongClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition(),true); // Gọi interface , true là vì đây là onLongClick
            return true;
        }
    }
}
