package com.example.utindergui.Post;
import com.example.utindergui.User.User;

import java.util.ArrayList;
import java.util.List;

public class Post {
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