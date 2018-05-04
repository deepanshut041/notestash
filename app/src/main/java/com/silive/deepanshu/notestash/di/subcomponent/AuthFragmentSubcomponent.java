package com.silive.deepanshu.notestash.di.subcomponent;

import com.silive.deepanshu.notestash.di.PerFragment;
import com.silive.deepanshu.notestash.di.module.AuthFragmentModule;
import com.silive.deepanshu.notestash.ui.auth.AuthFragment;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by deepanshu on 4/5/18.
 */

/**
 * This AuthFragmentSubcomponent interface is used by Dagger to inject dependencies to the AuthFragment
 * The AuthFragmentSubcomponent extends AndroidInjector<MainFragment> and specifies that the AuthFragmentModule be used to provide
 * its dependencies and that the Builder build the subcomponent instance that will inject those dependencies into the AuthFragment.
 * The subcomponent is annotated with @PerFragment indicating that the specified modules provides @PerFragment scoped and non-scoped dependencies.
 */

// TODO (ContributesAndroidInjector) remove this in favor of @ContributesAndroidInjector
@PerFragment
@Subcomponent(modules = AuthFragmentModule.class)
public interface AuthFragmentSubcomponent extends AndroidInjector<AuthFragment> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<AuthFragment> {
    }
}
