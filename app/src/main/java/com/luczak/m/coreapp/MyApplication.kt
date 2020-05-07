package com.luczak.m.coreapp

import android.app.Application
import com.luczak.m.coreapp.injection.ApplicationComponent
import com.luczak.m.coreapp.injection.ApplicationModule
import com.luczak.m.coreapp.injection.DaggerApplicationComponent

class MyApplication: Application() {

    companion object {
        lateinit var myApplication: MyApplication private set
    }

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        myApplication = this
        component = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this)).build()
        component.inject(this)
    }

    fun getApplicationComponent(): ApplicationComponent {
        return component
    }

}