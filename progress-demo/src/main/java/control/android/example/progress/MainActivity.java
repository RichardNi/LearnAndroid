package control.android.example.progress;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private ProgressBar progressBar;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        progressBar = (ProgressBar) findViewById(R.id.pb);
        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        Button btnReduce = (Button) findViewById(R.id.btnReduce);
        Button btnReset = (Button) findViewById(R.id.btnReset);
        text = (TextView) findViewById(R.id.text);

        btnAdd.setOnClickListener(this);
        btnReduce.setOnClickListener(this);
        btnReset.setOnClickListener(this);

        progressBar.setMax(100);
        progressBar.setProgress(50);
        progressBar.setSecondaryProgress(70);

        text.setText("第一进度的百分比：" +
                (int) (progressBar.getProgress() / (float) progressBar.getMax() * 100) +
                "%，第二进度百分比：" +
                (int) (progressBar.getSecondaryProgress() / (float) progressBar.getMax() * 100) +
                "%");
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAdd:
                progressBar.incrementProgressBy(10);
                progressBar.incrementSecondaryProgressBy(10);
                break;
            case R.id.btnReduce:
                progressBar.incrementProgressBy(-10);
                progressBar.incrementSecondaryProgressBy(-10);
                break;
            case R.id.btnReset:
                progressBar.setProgress(50);
                progressBar.setSecondaryProgress(70);
                break;
            default:
                break;
        }
        
        text.setText("第一进度的百分比：" +
                (int) (progressBar.getProgress() / (float) progressBar.getMax() * 100) +
                "%，第二进度百分比：" +
                (int) (progressBar.getSecondaryProgress() / (float) progressBar.getMax() * 100) +
                "%");

    }
}
