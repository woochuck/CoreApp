package com.luczak.m.coreapp.injection

import com.luczak.m.coreapp.view.details.PostDetailFragment
import com.luczak.m.coreapp.view.posts.PostListFragment
import dagger.Component

@Component(modules = arrayOf(FragmentModule::class))
interface FragmentComponent {
    fun inject(postListFragment: PostListFragment)
    fun inject(postDetailFragment: PostDetailFragment)
}