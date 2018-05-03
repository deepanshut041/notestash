package com.silive.deepanshu.notestash.di.component;

import com.silive.deepanshu.notestash.App;
import com.silive.deepanshu.notestash.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;


/**
 * Created by deepanshu on 3/5/18.
 */

/**
 * The AppComponent is annotated with @Component and @Singleton to indicate that its modules (AppModule) are to provide @Singleton scoped or unscoped dependencies.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(App app);
}
