package com.silive.deepanshu.notestash.ui.auth;

/**
 * Created by deepanshu on 4/5/18.
 */


/**
 * AuthFragmentListener simply defines the methods that are invoked when the buttons are clicked
 */
public interface AuthFragmentListener {

    void onLoginClicked();

    void onSignupClicked();

    void onGoogleClicked();

    void onFacebookClicked();

    void onSkipClicked();
}
