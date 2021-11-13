package com.example.utindergui.Post;

import com.example.utindergui.User.User;

import java.util.ArrayList;
import java.util.HashMap;

public class PostManager {
    private ArrayList<Post> postlist;

    public PostManager(){
        this.postlist = new ArrayList();
    }

    public ArrayList<Post> getPostList(){
        return this.postlist;
    }

    public void makePost(String text, User postmaker, ArrayList photos, String title){
        Post post = new Post(text, postmaker, photos, title);
        this.postlist.add(post);
    }

    public void makeComment(String text, User postmaker, ArrayList photos, Post post){
        Post comment = new Post(text, postmaker, photos);
        post.addComment(comment);
    }

    public void deleteMainPost(Post current_post){
        this.postlist.remove(current_post);
    }

    public void deleteComment(Post current_post, Post current_comment){
        current_post.removeComment(current_comment);
    }

    public void likePost(Post post){
        post.addLike();
    }

    public void editPost(Post post, String newText) {
        post.editText(newText);
    }
}
