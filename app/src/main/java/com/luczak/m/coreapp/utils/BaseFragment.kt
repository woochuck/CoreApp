package com.luczak.m.coreapp.utils

import android.content.Context
import android.support.v4.app.Fragment
import com.luczak.m.coreapp.interaction.ActivityInteractions

abstract class BaseFragment : Fragment() {
    internal var actions: ActivityInteractions? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            actions = context as ActivityInteractions
        } catch (ex: Exception) {
            throw IllegalStateException(ex.toString())
        }

    }

    override fun onDetach() {
        super.onDetach()
        actions = null
    }

}