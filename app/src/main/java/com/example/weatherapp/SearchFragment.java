package com.example.weatherapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SearchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private static final String TAG = "SearchFragment";

    public SearchFragment() {
        // Required empty public constructor
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SearchFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SearchFragment newInstance(String param1, String param2) {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_search, container, false);
        Button beijing_btn = rootView.findViewById(R.id.beijing);
        Button shanghai_btn = rootView.findViewById(R.id.shanghai);
        Button guangzhou_btn = rootView.findViewById(R.id.guangzhou);
        Button tianjin_btn = rootView.findViewById(R.id.tianjin);
        Button chengdu_btn = rootView.findViewById(R.id.chengdu);
        Button fuzhou_btn = rootView.findViewById(R.id.fuzhou);
        Button changsha_btn = rootView.findViewById(R.id.changsha);
        Button haerbin_btn = rootView.findViewById(R.id.haerbin);
        Button hangzhou_btn = rootView.findViewById(R.id.hangzhou);
        Button chongqing_btn = rootView.findViewById(R.id.chongqing);
        Button guiyang_btn = rootView.findViewById(R.id.guiyang);
        Button kunming_btn = rootView.findViewById(R.id.kunming);
        Button search_btn = rootView.findViewById(R.id.search_button);

        EditText search_text = rootView.findViewById(R.id.search_city);

        beijing_btn.setOnClickListener(v -> {
            String cityName = "北京";
            Intent detailIntent = new Intent(getActivity(), CityDetailActivity.class);
            detailIntent.putExtra("cityName",cityName);
            startActivity(detailIntent);
        });
        shanghai_btn.setOnClickListener(v -> {
            String cityName = "上海";
            Intent detailIntent = new Intent(getActivity(), CityDetailActivity.class);
            detailIntent.putExtra("cityName",cityName);
            startActivity(detailIntent);
        });
        guangzhou_btn.setOnClickListener(v -> {
            String cityName = "广州";
            Intent detailIntent = new Intent(getActivity(), CityDetailActivity.class);
            detailIntent.putExtra("cityName",cityName);
            startActivity(detailIntent);
        });
        tianjin_btn.setOnClickListener(v -> {
            String cityName = "天津";
            Intent detailIntent = new Intent(getActivity(), CityDetailActivity.class);
            detailIntent.putExtra("cityName",cityName);
            startActivity(detailIntent);
        });
        chengdu_btn.setOnClickListener(v -> {
            String cityName = "成都";
            Intent detailIntent = new Intent(getActivity(), CityDetailActivity.class);
            detailIntent.putExtra("cityName",cityName);
            startActivity(detailIntent);
        });
        fuzhou_btn.setOnClickListener(v -> {
            String cityName = "福州";
            Intent detailIntent = new Intent(getActivity(),CityDetailActivity.class);
            detailIntent.putExtra("cityName",cityName);
            startActivity(detailIntent);
        });
        haerbin_btn.setOnClickListener(v -> {
            String cityName = "哈尔滨";
            Intent detailIntent = new Intent(getActivity(),CityDetailActivity.class);
            detailIntent.putExtra("cityName",cityName);
            startActivity(detailIntent);
        });
        changsha_btn.setOnClickListener(v -> {
            String cityName = "长沙";
            Intent detailIntent = new Intent(getActivity(),CityDetailActivity.class);
            detailIntent.putExtra("cityName",cityName);
            startActivity(detailIntent);
        });
        hangzhou_btn.setOnClickListener(v -> {
            String cityName = "杭州";
            Intent detailIntent = new Intent(getActivity(),CityDetailActivity.class);
            detailIntent.putExtra("cityName",cityName);
            startActivity(detailIntent);
        });
        chongqing_btn.setOnClickListener(v -> {
            String cityName = "重庆";
            Intent detailIntent = new Intent(getActivity(),CityDetailActivity.class);
            detailIntent.putExtra("cityName",cityName);
            startActivity(detailIntent);
        });
        guiyang_btn.setOnClickListener(v -> {
            String cityName = "贵阳";
            Intent detailIntent = new Intent(getActivity(),CityDetailActivity.class);
            detailIntent.putExtra("cityName",cityName);
            startActivity(detailIntent);
        });
        kunming_btn.setOnClickListener(v -> {
            String cityName = "昆明";
            Intent detailIntent = new Intent(getActivity(),CityDetailActivity.class);
            detailIntent.putExtra("cityName",cityName);
            startActivity(detailIntent);
        });
        search_btn.setOnClickListener(v -> {
            try{
                String content = search_text.getText().toString();
                String[] searchWords = content.split(" ");
                Intent detailIntent = new Intent(getActivity(),CityDetailActivity.class);
                detailIntent.putExtra("city_name",searchWords[1]);
                detailIntent.putExtra("province",searchWords[0]);
//                Log.i("省份",searchWords[0]);
//                Log.i("城市",searchWords[1]);
                startActivity(detailIntent);
            } catch (Exception e) {
                Toast.makeText(getContext(),"输入格式有误，请重试！",Toast.LENGTH_SHORT).show();
            }

        });

        return rootView;
    }
}