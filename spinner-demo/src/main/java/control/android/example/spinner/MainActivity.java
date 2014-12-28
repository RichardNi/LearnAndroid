package control.android.example.spinner;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends ActionBarActivity {
    private static final String TAG = "Main";

    private TextView textView;
    private Spinner spinner;
    List<String> itemCity = new ArrayList<>();
    List<Map<String, Object>> listMapCity = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
        demo2();
    }

    private void demo() {
        textView = (TextView) findViewById(R.id.tv_city);
        initData();
        textView.setText("你选择的城市是：" + itemCity.get(0));

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,
                itemCity);

        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String cityName = adapter.getItem(position);
                textView.setText("你选择的城市是：" + cityName);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.i(TAG, "什么也没有选中");
            }
        });
    }

    private void demo2() {
        getData();

        final SimpleAdapter adapter = new SimpleAdapter(this, listMapCity, R.layout.item,
                new String[]{"image", "text"}, new int[]{R.id.image, R.id.tv_city});
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Map<String, Object> map = (HashMap<String, Object>) adapter.getItem(position);
                Toast.makeText(MainActivity.this, map.get("text").toString(),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void getData() {
        initData();
        Map<String, Object> map;
        for (String s : itemCity) {
            map = new HashMap<>();
            map.put("image", R.drawable.ic_launcher);
            map.put("text", s);
            listMapCity.add(map);
        }
    }

    private void initData() {
        itemCity.add("北京");
        itemCity.add("上海");
        itemCity.add("广州");
        itemCity.add("深圳");
        itemCity.add("成都");
    }




}
