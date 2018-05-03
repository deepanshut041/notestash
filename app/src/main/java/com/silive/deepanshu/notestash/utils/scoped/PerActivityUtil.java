package com.silive.deepanshu.notestash.utils.scoped;

/**
 * Created by deepanshu on 3/5/18.
 */

import android.app.Activity;

import javax.inject.Inject;

/**
 * The PerActivityUtil is scoped with @PerActivity.
 * This means that the Activity and all of its Fragments and child Fragments and their dependencies will share the same instance of this class.
 * However, different activity instances will have their own instances.
 * This is not available at the Application level.
 */
public final class PerActivityUtil {

    private final Activity activity;

    /**
     * Default, package-private constructor is provided and annotated with @Inject
     * In order to automatically provide an instance of this class without having to manually create a new instance of it
     */
    @Inject
    PerActivityUtil(Activity activity) {
        this.activity = activity;
    }

    /**
     * doSomething() method returns the instance’s and activity’shashCode.
     * This will be used to verify that the same instance is used in all Fragments and child Fragments of each Activity though each Activity will have their own instance.
     */
    public String doSomething() {
        return "PerActivityUtil: " + hashCode() + ", Activity: " + activity.hashCode();
    }
}
