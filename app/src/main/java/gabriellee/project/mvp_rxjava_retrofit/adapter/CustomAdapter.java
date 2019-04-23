package gabriellee.project.mvp_rxjava_retrofit.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import gabriellee.project.mvp_rxjava_retrofit.R;
import gabriellee.project.mvp_rxjava_retrofit.model.User;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private List<User> mUser;

    public CustomAdapter(List<User> user) {
        this.mUser = user;
    }

    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_item, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.tvTitle.setText(mUser.get(i).getTitle());
        myViewHolder.tvId.setText(String.valueOf(mUser.get(i).getId()));
        myViewHolder.tvBody.setText(mUser.get(i).getBody());
    }

    @Override
    public int getItemCount() {
        return mUser.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvId, tvTitle, tvBody;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.user_id);
            tvTitle = itemView.findViewById(R.id.user_title);
            tvBody = itemView.findViewById(R.id.user_body);
        }
    }
}
