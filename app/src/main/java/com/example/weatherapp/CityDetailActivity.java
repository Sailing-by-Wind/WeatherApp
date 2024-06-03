package com.example.weatherapp;

import static java.security.AccessController.getContext;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import webjson.DayData;
import webjson.Hours;
import webjson.JsonRootBean;
import webjson.JsonRootBeanDay;

public class CityDetailActivity extends AppCompatActivity {

    private static final String TAG = "CityDetailActivity";
    public JsonRootBean jsonRootBean;
    public JsonRootBeanDay jsonRootBeanDay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_detail);

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo == null || !networkInfo.isConnected()) {

//            Intent intent = new Intent(this,NetworkErrActivity.class);
//            startActivity(intent);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("网络错误"); // 设置弹窗标题
            builder.setMessage("当前网络不可用，请检查网络设置后重试！"); // 设置弹窗内容
            // 设置确认按钮
            builder.setPositiveButton("我知道了", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // 点击确认按钮后的操作
                    finish();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.setCancelable(false); // 禁止点击外部区域关闭弹窗
            dialog.show();
            Toast.makeText(CityDetailActivity.this,"网络服务错误！", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = getIntent();

        String cityName = null;
        cityName = intent.getStringExtra("cityName");
        String city_name = null;
        city_name = intent.getStringExtra("city_name");
        //Log.i(TAG,city_name);
        String province = null;
        province = intent.getStringExtra("province");
        //Log.i(TAG,province);

        if(province != null)Log.i(TAG,province);
        Handler handler = new Handler(Looper.myLooper()){
            @Override
            public void handleMessage(@NonNull Message msg) {

                try{
                    if(msg.what == 2){
                        Bundle bundle = new Bundle();
                        bundle = (Bundle) msg.obj;
                        jsonRootBean = (JsonRootBean) bundle.getSerializable("cityInform");


                        String cityName = jsonRootBean.getCity();
                        String cityTem = jsonRootBean.getTem();
                        String cityAir = jsonRootBean.getAir();
                        String cityWea = jsonRootBean.getWea();
                        String cityTem1 = jsonRootBean.getTem1();
                        String cityTem2 = jsonRootBean.getTem2();
                        String uv = jsonRootBean.getUvDescription();
                        String humidity = jsonRootBean.getHumidity();
                        String pm25 = jsonRootBean.getAirPm25();
                        String windDirection = jsonRootBean.getWin();
                        String wind = jsonRootBean.getWinSpeed();
                        String sunrise = jsonRootBean.getSunrise();
                        String sunset = jsonRootBean.getSunset();
                        List<Hours> hours = jsonRootBean.getHours();

                        TextView city_name = findViewById(R.id.cityName);
                        city_name.setText(cityName);
                        TextView city_tem = findViewById(R.id.currTem);
                        city_tem.setText(cityTem + "°C");
                        int airNum = Integer.parseInt(cityAir);
                        TextView city_air = findViewById(R.id.airQua);
                        if(airNum <= 50){
                            city_air.setText("AQI " + cityAir + " 优");
                            city_air.setTextColor(ContextCompat.getColor(CityDetailActivity.this,R.color.best_air));
                        }else if(airNum > 50 && airNum <= 100){
                            city_air.setText("AQI " + cityAir + " 良");
                            city_air.setTextColor(ContextCompat.getColor(CityDetailActivity.this,R.color.good_air));
                        }else if(airNum > 100 && airNum <= 150){
                            city_air.setText("AQI " + cityAir + " 轻微污染");
                            city_air.setTextColor(ContextCompat.getColor(CityDetailActivity.this,R.color.bad_air));
                        }else if(airNum > 150 && airNum <= 200){
                            city_air.setText("AQI " + cityAir + " 轻度污染");
                            city_air.setTextColor(ContextCompat.getColor(CityDetailActivity.this,R.color.worse_air));
                        }else if(airNum > 200 && airNum <= 300){
                            city_air.setText("AQI " + cityAir + " 中度重污染");
                            city_air.setTextColor(ContextCompat.getColor(CityDetailActivity.this,R.color.worst_air));
                        }else{
                            city_air.setText("AQI " + cityAir + " 重度污染");
                            city_air.setTextColor(ContextCompat.getColor(CityDetailActivity.this,R.color.worst_air));
                        }
                        TextView city_wea = findViewById(R.id.wea);
                        city_wea.setText(cityWea + " 最高" + cityTem1 + "°C 最低" + cityTem2 + "°C");

                        RecyclerView recyclerView = findViewById(R.id.hours);
                        LinearLayoutManager layoutManager = new LinearLayoutManager(CityDetailActivity.this,LinearLayoutManager.HORIZONTAL,false);
                        recyclerView.setLayoutManager(layoutManager);
                        MyListAdapter myListAdapter = new MyListAdapter(hours);
                        recyclerView.setAdapter(myListAdapter);

                        TitleSubtitleView titleSubtitleView_uv = findViewById(R.id.uv);
                        TitleSubtitleView titleSubtitleView_humidity = findViewById(R.id.humidity);
                        TitleSubtitleView titleSubtitleView_windDirection = findViewById(R.id.wind_direction);
                        TitleSubtitleView titleSubtitleView_pm25 = findViewById(R.id.pm25);
                        TitleSubtitleView titleSubtitleView_sunrise = findViewById(R.id.sunrise);
                        TitleSubtitleView titleSubtitleView_sunset = findViewById(R.id.sunset);

                        titleSubtitleView_uv.setTitle("紫外线");titleSubtitleView_uv.setSubtitle(uv);
                        titleSubtitleView_humidity.setTitle("湿度");titleSubtitleView_humidity.setSubtitle(humidity);
                        titleSubtitleView_windDirection.setTitle(windDirection);titleSubtitleView_windDirection.setSubtitle(wind);
                        titleSubtitleView_pm25.setTitle("PM 2.5");titleSubtitleView_pm25.setSubtitle(pm25);
                        titleSubtitleView_sunrise.setTitle("日出");titleSubtitleView_sunrise.setSubtitle(sunrise);
                        titleSubtitleView_sunset.setTitle("日落");titleSubtitleView_sunset.setSubtitle(sunset);

                    }

                    if(msg.what == 10){

                        Bundle bundle1 = new Bundle();
                        bundle1 = (Bundle) msg.obj;
                        jsonRootBeanDay = (JsonRootBeanDay) bundle1.getSerializable("inform_day");

                        assert jsonRootBeanDay != null;
                        List<DayData> dayData = jsonRootBeanDay.getData();

                        RecyclerView recyclerView1 = findViewById(R.id.day);
                        LinearLayoutManager layoutManager1 = new LinearLayoutManager(CityDetailActivity.this, LinearLayoutManager.VERTICAL, false);
                        recyclerView1.setLayoutManager(layoutManager1);
                        MyDayListAdapter myDayListAdapter = new MyDayListAdapter(dayData);
                        recyclerView1.setAdapter(myDayListAdapter);
                    }

                    if(msg.what == 12){
                        Bundle bundle2 = new Bundle();
                        bundle2 = (Bundle) msg.obj;
                        jsonRootBeanDay = (JsonRootBeanDay) bundle2.getSerializable("cityDayInform");

                        List<DayData> dayData = jsonRootBeanDay.getData();
                        RecyclerView recyclerView1 = findViewById(R.id.day);
                        LinearLayoutManager layoutManager1 = new LinearLayoutManager(CityDetailActivity.this, LinearLayoutManager.VERTICAL, false);
                        recyclerView1.setLayoutManager(layoutManager1);
                        MyDayListAdapter myDayListAdapter = new MyDayListAdapter(dayData);
                        recyclerView1.setAdapter(myDayListAdapter);
                    }
                }catch (Exception e){
                    Toast.makeText(CityDetailActivity.this,"给我干哪来了，这还是国内吗？>_<",Toast.LENGTH_LONG).show();
                    AlertDialog.Builder builder = new AlertDialog.Builder(CityDetailActivity.this);
                    builder.setTitle("查询地区不存在！"); // 设置弹窗标题
                    builder.setMessage("请检查搜索内容后重试"); // 设置弹窗内容
                    // 设置确认按钮
                    builder.setPositiveButton("我知道了", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // 点击确认按钮后的操作
                            finish();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.setCancelable(false); // 禁止点击外部区域关闭弹窗
                    dialog.show();
                    return;
                }
                super.handleMessage(msg);
            }
        };

        if(cityName != null){
            Log.i(TAG,cityName);
            MyCityThread myCityThread = new MyCityThread(cityName);
            myCityThread.setHandler(handler);
            Thread t2 = new Thread(myCityThread);
            t2.start();

            MyDayThread myDayThread = new MyDayThread();
            myDayThread.setHandler(handler);
            Thread t5 = new Thread(myDayThread);
            t5.start();
        }else {
            Log.i(TAG,city_name);
            Log.i(TAG,province);
            MySearchThread mySearchThread = new MySearchThread(province,city_name);
            mySearchThread.setHandler(handler);
            Thread t3 = new Thread(mySearchThread);
            t3.start();

        }

    }
}