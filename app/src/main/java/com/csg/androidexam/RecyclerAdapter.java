package com.csg.androidexam;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private List<Model> mItems = new ArrayList<>();

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, viewGroup, false);
        final MyViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Model model = mItems.get(i);
        Glide.with(myViewHolder.itemView.getContext())
                .load(model.getUrl())
                .into(myViewHolder.imageView);
        myViewHolder.titleTextView.setText(model.getTitle());
        myViewHolder.contentTextView.setText(model.getContent());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void addItems(List<Model> models) {
        mItems.addAll(models);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView titleTextView;
        public TextView contentTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_movie);
            titleTextView = itemView.findViewById(R.id.text_movie_title);
            contentTextView = itemView.findViewById(R.id.text_movie_content);
        }
    }
}
