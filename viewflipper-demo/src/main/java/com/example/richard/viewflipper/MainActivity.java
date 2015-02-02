package com.example.richard.viewflipper;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.ViewFlipper;


public class MainActivity extends ActionBarActivity {

    private ViewFlipper flipper;
    private int[] imageIds = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4};
    private float startX = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flipper = (ViewFlipper) findViewById(R.id.flipper);
        init();
        // 设置ViewFlipper切换时移入、移出动画效果
//        flipper.setInAnimation(this, R.anim.left_in);
//        flipper.setOutAnimation(this, R.anim.left_out);
//
//        // 设置切换时间
//        flipper.setFlipInterval(3000);
//        // 开始播放
//        flipper.startFlipping();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            // 手指按下
            case MotionEvent.ACTION_DOWN:
                startX = event.getX();
                break;

            // 手指滑动
            case MotionEvent.ACTION_MOVE:
                break;

            // 手指抬起
            case MotionEvent.ACTION_UP:
                // 手指向右滑动
                if (event.getX() - startX > 150) {
                    flipper.setInAnimation(this, R.anim.left_in);
                    flipper.setOutAnimation(this, R.anim.left_out);
                    flipper.showPrevious();

                } else if (startX - event.getX() > 150) {// 手指向左滑动
                    flipper.setInAnimation(this, R.anim.right_in);
                    flipper.setOutAnimation(this, R.anim.right_out);
                    flipper.showNext();
                }

                break;

        }
        return super.onTouchEvent(event);
    }

    private void init() {
        ImageView imageView;
        for (int id : imageIds) {
            imageView = new ImageView(this);
            imageView.setBackgroundResource(id);
            flipper.addView(imageView);
        }
    }

}
