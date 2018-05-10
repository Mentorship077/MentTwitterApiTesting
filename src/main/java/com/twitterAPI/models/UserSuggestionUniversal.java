package com.twitterAPI.models;

import com.twitterAPI.payloads.follows.UserSuggestion;
import io.restassured.response.Response;

import java.util.List;

public class UserSuggestionUniversal {

    private Response response;
    private List<UserSuggestion> userSuggestionModel;

    public UserSuggestionUniversal() {
    }

    public UserSuggestionUniversal(Response response, List<UserSuggestion> userSuggestionModel) {
        this.response = response;
        this.userSuggestionModel = userSuggestionModel;
    }

    @Override
    public String toString() {
        return "UserSuggestionUniversal{" +
                "response=" + response +
                ", userSuggestionModel=" + userSuggestionModel +
                '}';
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public List<UserSuggestion> getUserSuggestionModel() {
        return userSuggestionModel;
    }

    public void setUserSuggestionModel(List<UserSuggestion> userSuggestionModel) {
        this.userSuggestionModel = userSuggestionModel;
    }
}
