package com.twitterAPI.api;

import io.restassured.response.Response;

public class TweetsApi extends AuthBaseApi {
    public Response createTweet(String tweetDescription) {
        Response response = getAuth()
                .when()
                .post("https://api.twitter.com/1.1/statuses/update.json?status=" + tweetDescription);
        return response;
    }

    public Response deleteTweet(String id) {
        Response response = getAuth()
                .when()
                .post("https://api.twitter.com/1.1/statuses/destroy/?status=" + id);
        return response;
    }

    public Response homeTimeLine() {
        Response response = getAuth()
                .when()
                .get("https://api.twitter.com/1.1/statuses/home_timeline.json");
        return response;
    }
}
