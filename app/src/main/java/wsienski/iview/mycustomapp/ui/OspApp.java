package wsienski.iview.mycustomapp.ui;

import android.app.Application;

import timber.log.Timber;
import wsienski.iview.mycustomapp.BuildConfig;

/**
 * Created by WSienski on 13/04/2016.
 */
public class OspApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}
