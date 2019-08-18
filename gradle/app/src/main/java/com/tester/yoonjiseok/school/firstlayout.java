package com.tester.yoonjiseok.school;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class firstlayout extends Fragment {

    View v;

    private WebView mWebView;   // 웹뷰
    private WebSettings mWebSettings; //웹뷰세팅

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.first_layout, container, false);


         mWebView = (WebView)v.findViewById(R.id.webview);
        mWebView.setWebViewClient(new WebViewClient());
         mWebSettings = mWebView.getSettings();
         mWebSettings.setJavaScriptEnabled(true);
         mWebView.getSettings().setBuiltInZoomControls(true);
         mWebView.getSettings().setSupportZoom(true);
         mWebView.loadUrl("http://www.sungil.hs.kr/?_page=1");


         return v;


    }






}
