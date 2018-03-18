package com.twitterAPI;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twitterAPI.api.TweetsApi;
import com.twitterAPI.payloads.HomeTimeLine;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;

public class HelloWorldRestAssured {
    @Test
    public void makeSureThatGoogleIsUp() {
        given().when().get("http://www.google.com").then().statusCode(200);
    }


    public static void main(String[] args) throws IOException {
        TweetsApi tweetsApi = new TweetsApi();

//        System.out.println(tweetsApi.homeTimeLine().asString());
        ObjectMapper mapper = new ObjectMapper();
        HomeTimeLine[] api = mapper.readValue(tweetsApi.homeTimeLine().asString(), HomeTimeLine[].class);
        System.out.println(api[1].toString());

    }
}
