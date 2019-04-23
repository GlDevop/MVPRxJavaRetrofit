package gabriellee.project.mvp_rxjava_retrofit;

import android.content.Context;

import java.util.List;

import gabriellee.project.mvp_rxjava_retrofit.contract.UserContract;
import gabriellee.project.mvp_rxjava_retrofit.model.User;
import gabriellee.project.mvp_rxjava_retrofit.requests.UserTask;
import gabriellee.project.mvp_rxjava_retrofit.utils.Callback;

public class UserPresenter implements UserContract.Presenter {

    UserContract.View mView;

    public UserPresenter(UserContract.View view) {
        this.mView = view;
    }

    @Override
    public void start() {
        mView.init();
    }

    @Override
    public void loadUsers() {
        UserTask.getUsers(new Callback<List<User>>() {
            @Override
            public void returnResult(List<User> users) {
                mView.loadDataInList(users);
            }

            @Override
            public void returnError(String message) {
                mView.showError(message);
            }
        });
    }
}
