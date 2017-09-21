package com.nemanja.shortener.controller;

import com.nemanja.shortener.model.ShortenRequestJSON;
import com.nemanja.shortener.model.ShortenResponseJSON;
import com.nemanja.shortener.service.ShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/")
public class ShortenerController {

    private final String requestURL = "http://localhost:8080/";

    @Autowired
    private ShortenerService shortenerService;

    @RequestMapping(value = "/shorten", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ShortenResponseJSON shortener(@RequestBody ShortenRequestJSON url, HttpServletRequest request) {

        String requestUrl = url.getUrl();
        String shortUrl = shortenerService.generateShortUrl(requestUrl);

        String hostUrl = request.getRequestURL().toString();
        String prefixUrl = hostUrl.replace(request.getServletPath(), "") + "/";

        ShortenResponseJSON shortenResponseJSON = new ShortenResponseJSON();

        shortenResponseJSON.setOriginal_link(requestUrl);

        if(shortUrl == "") {

            shortenResponseJSON.setShort_link("Url format is not valid.");
        }
        else {

            shortenResponseJSON.setShort_link(prefixUrl + shortUrl);
        }

        return shortenResponseJSON;
    }

    @RequestMapping(value = "/{shortLink}", method = RequestMethod.GET)
    public void redirectToOriginalUrl(HttpServletResponse response,
                                      @PathVariable(value = "shortLink") String shortLink) throws Exception {

        String originalUrl = shortenerService.getOriginalUrl(shortLink);

        if(originalUrl != "") {
            response.addHeader("Location", originalUrl);
            response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
        }
        else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}