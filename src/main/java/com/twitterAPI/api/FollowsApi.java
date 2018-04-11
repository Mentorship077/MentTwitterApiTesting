package com.twitterAPI.api;

import io.restassured.response.Response;

import static com.twitterAPI.constants.TwitterAPIConsts.TWITTER_BASE_URI_API;

public class FollowsApi extends AuthBaseApi {

    public Response userSuggestion() {
        return get(TWITTER_BASE_URI_API+"users/suggestions.json");
    }

    public Response userSuggestionSlug(String suggestion) {
        return get(TWITTER_BASE_URI_API+"users/suggestions/" + suggestion + "/members.json");
    }


    public Response followersList() {
        return get(TWITTER_BASE_URI_API+"followers/list.json");
    }

    public Response createFriendship(Long id) {
        return post(TWITTER_BASE_URI_API+"friendships/create.json?user_id=" + id);
    }
}
