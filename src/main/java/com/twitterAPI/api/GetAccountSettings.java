package com.twitterAPI.api;


import io.restassured.response.Response;

public class GetAccountSettings extends AuthBaseApi {
//    href="https://dev.twitter.com/docs/api/1.1/get/account/settings
    public Response getAccountSettings(final String tweetDescription){
    Response response =  getAuth()
                .when()
                .post("https://api.twitter.com/1.1/statuses/update.json?status=" + tweetDescription);
    return response;
    }
    public Response tweetList() {
        Response response = getAuth()
                .when()
                .get("https://api.twitter.com/1.1/statuses/home_timeline.json\n" +
                        "\n" +
                        "\n");
        return response;
    }

    public static void main(String[] args) {
        System.out.println(new GetAccountSettings().tweetList().asString());
    }
}


