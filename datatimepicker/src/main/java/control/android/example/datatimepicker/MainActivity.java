package control.android.example.datatimepicker;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;


public class MainActivity extends ActionBarActivity {
    private static final String TAG = "Main";
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Calendar cal = Calendar.getInstance();

        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH) + 1;
        day = cal.get(Calendar.DAY_OF_MONTH);
        hour = cal.get(Calendar.HOUR_OF_DAY);
        minute = cal.get(Calendar.MINUTE);
        // 12小时制的小时
        int hour2 = cal.get(Calendar.HOUR);
        Log.i(TAG, hour2 + "");

        setTitle(year + "-" + month + "-" + day + " " + hour + ":" + minute);

        DatePicker datePicker = (DatePicker) findViewById(R.id.dp);
        datePicker.init(year, cal.get(Calendar.MONTH), day, dateListener);

        TimePicker timePicker = (TimePicker) findViewById(R.id.tp);

        timePicker.setOnTimeChangedListener(timeListener);

    }

    private DatePicker.OnDateChangedListener dateListener = new DatePicker.OnDateChangedListener() {
        @Override
        public void onDateChanged(DatePicker view, int y, int monthOfYear, int dayOfMonth) {
            year = y;
            month = monthOfYear;
            day = dayOfMonth;
            setTitle(year + "-" + (month + 1) + "-" + day + " " + hour + ":" + minute);

        }
    };

    private TimePicker.OnTimeChangedListener timeListener = new TimePicker.OnTimeChangedListener() {
        @Override
        public void onTimeChanged(TimePicker view, int hourOfDay, int m) {
            hour = hourOfDay;
            minute = m;
            setTitle(year + "-" + (month + 1) + "-" + day + " " + hour + ":" + minute);
        }
    };



}

