package com.luczak.m.coreapp.injection

import com.luczak.m.coreapp.view.main.MainActivity
import dagger.Component

@Component(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun inject(mainActivity: MainActivity)
}