package com.example.weatherapp;

import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;


import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import webjson.JsonRootBean;

public class MyCityThread implements Runnable {
    private String cityName;
    private String urlString = "http://v1.yiketianqi.com/api?unescape=1&version=v63&appid=16295769&appsecret=Z6bPelf8&city=";
    Bundle bundle = new Bundle();
    Handler handler = new Handler();
    public MyCityThread(String cityName){
        this.cityName = cityName;
    }
    public void setHandler(Handler handler){
        this.handler = handler;
    }
    @Override
    public void run() {
        JsonRootBean jsonRootBean = null;
        try{
            urlString += cityName;
            URL url = new URL(urlString);
            Log.i("网络链接",urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                //读取服务器返回的JASON数据
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                StringBuilder json = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    json.append(line);
                }
                //关闭网络连接
                reader.close();

                //使用Gson解析JSON数据
                Gson gson = new Gson();

                //对应Java实体类
                jsonRootBean = gson.fromJson(json.toString(), JsonRootBean.class);
                //获取天气特征信息
                cityName = jsonRootBean.getCity();

                //Log.i("城市", jsonRootBean.getCity());
                //Log.i("温度", jsonRootBean.getTem() + "°C");
            } else {//网络请求失败
                Log.i("网络请求失败", "Failed to fetch data, Response code: " + responseCode);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        bundle.putSerializable("cityInform",jsonRootBean);
        Message msg = handler.obtainMessage(2);
        msg.what = 2;
        msg.obj = bundle;
        handler.sendMessage(msg);
    }
}