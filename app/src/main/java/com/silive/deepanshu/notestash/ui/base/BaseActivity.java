package com.silive.deepanshu.notestash.ui.base;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;

import com.silive.deepanshu.notestash.di.module.BaseActivityModule;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasFragmentInjector;

/**
 * Created by deepanshu on 3/5/18.
 */

/**
 * Its implementation is as same as App the only difference in BaseActivity implements HasFragmentInjector
 * It is indicating that fragments are to participate in dagger.android injection.
 */

public abstract class BaseActivity extends Activity implements HasFragmentInjector {


    /**
     * A FragmentManager named BaseActivityModule.ACTIVITY_FRAGMENT_MANAGER is injected.
     * The name is necessary here to avoid conflicts between the activity’sFragmentManager and the fragment’s child FragmentManager during injection.
     */
    @Inject
    @Named(BaseActivityModule.ACTIVITY_FRAGMENT_MANAGER)
    protected FragmentManager fragmentManager;

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentInjector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public final AndroidInjector<Fragment> fragmentInjector() {
        return fragmentInjector;
    }

    /**
     * addFragment method provides subclasses the ability to add fragments
     *
     * @param containerViewId
     * @param fragment
     */
    protected final void addFragment(@IdRes int containerViewId, Fragment fragment) {
        fragmentManager.beginTransaction()
                .add(containerViewId, fragment)
                .commit();
    }
}
