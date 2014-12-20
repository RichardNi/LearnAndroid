package control.android.example.listview;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import control.android.example.R;

/**
 * ListView ArrayAdapter示例
 *
 * @author RichardNi
 */
public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        // 设置数据源
        String[] item = {"小明", "小红", "jack", "tom", "小明", "小红", "jack", "tom",
                "不错哦，哈哈", "Java", "Android", "呵呵"};
        // 创建ArrayAdapter
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, item);

        ListView listView = (ListView) findViewById(R.id.lv_show);
        // 设置adapter到ListView上
        listView.setAdapter(arrayAdapter);
    }

}
