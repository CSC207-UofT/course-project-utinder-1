package com.example.utindergui.Post;

public class PostManager {

    PostComponent postList;

    public PostManager(PostComponent newPostList) {
        postList = newPostList;
    }

    public void getPostList() {
        postList.displayPostInfo();
    }
}