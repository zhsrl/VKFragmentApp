package com.e.vknew.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.e.vknew.R;
import com.e.vknew.ui.home.FeedFragment;
import com.e.vknew.ui.models.FeedModel;
import com.e.vknew.ui.models.StoriesModel;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class StoriesAdapter extends RecyclerView.Adapter<StoriesAdapter.MyViewHolder> {
    Context context;
    private List<StoriesModel> mData;
    RequestManager glide;
    FeedFragment feedFragment;


    public StoriesAdapter(Context context, List<StoriesModel> mData) {
        this.context = context;
        this.mData = mData;
        this.glide = Glide.with(context);
    }

    public StoriesAdapter() {

    }




    @NonNull
    @Override
    public StoriesAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.stories_model, null, false);
        RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        view.setLayoutParams(params);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoriesAdapter.MyViewHolder holder, int position) {
        holder.userName.setText(mData.get(position).getUserName());
        glide.load(mData.get(position).getStoriesPic()).into(holder.storiesPic);
    }

    @Override
    public int getItemCount() {
        if (mData == null)return 0;
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView userName;
        CircleImageView storiesPic;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            storiesPic = itemView.findViewById(R.id.user_picture);
            userName = itemView.findViewById(R.id.user_name);
        }
    }
}
