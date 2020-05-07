package com.luczak.m.coreapp.injection

import com.luczak.m.coreapp.utils.ApiService
import com.luczak.m.coreapp.view.base.BasePresenter
import com.luczak.m.coreapp.view.details.PostDetailPresenter
import com.luczak.m.coreapp.view.posts.PostListPresenter
import dagger.Module
import dagger.Provides

@Module
class FragmentModule {
    @Provides
    fun providePostListPresenter(): PostListPresenter {
        return PostListPresenter()
    }

    @Provides
    fun providePostDetailPresenter(): PostDetailPresenter {
        return PostDetailPresenter()
    }

    @Provides
    fun provideApiService(): ApiService {
        return ApiService.create()
    }
}