package com.twitterAPI;

import com.fasterxml.jackson.databind.JsonNode;
import com.twitterAPI.api.FollowsApi;
import com.twitterAPI.payloads.follows.UserSuggestion;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class FollowsTest extends BaseTestClass {
    private FollowsApi tweetsApi = new FollowsApi();

    @Test
    public void userSuggestionTest() throws IOException {
//        System.out.println(tweetsApi.gerUserSuggestion()
//                .body().prettyPrint());

        tweetsApi.gerUserSuggestion()
                .getResponse()
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);


//        List<UserSuggestion> asList = tweetsApi.getUserSuggestionModel();
//
//        for (UserSuggestion userTweet : asList) {
//            System.out.println(userTweet);
//        }
    }

    @Test
    public void userSuggestionSlugTest() throws IOException {
        List<UserSuggestion> userTypeSuggestion = tweetsApi.gerUserSuggestion().getUserSuggestionModel();
        System.out.println(" Number od categories " + userTypeSuggestion.size());
        JsonNode actualObj = tweetsApi.getUserSuggestionSlugModel(userTypeSuggestion.get(0));
        System.out.println(" Number of categories profiles " + actualObj.size());

        System.out.println("\n " + actualObj.get(0).get("id"));
//        tweetsApi.createFriendship(actualObj.get("id").asLong());
    }
}
