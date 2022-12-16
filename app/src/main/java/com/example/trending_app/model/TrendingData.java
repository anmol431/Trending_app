package com.example.trending_app.model;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.bumptech.glide.Glide;
import com.example.trending_app.R;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "trending_table")
public class TrendingData {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "author")
    @SerializedName("author")
    private String author;

    @ColumnInfo(name = "name")
    @SerializedName("name")
    private String name;

    @ColumnInfo(name = "avatar")
    @SerializedName("avatar")
    private String avatar;

    @ColumnInfo(name = "url")
    @SerializedName("url")
    private String url;

    @ColumnInfo(name = "description")
    @SerializedName("description")
    private String description;

    @ColumnInfo(name = "language")
    @SerializedName("language")
    private String language;

    @ColumnInfo(name = "languageColor")
    @SerializedName("languageColor")
    private String languageColor;

    @ColumnInfo(name = "stars")
    @SerializedName("stars")
    private String stars;

    @ColumnInfo(name = "forks")
    @SerializedName("forks")
    private String forks;

    @ColumnInfo(name = "currentPeriodStars")
    @SerializedName("currentPeriodStars")
    private String currentPeriodStars;

    @BindingAdapter({"app:image_url"})
    public static void loadImage(ImageView view, String logoUrl) {
        if (logoUrl == null) {
            view.setImageResource(R.drawable.ic_default);
        } else {
            Glide.with(view.getContext()).load(logoUrl).into(view);
        }
    }

    @BindingAdapter({"app:image_tint"})
    public static void setTintImage(ImageView view, String tint) {
        if (tint == null) {
            view.setColorFilter(ContextCompat.getColor(view.getContext(), R.color.dot_color), PorterDuff.Mode.ADD);
        } else {
            view.setColorFilter(Color.parseColor(tint), PorterDuff.Mode.ADD);
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguageColor() {
        return languageColor;
    }

    public void setLanguageColor(String languageColor) {
        this.languageColor = languageColor;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public String getForks() {
        return forks;
    }

    public void setForks(String forks) {
        this.forks = forks;
    }

    public String getCurrentPeriodStars() {
        return currentPeriodStars;
    }

    public void setCurrentPeriodStars(String currentPeriodStars) {
        this.currentPeriodStars = currentPeriodStars;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    @Override
    public String toString() {
        return "TrendingData{" +
                "author='" + author + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", language='" + language + '\'' +
                ", languageColor='" + languageColor + '\'' +
                ", stars='" + stars + '\'' +
                ", forks='" + forks + '\'' +
                ", currentPeriodStars='" + currentPeriodStars + '\'' +
                '}';
    }
}
