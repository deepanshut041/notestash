package com.silive.deepanshu.notestash.ui.auth;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.silive.deepanshu.notestash.R;
import com.silive.deepanshu.notestash.ui.base.BaseActivity;

public class AuthActivity extends BaseActivity implements AuthFragmentListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        if (savedInstanceState == null) {
            addFragment(R.id.auth_fragment_container, new AuthFragment());
        }
    }

    @Override
    public void onLoginClicked() {
        // TODO start Login activity
        Toast.makeText(this, "Launch Login Activity", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSignupClicked() {
        // TODO start Signup activity
        Toast.makeText(this, "Launch SignUp Activity", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onGoogleClicked() {
        // TODO start Google authentication
        Toast.makeText(this, "Google Authentication", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFacebookClicked() {
        // TODO start Facebook authentication
        Toast.makeText(this, "Facebook Authentication", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSkipClicked() {
        // TODO skip authentication
        Toast.makeText(this, "Skip Authentication", Toast.LENGTH_SHORT).show();
    }
}
