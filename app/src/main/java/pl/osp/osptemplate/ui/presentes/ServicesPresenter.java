package pl.osp.osptemplate.ui.presentes;

import javax.inject.Inject;

import pl.osp.osptemplate.network.IApiService;
import pl.osp.osptemplate.ui.screen_contract.ServicesView;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by WSienski on 18/04/2016.
 */
public class ServicesPresenter implements BasePresenter<ServicesView> {

    private ServicesView mainView;
    private IApiService apiService;
    private Subscription subscription;

    @Inject
    public ServicesPresenter(IApiService apiService) {
        this.apiService = apiService;
    }

    public void getServices() {
        subscription = apiService.getServices().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                //.flatMap(servicelist -> Observable.from(servicelist.getServices()))
                .subscribe(serviceItem -> {
                    mainView.loadServices(serviceItem);
                    Timber.d("Services size: %s", serviceItem.getServices().length);
                });
    }

    @Override
    public void attachView(ServicesView view) {
        this.mainView = view;
    }

    @Override
    public void detachView() {
        if (subscription != null) subscription.unsubscribe();
    }
}
