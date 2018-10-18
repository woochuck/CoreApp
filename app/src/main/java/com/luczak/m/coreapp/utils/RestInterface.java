package com.luczak.m.coreapp.utils;

import com.luczak.m.coreapp.model.Comment;
import com.luczak.m.coreapp.model.Post;
import com.luczak.m.coreapp.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RestInterface {
    @GET("posts")
    Call<List<Post>> posts();

    @GET("users" + "/{userId}")
    Call<User> user(@Path(value = "userId") int id);

    @GET("comments")
    Call<List<Comment>> detail();
}
