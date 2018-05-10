package com.twitterAPI.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.twitterAPI.models.UserSuggestionUniversal;
import com.twitterAPI.payloads.follows.UserSuggestion;
import io.restassured.response.Response;

import java.io.IOException;

import static com.twitterAPI.constants.TwitterAPIConsts.TWITTER_BASE_URI_API;

public class FollowsApi extends AuthBaseApi {

    public UserSuggestionUniversal gerUserSuggestion() throws IOException {
        return new UserSuggestionUniversal(
                get(TWITTER_BASE_URI_API + "users/suggestions.json"),
                mapper.readValue(get(TWITTER_BASE_URI_API + "users/suggestions.json").asString(), userTypeSuggestions)
        );
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
//    public List<UserSuggestion> getUserSuggestionModel() throws IOException {
//        return mapper.readValue(
//                get(TWITTER_BASE_URI_API + "users/suggestions.json").asString(), userTypeSuggestions);
//    }

    public JsonNode getUserSuggestionSlugModel(UserSuggestion suggestion) throws IOException {
        return mapper.readTree(get(TWITTER_BASE_URI_API + "users/suggestions/" + suggestion.getSlug() + "/members.json").asString());
    }
}
