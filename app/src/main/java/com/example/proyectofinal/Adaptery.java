package com.example.proyectofinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.proyectofinal.Model.Data;

import java.util.List;

public class Adaptery extends RecyclerView.Adapter<Adaptery.MyViewHolder> {

    private Context mContext;
    private List<Data> dataList;

    public Adaptery(Context mContext, List<Data> dataList) {
        this.mContext = mContext;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        v = layoutInflater.inflate(R.layout.agent_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.nombre.setText(dataList.get(position).getDisplayName());
        holder.rol.setText(dataList.get(position).getRole().getDisplayName());
        holder.descripcion.setText(dataList.get(position).getDescription());

        Glide.with(mContext)
                .load(dataList.get(position).getDisplayIconSmall())
                .into(holder.imagen);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nombre;
        TextView rol;
        TextView descripcion;
        ImageView imagen;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nombre = itemView.findViewById(R.id.textView);
            rol = itemView.findViewById(R.id.textView2);
            descripcion = itemView.findViewById(R.id.textView3);
            imagen = itemView.findViewById(R.id.imageView);
        }
    }
}
