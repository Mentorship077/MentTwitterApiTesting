package com.twitterAPI.api;

import io.restassured.response.Response;

import static com.twitterAPI.constants.TwitterAPIConsts.TWITTER_BASE_URI_API;

public class TweetsApi extends AuthBaseApi {

    public Response createTweet(String tweetDescription) {
        return post(TWITTER_BASE_URI_API+"statuses/update.json?status=" + tweetDescription);
    }

    public Response deleteTweet(Long id) {
        return post(TWITTER_BASE_URI_API+"statuses/destroy/?status=" + id);
    }

    public Response getHomeTimeLine() {
        return get(TWITTER_BASE_URI_API+"statuses/home_timeline.json");
    }

    public Response getUserTimeLine() {
        return get(TWITTER_BASE_URI_API+"statuses/user_timeline.json");
    }
}
