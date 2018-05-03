package com.silive.deepanshu.notestash.utils.scoped;

import android.app.Fragment;

import com.silive.deepanshu.notestash.di.PerChildFragment;
import com.silive.deepanshu.notestash.di.module.BaseChildFragmentModule;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by deepanshu on 3/5/18.
 */

/**
 * The PerChildFragmentUtil is scoped with @PerChildFragment.
 * This means that the child Fragment (a fragment inside a fragment that is added using Fragment.getChildFragmentManager()) and all of its dependencies will share the same instance of this class.
 * However, different child fragments instances will have their own instances of this class.
 * This is not available at the (parent) Fragment, Activity, and Application level.
 */
@PerChildFragment
public final class PerChildFragmentUtil {

    private final Fragment childFragment;

    /**
     * Default, package-private constructor is provided and annotated with @Inject
     * In order to automatically provide an instance of this class without having to manually create a new instance of it
     */
    @Inject
    PerChildFragmentUtil(@Named(BaseChildFragmentModule.CHILD_FRAGMENT) Fragment childFragment) {
        this.childFragment = childFragment;
    }

    /**
     * The doSomething() method returns the instance’s and child fragment’s hashCode.
     * This will be used to verify that no same instance is used in different child fragments.
     */
    public String doSomething() {
        return "PerChildFragmentUtil: " + hashCode()
                + ", child Fragment: " + childFragment.hashCode();
    }
}
