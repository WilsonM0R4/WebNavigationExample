package com.example.wmora.webnavigationexample;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by wmora on 29/03/17.
 */

public class WebFragment extends Fragment implements WebNavigationCallback, WebNavigationListener{


    /**
     * Enabling callback for set back and forward button status
     * **/
    WebNavigationEnablingCallback enablingCallback;

    /**
     * Class variables
     * **/
    WebView webView;


    /**
     * Fragment override methods
     * **/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.web_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){

        webView = (WebView) view.findViewById(R.id.web_view);
        webView.setWebViewClient( new ExampleWebViewClient(WebFragment.this));
        webView.loadUrl("https://www.google.com.co");

        enablingCallback = (MainActivity) getActivity();

    }


    /**
     * WebNavigationCallback override methods
     * **/
    @Override
    public boolean onWebBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();

        }

        return false;
    }

    @Override
    public boolean onWebForwardPressed() {
        if(webView.canGoForward()){
            webView.goForward();

        }

        return false;
    }


    /**
     * WebNavigationListener override methods
     * **/
    @Override
    public void onBackAvailable(boolean isAvailable) {
        enablingCallback.canGoForward(isAvailable);
    }

    @Override
    public void onForwardAvailable(boolean isAvailable) {
        enablingCallback.canGoBack(isAvailable);
    }


    /**
     * Inner WebViewClient extended class
     * **/
    private class ExampleWebViewClient extends WebViewClient {

        /**
         * Navigation listener used for set navigation status
         * **/
        WebNavigationListener listener;

        /**
         * public constructor
         * **/
        public ExampleWebViewClient(WebFragment parent){
            listener = parent;
        }

        /**
         * WebViewClient override methods
         * **/
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url){
            return false;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon){
            super.onPageStarted(view, url, favicon);

            listener.onBackAvailable(view.canGoBack());
            listener.onForwardAvailable(view.canGoForward());
        }

        @Override
        public void onPageFinished(WebView view, String url){
            super.onPageFinished(view, url);

            listener.onBackAvailable(view.canGoBack());
            listener.onForwardAvailable(view.canGoForward());
        }

    }

}
