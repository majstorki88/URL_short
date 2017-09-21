package com.nemanja.shortener.service;

import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import com.google.common.hash.Hashing;


@Service
public class ShortenerServiceImpl implements ShortenerService {

    private Object lock = new Object();
    ConcurrentMap<String, String> shortenedMap = new ConcurrentHashMap<String, String>();

    @Override
    public String getOriginalUrl(String ShortLinkId) {
        String originalUrl = shortenedMap.get(ShortLinkId);

        if (originalUrl != null) {

            return shortenedMap.get(ShortLinkId);
        }

        return "";
    }


    @Override
    public String generateShortUrl(String originalUrl) {

        if(!isUrlValid(originalUrl)) {

            return "";
        }

        String shortUrl = Hashing.murmur3_32()
                .hashString(originalUrl, StandardCharsets.UTF_8).toString();

        synchronized (lock) {
            shortenedMap.put(shortUrl, originalUrl);
        }

        return shortUrl;
    }

    private boolean isUrlValid(String url) {

        boolean isValid = true;

        try {

            new URL(url);
        }
        catch (MalformedURLException e) {

            isValid = false;
        }

        return isValid;
    }
}
