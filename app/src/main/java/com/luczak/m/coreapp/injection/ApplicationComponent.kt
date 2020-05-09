package com.luczak.m.coreapp.injection

import com.luczak.m.coreapp.MyApplication
import dagger.Component

@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {
    fun inject(application: MyApplication)
}