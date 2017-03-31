package com.example.wmora.webnavigationexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements WebNavigationEnablingCallback{


    /**
     * Callback object for web navigation
     * **/
    WebNavigationCallback callback;

    /**
     * Navigation buttons
     * **/
    ImageButton backButton, forwardButton;

    /**
     * Activity override methods
     * **/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        initViews();
        setListeners();

    }

    /**
     * Navigation callback override methods
     * **/
    @Override
    public void canGoBack(boolean canGoBack) {
        enableBack(canGoBack);
    }

    @Override
    public void canGoForward(boolean canGoForward) {
        enableForward(canGoForward);
    }


    /**
     * PROPER METHODS
     *
     * initViews() - used for init all views in the activity
     * */
    private void initViews(){
        backButton = (ImageButton) findViewById(R.id.ib_backWeb);
        forwardButton = (ImageButton) findViewById(R.id.ib_forwardWeb);

        WebFragment fragment = new WebFragment();
        callback = fragment;

        getFragmentManager().beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit();
    }

    /**
     * setListeners() - used for add all needed listeners for any view
     * **/

    private void setListeners(){
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableBack(callback.onWebBackPressed());
            }
        });

        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableForward(callback.onWebForwardPressed());
            }
        });
    }

    /**
     * enableForward() - used for change forward button status
     * **/

    private void enableForward(boolean canGoBack){
        if(canGoBack){
            backButton.setImageResource(R.drawable.navigation__backurl);
        }else{
            backButton.setImageResource(R.drawable.navigation__backurl_2);
        }
    }

    /**
     * enableBack() - used for change back button status
     * **/

    private void enableBack(boolean canGoForward){
        if(canGoForward){
            forwardButton.setImageResource(R.drawable.navigation__fwdurl_2);
        }else{
            forwardButton.setImageResource(R.drawable.navigation__fwdurl);
        }
    }


}
