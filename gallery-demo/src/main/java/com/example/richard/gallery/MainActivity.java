package com.example.richard.gallery;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Gallery;


public class MainActivity extends ActionBarActivity {

    private int[] resourceImageIds = {R.drawable.item1, R.drawable.item2, R.drawable.item3,
            R.drawable.item4, R.drawable.item5, R.drawable.item6, R.drawable.item7,
            R.drawable.item8, R.drawable.item9, R.drawable.item10, R.drawable.item11,
            R.drawable.item12};

    private Gallery gallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gallery = (Gallery) findViewById(R.id.gallery);
        MyImageAdapter adapter = new MyImageAdapter(resourceImageIds, this);
        gallery.setAdapter(adapter);

    }

}
