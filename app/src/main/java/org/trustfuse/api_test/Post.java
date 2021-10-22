package org.trustfuse.api_test;

import com.google.gson.annotations.SerializedName;

public class Post {
//    private int postId;
//    private int id;
//
//    @SerializedName("body")
//    private String body;
//    private String name;
//    private String email;

    private int id;
    @SerializedName("body")
    private String text;
    private String source;
    private String destiation;
    private String date_created;


//    public Post(int postId, String body, String name, String email) {
//        this.postId = postId;
//        this.body = body;
//        this.name = name;
//        this.email = email;
//    }

//    public int getPostId() {
//        return postId;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public String getBody() {
//        return body;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
}
