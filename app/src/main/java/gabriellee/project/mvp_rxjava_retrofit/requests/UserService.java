package gabriellee.project.mvp_rxjava_retrofit.requests;

import java.util.List;

import gabriellee.project.mvp_rxjava_retrofit.model.User;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface UserService {

    @GET("/posts")
    Observable<List<User>> getUsers();
}
