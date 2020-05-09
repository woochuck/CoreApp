package com.luczak.m.coreapp.injection

import android.app.Activity
import android.content.Context
import com.luczak.m.coreapp.view.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private var activity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    @Provides
    internal fun providePresenter(): MainPresenter {
        return MainPresenter()
    }
}