package com.luczak.m.coreapp.utils

import com.luczak.m.coreapp.model.Post
import io.reactivex.Single
import io.reactivex.functions.Function
import javax.inject.Inject

object DataManager {
    private lateinit var apiService: ApiService
//
//    fun getProducts(): Single<List<Post>>? {
//        return apiService.getProducts().cache().map(Function<Any, List<Any?>?> { productsList -> productsList.getData() })
//    }
}