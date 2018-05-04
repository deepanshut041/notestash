package com.silive.deepanshu.notestash.di.module;

import android.app.Activity;
import android.app.Fragment;

import com.silive.deepanshu.notestash.di.PerActivity;
import com.silive.deepanshu.notestash.di.subcomponent.AuthFragmentSubcomponent;
import com.silive.deepanshu.notestash.ui.auth.AuthActivity;
import com.silive.deepanshu.notestash.ui.auth.AuthFragment;
import com.silive.deepanshu.notestash.ui.auth.AuthFragmentListener;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.FragmentKey;
import dagger.multibindings.IntoMap;

/**
 * Created by deepanshu on 4/5/18.
 */

/**
 * The AuthActivityModule includes the BaseActivityModule and specifies that the AuthFragmentSubcomponent is a subcomponent of this module
 * (thereby gaining access to this activity’s, and in turn the application’s, dependencies).
 */
@Module(includes = BaseActivityModule.class,
        subcomponents = AuthFragmentSubcomponent.class)
public abstract class AuthActivityModule {

    // TODO (ContributesAndroidInjector) remove this in favor of @ContributesAndroidInjector

    /**
     * authFragmentInjectorFactory method takes in the AuthFragmentSubcomponent.
     * Builder and returns the AndroidInjectorFactory.
     * This provides the injector for the AuthFragment.
     */
    @Binds
    @IntoMap
    @FragmentKey(AuthFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment>
    authFragmentInjectorFactory(AuthFragmentSubcomponent.Builder builder);

    /**
     * activity method takes in a concrete activity, in this case AuthActivity, as per the contract specified in BaseActivityModule
     */
    @Binds
    @PerActivity
    abstract Activity activity(AuthActivity authActivity);

    /**
     * authFragmentListener takes in the AuthActivity, which implements AuthFragmentListener,
     * and binds it into the AuthFragment that expects a AuthFragmentListener to be injected
     */
    @Binds
    @PerActivity
    abstract AuthFragmentListener authFragmentListener(AuthActivity authActivity);
}
