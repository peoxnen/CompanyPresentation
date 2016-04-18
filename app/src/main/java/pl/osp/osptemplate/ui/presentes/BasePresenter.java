package pl.osp.osptemplate.ui.presentes;

/**
 * Created by WSienski on 18/04/2016.
 */
public interface BasePresenter<V> {

    void attachView(V view);

    void detachView();

}
