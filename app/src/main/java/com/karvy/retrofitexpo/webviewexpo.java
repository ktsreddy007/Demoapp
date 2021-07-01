package com.karvy.retrofitexpo;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class webviewexpo extends AppCompatActivity
{
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webviewexpo);
        webView=findViewById(R.id.wv);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.amazon.in");
      //  webView.loadUrl("http://www.google.com");
    }
    @Override
    public void onBackPressed()
    {
        if (webView.canGoBack())
        {
            webView.goBack();
        }
        else
        {
            super.onBackPressed();
        }
    }
}