package com.example.richard.scrollview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private static final String TAG = "Main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = (TextView) findViewById(R.id.txt);
        textView.setText(R.string.content);

        final ScrollView scrollView = (ScrollView) findViewById(R.id.scroll);
        scrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.d(TAG, "手指按下，Y坐标：" + scrollView.getScrollY());
                        break;

                    case MotionEvent.ACTION_UP:
                        Log.d(TAG, "手指抬起，Y坐标：" + scrollView.getScrollY());
                        break;

                    case MotionEvent.ACTION_MOVE:
                        /**
                         * scrollView.getScrollY():ScrollView滚动的垂直距离
                         * scrollView.getHeight():一屏的高度
                         * scrollView.getChildAt(0).getMeasuredHeight():ScrollView内子标签的总高度
                         * 这里是TextView的总高度
                         *
                         */
                        Log.d(TAG, "手指滑动，Y坐标：" + scrollView.getScrollY() +
                                "，scrollView.getHeight()：" +
                                scrollView.getHeight() +
                                "，scrollView.getChildAt(0).getMeasuredHeight()：" +
                                scrollView.getChildAt(0).getMeasuredHeight() +
                                "，scrollView.getMeasuredHeight()：" +
                                scrollView.getMeasuredHeight());

                        // 是否滑动到滚动条底部的判断依据：TextView总高度<= 一屏的高度 +
                        // ScrollView滚动的垂直距离
                        if (scrollView.getChildAt(0).getMeasuredHeight() <= scrollView.getHeight() +
                                scrollView.getScrollY()) {
                            Log.d(TAG, "已经到底部鸟！");
                            textView.append(getResources().getString(R.string.content));
                        }
                }
                return false;
            }
        });

    }
}
