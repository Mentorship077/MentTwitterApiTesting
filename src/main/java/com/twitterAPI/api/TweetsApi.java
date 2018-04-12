package com.twitterAPI.api;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.twitterAPI.payloads.tweets.HomeTimeLine;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.List;

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

    //   Additional methods
    public List<HomeTimeLine> getHomeTimeLineModel() throws IOException {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(
                get(TWITTER_BASE_URI_API+"statuses/home_timeline.json").asString(), homeTimeLine);
    }

    public List<HomeTimeLine> getUserTimeLineModel() throws IOException {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(
                get(TWITTER_BASE_URI_API+"statuses/user_timeline.json").asString(), homeTimeLine);
    }
}
