package com.silive.deepanshu.notestash.di.module;

import android.app.Activity;

import com.silive.deepanshu.notestash.di.subcomponent.AuthActivitySubcomponent;
import com.silive.deepanshu.notestash.ui.auth.AuthActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Created by deepanshu on 3/5/18.
 */

/**
 * The AppModule is an abstract class that is annotated with the @Module annotation and includes the AndroidInjectionModule
 * It contains bindings to ensure the usability of dagger.android framework classes
 */

@Module(includes = AndroidInjectionModule.class, subcomponents = AuthActivitySubcomponent.class)
public abstract class AppModule {

    // TODO (ContributesAndroidInjector) remove this in favor of @ContributesAndroidInjector

    /**
     * authActivityInjectorFactory provides the injector for the AuthActivity.
     * The AuthActivitySubcomponent has also been added as a subcomponent in the @Module subcomponents field.
     */
    @Binds
    @IntoMap
    @ActivityKey(AuthActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>
    authActivityInjectorFactory(AuthActivitySubcomponent.Builder builder);

}
