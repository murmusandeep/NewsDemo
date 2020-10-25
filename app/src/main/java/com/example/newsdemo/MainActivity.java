package com.example.newsdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.newsdemo.Retrofit.ApiClient;
import com.example.newsdemo.Retrofit.ApiInterface;
import com.example.newsdemo.Retrofit.Articles;
import com.example.newsdemo.Retrofit.ArticlesAdapter;
import com.example.newsdemo.Retrofit.NewsData;

import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private NewsData newsData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(dividerItemDecoration);

        getNewsData();
    }

    private void getNewsData() {

        ApiInterface apiInterface = ApiClient.getClient(MainActivity.this).create(ApiInterface.class);
        Call<NewsData> call = apiInterface.getNewsData();

        call.enqueue(new Callback<NewsData>() {
            @Override
            public void onResponse(Call<NewsData> call, Response<NewsData> response) {

                newsData = response.body();

                //HomeActivityAdapter mainActivitySectionAdapter = new HomeActivityAdapter(HomeActivity.this, mData);
                //mRecyclerViewSection.setAdapter(mainActivitySectionAdapter);

                ArticlesAdapter articlesAdapter = new ArticlesAdapter(MainActivity.this, newsData);
                mRecyclerView.setAdapter(articlesAdapter);

            }

            @Override
            public void onFailure(Call<NewsData> call, Throwable t) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.searchNews:
                Toast.makeText(MainActivity.this, "Search is Clicked", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.setting:
                Toast.makeText(MainActivity.this, "Setting is Clicked", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
}