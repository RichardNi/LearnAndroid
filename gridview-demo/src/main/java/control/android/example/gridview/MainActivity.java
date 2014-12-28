package control.android.example.gridview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends ActionBarActivity {
    private static final String TAG = "Main";

    private int[] icons = {R.drawable.address_book, R.drawable.calendar, R.drawable.camera,
            R.drawable.clock, R.drawable.games_control, R.drawable.messenger,
            R.drawable.ringtone, R.drawable.settings, R.drawable.speech_balloon,
            R.drawable.weather, R.drawable.world, R.drawable.youtube};

    private String[] names = {"通讯录", "日历", "相机", "时钟", "游戏", "短信", "铃声", "设置",
            "语音", "天气", "浏览器", "YouTube"};
    private List<Map<String, Object>> data = new ArrayList<>();

    private GridView gridView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        gridView = (GridView) findViewById(R.id.gv);
        SimpleAdapter adapter = new SimpleAdapter(this, getData(), R.layout.item,
                new String[]{"img", "txt"}, new int[]{R.id.img, R.id.txt});
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, names[position], Toast.LENGTH_SHORT).show();
                Log.i(TAG, "点击了第：" + position + "个元素，id：" + id + "，View：" + view);
            }
        });

    }

    private List<Map<String, Object>> getData() {
        Map<String, Object> map;
        for (int i = 0; i < icons.length; i++) {
            map = new HashMap<>();
            map.put("img", icons[i]);
            map.put("txt", names[i]);
            data.add(map);
        }
        return data;
    }

}
