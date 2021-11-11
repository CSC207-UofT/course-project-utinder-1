package com.example.utindergui.Post;

public class PostListGenerator {

    public static void main(String[] args) {
        PostComponent mainPost = new PostGroup("Wonderland whoooo", "Went to wonderland today boys!");
        PostComponent comment1 = new Comment("mainPost", "Yooo I really wanna go!!");
        PostComponent comment2 = new Comment("comment1", "Yooo me too!!");
        PostComponent comment3 = new Comment("mainPost", "Invite me invite me!!");

        mainPost.addPost(comment1);
        comment1.addPost(comment2);
        mainPost.addPost(comment3);

        PostManager blah = new PostManager(mainPost);

        blah.getPostList();
    }
}