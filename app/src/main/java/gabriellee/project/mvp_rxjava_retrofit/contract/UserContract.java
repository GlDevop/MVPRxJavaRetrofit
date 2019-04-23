package gabriellee.project.mvp_rxjava_retrofit.contract;

import java.util.List;

import gabriellee.project.mvp_rxjava_retrofit.model.User;

public interface UserContract {

    interface View {
        void init();

        void showError(String message);

        void loadDataInList(List<User> users);
    }

    interface Presenter {

        void start();

        void loadUsers();

    }
}
