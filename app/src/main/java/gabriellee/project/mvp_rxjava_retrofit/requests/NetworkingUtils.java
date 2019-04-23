package gabriellee.project.mvp_rxjava_retrofit.requests;

import gabriellee.project.mvp_rxjava_retrofit.requests.RetrofitAdapter;
import gabriellee.project.mvp_rxjava_retrofit.requests.UserService;

public class NetworkingUtils {

    private static UserService userService;

    public static UserService getUserApiInstance() {
        if (userService == null) userService = RetrofitAdapter.getInstance().create(UserService.class);

        return userService;
    }
}
