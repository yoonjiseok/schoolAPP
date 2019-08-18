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

public class fourth extends Fragment {

    View v;

    private WebView mWebView;   // 웹뷰
    private WebSettings mWebSettings; //웹뷰세팅

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fourth, container, false);


         mWebView = (WebView)v.findViewById(R.id.webview2);
        mWebView.setWebViewClient(new WebViewClient());
         mWebSettings = mWebView.getSettings();
         mWebSettings.setJavaScriptEnabled(true);
         mWebView.getSettings().setBuiltInZoomControls(true);
         mWebView.getSettings().setSupportZoom(true);
         mWebView.loadUrl("https://map.naver.com/index.nhn?pinTitle=%EC%84%B1%EC%9D%BC%EA%B3%A0%EB%93%B1%ED%95%99%EA%B5%90&pinType=site&pinId=12029404&mapMode=0");


         return v;


    }






}
