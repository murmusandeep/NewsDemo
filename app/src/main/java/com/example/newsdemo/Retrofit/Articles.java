package com.example.newsdemo.Retrofit;

import com.google.gson.annotations.SerializedName;

public class Articles {

    @SerializedName("urlToImage")
    private String urlToImage;

    @SerializedName("title")
    private String title;

    @SerializedName("author")
    private String author;

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
