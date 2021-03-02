package org.dailyinfo.telegrambot.telegrambot.config.quote;

import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.ArrayList;

public class Quote {

    @JsonProperty("id")
    private int id;
    @JsonProperty("dialogue")
    private boolean dialogue;
    @JsonProperty("private")
    private boolean isPrivate;
    @JsonProperty("tags")
    private ArrayList<String> tags;
    @JsonProperty("url")
    private String url;
    @JsonProperty("favorites_count")
    private int favorites_count;
    @JsonProperty("upvotes_count")
    private int upvotes_count;
    @JsonProperty("downvotes_count")
    private int downvotes_count;
    @JsonProperty("author")
    private String author;
    @JsonProperty("author_permalink")
    private String author_permalink;
    @JsonProperty("body")
    private String body;

    public Quote() {
    }

    public int getId() {
        return id;
    }
    public boolean isDialogue() {
        return dialogue;
    }
    public boolean isPrivate() {
        return isPrivate;
    }
    public ArrayList<String> getTags() {
        return tags;
    }
    public String getUrl() {
        return url;
    }
    public int getFavorites_count() {
        return favorites_count;
    }
    public int getUpvotes_count() {
        return upvotes_count;
    }
    public int getDownvotes_count() {
        return downvotes_count;
    }
    public String getAuthor() {
        return author;
    }
    public String getAuthor_permalink() {
        return author_permalink;
    }
    public String getBody() {
        return body;
    }


    public boolean hasTags() {
        return this.tags != null;
    }
    public boolean hasUrl() {
        return this.url != null && !this.url.isEmpty();
    }
    public boolean hasAuthor() {
        return this.author != null && !this.author.isEmpty();
    }
    public boolean hasAuthor_permalink() {
        return this.author_permalink != null && !this.author_permalink.isEmpty();
    }
    public boolean hasBody() {
        return this.body != null && !this.body.isEmpty();
    }
}
