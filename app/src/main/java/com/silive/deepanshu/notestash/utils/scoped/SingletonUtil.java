package com.silive.deepanshu.notestash.utils.scoped;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by deepanshu on 3/5/18.
 */

/**
 * The SingletonUtil is scoped with @Singleton.
 * This means that the Application and all Activities, Fragments, and child Fragments and their dependencies will share the same single instance of this class.
 */
@Singleton
public final class SingletonUtil {

    /**
     * Default, package-private constructor is provided and annotated with @Inject
     * In order to automatically provide an instance of this class without having to manually create a new instance of it
     */
    @Inject
    SingletonUtil() {
    }

    /**
     * doSomething() method returns the instance’s hashCode.
     * This will be used on to verify that the same instance is used in all Activities, Fragments, and child Fragments.
     */
    public String doSomething() {
        return "SingletonUtil: " + hashCode();
    }
}
