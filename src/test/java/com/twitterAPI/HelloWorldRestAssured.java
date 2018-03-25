package com.twitterAPI;

import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class HelloWorldRestAssured {
    public static void main(String[] args) throws IOException {
//        TweetsApi tweetsApi = new TweetsApi();
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        CollectionType javaType = mapper.getTypeFactory().constructCollectionType(List.class, HomeTimeLine.class);
//
//        List<HomeTimeLine> asList = mapper.readValue(tweetsApi.getHomeTimeLine().asString(), javaType);
//        for (HomeTimeLine timeLine: asList) {
//            System.out.println(timeLine.getUser().getName());
//        }
    }

    @Test
    public void makeSureThatTwitterIsUp() {
        given().when().get("http://www.google.com").then().statusCode(200);
    }
}
