package com.luczak.m.coreapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.luczak.m.coreapp.R;
import com.luczak.m.coreapp.model.Comment;

import java.util.ArrayList;
import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> {
    private List<Comment> comments = new ArrayList<>();
    public CommentAdapter(List<Comment> allComment) {
        comments = allComment;
    }

    @Override
    public CommentAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_comment, viewGroup, false);
        CommentAdapter.ViewHolder vh = new CommentAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(final CommentAdapter.ViewHolder viewHolder, final int i) {
        viewHolder.name.setText(comments.get(i).getName());
        viewHolder.body.setText(comments.get(i).getBody());
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, body;

        public ViewHolder(View root) {
            super(root);
            this.name = root.findViewById(R.id.tv_name_comm);
            this.body = root.findViewById(R.id.tv_body_comm);
        }
    }
}
