package com.luczak.m.coreapp.view.details

import com.luczak.m.coreapp.model.Comment
import com.luczak.m.coreapp.model.Post
import com.luczak.m.coreapp.model.User

interface PostDetailMvpView {
    fun showProgress(show: Boolean)
    fun setAuthorData(user: User)
    fun setComments(list: ArrayList<Comment>)
    fun setPostDetails(post: Post)
}