package com.example.utindergui.Post;
import java.util.ArrayList;

public class PostManager {

    ArrayList<PostComponent> postList = new ArrayList<>();

    public void addPost(String title, String text) {
        postList.add(new PostGroup(title, text));
    }

    public void removePost(PostComponent postGroup) {
        postList.remove(postGroup);
    }

    public void addComment(String title, String text, PostComponent post) {
        post.addPost(new Comment(title, text));
    }

    public void removeComment(PostComponent parentPost, PostComponent comment) {
        parentPost.removePost(comment);
    }

    public void addLike(PostComponent post) {
        post.addLike();
    }

    public void removeLike(PostComponent post) {
        post.removeLike();
    }

    public void getPostList() {
        for (PostComponent mainPost : postList) {
            mainPost.displayPostInfo();
        }
    }
}