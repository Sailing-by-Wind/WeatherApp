package com.example.weatherapp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TitleSubtitleView extends LinearLayout {
    private TextView titleTextView;
    private TextView subtitleTextView;

    public TitleSubtitleView(Context context) {
        super(context);
        init(context);
    }

    public TitleSubtitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TitleSubtitleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.title_subtitle_view, this);
        titleTextView = findViewById(R.id.title_text_view);
        subtitleTextView = findViewById(R.id.subtitle_text_view);
    }

    public void setTitle(String title) {
        titleTextView.setText(title);
    }

    public void setSubtitle(String subtitle) {
        subtitleTextView.setText(subtitle);
    }

    // 新增方法，设置主标题和副标题
    public void setDefaults(String title, String sub_title) {
        titleTextView.setText(title);
        subtitleTextView.setText(sub_title);
    }
}