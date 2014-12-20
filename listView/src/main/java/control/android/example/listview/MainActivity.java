package control.android.example.listview;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import control.android.example.R;


/**
 * 演示ListView的ArrayAdapter、SimpleAdapter
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
//        listView.setAdapter(arrayAdapter);

        /**
         * data:数据源
         * resource:ListView列表项的布局文件
         * from:数据源中Map对象的键(Key)列表
         * to:保存布局文件中控件的id列表(与前面的from里面保存的键列表一一对应)
         **/
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, getData(), R.layout.item,
                new String[]{"picture", "content"}, new int[]{R.id.pic, R.id.txt});

        listView.setAdapter(simpleAdapter);

    }

    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> maps = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("content", "不错哦，哈哈" + i);
            map.put("picture", R.drawable.ic_launcher);
            maps.add(map);
        }
        return maps;
    }


}
