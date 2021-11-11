package com.example.utindergui.Post;

import com.example.utindergui.User.User;

import java.util.ArrayList;

public class MainPost extends Post{
    private String title;
    private ArrayList<String> photos;

    public MainPost(String title, String text, User postmaker, ArrayList<String> photos){
        super(text, postmaker);
        this.title = title;
        this.photos = photos;
    }

    public String getTitle(){
        return this.title;
    }

    public ArrayList<String> getPhotos(){
        return photos;
    }
}
