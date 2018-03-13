package com.twitterAPI;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class HelloWorldRestAssured {
    @Test
    public void makeSureThatGoogleIsUp() {
        given().when().get("http://www.google.com").then().statusCode(200);
    }
}
