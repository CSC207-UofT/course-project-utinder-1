package com.example.utindergui.Post;
import com.example.utindergui.User.User;

import java.util.ArrayList;
import java.util.List;

public class Post {
    private String title;
    private String text;
    private ArrayList<Post> comments; //a sub post can only be a comment.
    private int likes;
    private User postmaker;

    public Post(String text, User postmaker, ArrayList photos, String title){//Constructor for a post
        this.title = title;
        this.text = text;
        this.comments = new ArrayList<>();
        this.likes = 0;
        this.postmaker = postmaker;
    }

    public Post(String text, User postmaker, ArrayList photos){//Constructor for a comment
        this.title = null;
        this.text = text;
        this.comments = new ArrayList<>();
        this.likes = 0;
        this.postmaker = postmaker;
    }

    public Post getPost(PostManager manager, int postIndex){
        return manager.getPostList().get(postIndex);
    }

    public String getText(){
        return this.getText();
    }

    public void editText(String newText) { this.text = newText;}

    public void addComment(Post comment) {
        this.comments.add(comment);
    }

    public void removeComment(Post current_comment){
        this.comments.remove(current_comment);
    }

    public ArrayList getComments(){
        return comments;
    }

    public void addLike(){
        this.likes += 1;
    }

    public int getLikes(){
        return this.likes;
    }

}