package pl.osp.osptemplate.di.component;

import android.content.SharedPreferences;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import pl.osp.osptemplate.OspApp;
import pl.osp.osptemplate.di.module.AppModule;
import pl.osp.osptemplate.di.module.NetModule;
import pl.osp.osptemplate.network.IApiService;
import retrofit2.Retrofit;

/**
 * Created by WSienski on 18/04/2016.
 */
@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface AppComponent {

    void inject(OspApp myApplication);

    IApiService apiService();

    Retrofit retrofit();

    OkHttpClient okHttpClient();

    SharedPreferences sharedPreferences();

    EventBus eventBus();
}

