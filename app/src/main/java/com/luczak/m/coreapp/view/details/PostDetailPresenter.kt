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

    fun loadData(userId: Int) {
        val subscribe = api.getUserDetails(userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.showProgress(true)
                    view.setAuthorData(it)
                }, { error ->
                    view.showProgress(false)
                    Log.e("PostDetailPresenter", error.message)
                })
        subscriptions.add(subscribe)
    }

}