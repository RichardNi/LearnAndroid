package com.example.richard.layout;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";

    private TextView tvTitle;
    private TextView tvGoBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitle = (TextView) findViewById(R.id.tv_title);
        tvTitle.setText("自定导航");

        tvGoBack = (TextView) findViewById(R.id.tv_back);
        tvGoBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_back:
                Toast.makeText(this, "你点击了返回按钮", Toast.LENGTH_SHORT).show();
                Log.d(TAG, ((TextView) v).getText().toString());
        }

    }
}
