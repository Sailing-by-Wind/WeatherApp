package com.example.weatherapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.io.IOException;

public class BeginActivity extends AppCompatActivity {

    private CityFragment cityFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        cityFragment = new CityFragment();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin);
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo == null || !networkInfo.isConnected()) {

//            Intent intent = new Intent(this,NetworkErrActivity.class);
//            startActivity(intent);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("网络错误"); // 设置弹窗标题
            builder.setMessage("当前网络不可用，请检查网络设置后重试！"); // 设置弹窗内容

            builder.setNegativeButton("打开系统设置", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // 点击确认按钮后的操作
                    Intent settingIntent = new Intent(Settings.ACTION_SETTINGS);

                    // 启动系统设置界面
                    startActivity(settingIntent);
                    finish();
                    finishAffinity();
                }
            });

// 设置取消按钮
            builder.setPositiveButton("退出", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // 点击取消按钮后的操作
                    finish();
                    finishAffinity();
                }
            });

            AlertDialog dialog = builder.create();
            dialog.setCancelable(false); // 禁止点击外部区域关闭弹窗
            dialog.show();
            Toast.makeText(BeginActivity.this,"网络服务错误！", Toast.LENGTH_SHORT).show();
            return;
        }
        ViewPager2 viewPager = findViewById(R.id.viewPager2);
        MyPageAdapter pageAdapter = new MyPageAdapter(this);
        viewPager.setAdapter(pageAdapter);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        //禁用滑动切换
//        ViewPager2 viewPager2 = findViewById(R.id.viewPager2);
//        ViewGroup viewPagerParent = (ViewGroup)viewPager2.getParent();
//        viewPagerParent.setOnTouchListener(new View.OnTouchListener(){
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return false;
//            }
//        });

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText("当前城市，查询城市，关于我们".split("，")[position])
        ).attach();


    }

    @SuppressLint("ResourceType")
    public void setFragmentBackground(Uri imageUri) {
        try {
            // 从Uri中获取选定的图片，并设置为背景
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
            Drawable drawable = new BitmapDrawable(getResources(), bitmap);
//            ImageView imageView = cityFragment.getView().findViewById(R.id.background);
//            imageView.setBackground(drawable);
            cityFragment.setBackground(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}