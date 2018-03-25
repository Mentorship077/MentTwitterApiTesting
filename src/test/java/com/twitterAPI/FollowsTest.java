package com.twitterAPI;

import com.twitterAPI.api.FollowsApi;
import org.testng.annotations.Test;

public class FollowsTest extends BaseTestClass {
    private FollowsApi tweetsApi = new FollowsApi();

    @Test
    public void userSuggestionTest(){
        System.out.println(tweetsApi.userSugesstion().asString());
    }
}
