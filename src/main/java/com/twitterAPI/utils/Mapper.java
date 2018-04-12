package com.twitterAPI.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.twitterAPI.api.FollowsApi;
import com.twitterAPI.payloads.follows.UserSuggestion;

import java.util.List;

public class Mapper {
    private FollowsApi tweetsApi = new FollowsApi();
    private ObjectMapper mapper = new ObjectMapper();
    private CollectionType userTypeSuggestions = mapper.getTypeFactory().constructCollectionType(List.class, UserSuggestion.class);


}
