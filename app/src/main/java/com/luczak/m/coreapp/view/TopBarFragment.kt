package com.luczak.m.coreapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.luczak.m.coreapp.R
import com.luczak.m.coreapp.interaction.TopBarInteraction
import com.luczak.m.coreapp.utils.BaseFragment

class TopBarFragment: BaseFragment(), TopBarInteraction {
    private lateinit var title: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_top_bar, container, false)
        title = view.findViewById(R.id.top_bar_title)
        return view
    }

    override fun setTitle(res: Int) {
        title.setText(res)
    }

}