package com.twitterAPI;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.twitterAPI.api.FollowsApi;
import com.twitterAPI.payloads.follows.UserSuggestion;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static com.twitterAPI.constants.TwitterAPIConsts.TWITTER_BASE_URI_API;

public class FollowsTest extends BaseTestClass {
    private FollowsApi tweetsApi = new FollowsApi();
    private ObjectMapper mapper = new ObjectMapper();
    private CollectionType userTypeSuggestions = mapper.getTypeFactory().constructCollectionType(List.class, UserSuggestion.class);


    @Test
    public void userSuggestionTest() throws IOException {
        List<UserSuggestion> asList = tweetsApi.getUserSuggestionModel();
        for (UserSuggestion userTweet : asList) {
            System.out.println(userTweet);
        }
    }

    @Test
    public void userSuggestionSlugTest() throws IOException {
        List<UserSuggestion> userTypeSuggestion = tweetsApi.getUserSuggestionModel();
        System.out.println(userTypeSuggestion.size()+" Number od categories");

        JsonNode actualObj = mapper.readTree(tweetsApi.getUserSuggestionSlug(userTypeSuggestion.get(3).getSlug()).toString());

        System.out.println(actualObj.size());

        if (actualObj.isArray()) {
            for (JsonNode jsonNode : actualObj) {
                System.out.println(jsonNode.get("id"));
//                follow another people by id
                tweetsApi.createFriendship(jsonNode.get("id").asLong());
            }
        }

//
        System.out.println("\n " + actualObj.get(0).get("id"));
//        System.out.println("\n " + actualObj.get(0).get("name"));
//        actualObj.get(0).get("id").ge;



//        System.out.println("\n\n");
//        System.out.println(tweetsApi.getUserSuggestionSlug(userTypeSuggestion.get(0).getSlug()).asString());
//        MyDtoIgnoreUnknown node = mapper.readValue(tweetsApi.getUserSuggestionSlug(userTypeSuggestion.get(0).getSlug()).asString(), MyDtoIgnoreUnknown.class);

//        if (node.has("id")) {
//            System.out.println("id: " + node.get("id"));
//        }
    }

}
