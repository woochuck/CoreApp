package com.luczak.m.coreapp.view.posts

import com.luczak.m.coreapp.model.Post
import com.luczak.m.coreapp.view.base.BaseMvpView

interface PostsMvpView: BaseMvpView {
    fun loadDataSuccess(list: List<Post>)
    fun showProgress(show: Boolean)
}