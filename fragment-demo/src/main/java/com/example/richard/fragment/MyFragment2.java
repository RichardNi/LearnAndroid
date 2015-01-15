package com.example.richard.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Richard on 2015/1/15.
 */
public class MyFragment2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /**
         * resource: fragment需要加载的布局文件
         * root: 加载layout父的ViewGroup
         * attachToRoot: true：返回父的ViewGroup，false不返回父的ViewGroup
         */
        View view = inflater.inflate(R.layout.fragment, container, false);
        TextView textView = (TextView) view.findViewById(R.id.text);
        textView.setText("fragment中的TextView");
        return view;
    }

}
