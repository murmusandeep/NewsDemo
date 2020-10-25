package com.example.newsdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.newsdemo.Retrofit.ApiClient;
import com.example.newsdemo.Retrofit.ApiInterface;
import com.example.newsdemo.Retrofit.ArticlesAdapter;
import com.example.newsdemo.Retrofit.NewsData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private NewsData mNewsData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        getNewsData();
    }

    private void getNewsData() {

        ApiInterface apiInterface = ApiClient.getClient(MainActivity.this).create(ApiInterface.class);
        Call<NewsData> call = apiInterface.getNewsData();

    }
}