package com.example.weatherapp;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import webjson.DayData;

public class MyDayListAdapter extends RecyclerView.Adapter<MyDayListAdapter.ViewHolder> {

    private String TAG = "MyDayListAdapter";
    private List<DayData> daysList;

    public MyDayListAdapter(List<DayData> daysList){this.daysList = daysList;}
    @NonNull
    @Override
    public MyDayListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.days_detail,parent,false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyDayListAdapter.ViewHolder holder, int position) {
        //将数据绑定到布局中
        DayData dayData = daysList.get(position);
        holder.date.setText(dayData.getDay());
        holder.tem1.setText(dayData.getTem1() + "°C");
        holder.tem2.setText(dayData.getTem2() + "°C");
        holder.weather.setText(dayData.getWea());
    }

    @Override
    public int getItemCount() {
        if(daysList != null) return daysList.size();
        else return 0;
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        TextView date,weather,tem1,tem2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //初始化布局中的控件
            date = itemView.findViewById(R.id.date);
            weather = itemView.findViewById(R.id.day_weather);
            tem1 = itemView.findViewById(R.id.tem1);
            tem2 = itemView.findViewById(R.id.tem2);
        }
    }
}
