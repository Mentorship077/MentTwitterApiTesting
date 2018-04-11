package com.twitterAPI.api;

import io.restassured.response.Response;

public class TweetsApi extends AuthBaseApi {
    public Response createTweet(String tweetDescription) {
        return post("https://api.twitter.com/1.1/statuses/update.json?status=" + tweetDescription);
    }

    public Response deleteTweet(Long id) {
        return post("https://api.twitter.com/1.1/statuses/destroy/?status=" + id);
    }

    public Response getHomeTimeLine() {
        return get("https://api.twitter.com/1.1/statuses/home_timeline.json");
    }

    public Response getUserTimeLine() {
        return get("https://api.twitter.com/1.1/statuses/user_timeline.json");
    }
}
