package com.example.tiles_app.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "trending_table")
public class TrendingData {
    @PrimaryKey(autoGenerate = true)

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

    @Override
    public String toString() {
        return "TrendingData{" +
                "author='" + author + '\'' +
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
