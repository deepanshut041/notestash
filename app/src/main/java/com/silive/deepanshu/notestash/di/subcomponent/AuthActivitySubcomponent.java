package com.silive.deepanshu.notestash.di.subcomponent;

import com.silive.deepanshu.notestash.di.PerActivity;
import com.silive.deepanshu.notestash.di.module.AuthActivityModule;
import com.silive.deepanshu.notestash.ui.auth.AuthActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by deepanshu on 4/5/18.
 */

/**
 * AuthActivitySubcomponent extends AndroidInjector<MainActivity> and specifies that the AuthActivityModule be used to provide its dependencies
 * Builder build the subcomponent instance that will inject those dependencies into the AuthActivity.
 * The subcomponent is annotated with @PerActivity indicating that the specified modules provides @PerActivity scoped and non-scoped dependencies.
 */
// TODO (ContributesAndroidInjector) remove this in favor of @ContributesAndroidInjector
@PerActivity
@Subcomponent(modules = AuthActivityModule.class)
public interface AuthActivitySubcomponent extends AndroidInjector<AuthActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<AuthActivity> {

    }
}
