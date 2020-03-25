package com.e.vknew.ui.models;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RequiresApi;
import android.os.Build;

import java.util.ArrayList;
import java.util.List;

public class FeedModel implements Parcelable{
    public static List<FeedModel> feedModelList = new ArrayList<>();
    private boolean isLiked = false;
    private String status;
    private int LikeButton;

    private String Name;
    private String Time;
    private String postText;
    private String likes;
    private int uploaderpic;
    private int postpic;
    private String comments;
    private String shares;
    private String views;



    public FeedModel(String name, String time,String postText, String likes, int uploaderpic,int postpic,String comments,String shares,String views,String status) {
        Name = name;
        Time = time;
        this.postText = postText;
        this.likes = likes;
        this.uploaderpic = uploaderpic;
        this.postpic = postpic;
        this.comments = comments;
        this.shares = shares;
        this.views = views;
        this.status = status;
    }


    @RequiresApi(api = Build.VERSION_CODES.Q)
    protected FeedModel(Parcel in){
        this.Name = in.readString();
        this.Time = in.readString();
        this.postText = in.readString();
        this.likes = in.readString();
        this.uploaderpic = in.readInt();
        this.postpic = in.readInt();
        this.comments = in.readString();
        this.shares = in.readString();
        this.views = in.readString();
        this.status = in.readString();


    }

    public static final Creator<FeedModel> CREATOR = new Creator<FeedModel>() {
        @RequiresApi(api = Build.VERSION_CODES.Q)
        @Override
        public FeedModel createFromParcel(Parcel in) {
            return new FeedModel(in);
        }

        @Override
        public FeedModel[] newArray(int size) {
            return new FeedModel[size];
        }
    };

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("News{");
        sb.append("author='").append(Name).append('\'');
        sb.append(", time='").append(Time).append('\'');
        sb.append(", posttext='").append(postText).append('\'');
        sb.append(", likes='").append(likes).append("\'");
        sb.append(", uploaderpic='").append(uploaderpic).append("\'");
        sb.append(", postpoc='").append(postpic).append("\'");
        sb.append(", comments='").append(comments).append("\'");
        sb.append(", shares='").append(shares).append("\'");
        sb.append(", views='").append(views).append("\'");
        sb.append('}');

        return sb.toString();

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    public void writeToParcel(Parcel dest,int flags){
        dest.writeString(this.Name);
        dest.writeString(this.Time);
        dest.writeString(this.postText);
        dest.writeString(this.likes);
        dest.writeInt(this.uploaderpic);
        dest.writeInt(this.postpic);
        dest.writeString(this.comments);
        dest.writeString(this.shares);
        dest.writeString(this.views);
        dest.writeString(this.status);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getPostText(){
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }


    public int getUploaderpic() {
        return uploaderpic;
    }

    public void setUploaderpic(int uploaderpic) {
        this.uploaderpic = uploaderpic;
    }

    public int getPostpic() {
        return postpic;
    }

    public void setPostpic(int postpic) {
        this.postpic = postpic;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getShares() {
        return shares;
    }

    public void setShares(String shares) {
        this.shares = shares;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    private CharSequence getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }






    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked){
        isLiked = liked;
    }
}
