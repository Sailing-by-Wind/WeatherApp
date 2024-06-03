package com.example.weatherapp;

import static androidx.core.view.ViewCompat.setBackground;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Objects;

import webjson.DayData;
import webjson.Hours;
import webjson.JsonRootBean;
import webjson.JsonRootBeanDay;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CityFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CityFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public JsonRootBean jsonRootBean;

    public JsonRootBeanDay jsonRootBeanDay;
    private SwipeRefreshLayout swipeRefreshLayout;
    private static final String TAG = "CityFragment";

    public CityFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CityFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CityFragment newInstance(String param1, String param2) {
        CityFragment fragment = new CityFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Handler handler = new Handler(Looper.myLooper()) {
            @SuppressLint("SetTextI18n")
            @Override
            public void handleMessage(@NonNull Message msg) {
                if (msg.what == 1) {
                    try {
                        Bundle bundle = new Bundle();
                        bundle = (Bundle) msg.obj;
                        jsonRootBean = (JsonRootBean) bundle.getSerializable("inform");
                        assert jsonRootBean != null;
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

                        TextView city_name = getView().findViewById(R.id.cityName);
                        city_name.setText(cityName);

                        TextView city_tem = getView().findViewById(R.id.currTem);
                        city_tem.setText(cityTem + "°C");

                        int airNum = Integer.parseInt(cityAir);
                        TextView city_air = getView().findViewById(R.id.airQua);
                        if (airNum <= 50) {
                            city_air.setText("AQI " + cityAir + " 优");
                            city_air.setTextColor(ContextCompat.getColor(getContext(), R.color.best_air));
                        } else if (airNum > 50 && airNum <= 100) {
                            city_air.setText("AQI " + cityAir + " 良");
                            city_air.setTextColor(ContextCompat.getColor(getContext(), R.color.good_air));
                        } else if (airNum > 100 && airNum <= 150) {
                            city_air.setText("AQI " + cityAir + " 轻微污染");
                            city_air.setTextColor(ContextCompat.getColor(getContext(), R.color.bad_air));
                        } else if (airNum > 150 && airNum <= 200) {
                            city_air.setText("AQI " + cityAir + " 轻度污染");
                            city_air.setTextColor(ContextCompat.getColor(getContext(), R.color.worse_air));
                        } else if (airNum > 200 && airNum <= 300) {
                            city_air.setText("AQI " + cityAir + " 中度重污染");
                            city_air.setTextColor(ContextCompat.getColor(getContext(), R.color.worst_air));
                        } else {
                            city_air.setText("AQI " + cityAir + " 重度污染");
                            city_air.setTextColor(ContextCompat.getColor(getContext(), R.color.worst_air));
                        }

                        TextView city_wea = getView().findViewById(R.id.wea);
                        city_wea.setText(cityWea + " 最高" + cityTem1 + "°C 最低" + cityTem2 + "°C");

                        RecyclerView recyclerView = getView().findViewById(R.id.hours);
                        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
                        recyclerView.setLayoutManager(layoutManager);
                        MyListAdapter myListAdapter = new MyListAdapter(hours);
                        recyclerView.setAdapter(myListAdapter);

                        TitleSubtitleView titleSubtitleView_uv = getView().findViewById(R.id.uv);
                        TitleSubtitleView titleSubtitleView_humidity = getView().findViewById(R.id.humidity);
                        TitleSubtitleView titleSubtitleView_windDirection = getView().findViewById(R.id.wind_direction);
                        TitleSubtitleView titleSubtitleView_pm25 = getView().findViewById(R.id.pm25);
                        TitleSubtitleView titleSubtitleView_sunrise = getView().findViewById(R.id.sunrise);
                        TitleSubtitleView titleSubtitleView_sunset = getView().findViewById(R.id.sunset);

                        titleSubtitleView_uv.setTitle("紫外线");
                        titleSubtitleView_uv.setSubtitle(uv);
                        titleSubtitleView_humidity.setTitle("湿度");
                        titleSubtitleView_humidity.setSubtitle(humidity);
                        titleSubtitleView_windDirection.setTitle(windDirection);
                        titleSubtitleView_windDirection.setSubtitle(wind);
                        titleSubtitleView_pm25.setTitle("PM 2.5");
                        titleSubtitleView_pm25.setSubtitle(pm25);
                        titleSubtitleView_sunrise.setTitle("日出");
                        titleSubtitleView_sunrise.setSubtitle(sunrise);
                        titleSubtitleView_sunset.setTitle("日落");
                        titleSubtitleView_sunset.setSubtitle(sunset);

                    } catch (Exception e) {
                        Toast.makeText(getContext(), "当前地区不存在！", Toast.LENGTH_SHORT).show();
                    }
                }

                if(msg.what == 10){
                    try{
                        Bundle bundle1 = new Bundle();
                        bundle1 = (Bundle) msg.obj;
                        jsonRootBeanDay = (JsonRootBeanDay) bundle1.getSerializable("inform_day");

                        assert jsonRootBeanDay != null;
                        List<DayData> dayData = jsonRootBeanDay.getData();

                        RecyclerView recyclerView1 = getView().findViewById(R.id.day);
                        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                        recyclerView1.setLayoutManager(layoutManager1);
                        MyDayListAdapter myDayListAdapter = new MyDayListAdapter(dayData);
                        recyclerView1.setAdapter(myDayListAdapter);

                    } catch (Exception e) {
                        Toast.makeText(getContext(), "当前地区不存在！", Toast.LENGTH_SHORT).show();
                    }
                }


                super.handleMessage(msg);
            }
        };
        MyWeatherThread myWeatherThread = new MyWeatherThread();
        myWeatherThread.setHandler(handler);
        Thread t1 = new Thread(myWeatherThread);
        t1.start();

        MyDayThread myDayThread = new MyDayThread();
        myDayThread.setHandler(handler);
        Thread t5 = new Thread(myDayThread);
        t5.start();

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void setBackground(Drawable drawable) {
        if (getView() != null) {
            getView().findViewById(R.id.background_img).setBackground(drawable);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        return inflater.inflate(R.layout.fragment_city, container, false);


        //下拉刷新数据
//        swipeRefreshLayout = rootView.findViewById(R.id.swipeRefreshLayout);
//
//        // 设置刷新事件监听器
//        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                // 执行刷新逻辑
//                refreshContent();
//            }
//
//            private void refreshContent() {
//                // 这里执行刷新逻辑，比如重新加载数据或者重新请求网络数据
//
//                // 刷新完成后停止刷新动画
//                swipeRefreshLayout.setRefreshing(false);
//            }
//        });

    }
}