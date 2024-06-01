package com.example.weatherapp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import webjson.Hours;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder> {
    private List<Hours> hoursList;

    public MyListAdapter(List<Hours> hoursList) {
        this.hoursList = hoursList;
    }


    @NonNull
    @Override
    public MyListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyListAdapter.ViewHolder holder, int position) {
        //将数据绑定到布局中
        Hours hours = hoursList.get(position);
        holder.tem.setText(hours.getTem() + "°C");
        holder.weather.setText(hours.getWea());
        holder.wind.setText(hours.getWin_speed());
        holder.time.setText(hours.getHours());
    }

    @Override
    public int getItemCount() {
        //获取数据列表的大小
        return hoursList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tem,weather,wind,time;
        public ViewHolder(View itemView) {
            super(itemView);
            // 初始化布局中的控件
            tem = itemView.findViewById(R.id.tem);
            weather = itemView.findViewById(R.id.weather);
            wind = itemView.findViewById(R.id.wind);
            time = itemView.findViewById(R.id.time);
        }
    }
}
