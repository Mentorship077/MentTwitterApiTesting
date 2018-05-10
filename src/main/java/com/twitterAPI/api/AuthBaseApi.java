package com.twitterAPI.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.twitterAPI.payloads.follows.UserSuggestion;
import com.twitterAPI.payloads.tweets.HomeTimeLine;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

import static io.restassured.RestAssured.given;

public class AuthBaseApi {
    private static final String COSUMER_KEY = "QK6tJzbhiYgqq9C2eRI8UuIvz";
    private static final String COSUMER_SEKRET_KEY = "gZfMQ8dHr9e8xCidS92NaFFSlRWelurLBNnh03HKN7i2bKJEde";
    private static final String ACCESS_TOKEN = "971038894115475457-6kSyriaT8V4m4NKdoudgYaFXoRuic2h";
    private static final String ACCESS_TOKEN_SECRET = "0EQcJyjOjAbaUa8m9r4lNuWtgiYMlPvqDRwEUUw9d6yhe";
    ObjectMapper mapper = new ObjectMapper();
    CollectionType userTypeSuggestions = mapper.getTypeFactory().constructCollectionType(List.class, UserSuggestion.class);
    CollectionType homeTimeLine = mapper.getTypeFactory().constructCollectionType(List.class, HomeTimeLine.class);

    public static RequestSpecification getAuth() {
        return given()
                .auth()
                .oauth(COSUMER_KEY, COSUMER_SEKRET_KEY, ACCESS_TOKEN, ACCESS_TOKEN_SECRET);
    }

    public Response get(String path) {
        return getAuth()
                .when()
                .get(path);
    }

    public Response post(String path) {
        return getAuth()
                .when()
                .post(path);
    }

}
