package com.luczak.m.coreapp.injection

import android.app.Application
import com.luczak.m.coreapp.MyApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: MyApplication) {
    @Provides
    @Singleton
    @PerApplication
    fun provideApplication(): Application {
        return application
    }
}