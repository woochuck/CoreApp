package com.luczak.m.coreapp.view.details

import android.util.Log
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
        val userSubscribe = api.getUserDetails(userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.showProgress(true)
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
                    view.showProgress(true)
                    view.setPostDetails(it)
                }, {
                    error ->
                    view.showProgress(false)
                    Log.e("postSubscribe", error.message)
                })
        subscriptions.add(postSubscribe)
    }

}