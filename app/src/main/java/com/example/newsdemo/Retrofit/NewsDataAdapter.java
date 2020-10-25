package com.example.newsdemo.Retrofit;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NewsDataAdapter extends RecyclerView.Adapter<NewsDataAdapter.MyViewHolder> {

    private Context mContext;
    private NewsData mNewsData;


    class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public NewsDataAdapter(Context mContext, NewsData mNewsData) {
        this.mContext = mContext;
        this.mNewsData = mNewsData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


}
