package com.silive.deepanshu.notestash.utils.scoped;

import android.app.Fragment;

import com.silive.deepanshu.notestash.di.PerFragment;
import com.silive.deepanshu.notestash.di.module.BaseFragmentModule;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by deepanshu on 3/5/18.
 */

/**
 * The PerFragmentUtil is scoped with @PerFragment.
 * This means that the Fragment and all of its child fragments and their dependencies will share the same instance of this class.
 * However, different fragment instances will have their own instances.
 * This is not available at the Activity and Application level.
 */

@PerFragment
public final class PerFragmentUtil {

    private final Fragment fragment;

    /**
     * Default, package-private constructor is provided and annotated with @Inject
     * In order to automatically provide an instance of this class without having to manually create a new instance of it
     */
    @Inject
    PerFragmentUtil(@Named(BaseFragmentModule.FRAGMENT) Fragment fragment) {
        this.fragment = fragment;
    }

    /**
     * The doSomething() method returns the instance’s and fragment’s hashCode.
     * This will be used later on to verify that the same instance is used in all child Fragments of each (parent) Fragment though each (parent) Fragment will have their own instance.
     */
    public String doSomething() {
        return "PerFragmentUtil: " + hashCode() + ", Fragment: " + fragment.hashCode();
    }
}
