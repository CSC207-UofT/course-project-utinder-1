package com.example.utindergui.Post;

import com.example.utindergui.User.User;

import java.util.ArrayList;
import java.util.HashMap;

public class PostManager {
    private ArrayList postlist;

    public PostManager(){
        this.postlist = new ArrayList();
    }

    public void makeMainPost(String title, User postmaker, String text, ArrayList<String> photos){
        MainPost mainPost = new MainPost(title, text, postmaker, photos);
        this.postlist.add(mainPost);
    }

    public void makeComment(String text, User postmaker, Post post){
        Comment comment = new Comment(text, postmaker);
        post.addComment(comment);
    }

    public void deleteMainPost(MainPost current_post){
        this.postlist.remove(current_post);
    }

    public void deleteComment(Post current_post, Comment current_comment){
        current_post.removeComment(current_comment);
    }

    public void likePost(Post post){
        post.addLike();
    }
}
