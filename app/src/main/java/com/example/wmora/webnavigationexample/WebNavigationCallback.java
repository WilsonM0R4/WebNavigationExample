package com.example.wmora.webnavigationexample;

/**
 * Created by wmora on 29/03/17.
 */

public interface WebNavigationCallback {

    /**
     * onWebBackPressed() - listens for back pressed onClick()
     * **/
    boolean onWebBackPressed();

    /**
     * onWebForwardPressed() - listens for forward pressed onClick()
     * **/
    boolean onWebForwardPressed();
}
