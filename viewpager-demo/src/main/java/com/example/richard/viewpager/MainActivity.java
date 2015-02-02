package com.example.richard.viewpager;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private List<View> viewList = new ArrayList<>(4);

    private List<String> titleList = new ArrayList<>(4);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // 设置ViewPager tab页的标题
        titleList.add("第一页");
        titleList.add("第二页");
        titleList.add("第三页");
        titleList.add("第四页");

        // region 设置ViewPager tab相关的样式

        PagerTabStrip tabStrip = (PagerTabStrip) findViewById(R.id.tab);
        // 设置标题背景颜色
        tabStrip.setBackgroundColor(Color.YELLOW);
        // 设置标题文字颜色
        tabStrip.setTextColor(Color.RED);
        // 设置是否显示标题上的最长的线。false:不显示
        tabStrip.setDrawFullUnderline(false);
        // 设置标题选中线的颜色
        tabStrip.setTabIndicatorColor(Color.RED);
        // endregion

        // region 1.通过View对象作为ViewPager的数据源
        View view1 = View.inflate(this, R.layout.view1, null);
        View view2 = View.inflate(this, R.layout.view2, null);
        View view3 = View.inflate(this, R.layout.view3, null);
        View view4 = View.inflate(this, R.layout.view4, null);

        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        viewList.add(view4);
        // endregion

        // region 2.创建PageAdapter，并设置数据源
        MyPageAdapter adapter = new MyPageAdapter(viewList, titleList);
        // endregion

        // region 3.创建ViewPager对象，并设置数据适配器
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);
        // endregion

    }

}
