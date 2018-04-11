package com.twitterAPI.api;

import io.restassured.response.Response;

public class FollowsApi extends AuthBaseApi {

    public Response userSuggestion() {
        return get("https://api.twitter.com/1.1/users/suggestions.json");
    }

    public Response userSuggestionSlug(String suggestion) {
        return get("https://api.twitter.com/1.1/users/suggestions/" + suggestion + "/members.json");
    }


    public Response followersList() {
        return get("https://api.twitter.com/1.1/followers/list.json");
    }

    public Response createFriendship(Long id) {
        return post("https://api.twitter.com/1.1/friendships/create.json?user_id=" + id);
    }
}
