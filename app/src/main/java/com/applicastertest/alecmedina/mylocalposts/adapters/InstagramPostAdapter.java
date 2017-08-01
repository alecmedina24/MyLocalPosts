package com.applicastertest.alecmedina.mylocalposts.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.applicastertest.alecmedina.mylocalposts.R;
import com.applicastertest.alecmedina.mylocalposts.models.PostModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alec.medina on 7/28/17.
 */

public class InstagramPostAdapter extends RecyclerView.Adapter<InstagramPostAdapter.ItemViewHolder> {

    private List<PostModel> posts;
    private Context context;

    public InstagramPostAdapter(Context context, List<PostModel> posts) {
        this.posts = posts;
        this.context = context;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(new View(context));
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        for (int i = 0; i < posts.size(); i++) {
            ItemView itemView;
            if (i < holder.mChildViews.size()) {
                itemView = holder.mChildViews.get(i);
                holder.masterLayout.removeView(itemView.instagramPostLayout);
            } else {
                itemView = new ItemView(inflater);
                holder.mChildViews.add(itemView);
            }

            PostModel post = posts.get(position);

            itemView.userCommentView.setText(post.getUserComment());
            itemView.usernameView.setText(post.getUserName());

            holder.masterLayout.addView(itemView.instagramPostLayout);
        }
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    private static class ItemView {
        private LinearLayout instagramPostLayout;
        private ImageView postImageView;
        private ImageView userImageView;
        private TextView usernameView;
        private TextView userCommentView;

        ItemView(LayoutInflater inflater) {
            instagramPostLayout = (LinearLayout) inflater.inflate(R.layout.instagram_post_list_item, null);
            postImageView = (ImageView) instagramPostLayout.findViewById(R.id.post_image);
            userImageView = (ImageView) instagramPostLayout.findViewById(R.id.user_image);
            usernameView = (TextView) instagramPostLayout.findViewById(R.id.username);
            userCommentView = (TextView) instagramPostLayout.findViewById(R.id.user_comment);
        }
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        ArrayList<ItemView> mChildViews;
        LinearLayout masterLayout;

        public ItemViewHolder(View itemView) {
            super(itemView);
            masterLayout = (LinearLayout) itemView.findViewById(R.id.master_layout);
            mChildViews = new ArrayList<>();
        }
    }
}
