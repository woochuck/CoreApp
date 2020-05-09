package com.luczak.m.coreapp.view.base

interface BasePresenter<in T> {
    fun subscribe()
    fun unsubscribe()
    fun attach(view: T)
}
