package com.silive.deepanshu.notestash.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by deepanshu on 3/5/18.
 */

// The @PerChildFragment custom scoping annotation specifies that the lifespan of a dependency be the same as that of a child Fragment
// This is used to annotate dependencies that behave like a singleton within the lifespan of a child Fragment instead of the entire Application, Activity, or parent Fragment.

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerChildFragment {
}
