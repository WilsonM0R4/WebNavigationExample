package com.example.wmora.webnavigationexample;

/**
 * Created by wmora on 29/03/17.
 */

public interface WebNavigationEnablingCallback {

    /**
     * canGoBack() - listens for webView.canGoBack()
     * **/
    void canGoBack(boolean canGoBack);

    /**
     * canGoForward() - listens for webView.canGoForward()
     * **/
    void canGoForward(boolean canGoForward);

}
