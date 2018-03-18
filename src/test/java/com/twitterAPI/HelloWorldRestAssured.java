package com.twitterAPI;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.twitterAPI.api.TweetsApi;
import com.twitterAPI.payloads.HomeTimeLine;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;

public class HelloWorldRestAssured {
    public static void main(String[] args) throws IOException {
        TweetsApi tweetsApi = new TweetsApi();

//        System.out.println(tweetsApi.homeTimeLine().asString());
//        ObjectMapper mapper = new ObjectMapper();
//        HomeTimeLine[] api = mapper.readValue(tweetsApi.homeTimeLine().asString(), HomeTimeLine[].class);
//        System.out.println(api[1].toString());
//
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

//        List<HomeTimeLine> api = mapper.readValue(tweetsApi.homeTimeLine().asString(), new TypeReference<List<HomeTimeLine>>() {});


        CollectionType javaType = mapper.getTypeFactory()
                .constructCollectionType(List.class, HomeTimeLine.class);
        List<HomeTimeLine> asList = mapper.readValue(tweetsApi.homeTimeLine().asString(), javaType);

        System.out.println(asList.get(0).getId());
    }

    @Test
    public void makeSureThatGoogleIsUp() {
        given().when().get("http://www.google.com").then().statusCode(200);
    }
}
