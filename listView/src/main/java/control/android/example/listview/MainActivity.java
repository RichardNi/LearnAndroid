package control.android.example.listview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

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

    private static final String TAG = "Main";

    private ListView listView;
    private List<Map<String, Object>> dataList;
    private SimpleAdapter simpleAdapter;

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

        listView = (ListView) findViewById(R.id.lv_show);
        // 设置adapter到ListView上
//        listView.setAdapter(arrayAdapter);

        /**
         * data:数据源
         * resource:ListView列表项的布局文件
         * from:数据源中Map对象的键(Key)列表
         * to:保存布局文件中控件的id列表(与前面的from里面保存的键列表一一对应)
         **/
        simpleAdapter = new SimpleAdapter(this, getData(), R.layout.item,
                new String[]{"picture", "content"}, new int[]{R.id.pic, R.id.txt});

        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(onItemClickListener);
        listView.setOnScrollListener(onScrollListener);

    }

    /**ListView 每一项的点击事件*/
    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Object obj = listView.getItemAtPosition(position);

            Toast.makeText(MainActivity.this, "点击了第：" + position + "行\n内容："+ obj,
                    Toast.LENGTH_LONG).show();

            Log.i(TAG, "position:" + position + ", id:" + id + ", obj:" + obj);
        }
    };

    /**ListView滚动事件*/
    private AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(AbsListView view, int scrollState) {
            switch (scrollState) {
                case SCROLL_STATE_FLING:
                    Log.i(TAG, "用户手指在离开屏幕之前，由于用力滑了一下，视图由于惯性仍在滑动");
                    Map<String, Object> map = new HashMap<>();
                    map.put("content", "新增出来的数据哦");
                    map.put("picture", R.drawable.ic_launcher);
                    // 添加新的数据到数据源中
                    dataList.add(map);
                    // 通知adapter数据改变，刷新UI
                    simpleAdapter.notifyDataSetChanged();
                    break;
                case SCROLL_STATE_IDLE:
                    Log.i(TAG, "视图已经停止滚动");
                    break;
                case SCROLL_STATE_TOUCH_SCROLL:
                    Log.i(TAG, "手指没有离开屏幕，视图正在滑动");
                    break;
                default:
                    Log.i(TAG, "未知状态：" + scrollState);
                    break;
            }
        }

        @Override
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

        }
    };

    private List<Map<String, Object>> getData() {
        dataList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("content", "不错哦，哈哈" + i);
            map.put("picture", R.drawable.ic_launcher);
            map.put("id", i);
            dataList.add(map);
        }
        return dataList;
    }


}
