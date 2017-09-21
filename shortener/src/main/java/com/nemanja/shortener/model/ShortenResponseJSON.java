package com.nemanja.shortener.model;

public class ShortenResponseJSON {
    String original_link;
    String short_link;

    public String getOriginal_link() {
        return original_link;
    }

    public void setOriginal_link(String originalUrl) {
        this.original_link = originalUrl;
    }

    public String getShort_link() {
        return short_link;
    }

    public void setShort_link(String shortenUrl) {
        this.short_link = shortenUrl;
    }
}
