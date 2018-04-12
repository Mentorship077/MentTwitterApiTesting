package com.twitterAPI;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.twitterAPI.api.FollowsApi;
import com.twitterAPI.payloads.follows.UserSuggestion;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class FollowsTest extends BaseTestClass {
    private FollowsApi tweetsApi = new FollowsApi();
    private ObjectMapper mapper = new ObjectMapper();
    private CollectionType userTypeSuggestions = mapper.getTypeFactory().constructCollectionType(List.class, UserSuggestion.class);


    @Test
    public void userSuggestionTest() throws IOException {
        List<UserSuggestion> asList = mapper.readValue(tweetsApi.gerUserSuggestion().asString(), userTypeSuggestions);
        for (UserSuggestion userTweet : asList) {
            System.out.println(userTweet);
        }
    }

    @Test
    public void userSuggestionSlugTest() throws IOException {
        List<UserSuggestion> userTypeSuggestion = tweetsApi.getUserSuggestionModel();
        System.out.println(" Number od categories "+userTypeSuggestion.size());
        JsonNode actualObj = tweetsApi.getUserSuggestionSlugModel(userTypeSuggestion.get(0));
        System.out.println(" Number of categories profiles "+ actualObj.size());

        System.out.println("\n " + actualObj.get(0).get("id"));
//        tweetsApi.createFriendship(actualObj.get("id").asLong());
    }
}
