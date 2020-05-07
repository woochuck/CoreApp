package com.luczak.m.coreapp.view;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.inverce.mod.core.IM;
import com.luczak.m.coreapp.R;
import com.luczak.m.coreapp.adapter.ListPostAdapter;
import com.luczak.m.coreapp.model.Post;
import com.luczak.m.coreapp.utils.BaseFragment;
import com.luczak.m.coreapp.utils.ItemClickListener;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.ArrayList;
import java.util.List;
//
//public class PostListFragment extends BaseFragment implements ItemClickListener {
//    private static final String SAVED_BUNDLE_TAG = "SAVED_BUNDLE_TAG";
//
//    RecyclerView recyclerView;
//    ListPostAdapter adapter;
//    List<Post> postList = new ArrayList<>();
//    List<Post> dbPosts;
//    private Parcelable recyclerViewState;
//    private RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(IM.context());
//
//    public static PostListFragment newInstance() {
//        return new PostListFragment();
//    }
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (savedInstanceState != null) {
//            postList = savedInstanceState.getParcelable(SAVED_BUNDLE_TAG);
//        }
//        setRetainInstance(true);
//    }
//
//    @Override
//    public void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//        recyclerViewState = layoutManager.onSaveInstanceState();
//        outState.putParcelable(SAVED_BUNDLE_TAG, recyclerViewState);
//    }
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_post_list, container, false);
//        assert getActions() != null;
//        getActions().topBar().setTitle(R.string.posts);
//        findViews(view);
//        fetchData();
//
//        if (savedInstanceState != null) {
//            setRetainInstance(true);
//        }
//
//        return view;
//    }
//
//    private void findViews(View view) {
//        recyclerView = view.findViewById(R.id.list_recycler);
//        recyclerView.setLayoutManager(new LinearLayoutManager(IM.context()));
//    }
//
//    private void fetchData() {
//        dbPosts = SQLite.select().from(Post.class).queryList();
//        if (dbPosts.size() > 0) {
//            adapter = new ListPostAdapter(dbPosts);
//            recyclerView.setAdapter(adapter);
//            adapter.setOnItemClickListener(this);
//        }
//    }
//
//    @Override
//    public void onPause() {
//        super.onPause();
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//    }
//
//    @Override
//    public void onItemClick(View view, int pos) {
//        if (getActions() != null) {
//            getActions().navigateTo(PostDetailFragment.newInstance(dbPosts.get(pos).getUserId(), dbPosts.get(pos).getId()), true);
//        }
//    }
//}
