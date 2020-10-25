package com.example.newsdemo.Retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsdemo.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.MyViewHolder> {

    private Context mContext;
    private List<Articles> mArticles;


    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView mNewsPic;
        TextView mTitle;
        TextView mAuthor;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mNewsPic = itemView.findViewById(R.id.newsPic);
            mAuthor = itemView.findViewById(R.id.author);
            mTitle = itemView.findViewById(R.id.title);
        }

        public void bind(Articles articles) {
            Picasso.get()
                    .load(articles.getUrlToImage())
                    .into(mNewsPic);
            mAuthor.setText(articles.getAuthor());
            mTitle.setText(articles.getTitle());
        }
    }

    public ArticlesAdapter(Context mContext, List<Articles> mArticles) {
        this.mContext = mContext;
        this.mArticles = mArticles;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.articles_list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Articles articles = mArticles.get(position);
        holder.bind(articles);
    }

    @Override
    public int getItemCount() {
        return mArticles == null ? 0 : mArticles.size();
    }
}
