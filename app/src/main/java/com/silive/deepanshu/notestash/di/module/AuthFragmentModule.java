package com.silive.deepanshu.notestash.di.module;

import android.app.Fragment;

import com.silive.deepanshu.notestash.di.PerFragment;
import com.silive.deepanshu.notestash.ui.auth.AuthFragment;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;

/**
 * Created by deepanshu on 4/5/18.
 */

/**
 * AuthFragmentModule includes the BaseFragmentModule and provides a concrete fragment
 * In this case the AuthFragment, as per the contract specified in BaseFragmentModule
 */

@Module(includes = BaseFragmentModule.class)
public abstract class AuthFragmentModule {

    @Binds
    @Named(BaseFragmentModule.FRAGMENT)
    @PerFragment
    abstract Fragment fragment(AuthFragment authFragment);
}
