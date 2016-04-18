package pl.osp.osptemplate;

import android.app.Application;

import pl.osp.osptemplate.di.component.AppComponent;
import pl.osp.osptemplate.di.component.DaggerAppComponent;
import pl.osp.osptemplate.di.module.AppModule;
import pl.osp.osptemplate.di.module.NetModule;
import timber.log.Timber;

/**
 * Created by WSienski on 13/04/2016.
 */
public class OspApp extends Application {

    private final static String TAG = OspApp.class.getSimpleName();
    private AppComponent mAppComponent;

    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            //Timber.plant(new CrashReportingTree());
        }

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("http://demo0858935.mockable.io/"))
                .build();

        mAppComponent.inject(this);
    }


    public AppComponent getAppComponent() {
        return mAppComponent;
    }

}
