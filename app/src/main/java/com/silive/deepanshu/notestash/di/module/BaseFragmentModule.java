package com.silive.deepanshu.notestash.di.module;

import android.app.Fragment;
import android.app.FragmentManager;

import com.silive.deepanshu.notestash.di.PerFragment;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by deepanshu on 3/5/18.
 */

/**
 * The BaseFragmentModule provides the base fragment dependencies
 */

@Module
public abstract class BaseFragmentModule {

    public static final String FRAGMENT = "BaseFragmentModule.fragment";

    public static final String CHILD_FRAGMENT_MANAGER = "BaseFragmentModule.childFragmentManager";

    @Provides
    @Named(CHILD_FRAGMENT_MANAGER)
    @PerFragment
    static FragmentManager childFragmentManager(@Named(FRAGMENT) Fragment fragment) {
        return fragment.getChildFragmentManager();
    }


}
