package com.luczak.m.coreapp.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.luczak.m.coreapp.R;
import com.luczak.m.coreapp.model.Comment;
import com.luczak.m.coreapp.model.Post;
import com.luczak.m.coreapp.utils.BaseFragment;
import com.luczak.m.coreapp.utils.Rest;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainFragment extends BaseFragment implements View.OnClickListener {
    public static MainFragment newInstance() {
        return new MainFragment();
    }

    Button button;
    private List<Post> postsList = new ArrayList<>();
    private List<Post> postsFromDb = SQLite.select().from(Post.class).queryList();

    private List<Comment> commentsList = new ArrayList<>();
    private List<Comment> commentsFromDb = SQLite.select().from(Comment.class).queryList();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        assert getActions() != null;
        getActions().topBar().setTitle(R.string.welcome);
        button = view.findViewById(R.id.btn_main);
        button.setOnClickListener(this);

        if (postsFromDb.size() == 0) {
            fetchPostData();
        }
        if (commentsFromDb.size() == 0) {
            fetchCommentData();
        }
        return view;
    }

    private void fetchCommentData() {
        Rest.getRest().detail().enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        commentsList.addAll(response.body());
                        for (Comment c: commentsList) {
                            c.save();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {

            }
        });
    }

    private void fetchPostData() {
        Rest.getRest().posts().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        postsList.addAll(response.body());
                        for (Post post: postsList) {
                            post.save();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        if (getActions() != null) {
            getActions().navigateTo(PostListFragment.newInstance(), false);
        }
    }


}
