package wsienski.iview.mycustomapp.network;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by WSienski on 08/04/2016.
 */
public interface IService {

    @GET("/test")
    Call<Test> getTest();

    @GET("/test")
    Observable<Test> getRxTest();

    @GET("/test2")
    Observable<Test> getRxTest2();
}
