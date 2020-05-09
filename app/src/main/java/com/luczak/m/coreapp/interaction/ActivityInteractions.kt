package com.luczak.m.coreapp.interaction

import com.luczak.m.coreapp.view.base.BaseFragment

interface ActivityInteractions {
    fun navigateTo(fragment: BaseFragment, addToBackstack: Boolean): Boolean
   // fun topBar(): TopBarInteraction
}