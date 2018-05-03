package com.silive.deepanshu.notestash.ui.base;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.support.annotation.IdRes;

import com.silive.deepanshu.notestash.di.module.BaseFragmentModule;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasFragmentInjector;

/**
 * Created by deepanshu on 3/5/18.
 */

/**
 * Its implementation is as same as App the only difference in BaseFragment implements HasFragmentInjector
 * It is indicating that child fragments are to participate in dagger.android injection.
 */
public abstract class BaseFragment extends Fragment implements HasFragmentInjector {

    @Inject
    protected Context activityContext;

    /**
     * The activity Context, which is provided by the BaseActivityModule, is injected here as well as a FragmentManager named BaseFragmentModule.CHILD_FRAGMENT_MANAGER
     * The name is necessary here to avoid conflicts between the activity’sFragmentManager and the fragment’s child FragmentManager during injection.
     * <p>
     * ** Note that this should not be used within a child fragment.
     */
    @Inject
    @Named(BaseFragmentModule.CHILD_FRAGMENT_MANAGER)
    protected FragmentManager childFragmentManager;

    @Inject
    DispatchingAndroidInjector<Fragment> childFragmentInjector;


    /**
     * The injection occurs in onAttach before the call to super
     * AndroidInjection.inject(this) in onAttach(Context) for Android versions M (API level 23) and above and also in onAttach(Activity) for Android versions L (API level 22) and below.
     * The reason is that onAttach(Activity) has been deprecated starting at API level 23.
     * Do not only perform the injection in onAttach(Context) because it will not be invoked by devices running Lollipop (API level 22) and below
     * It will cause a NullPointerException when trying to access Fragment dependencies.
     */


    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            // Perform injection here for versions before M as onAttach(*Context*) did not yet exist
            // This fixes DaggerFragment issue: https://github.com/google/dagger/issues/777
            AndroidInjection.inject(this);
        }
        super.onAttach(activity);
    }

    @Override
    public void onAttach(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // Perform injection here for M (API 23) due to deprecation of onAttach(*Activity*)
            AndroidInjection.inject(this);
        }
        super.onAttach(context);
    }

    @Override
    public final AndroidInjector<Fragment> fragmentInjector() {
        return childFragmentInjector;
    }

    /**
     * addChildFragment method provides subclasses the ability to add child fragments
     */
    protected final void addChildFragment(@IdRes int containerViewId, Fragment fragment) {
        childFragmentManager.beginTransaction()
                .add(containerViewId, fragment)
                .commit();
    }

}
