package com.luczak.m.coreapp.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.luczak.m.coreapp.R;
import com.luczak.m.coreapp.model.Post;
import com.luczak.m.coreapp.utils.ItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class ListPostAdapter extends RecyclerView.Adapter<ListPostAdapter.ViewHolder> {
    private List<Post> postsList = new ArrayList<>();
    private OnItemClick listener;

    public ListPostAdapter(Context context, List<Post> posts, Fragment fragment) {
        postsList = posts;
        listener = (OnItemClick) fragment;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_post, viewGroup, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ListPostAdapter.ViewHolder viewHolder, final int position) {
        viewHolder.title.setText(postsList.get(position).getTitle());
        viewHolder.body.setText(postsList.get(position).getBody());
        viewHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.itemClick(postsList.get(position).getUserId(), postsList.get(position).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, body;
        RelativeLayout layout;

        public ViewHolder(View root) {
            super(root);
            this.title = root.findViewById(R.id.tv_title);
            this.body = root.findViewById(R.id.tv_body);
            this.layout = root.findViewById(R.id.layout);
        }
    }

    public interface OnItemClick {
        void itemClick(int userId, int postId);
    }
}
