package com.e.vknew;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.e.vknew.R;
import com.e.vknew.ui.models.FeedModel;

public class FeedDetailActivity extends Activity {

    private Context context;
    public static final String EXTRA_DETAIL = "extra_detail";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.detail_activity);


        context = this;

        ImageView userPic = findViewById(R.id.detail_user_pic);
        ImageView postPic = findViewById(R.id.detail_uploader_pic);


        TextView userName = findViewById(R.id.detail_user_name);
        TextView time = findViewById(R.id.detail_time);
        TextView postText = findViewById(R.id.detail_text);
        TextView likeCount = findViewById(R.id.detail_like_cnt);
        TextView shareCount = findViewById(R.id.detail_share_cnt);
        TextView viewCount = findViewById(R.id.detail_view_cnt);

        FeedModel feedModel = getIntent().getParcelableExtra(EXTRA_DETAIL);

        Glide.with(this).load(feedModel.getUploaderpic()).into(userPic);
        Glide.with(this).load(feedModel.getPostpic()).into(postPic);

        userName.setText(feedModel.getName());
        time.setText(feedModel.getTime());
        postText.setText(feedModel.getPostText());
        likeCount.setText(feedModel.getLikes());
        shareCount.setText(feedModel.getShares());
        viewCount.setText(feedModel.getViews());

    }

}