package com.example.weatherapp;

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

import webjson.JsonRootBean;
import webjson.JsonRootBeanDay;

public class MySearchThread implements Runnable {
    private String city_name;
    private String province;
    private String urlString = "http://v1.yiketianqi.com/api?unescape=1&version=v63&appid=16295769&appsecret=Z6bPelf8&city=";
    private String urlString1 = "https://v1.yiketianqi.com/api?unescape=1&version=v91&appid=16295769&appsecret=Z6bPelf8&city=";
    Bundle bundle = new Bundle();
    Bundle bundle1 = new Bundle();
    Handler handler = new Handler();

    public MySearchThread(String province, String city_name) {
        this.province = province;
        this.city_name = city_name;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {
        JsonRootBean jsonRootBean = null;
        JsonRootBeanDay jsonRootBeanDay = null;
        try {
            urlString = urlString + city_name + "&province=" + province;
            urlString1 = urlString1 + city_name + "&province=" + province;
            URL url = new URL(urlString);
            URL url1 = new URL(urlString1);

            //Log.i("网络链接", urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            HttpURLConnection conn1 = (HttpURLConnection) url1.openConnection();
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

            } else {//网络请求失败
                Log.i("网络请求失败", "Failed to fetch data, Response code: " + responseCode);
            }

            int responseCode1 = conn1.getResponseCode();
            if (responseCode1 == HttpURLConnection.HTTP_OK) {
                //读取服务器返回的JASON数据
                BufferedReader reader1 = new BufferedReader(new InputStreamReader(conn1.getInputStream()));

                StringBuilder json1 = new StringBuilder();
                String line1;
                while ((line1 = reader1.readLine()) != null) {
                    json1.append(line1);
                }
                //关闭网络连接
                reader1.close();

                //使用Gson解析JSON数据
                Gson gson1 = new Gson();

                //对应Java实体类
                jsonRootBeanDay = gson1.fromJson(json1.toString(), JsonRootBeanDay.class);

            } else {//网络请求失败
                Log.i("网络请求失败", "Failed to fetch data, Response code: " + responseCode1);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        bundle.putSerializable("cityInform", jsonRootBean);
        bundle1.putSerializable("cityDayInform", jsonRootBeanDay);

        Message msg = handler.obtainMessage(2);
        msg.what = 2;
        msg.obj = bundle;
        handler.sendMessage(msg);

        Message msg1 = handler.obtainMessage(12);
        msg1.what = 12;
        msg1.obj = bundle1;
        handler.sendMessage(msg1);

    }
}
