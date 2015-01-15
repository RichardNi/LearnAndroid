package com.example.richard.fragment;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Richard on 2015/1/15.
 */
public class MainActivity2 extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
        Button btn = (Button) findViewById(R.id.button);
        final TextView textView = (TextView) findViewById(R.id.text);
        btn.setText("改变值");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("TextView值改变了");
            }
        });
    }
}
