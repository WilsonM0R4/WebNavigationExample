package com.example.wmora.webnavigationexample;

/**
 * Created by wmora on 30/03/17.
 */

public interface WebNavigationListener {

    /**
     * onBackAvailable() - listens for web back availability
     * @param isAvailable
     *  available to go back
     * **/
    void onBackAvailable(boolean isAvailable);

    /**
     * onBackAvailable() - listens for web back availability
     * @param isAvailable
     *  available to go forward
     * **/
    void onForwardAvailable(boolean isAvailable);

}
