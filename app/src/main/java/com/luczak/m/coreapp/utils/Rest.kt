package com.luczak.m.coreapp.utils

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

val rest: RestInterface by lazy {
    Retrofit.Builder()
            .baseUrl("http://")
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
            .create(RestInterface::class.java)
}

interface RestInterface {
    //@GET("posts")
    //fun posts() : Call<List<Post>>

    //@GET("post/{postId}")
    //fun details(@Path("postId") id: Int) : Call<PostDetails>
}