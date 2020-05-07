package com.luczak.m.coreapp.view.posts

import android.util.Log
import com.luczak.m.coreapp.model.Post
import com.luczak.m.coreapp.utils.ApiService
import com.luczak.m.coreapp.view.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class PostListPresenter : BasePresenter<PostsMvpView> {

    private val subscriptions = CompositeDisposable()
    private val api: ApiService = ApiService.create()
    private lateinit var view: PostsMvpView

    override fun subscribe() {
    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: PostsMvpView) {
        this.view = view
    }

    fun loadData() {
        val subscribe = api.getPostList().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.showProgress(false)
                    view.loadDataSuccess(it)
                }, { error ->
                    view.showProgress(false)
                    Log.e("PostListPresenter", error.message)
                })

        subscriptions.add(subscribe)
    }
}
