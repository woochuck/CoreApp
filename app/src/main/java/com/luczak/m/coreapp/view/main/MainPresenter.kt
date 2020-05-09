package com.luczak.m.coreapp.view.main

import com.luczak.m.coreapp.view.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable

class MainPresenter: BasePresenter<MainMvpView> {

    private val subscriptions = CompositeDisposable()
    private lateinit var view: MainMvpView

    override fun subscribe() {
        subscriptions.clear()

    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: MainMvpView) {
        this.view = view
        view.showPostListFragment()
    }
}