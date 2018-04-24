package com.twitterAPI;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.twitterAPI.api.FollowsApi;
import com.twitterAPI.payloads.follows.UserSuggestion;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class FollowsTest extends BaseTestClass {
    private FollowsApi tweetsApi = new FollowsApi();
    private ObjectMapper mapper = new ObjectMapper();
    private CollectionType userTypeSuggestions = mapper.getTypeFactory().constructCollectionType(List.class, UserSuggestion.class);


    @Test
    public void userSuggestionTest() throws IOException {
        List<UserSuggestion> userTypeSuggestion = mapper.readValue(tweetsApi.gerUserSuggestion().asString(), userTypeSuggestions);
        for (UserSuggestion userTweet : userTypeSuggestion) {
            System.out.println(userTweet);
        }
        Assert.assertTrue(userTypeSuggestion.size() > 1, "Size of user suggestion categories " + userTypeSuggestion.size());
    }

    @Test
    public void userSuggestionSlugTest() throws IOException {
        List<UserSuggestion> userTypeSuggestion = tweetsApi.getUserSuggestionModel();
        JsonNode actualObj = tweetsApi.getUserSuggestionSlugModel(userTypeSuggestion.get(0));
        System.out.println(" Number of categories profiles " + actualObj.size());

        Assert.assertTrue(actualObj.size() > 1, "Size of category profile " + userTypeSuggestion.size());
        Assert.assertNotNull(actualObj.get(0).get("id"), "Profile doesn't found");

//        tweetsApi.createFriendship(actualObj.get("id").asLong());
    }
}
