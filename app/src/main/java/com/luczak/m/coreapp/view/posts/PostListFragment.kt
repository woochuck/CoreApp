package com.luczak.m.coreapp.view.posts

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.luczak.m.coreapp.R
import com.luczak.m.coreapp.adapter.ListPostAdapter
import com.luczak.m.coreapp.injection.DaggerFragmentComponent
import com.luczak.m.coreapp.injection.FragmentModule
import com.luczak.m.coreapp.model.Post
import com.luczak.m.coreapp.view.details.PostDetailFragment
import kotlinx.android.synthetic.main.fragment_post_list.*
import javax.inject.Inject

class PostListFragment: Fragment(), PostsMvpView, ListPostAdapter.OnItemClick {
    @Inject lateinit var presenter: PostListPresenter

    fun newInstance(): PostListFragment {
        return PostListFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDepedency()
        presenter.attach(this)
        presenter.subscribe()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_post_list, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.unsubscribe()
    }

    override fun onResume() {
        super.onResume()
        initView()
    }

    override fun showProgress(show: Boolean) {

    }

    override fun loadDataSuccess(list: List<Post>) {
        val adapter = ListPostAdapter(activity, list, this)
        list_recycler.layoutManager = LinearLayoutManager(activity)
        list_recycler.adapter = adapter
    }

    private fun injectDepedency() {
        val postListComponent = DaggerFragmentComponent.builder()
                .fragmentModule(FragmentModule())
                .build()

        postListComponent.inject(this)
    }

    private fun initView() {
        presenter.loadData()
    }

    override fun itemClick(userId: Int, postId: Int) {
        //set interfave to use navigateTo()
        fragmentManager!!.beginTransaction()
                .disallowAddToBackStack()
                .replace(R.id.activity_content, PostDetailFragment.newInstance(userId, postId), "PostDetailFragment")
                .commit()
    }
}