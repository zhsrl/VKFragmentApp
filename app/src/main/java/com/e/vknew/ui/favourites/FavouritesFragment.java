package com.e.vknew.ui.favourites;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.e.vknew.FeedDetailActivity;
import com.e.vknew.MainActivity;
import com.e.vknew.R;
import com.e.vknew.ui.adapter.FeedAdapter;
import com.e.vknew.ui.adapter.LikeAdapter;
import com.e.vknew.ui.models.FeedModel;

import java.util.ArrayList;
import java.util.List;

public class FavouritesFragment extends Fragment {

    private FavouritesViewModel favouritesViewModel;
    RecyclerView likeRecyclerView;
    private List<FeedModel> news;
    private LikeAdapter likeAdapter;
    private LikeAdapter.MyViewHolder.ItemClickListener listener;
    private LikeAdapter.MyViewHolder.FragmentLikeListener fragmentLikeListener;
    boolean isLiked;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        favouritesViewModel =
                ViewModelProviders.of(this).get(FavouritesViewModel.class);
        View view = inflater.inflate(R.layout.fragment_favourites, container, false);

        likeRecyclerView = view.findViewById(R.id.favourite_container);
        likeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        listener = new LikeAdapter.MyViewHolder.ItemClickListener() {
            @Override
            public void ItemClick(int position, FeedModel item) {
                Intent intent = new Intent(getActivity(), FeedDetailActivity.class);
                intent.putExtra("news",item);
                intent.putExtra("like",item.isLiked());
                startActivity(intent);
            }

            @Override
            public void LikeClick(int position, FeedModel item) {
                isLiked = item.isLiked();
                if(isLiked == false){
                    item.setLiked(true);
                    item.setLikes(String.valueOf(Integer.valueOf(item.getLikes())+ 1));
                    isLiked = true;
                }
                else {
                    item.setLiked(false);
                    item.setLikes(String.valueOf(Integer.valueOf(item.getLikes()) - 1));
                    isLiked = false;
                }

                likeAdapter.notifyItemChanged(position);
            }
        };

        fragmentLikeListener = new LikeAdapter.MyViewHolder.FragmentLikeListener() {
            @Override
            public void removeItemLike(FeedModel news) {
                ((MainActivity) getActivity()).removeItemLike(news);
            }
        };

        news = new ArrayList<>();
        likeAdapter = new LikeAdapter(news, (FeedAdapter.ItemClickListener) listener,fragmentLikeListener);
        likeRecyclerView.setAdapter(likeAdapter);

        return view;
    }

    public void saveNews(FeedModel feedModel){
        news.add(feedModel);

        likeRecyclerView.getAdapter().notifyItemInserted(news.size() - 1);
    }

    public void removeNews(FeedModel feedModel){
        if(news.indexOf(feedModel)==0)
            news.remove(feedModel);
        else{
            int position = news.indexOf(feedModel);
            news.remove(feedModel);
            likeRecyclerView.getAdapter().notifyItemRemoved(position);
        }

    }

    public void removeLike(FeedModel feedModel){
        int n = news.indexOf(feedModel);
        this.removeNews(feedModel);
        likeAdapter.notifyItemRemoved(n);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }
}
