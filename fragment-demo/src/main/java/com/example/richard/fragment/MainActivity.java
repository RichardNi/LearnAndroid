package com.example.richard.fragment;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private RadioGroup group;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        group = (RadioGroup) findViewById(R.id.rg);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_first:
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        startActivity(intent);
                        break;
                    case R.id.rb_second:
                        MyFragment2 fragment2 = new MyFragment2();
                        FragmentManager manager = getSupportFragmentManager();
                        FragmentTransaction transaction = manager.beginTransaction();
                        // 用添加每次都会添加一个fragment到LinearLayout中，所以改用替换。
//                        transaction.add(R.id.frame, fragment2);
                        transaction.replace(R.id.frame, fragment2);
                        // 增加物理按键可返回的设置
                        transaction.addToBackStack(null);

                        transaction.commit();

                        break;
                    case R.id.rb_third:
                        break;
                    case R.id.rb_fourth:
                        break;
                    default:
                        Log.d(TAG, "未知的id:" + checkedId);
                }
            }
        });
    }

}
