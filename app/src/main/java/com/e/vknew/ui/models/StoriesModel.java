package com.e.vknew.ui.models;

public class StoriesModel {
    private int storiesPic;
    private String userName;

    public StoriesModel(){

    }

    public StoriesModel(int storiesPic, String userName) {
        this.storiesPic = storiesPic;
        this.userName = userName;
    }

    public int getStoriesPic() {
        return storiesPic;
    }

    public void setStoriesPic(int storiesPic) {
        this.storiesPic = storiesPic;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
