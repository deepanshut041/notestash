package com.silive.deepanshu.notestash.di.module;

import dagger.Module;
import dagger.android.AndroidInjectionModule;

/**
 * Created by deepanshu on 3/5/18.
 */

/**
 * The AppModule is an abstract class that is annotated with the @Module annotation and includes the AndroidInjectionModule
 * It contains bindings to ensure the usability of dagger.android framework classes
 */

@Module(includes = AndroidInjectionModule.class)
public abstract class AppModule {

}
