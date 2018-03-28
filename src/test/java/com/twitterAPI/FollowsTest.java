package com.twitterAPI;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.twitterAPI.api.FollowsApi;
import com.twitterAPI.payloads.follows.MyDtoIgnoreUnknown;
import com.twitterAPI.payloads.follows.UserSuggestion;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FollowsTest extends BaseTestClass {
    private FollowsApi tweetsApi = new FollowsApi();
    private ObjectMapper mapper = new ObjectMapper();
    private CollectionType userTypeSuggestions = mapper.getTypeFactory().constructCollectionType(List.class, UserSuggestion.class);


    @Test
    public void userSuggestionTest() throws IOException {
        List<UserSuggestion> asList = mapper.readValue(tweetsApi.userSuggestion().asString(), userTypeSuggestions);
        for (UserSuggestion userTweet : asList) {
            System.out.println(userTweet);
        }
    }

    @Test
    public void userSuggestionSlugTest() throws IOException {
        List<UserSuggestion> userTypeSuggestion = mapper.readValue(tweetsApi.userSuggestion().asString(), userTypeSuggestions);

        JsonNode actualObj = mapper.readTree(tweetsApi.userSuggestionSlug(userTypeSuggestion.get(0).getSlug()).asString());

        System.out.println(actualObj.size());

        if (actualObj.isArray()) {
            for (JsonNode jsonNode : actualObj) {
                System.out.println(jsonNode.get("id"));
            }
        }

        System.out.println("\n " + actualObj.get(0).get("id"));
//        System.out.println("\n\n");
//        System.out.println(tweetsApi.userSuggestionSlug(userTypeSuggestion.get(0).getSlug()).asString());


//        MyDtoIgnoreUnknown node = mapper.readValue(tweetsApi.userSuggestionSlug(userTypeSuggestion.get(0).getSlug()).asString(), MyDtoIgnoreUnknown.class);

//        if (node.has("id")) {
//            System.out.println("id: " + node.get("id"));
//        }
    }

}
