package com.example.project;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    WebView webview;
    public void showInternalWebPage(){
        webview.loadUrl("file:///android_asset/about.html");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        webview = findViewById(R.id.webview);
        showInternalWebPage();
    }
}