package com.nemanja.shortener.service;

public interface ShortenerService {

    String generateShortUrl(String originalUrl);

    String getOriginalUrl(String ShortLinkId);
}