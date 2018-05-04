package com.silive.deepanshu.notestash.ui.auth;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.silive.deepanshu.notestash.R;
import com.silive.deepanshu.notestash.ui.base.BaseFragment;

import javax.inject.Inject;

/**
 * The AuthFragment extends our BaseFragment and listens to the click events from 5 buttons declared in the auth_fragment layout.
 * The AuthFragmentListener methods are invoked in accordance to the click events.
 */
// TODO (Listener) Need to create AuthFragmentListener which will simply defines the methods that are invoked when the buttons are clicked.
public class AuthFragment extends BaseFragment implements View.OnClickListener {

    @Inject
    AuthFragmentListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_auth, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // TODO (Butterknife) replace with butterknife view binding
        view.findViewById(R.id.auth_button_login).setOnClickListener(this);
        view.findViewById(R.id.auth_button_signup).setOnClickListener(this);
        view.findViewById(R.id.auth_button_google).setOnClickListener(this);
        view.findViewById(R.id.auth_button_facebook).setOnClickListener(this);
        view.findViewById(R.id.auth_button_skip).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.auth_button_login:
                onLoginClicked();
                break;
            case R.id.auth_button_signup:
                onSignupClicked();
                break;
            case R.id.auth_button_google:
                onGoogleClicked();
                break;
            case R.id.auth_button_facebook:
                onFacebookClicked();
                break;
            case R.id.auth_button_skip:
                onSkipClicked();
                break;
            default:
                throw new IllegalArgumentException("Unhandled view " + v.getId());
        }

    }

    private void onSkipClicked() {
        listener.onSkipClicked();
    }

    private void onFacebookClicked() {
        listener.onFacebookClicked();
    }

    private void onGoogleClicked() {
        listener.onGoogleClicked();
    }

    private void onSignupClicked() {
        listener.onSignupClicked();
    }

    private void onLoginClicked() {
        listener.onLoginClicked();
    }
}
