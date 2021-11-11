package com.example.utindergui.Post;

import java.util.ArrayList;
import java.util.Iterator;

public class PostGroup extends PostComponent{

    String title;
    String text;
    int likes = 0;
    ArrayList<PostComponent> postComponents = new ArrayList<>();

    public PostGroup(String postTitle, String postText) {
        title = "\n" + postTitle;
        text = postText;
    }

    public String getTitle() { return title; }
    public String getText() { return text; }
    public int getLikes() { return likes; }

    public void addPost(PostComponent newPostComponent) {
        postComponents.add(newPostComponent);
    }

    public void removePost(PostComponent newPostComponent) {
        postComponents.remove(newPostComponent);
    }

    public PostComponent getPost(int componentIndex) {
        return postComponents.get(componentIndex);
    }

    public void displayPostInfo() {

        System.out.println(getTitle() + "   " + getText() + "   " + getLikes());

        Iterator<PostComponent> postIterator = postComponents.iterator();

        while (postIterator.hasNext()) {
            PostComponent postInfo = (PostComponent) postIterator.next();
            postInfo.displayPostInfo();
        }
    }
}