package gabriellee.project.mvp_rxjava_retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import gabriellee.project.mvp_rxjava_retrofit.adapter.CustomAdapter;
import gabriellee.project.mvp_rxjava_retrofit.contract.UserContract;
import gabriellee.project.mvp_rxjava_retrofit.model.User;

public class UserActivity extends AppCompatActivity implements UserContract.View {

    private UserContract.Presenter mPresenter;
    private RecyclerView recyclerview;
    CustomAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new UserPresenter(this);
        mPresenter.start();

    }

    @Override
    public void init() {
        recyclerview = findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerview.setLayoutManager(manager);
        mPresenter.loadUsers();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void loadDataInList(List<User> users) {
        adapter = new CustomAdapter(users);
        recyclerview.setAdapter(adapter);
    }
}
