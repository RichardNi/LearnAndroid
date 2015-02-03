package com.example.richard.seekbar;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements SeekBar.OnSeekBarChangeListener {
    private static final String TAG = "MainActivity";

    private TextView tvProgress;
    private TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(this);

        tvProgress = (TextView) findViewById(R.id.tv_progress);
        tvStatus = (TextView) findViewById(R.id.tv_status);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        tvStatus.setText("正在拖动进度");
        tvProgress.setText("进度：" + progress);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        tvStatus.setText("开始拖动进度");
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        tvStatus.setText("停止拖动进度");
    }
}
