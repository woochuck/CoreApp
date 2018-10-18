package com.luczak.m.coreapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import com.luczak.m.coreapp.interaction.ActivityInteractions
import com.luczak.m.coreapp.interaction.TopBarInteraction
import com.luczak.m.coreapp.utils.BaseFragment
import com.luczak.m.coreapp.view.ItemListFragment

class MainActivity : AppCompatActivity(), ActivityInteractions, FragmentManager.OnBackStackChangedListener {

    lateinit var topBar: TopBarInteraction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            navigateTo(ItemListFragment.newInstance(), false)
        }

        val fragmentManager = supportFragmentManager
        topBar = fragmentManager.findFragmentById(R.id.top_fragment) as TopBarInteraction
        fragmentManager.addOnBackStackChangedListener(this)

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

    override fun onBackStackChanged() {

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    override fun navigateBack(): Boolean {
        onBackPressed()
        return false
    }

    override fun topBar(): TopBarInteraction {
        return topBar
    }
}
