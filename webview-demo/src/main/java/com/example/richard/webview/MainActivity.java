package com.example.richard.webview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MainActivity extends ActionBarActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // 当点击手机"返回"按钮并且WebView中有历史记录能返回，则返回上一个页面。
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void init() {
        webView = (WebView) findViewById(R.id.wv);
        webView.loadUrl("http://www.baidu.com");
        WebSettings webSettings = webView.getSettings();
        // 在WebView中启用JavaScript
        webSettings.setJavaScriptEnabled(true);

        // WebViewClient帮助WebView去处理一些页面控制和请求通知
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                // true:使用WebView打开URL，false:使用系统浏览器打开URL
                return true;
            }

        });


    }

}
