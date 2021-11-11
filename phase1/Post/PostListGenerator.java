package com.example.utindergui.Post;

public class PostListGenerator {

    public static void main(String[] args) {

        PostManager lePosts = new PostManager();

        lePosts.addPost("Wonderland whoooo", "Went to wonderland today boys! --- mainPost");
        lePosts.addComment("mainPost",
                "Yooo I really wanna go!! --- comment1", lePosts.postList.get(0));
        lePosts.addComment("comment1",
                "Yooo me too!! --- comment2", lePosts.postList.get(0).getPost(0));
        lePosts.addComment("mainPost",
                "Invite me invite me!! --- comment3", lePosts.postList.get(0));
        lePosts.addComment("comment2",
                "Broo we should go next time --- comment4", lePosts.postList.get(0).getPost(0).getPost(0));
        lePosts.addComment("comment1",
                "hahaha --- comment5", lePosts.postList.get(0).getPost(0));

        lePosts.getPostList();
    }
}