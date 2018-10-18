package com.luczak.m.coreapp.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.inverce.mod.core.IM;
import com.luczak.m.coreapp.R;
import com.luczak.m.coreapp.adapter.CommentAdapter;
import com.luczak.m.coreapp.model.Comment;
import com.luczak.m.coreapp.model.Comment_Table;
import com.luczak.m.coreapp.model.Post;
import com.luczak.m.coreapp.model.Post_Table;
import com.luczak.m.coreapp.model.User;
import com.luczak.m.coreapp.utils.BaseFragment;
import com.luczak.m.coreapp.utils.Rest;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostDetailFragment extends BaseFragment {
    private static final String SAVED_BUNDLE_TAG = "SAVED_BUNDLE_TAG";

    private final static String POST_ID = "POST_ID";
    private final static String USER_ID = "USER_ID";

    private int userId, postId;
    private Post singlePost;
    TextView title, name, description;
    RecyclerView comments;
    CommentAdapter adapter;
    private Parcelable recyclerViewState;
    private RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(IM.context());

    public static PostDetailFragment newInstance(int idUser, int idPost) {
        PostDetailFragment f = new PostDetailFragment();
        Bundle args = new Bundle();
        args.putInt(POST_ID, idPost);
        args.putInt(USER_ID, idUser);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        recyclerViewState = layoutManager.onSaveInstanceState();
        outState.putParcelable(SAVED_BUNDLE_TAG, recyclerViewState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            setRetainInstance(true);
        }
        if (getArguments() != null) {
            postId = this.getArguments().getInt(POST_ID);
            userId = this.getArguments().getInt(USER_ID);
            singlePost = SQLite.select().from(Post.class).where(Post_Table.id.eq(postId)).querySingle();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post_detail, container, false);
        assert getActions() != null;
        getActions().topBar().setTitle(R.string.details);
        findViews(view);
        getUser();
        setData();
        if (savedInstanceState != null) {
            setRetainInstance(true);
        }

        return view;
    }

    private void setData() {
        setCommentRecycler(singlePost.getId());
        title.setText(singlePost.getTitle());
        description.setText(singlePost.getBody());
    }

    private void getUser() {
        Rest.getRest().user(userId).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        name.setText(String.format("%s%s", IM.resources().getString(R.string.author), response.body().getEmail().toUpperCase()));
                    }
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

    private void setCommentRecycler(int id) {
        List<Comment> postComment = SQLite.select().from(Comment.class).where(Comment_Table.postId.eq(id)).queryList();
        comments.setLayoutManager(new LinearLayoutManager(IM.context()));
        adapter = new CommentAdapter(postComment);
        comments.setAdapter(adapter);
    }

    private void findViews(View view) {
        title = view.findViewById(R.id.tv_title_detail);
        description = view.findViewById(R.id.tv_desc);
        name = view.findViewById(R.id.tv_author);
        comments = view.findViewById(R.id.recycler_comments);
    }
}
