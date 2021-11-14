package com.example.utindergui.posting;
import com.example.utindergui.user.User;

import java.util.ArrayList;

abstract class Post {
    private String text;
    private ArrayList<Comment> comments;
    private int likes;
    private User postmaker;

    public Post(String text, User postmaker){
        this.text = text;
        this.comments = new ArrayList<>();
        this.likes = 0;
        this.postmaker = postmaker;
    }

    public String getText(){
        return this.getText();
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
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