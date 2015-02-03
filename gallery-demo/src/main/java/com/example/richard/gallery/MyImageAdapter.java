package com.example.richard.gallery;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

/**
 * Created by Richard on 2015/2/3.
 */
public class MyImageAdapter extends BaseAdapter {

    private static final String TAG = "MyImageAdapter";

    private int[] resImageIds;
    private Context context;

    public MyImageAdapter(int[] resImageIds, Context context) {
        this.resImageIds = resImageIds;
        this.context = context;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public Object getItem(int position) {
        return resImageIds[position % resImageIds.length];
    }

    @Override
    public long getItemId(int position) {
        return position % resImageIds.length;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d(TAG, "position=" + position + ", position % resImageIds.length=" + (position %
                resImageIds.length));
        ImageView imageView = new ImageView(context);
        imageView.setBackgroundResource(resImageIds[position % resImageIds.length]);
        // 设置图片大小为200x150
        imageView.setLayoutParams(new Gallery.LayoutParams(200, 150));
        // 图片缩放方式为以XY轴拉伸
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
    }
}
