package pl.osp.osptemplate.network;


import pl.osp.osptemplate.data.model.Services;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by WSienski on 08/04/2016.
 */
public interface IApiService {

    @GET("/services")
    Observable<Services> getServices();
}
