package com.twitterAPI.api;

import io.restassured.response.Response;

public class FollowsApi extends AuthBaseApi{

    public Response userSuggestion(){
        Response response =  getAuth()
                .when()
                .get("https://api.twitter.com/1.1/users/suggestions.json");
        return response;
    }
    public Response userSuggestionSlug(String suggestion){
        Response response =  getAuth()
                .when()
                .get("https://api.twitter.com/1.1/users/suggestions/" + suggestion + "/members.json");
        return response;
    }


    public Response followersList(){
        Response response =  getAuth()
                .when()
                .get("https://api.twitter.com/1.1/followers/list.json");
        return response;
    }

    public Response createFrienship(Long id){
        Response response =  getAuth()
                .when()
                .post("https://api.twitter.com/1.1/friendships/create.json?user_id="+id);
        return response;
    }
}
