package com.example.weatherapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.io.IOException;

public class BeginActivity extends AppCompatActivity {

    private CityFragment cityFragment;

    //private final boolean showAgain = sharedPreferences.getBoolean("doShowAgain", true);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //预加载缓解卡顿
//        // 创建 Fragment
//        Fragment fragment = new IndividualFragment();
//
//        // 获取 FragmentManager
//        FragmentManager fragmentManager = getSupportFragmentManager();
//
//        // 开启事务
//        FragmentTransaction transaction = fragmentManager.beginTransaction();
//
//        // 添加 Fragment 并设置标签
//        transaction.add(R.id.individualFragmentl, fragment, "fragment_individual_tag");
//
//        // 提交事务
//        transaction.commit();
//
//        Fragment individual_fragment = fragmentManager.findFragmentByTag("fragment_individual_tag");
//
//        if (individual_fragment != null) {
//            transaction = fragmentManager.beginTransaction();
//            transaction.show(individual_fragment);
//            transaction.commit();
//        }


        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        boolean isFirstRun = sharedPreferences.getBoolean("isFirstRun", true);

        //首次启动提示
        if (isFirstRun) {
            // 显示提示框
            AlertDialog.Builder dialogFirst = new AlertDialog.Builder(this);
            dialogFirst.setTitle("Swufe实况天气");
            dialogFirst.setCancelable(false);
            dialogFirst.setMessage("欢迎使用Swufe实况天气！这款应用可以为您提供快捷便利的实况天气查询服务。\n" +
                    "\n" +
                    "启动应用即可查看您所在城市的最新天气概况。想知道其他城市的天气状况？应用内置强大的搜索功能，让您轻松找到想要的天气信息！\n" +
                    "\n" +
                    "应用还提供24小时内的逐小时天气、PM2.5指数、紫外线强度、空气质量、风向风力、日出日落、湿度信息等多项天气特征，帮助您事先做好周全的准备。\n" +
                    "\n" +
                    "让我们一起掌握最新鲜的天气动态！");
            dialogFirst.setPositiveButton("我知道了", null);
            dialogFirst.show();

            AlertDialog.Builder dialogUpdate = new AlertDialog.Builder(this);
            dialogUpdate.setCancelable(false);
            dialogUpdate.setTitle("更新日志");
            dialogUpdate.setMessage("v1.5.6更新内容：\n1、优化首次启动APP时的提示框效果。\n");
            dialogUpdate.setPositiveButton("我知道了", null);
            dialogUpdate.show();

            // 将 isFirstRun 标志设置为 false，表示应用不再是首次启动
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("isFirstRun", false);
            editor.apply();


        }

        //不再提示选择框
//        // 显示提示框
//        RelativeLayout relativeLayout = new RelativeLayout(this);
//        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(
//                ViewGroup.LayoutParams.MATCH_PARENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT));
//
//// 添加 CheckBox 并设置对齐方式
//        CheckBox checkBox = new CheckBox(this);
//        checkBox.setText("不再提示");
//        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
//                ViewGroup.LayoutParams.WRAP_CONTENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT);
//        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
//        params.rightMargin = getResources().getDimensionPixelSize(R.dimen.dialog_checkbox_margin);
//        checkBox.setLayoutParams(params);
//        relativeLayout.addView(checkBox);
//
//        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            boolean showAgain = false;
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                this.showAgain = showAgain;
//            }
//        });
//        if (showAgain) {
//
//// 设置自定义视图
//            dialogUpdate.setView(relativeLayout);
//            dialogUpdate.show();
//        }

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