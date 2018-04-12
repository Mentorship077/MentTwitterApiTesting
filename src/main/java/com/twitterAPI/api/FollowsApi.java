package com.twitterAPI.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.twitterAPI.payloads.follows.UserSuggestion;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.List;

import static com.twitterAPI.constants.TwitterAPIConsts.TWITTER_BASE_URI_API;

public class FollowsApi extends AuthBaseApi {
    private ObjectMapper mapper = new ObjectMapper();
    private CollectionType userTypeSuggestions = mapper.getTypeFactory().constructCollectionType(List.class, UserSuggestion.class);


    public Response getUserSuggestion() {
        return get(TWITTER_BASE_URI_API + "users/suggestions.json");
    }

    public Response getUserSuggestionSlug(String suggestion) {
        return get(TWITTER_BASE_URI_API + "users/suggestions/" + suggestion + "/members.json");
    }

    public Response getFollowersList() {
        return get(TWITTER_BASE_URI_API + "followers/list.json");
    }

    public Response createFriendship(Long id) {
        return post(TWITTER_BASE_URI_API + "friendships/create.json?user_id=" + id);
    }

    //   Additional methods
    public List<UserSuggestion> getUserSuggestionModel() throws IOException {
        return mapper.readValue(
                get(TWITTER_BASE_URI_API + "users/suggestions.json").asString(), userTypeSuggestions);
    }

    public JsonNode getUserSuggestionSlugModel(UserSuggestion suggestion) throws IOException {
        return mapper.readTree(
                get(TWITTER_BASE_URI_API + "users/suggestions/" + suggestion.getSlug() + "/members.json").toString());
        //        JsonNode actualObj = mapper.readTree(tweetsApi.userSuggestionSlug(userTypeSuggestion.get(3).getSlug()).asString());
    }
}
