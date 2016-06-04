package com.example.cookiesfly.sustlibrary;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainWeb extends AppCompatActivity{

    // WebView访问的URL地址
    private String url = "http://222.24.94.244/ml/Default.do";
    private WebView webView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去掉标题栏
        //requestWindowFeature(Window.FEATURE_NO_TITLE);//Activity
        getSupportActionBar().hide();
        //全屏
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main_web);

        // 获取WebView元素
        webView = (WebView) findViewById(R.id.web);
        //设置使用够执行JS脚本
        webView.getSettings().setJavaScriptEnabled(true);
        //设置支持变焦
        webView.getSettings().setSupportZoom(true);
        //设置使支持缩放
        webView.getSettings().setBuiltInZoomControls(true);
        //滚动条风格，为0就是不给滚动条留空间，滚动条覆盖在网页上
        webView.setScrollBarStyle(0);
        //优先使用缓存
        webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

        //加载url网页
        webView.loadUrl(url);

        //点击链接继续在当前 browser中响应
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url){
                view.loadUrl(url);//使用当前WebView处理跳转
                return true;
            }
        });

        WebChromeClient mWebChromeClient = new WebChromeClient() {
            //获得网页的加载进度，显示在右上角的TextView控件中
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress < 100) {
                    String progress = newProgress + "%";
                }
            }
        };
        //webView.setWebChromeClient(new MyWebViewClient());
    }


    //默认点回退键，会退出Activity，需监听按键操作，使回退在WebView内发生
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
