package com.luczak.m.coreapp.interaction

import android.support.annotation.StringRes

interface TopBarInteraction {
    fun setTitle(@StringRes res: Int)
}