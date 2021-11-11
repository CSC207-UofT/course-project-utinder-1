package com.example.utindergui.Post;

import java.util.ArrayList;
import java.util.Iterator;

public class PostGroup extends PostComponent{

    private String title;
    private String text;
    private int likes = 0;
    private ArrayList<PostComponent> postComponents = new ArrayList<>();

    public PostGroup(String postTitle, String postText) {
        title = "\n" + postTitle;
        text = postText;
    }

    public String getTitle() { return title; }
    public String getText() { return text; }
    public int getLikes() { return likes; }

    public void addPost(PostComponent newPostComponent) { postComponents.add(newPostComponent); }

    public void removePost(PostComponent newPostComponent) { postComponents.remove(newPostComponent); }

    public PostComponent getPost(int postIndex) { return postComponents.get(postIndex); }

    public void addLike() { likes += 1; }
    public void removeLike() { likes -= 1; }

    public void displayPostInfo() {

        System.out.println(getTitle() + "   " + getText() + "   " + getLikes());

        for (PostComponent postInfo : postComponents) {
            postInfo.displayPostInfo();
        }
    }
}