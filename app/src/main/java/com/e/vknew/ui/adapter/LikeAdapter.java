package com.e.vknew.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.RequestManager;
import com.e.vknew.R;
import com.e.vknew.ui.models.FeedModel;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class LikeAdapter<ItemClickListener,FragmentLikeListener> extends RecyclerView.Adapter<LikeAdapter.MyViewHolder> {
    private List<FeedModel> mData;
    public @Nullable ItemClickListener listener;
     @Nullable FragmentLikeListener fragmentLikeListener;

    RequestManager glide;

    public LikeAdapter(List<FeedModel> mData,
                       @Nullable FeedAdapter.ItemClickListener listener,
                       @Nullable FragmentLikeListener fragmentLikeListener){
        this.mData = mData;
        this.listener = (ItemClickListener) listener;
        this.fragmentLikeListener = fragmentLikeListener;
    }

    @NonNull
    @Override
    public LikeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feed_model,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LikeAdapter.MyViewHolder holder,final int position) {
        final FeedModel feedModel = mData.get(getItemViewType(position));
        holder.uploadername.setText(mData.get(position).getName());
        holder.posttime.setText(mData.get(position).getTime());
        holder.likes.setText(mData.get(position).getLikes());
        holder.comments.setText(mData.get(position).getComments());
        holder.shares.setText(mData.get(position).getShares());
        holder.views.setText(mData.get(position).getViews());
        holder.postText.setText(mData.get(position).getPostText());

        holder.likes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fragmentLikeListener != null)
                    fragmentLikeListener.removeItemLike(feedModel);
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null)
                    listener.ItemClick(position,feedModel);
            }
        });

        if(feedModel.isLiked() == true){
            holder.likes.setImageResource(R.drawable.ic_favorite_black_24dp);
        }else
            holder.likes.setImageResource(R.drawable.ic_favorite_border_black_24dp);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView uploadername,posttime,postText,likes,comments,shares,views;
        CircleImageView uploader;
        ImageView post;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            uploadername = itemView.findViewById(R.id.user_name);
            posttime = itemView.findViewById(R.id.post_time);
            likes = itemView.findViewById(R.id.cnt_like);
            postText = itemView.findViewById(   R.id.post_text);
            comments = itemView.findViewById(R.id.cnt_comment);
            shares = itemView.findViewById(R.id.cnt_shares);
            views = itemView.findViewById(R.id.cnt_view);

            uploader = itemView.findViewById(R.id.user_avatar);
            post = itemView.findViewById(R.id.post_pic);

        }

        public int getItemViewType(int position){
            return position;
        }

        public interface ItemClickListener{
            void ItemClick(int position,FeedModel item);
            void LikeClick(int position,FeedModel item);
        }

        public interface FragmentLikeListener{
            void removeItemLike(FeedModel news);
        }
    }
}
