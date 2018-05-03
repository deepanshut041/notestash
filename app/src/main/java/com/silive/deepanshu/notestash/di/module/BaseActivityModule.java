package com.silive.deepanshu.notestash.di.module;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;


import com.silive.deepanshu.notestash.di.PerActivity;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Created by deepanshu on 3/5/18.
 */

/**
 * BaseActivityModule provides the base activity dependencies
 */

@Module
public abstract class BaseActivityModule {


    static final String ACTIVITY_FRAGMENT_MANAGER = "BaseActivityModule.activityFragmentManager";

    @Provides
    @Named(ACTIVITY_FRAGMENT_MANAGER)
    @PerActivity
    static FragmentManager activityFragmentManager(Activity activity) {
        return activity.getFragmentManager();
    }

    @Binds
    @PerActivity
    abstract Context activityContext(Activity activity);
}
