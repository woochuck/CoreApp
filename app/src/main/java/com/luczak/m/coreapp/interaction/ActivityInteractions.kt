package com.luczak.m.coreapp.interaction

import com.luczak.m.coreapp.utils.BaseFragment

interface ActivityInteractions {
    fun navigateTo(fragment: BaseFragment, addToBackstack: Boolean): Boolean
    fun navigateBack(): Boolean
    fun topBar(): TopBarInteraction
}