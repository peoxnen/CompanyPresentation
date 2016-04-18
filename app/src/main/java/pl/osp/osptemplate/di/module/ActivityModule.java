package pl.osp.osptemplate.di.module;

import android.app.Activity;

import dagger.Module;

/**
 * Created by WSienski on 18/04/2016.
 */
@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

}
