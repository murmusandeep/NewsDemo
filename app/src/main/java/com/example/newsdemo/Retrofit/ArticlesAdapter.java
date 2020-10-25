package com.example.newsdemo.Retrofit;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsdemo.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.MyViewHolder> {

    private Context mContext;
    private NewsData newsData;

    private List<Articles> mArticles;

    String url;





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
            url = articles.getUrl();


        }
    }

    public ArticlesAdapter(Context mContext, NewsData newsData) {
        this.mContext = mContext;
        this.newsData = newsData;
        mArticles = this.newsData.getArticles();

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.articles_list_item, parent, false);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.launchUrl(mContext, Uri.parse(url));

            }
        });


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

