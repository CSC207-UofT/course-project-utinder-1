package com.example.utindergui.Post;

public abstract class PostComponent {

    public void addPost(PostComponent newPostComponent) {
        throw new UnsupportedOperationException();
    }

    public void removePost(PostComponent newPostComponent) {
        throw new UnsupportedOperationException();
    }

    public PostComponent getPost(int componentIndex) {
        throw new UnsupportedOperationException();
    }

    public String getTitle(PostComponent oldPostComponent) {
        throw new UnsupportedOperationException();
    }

    public void displayPostInfo() {
        throw new UnsupportedOperationException();
    }

}
