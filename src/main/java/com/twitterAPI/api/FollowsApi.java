package com.twitterAPI.api;

import io.restassured.response.Response;

public class FollowsApi extends AuthBaseApi{

    public Response userSugesstion(){
        Response response =  getAuth()
                .when()
                .get("https://api.twitter.com/1.1/users/suggestions.json");
        return response;
    }


    // POST
    public void createFriendship(){

    }

    public Response followersList(){
        Response response =  getAuth()
                .when()
                .get("https://api.twitter.com/1.1/followers/list.json");
        return response;
    }
}
