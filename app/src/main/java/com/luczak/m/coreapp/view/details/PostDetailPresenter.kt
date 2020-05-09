package com.luczak.m.coreapp.view.details

import android.util.Log
import com.luczak.m.coreapp.model.Comment
import com.luczak.m.coreapp.utils.ApiService
import com.luczak.m.coreapp.view.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class PostDetailPresenter : BasePresenter<PostDetailMvpView> {
    private val subscriptions = CompositeDisposable()
    private val api: ApiService = ApiService.create()
    private lateinit var view: PostDetailMvpView

    override fun subscribe() {

    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: PostDetailMvpView) {
        this.view = view
    }

    fun loadData(userId: Int, postId: Int) {
        //showuld move calls to some rxUtils
        view.showProgress(true)
        val userSubscribe = api.getUserDetails(userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.setAuthorData(it)
                }, { error ->
                    view.showProgress(false)
                    Log.e("userSubscribe", error.message)
                })
        subscriptions.add(userSubscribe)
        val postSubscribe = api.getPostDetail(postId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.setPostDetails(it)
                    view.showProgress(false)
                }, {
                    error ->
                    view.showProgress(false)
                    Log.e("postSubscribe", error.message)
                })
        subscriptions.add(postSubscribe)
        val commentsSubscribe = api.getComments()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    val filteredComments = it.filter { it.postId == postId}
                    view.setComments(filteredComments as ArrayList<Comment>)
                }, {
                    error ->
                    view.showProgress(false)
                    Log.e("commentsSubscribe", error.message)
                })
        subscriptions.add(commentsSubscribe)
    }

}