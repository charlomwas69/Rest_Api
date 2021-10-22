package org.trustfuse.api_test;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface JsonPLaceHolder {
    @GET("{phone}")
    Call<List<Reply>> getPosts(@Path("phone") String phone);

//    @GET("comments")
//    Call<List<Post>> getPosts(@QueryMap Map<String,String> parameters);

    @POST("posts")
    Call<Post> createPost(@Body Post post);

    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPost(
            @Field("postId")int userId
    );

}
