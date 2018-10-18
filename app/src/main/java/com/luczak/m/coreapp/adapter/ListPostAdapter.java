package com.luczak.m.coreapp.adapter;

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
    private ItemClickListener itemClickListener;
    private List<Post> postsList = new ArrayList<>();

    public ListPostAdapter(List<Post> posts) {
        postsList = posts;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_post, viewGroup, false);
        ViewHolder vh = new ViewHolder(view, itemClickListener);
        return vh;
    }

    public void setOnItemClickListener(ItemClickListener listener){
        this.itemClickListener = listener;
    }

    @Override
    public void onBindViewHolder(final ListPostAdapter.ViewHolder viewHolder, final int i) {
        viewHolder.title.setText(postsList.get(i).getTitle());
        viewHolder.body.setText(postsList.get(i).getBody());
    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title, body;
        ItemClickListener listener;
        RelativeLayout layout;

        public ViewHolder(View root, ItemClickListener listener) {
            super(root);
            this.title = root.findViewById(R.id.tv_title);
            this.body = root.findViewById(R.id.tv_body);
            this.layout = root.findViewById(R.id.layout);
            this.listener = listener;
            root.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (listener != null) {
                listener.onItemClick(view, getLayoutPosition());
            }
        }
    }
}
