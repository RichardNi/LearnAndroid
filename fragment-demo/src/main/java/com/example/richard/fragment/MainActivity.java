package com.example.richard.fragment;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioGroup;


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
