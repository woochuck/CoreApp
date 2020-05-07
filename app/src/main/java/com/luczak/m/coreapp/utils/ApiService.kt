package com.luczak.m.coreapp.utils

import com.luczak.m.coreapp.model.Comment
import com.luczak.m.coreapp.model.Post
import com.luczak.m.coreapp.model.PostList
import com.luczak.m.coreapp.model.User
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

   companion object Factory {
        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(Cfg.BASE_URL)
                    .build()

            return retrofit.create(ApiService::class.java)
        }
    }

    @GET("posts")
    fun getPostList(): Observable<List<Post>>

    @GET("posts/{id}")
    fun getPostDetail(@Path("id") id: Int): Observable<Post>

    @GET("users")
    fun getUserList(): Observable<List<User>>

    @GET("users/{userId}")
    fun getUserDetails(@Path(value = "userId") id: Int): Observable<User>
//
//    @GET("comments")
//    fun detail(): Call<List<Comment?>?>?

}