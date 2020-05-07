package com.luczak.m.coreapp.view.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.luczak.m.coreapp.R
import com.luczak.m.coreapp.injection.ActivityModule
import com.luczak.m.coreapp.injection.DaggerActivityComponent
import com.luczak.m.coreapp.interaction.ActivityInteractions
import com.luczak.m.coreapp.utils.BaseFragment
import com.luczak.m.coreapp.view.posts.PostListFragment
import com.raizlabs.android.dbflow.config.FlowManager
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainMvpView, ActivityInteractions {
    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injectDependency()

        presenter.attach(this)
    }

    override fun showPostListFragment() {
        supportFragmentManager.beginTransaction()
                .disallowAddToBackStack()
                .replace(R.id.activity_content, PostListFragment().newInstance(), "PostListFragment")
                .commit()
    }

    override fun navigateTo(fragment: BaseFragment, addToBackstack: Boolean): Boolean {
        val manager = supportFragmentManager

        if (fragment == null || manager == null) {
            return false
        }

        if (manager.fragments != null) {
            val current = manager.findFragmentById(R.id.activity_content)
            if (current != null && fragment.javaClass.equals(current.javaClass)) {
                return false
            }
        }

        val transaction = manager.beginTransaction()
        transaction.replace(R.id.activity_content, fragment)
        if (addToBackstack) {
            transaction.addToBackStack(fragment.toString())
        }
        transaction.commit()
        return true
    }

    private fun injectDependency() {
        val activityComponent = DaggerActivityComponent.builder()
                .activityModule(ActivityModule(this))
                .build()

        activityComponent.inject(this)
    }
}
